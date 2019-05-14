package com.maruani.games.mylittleheroesgi.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.maruani.games.mylittleheroesgi.R;
import com.maruani.games.mylittleheroesgi.data.model.Weapon;
import com.maruani.games.mylittleheroesgi.data.service.NetworkProvider;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ChooseWeaponActivity extends AppCompatActivity {

    private WeaponAdapter weaponAdapter;
    private String currentChosenWeaponUrl;
    private String currentWeaponType;

    @BindView(R.id.activity_choose_weapon_weapon_preview)
    ImageView currentWeaponPreviewIv;

    @BindView(R.id.activity_choose_weapon_rcv)
    RecyclerView weaponChoiceRcv;

    @BindView(R.id.activity_choose_weapon_description_message_tv)
    TextView descriptionMessageTv;

    @BindView(R.id.activity_choose_weapon_show_summary)
    Button showPlayerSummaryBtn;


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_choose_weapon);
    ButterKnife.bind(this);

    descriptionMessageTv.setVisibility(View.INVISIBLE);
    initRecyclerView();
    loadData();
  }

  private void initRecyclerView(){
      weaponChoiceRcv.setLayoutManager(new LinearLayoutManager(this));
      weaponAdapter = new WeaponAdapter();
      weaponChoiceRcv.setAdapter(weaponAdapter);

      weaponAdapter.setItemClickListener(weapon -> {
          Toast.makeText(this, weapon.getName(), Toast.LENGTH_SHORT).show();
          Glide.with(this).load(weapon.getPictureUrl()).into(currentWeaponPreviewIv);
          descriptionMessageTv.setVisibility(View.VISIBLE);
          currentChosenWeaponUrl = weapon.getPictureUrl();
          currentWeaponType = weapon.getType().toString();
      });

      showPlayerSummaryBtn.setVisibility(View.INVISIBLE);
      showPlayerSummaryBtn.setOnClickListener(v -> {
        Intent i = new Intent(this, RecapActivity.class);
        i.putExtra("pseudo", getIntent().getStringExtra("pseudo")) ;
        i.putExtra("sexe", getIntent().getStringExtra("sexe")) ;
        i.putExtra("birthdate", getIntent().getStringExtra("birthdate"));
        i.putExtra("weapon-type", currentWeaponType);
        i.putExtra("imageUrl", currentChosenWeaponUrl);
        startActivity(i);
      });

  }

  private void loadData(){
      NetworkProvider.getInstance().getWeapons(new NetworkProvider.Listener<List<Weapon>>() {
          @Override public void onSuccess(List<Weapon> data) {
              Log.d("ChooseWeaponActivity", data.toString());
              weaponAdapter.setWeaponList(data);
              showPlayerSummaryBtn.setVisibility(View.VISIBLE);
          }

          @Override public void onError(Throwable t) {

          }
      });
  }

}

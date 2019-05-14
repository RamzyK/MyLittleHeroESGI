package com.maruani.games.mylittleheroesgi.views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.maruani.games.mylittleheroesgi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecapActivity extends AppCompatActivity {

    @BindView(R.id.recap_activity_player_pseudo_tev)
    TextView playerPseudoTv;

    @BindView(R.id.recap_activity_sexe_tv)
    TextView playerSeweTv;

    @BindView(R.id.recap_activity_birthdate_tv)
    TextView birthDateTv;

    @BindView(R.id.recap_activity_beginning_weapon)
    ImageView beginningWeaponImage;

    @BindView(R.id.recap_activity_weapon_type_tv)
    TextView weaponTypeTv;

    private String pseudo;
    private String gender;
    private String birthdate;
    private String weapon_type;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recap);
        ButterKnife.bind(this);

        Intent params = getIntent();


        if(params.getExtras() != null){
            pseudo = params.getStringExtra("pseudo");
            gender = params.getStringExtra("sexe");
            birthdate = params.getStringExtra("birthdate");
            weapon_type = params.getStringExtra("weapon-type");

            playerPseudoTv.setText("Pseudo: " + pseudo);
            playerSeweTv.setText("Sexe: " + gender);
            birthDateTv.setText("Birthdate: " + birthdate);
            weaponTypeTv.setText("Weapon type: " + weapon_type);
            Glide.with(this).load(params.getStringExtra("imageUrl")).into(beginningWeaponImage);
        }
    }
}

package com.maruani.games.mylittleheroesgi.views;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.maruani.games.mylittleheroesgi.R;


public class HomeActivity extends AppCompatActivity {


  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_home);

    Button startButton = findViewById(R.id.activity_home_start_btn);
    startButton.setOnClickListener(v -> {
      Intent intent = new Intent(HomeActivity.this, CreatePlayerActivity.class);
      startActivity(intent);
    });
  }
}

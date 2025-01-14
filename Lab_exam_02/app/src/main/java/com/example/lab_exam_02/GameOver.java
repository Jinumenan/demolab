package com.example.lab_exam_02;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GameOver extends AppCompatActivity {

    TextView tvPoints, tvPersonalBest;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.game_over);
        int points = getIntent().getExtras().getInt("points");
        tvPoints = findViewById(R.id.tvPoints);
        tvPersonalBest = findViewById(R.id.tvPersonalBest);
        tvPoints.setText("" + points);
        sharedPreferences = getSharedPreferences("pref", 0);
        int pointsSP = sharedPreferences.getInt("pointsSP", 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        if(points > pointsSP){
            pointsSP = points;
            editor.putInt("pointsSp" , pointsSP);
            editor.commit();
        }
        tvPersonalBest.setText("" + pointsSP);
    }

    public void restart(View view) {
        Intent intent = new Intent(GameOver.this,StartGmae.class);
        startActivity(intent);
        finish();
    }

    public void exit(View view) {
        finish();
    }
}

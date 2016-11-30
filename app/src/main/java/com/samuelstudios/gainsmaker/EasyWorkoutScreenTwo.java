package com.samuelstudios.gainsmaker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static com.samuelstudios.gainsmaker.R.id.chestBtn;
import static com.samuelstudios.gainsmaker.R.string.shouldBtn;

public class EasyWorkoutScreenTwo extends AppCompatActivity {
    Button legBtn,absBtn,shouldBtn,armsBtn,chestBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_workout_screen_two);


        legBtn=(Button)findViewById(R.id.legsBtn);
        absBtn=(Button)findViewById(R.id.absBtn);
        shouldBtn=(Button)findViewById(R.id.shouldersBtn);
        armsBtn=(Button)findViewById(R.id.bisBtn);
        chestBtn=(Button)findViewById(R.id.chestBtn);

        legBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EasyWorkoutScreenTwo.this, Quads.class));
            }
        });

        absBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EasyWorkoutScreenTwo.this, Abs.class));
            }
        });

        shouldBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EasyWorkoutScreenTwo.this, Shoulders.class));
            }
        });

        armsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EasyWorkoutScreenTwo.this, Biceps.class));
            }
        });

        chestBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(EasyWorkoutScreenTwo.this, Chest.class));
            }
        });
    }
}

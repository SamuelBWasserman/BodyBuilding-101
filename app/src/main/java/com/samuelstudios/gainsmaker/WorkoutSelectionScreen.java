package com.samuelstudios.gainsmaker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class WorkoutSelectionScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workout_selection_screen);

        //custom fonts
        TextView instructions=(TextView) findViewById(R.id.instruction);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/airstrike.ttf");

        instructions.setTypeface(custom_font);

        //to the chest workouts
        Button chestbtn = (Button) findViewById(R.id.ChestBtn);

        chestbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorkoutSelectionScreen.this, Chest.class));
            }
        });

        Button shouldbtn = (Button) findViewById(R.id.shouldersBtn);

        shouldbtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorkoutSelectionScreen.this, Shoulders.class));
            }
        });

        Button bisBtn = (Button) findViewById(R.id.bisBtn);

        bisBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorkoutSelectionScreen.this, Biceps.class));
            }
        });

        Button quadsBtn = (Button) findViewById(R.id.quadsBtn);
        quadsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorkoutSelectionScreen.this, Quads.class));
            }
        });

        Button absBtn = (Button) findViewById(R.id.absBtn);
        absBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WorkoutSelectionScreen.this, Abs.class));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_workout_selection_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

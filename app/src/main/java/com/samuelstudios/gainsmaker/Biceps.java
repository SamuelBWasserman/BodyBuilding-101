package com.samuelstudios.gainsmaker;

import android.support.v7.app.AppCompatActivity;


import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;



import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;


import static com.samuelstudios.gainsmaker.R.id.adView1;

public class Biceps extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biceps);

        TextView intro=(TextView) findViewById(R.id.bisDay);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/airstrike.ttf");

        intro.setTypeface(custom_font);

        AdView mAdView = (AdView) findViewById(adView1);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_biceps, menu);
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

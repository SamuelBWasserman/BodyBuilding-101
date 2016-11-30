package com.samuelstudios.gainsmaker;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;



public class SelectionScreen extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selection_screen);

        //custom fonts
        Button line1 = (Button) findViewById(R.id.wkrbtn);
        Button line2 = (Button) findViewById(R.id.inspBtn);
        Button line3=(Button) findViewById(R.id.contBtn);
        Button line4=(Button) findViewById(R.id.nutrBtn);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/airstrike.ttf");

        line1.setTypeface(custom_font);
        line2.setTypeface(custom_font);
        line3.setTypeface(custom_font);
        line4.setTypeface(custom_font);
        //
        Button yourButton = (Button) findViewById(R.id.wkrbtn);
        yourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SelectionScreen.this, EasyWorkoutScreenTwo.class));
            }
        });

        Button contactBtn = (Button) findViewById(R.id.contBtn);
        contactBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SelectionScreen.this, ContactUs.class));
            }
        });

        Button inspBtn = (Button) findViewById(R.id.inspBtn);
        inspBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SelectionScreen.this, Inspiration.class));
            }
        });

        Button nutrBtn = (Button) findViewById(R.id.nutrBtn);
        nutrBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SelectionScreen.this, Nutrition.class));
            }
        });


        Button adBtn = (Button) findViewById(R.id.contBtn);

        adBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(SelectionScreen.this, ContactUs.class));
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7922851739835700/3371199274");

        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                requestNewInterstitial();

            }
        });

        requestNewInterstitial();


    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                // .addTestDevice("SEE_YOUR_LOGCAT_TO_GET_YOUR_DEVICE_ID")
                .build();

        mInterstitialAd.loadAd(adRequest);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selection_screen, menu);
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

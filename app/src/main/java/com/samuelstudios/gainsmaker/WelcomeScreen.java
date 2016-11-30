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


import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class WelcomeScreen extends AppCompatActivity {
    InterstitialAd mInterstitialAd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_welcome_screen);
        //Custon Fonts
        //TextView line1 = (TextView) findViewById(R.id.line1);
        //TextView line2 = (TextView) findViewById(R.id.name);
        Button firstbtn=(Button) findViewById(R.id.firstbtn);
        TextView msg=(TextView) findViewById(R.id.welcomeMsg);
        Typeface custom_font = Typeface.createFromAsset(getAssets(),  "fonts/airstrike.ttf");

        //line1.setTypeface(custom_font);
        //line2.setTypeface(custom_font);
        firstbtn.setTypeface(custom_font);
        //msg.setTypeface(custom_font);
        //Button Click
        Button yourButton = (Button) findViewById(R.id.firstbtn);

        yourButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(WelcomeScreen.this, SelectionScreen.class));
                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }
            }
        });


        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-7922851739835700/6537135275");

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
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
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

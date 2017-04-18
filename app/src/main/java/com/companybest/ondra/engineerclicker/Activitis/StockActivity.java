package com.companybest.ondra.engineerclicker.Activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class StockActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stock);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");


        //AD VIEW
        AdView mAdView2 = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);
    }
}

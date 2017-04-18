package com.companybest.ondra.engineerclicker.Activitis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Adapters.MainRealmAdapter;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MechanicActivity extends AppCompatActivity {

    RealmRecyclerView mainScreenRecyclerView;

    public static TextView numberOfWorkers;
    public static TextView coins;
    public static TextView costOfWorkers;
    MainActivity mainActivity;


    MainRealmAdapter mainRealmAdapter;


    //REALM DATABASE
    RealmResults<Machine> machines;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanic);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");


        //AD VIEW
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //FOR ADAPTER LIST OF MACHINES
        machines = realm
                .where(Machine.class)
                .findAll();

        //Log.i("user", String.valueOf(machines));
        mainRealmAdapter = new MainRealmAdapter(this, machines, true, false);


        //RECYCLERVIEW
        mainScreenRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view);
        mainScreenRecyclerView.setAdapter(mainRealmAdapter);


        //TEXT VIEWS OF WORKERS COINS AND COST OF WORKERS AND SETTING VALUE
        numberOfWorkers = (TextView) findViewById(R.id.numberOfWorkers);
        coins = (TextView) findViewById(R.id.coins);
        costOfWorkers = (TextView) findViewById(R.id.costOfWorkers);

        realm = Realm.getDefaultInstance();
        BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
        User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();
        numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));
        coins.setText("Coins: " + String.valueOf(user.getCoins()));
        costOfWorkers.setText("Cost: " + String.valueOf(worker.getCost()));
    }
}

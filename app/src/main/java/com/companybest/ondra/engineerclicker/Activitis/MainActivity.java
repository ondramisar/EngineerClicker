package com.companybest.ondra.engineerclicker.Activitis;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.companybest.ondra.engineerclicker.Adapters.MainRealmAdapter;
import com.companybest.ondra.engineerclicker.Adapters.MaterialRealmAdapter;
import com.companybest.ondra.engineerclicker.Adapters.UpgradeRealAdapter;
import com.companybest.ondra.engineerclicker.GameLoop.MainThread;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;
import com.companybest.ondra.engineerclicker.MyService;
import com.companybest.ondra.engineerclicker.R;
import com.companybest.ondra.engineerclicker.RealmBaseActivity;
import com.companybest.ondra.engineerclicker.References.MainReferences;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.Random;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends RealmBaseActivity implements RewardedVideoAdListener  {

    RealmRecyclerView materialRecyclerView;
    public static RealmRecyclerView upgradeRecyclerView;
    RealmRecyclerView mainScreenRecyclerView;

    public static TextView numberOfWorkers;
    public static TextView coins;
    public static TextView costOfWorkers;

    private RewardedVideoAd mAd;

    public MechanicActivity mechanicActivity;



    Button playAd;

    public MainThread thread;

    int timeForMachine1 = 0;
    int timeForMachine2 = 0;
    int timeForMachine3 = 0;
    int timeForMachine4 = 0;
    int timeForMachine5 = 0;
    int timeForMachine6 = 0;
    int timeForMachine7 = 0;
    int timeForMachine8 = 0;
    int timeForMachine9 = 0;
    int timeForMachine10 = 0;

    //REFERENCES
    public static MainReferences mainReferences;

    MainRealmAdapter mainRealmAdapter;
    MaterialRealmAdapter materialRealmAdapter;
    UpgradeRealAdapter upgradeRealAdapter;

    //REALM DATABASE
    RealmResults<Machine> machines;
    RealmResults<Material> materials;
    RealmResults<Upgrade> upgrades;

    Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");

        //AD VIEW
        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //AD VIEW
        AdView mAdView2 = (AdView) findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        mAdView2.loadAd(adRequest2);

        //AD VIEW
        AdView mAdView3 = (AdView) findViewById(R.id.adView3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest3);


        //THREAD FOR GAME LOOP
        thread = new MainThread(this,true);
        starThread();

        //REALM INITIALIZE
        Realm.setDefaultConfiguration(getRealmConfig());

        Realm realm = Realm.getInstance(getRealmConfig());

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);

        //REFERENCE FOR REAL OBJECT
        mainReferences = new MainReferences();

        //CREATING MACHINES
        if (sharedPreferences.getInt("created", 0) == 0) {
            sharedPreferences.edit().putInt("created", 1).apply();
            mainReferences.createAllMachines();
            mainReferences.createAllMaterials();
            mainReferences.createAllUpgrades();
            mainReferences.createWorker();
            mainReferences.createUser();
            Log.i("user", "first Time Created");
        } else if (sharedPreferences.getInt("created", 0) == 1) {
            Log.i("user", "was created");

        }


        //FOR ADAPTER LIST OF MACHINES
        machines = realm
                .where(Machine.class)
                .findAll();

        //Log.i("user", String.valueOf(machines));
        mainRealmAdapter = new MainRealmAdapter(this, machines, true, false);


        //RECYCLERVIEW
        mainScreenRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view);
        mainScreenRecyclerView.setAdapter(mainRealmAdapter);

        //FOR ADAPTER LIST OF MACHINES
        materials = realm
                .where(Material.class)
                .findAll();

        //Log.i("user", String.valueOf(machines));
        materialRealmAdapter = new MaterialRealmAdapter(this, materials, true, false);


        //RECYCLERVIEW
        materialRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view_for_products);
        materialRecyclerView.setAdapter(materialRealmAdapter);


        //FOR ADAPTER LIST OF MACHINES
        upgrades = realm
                .where(Upgrade.class)
                .findAll();

        //Log.i("user", String.valueOf(machines));
        upgradeRealAdapter = new UpgradeRealAdapter(this, upgrades, true, false);


        //RECYCLERVIEW
        upgradeRecyclerView = (RealmRecyclerView) findViewById(R.id.realm_recycler_view_for_upgrades);
        upgradeRecyclerView.setAdapter(upgradeRealAdapter);




        //TEXT VIEWS OF WORKERS COINS AND COST OF WORKERS AND SETTING VALUE
        numberOfWorkers = (TextView) findViewById(R.id.numberOfWorkers);
        coins = (TextView) findViewById(R.id.coins);
        costOfWorkers = (TextView) findViewById(R.id.costOfWorkers);

        realm = Realm.getDefaultInstance();
        BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainReferences.nameOfWorker).findFirst();
        User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();
        numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));
        coins.setText("Coins: " + String.valueOf(user.getCoins()));
        costOfWorkers.setText("Cost: " + String.valueOf(worker.getCost()));


        if(isMyServiceRunning(MyService.class)) {
            stopService(new Intent(getBaseContext(), MyService.class));
        }


        mAd = MobileAds.getRewardedVideoAdInstance(this);
        mAd.setRewardedVideoAdListener(this);
        loadAd();



        playAd = (Button) findViewById(R.id.playAd);
        playAd.setEnabled(false);
        playAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mAd.isLoaded()){
                    mAd.show();
                }
            }
        });

        //set up for tab view
        TabHost host = (TabHost) findViewById(R.id.tabHost);
        host.setup();


        //Tab 1
        TabHost.TabSpec spec = host.newTabSpec("Tab One");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Mach");
        host.addTab(spec);

        //Tab 2
        spec = host.newTabSpec("Tab Two");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Stock");
        host.addTab(spec);

        //Tab 3
        spec = host.newTabSpec("Tab Three");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Upgrad");
        host.addTab(spec);

        //Tab 4
        spec = host.newTabSpec("Tab Fourth");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Betting");
        host.addTab(spec);



        /*
        host = (FragmentTabHostt) findViewById(android.R.);

        host.setup(this, getSupportFragmentManager(), R.id.realtabcontent());

        //Creating tab menu.
        TabHost.TabSpec TabMenu1 = host.newTabSpec("Mach")setIndicator("Mach");
        TabHost.TabSpec TabMenu2 = host.newTabSpec("Stock").setIndicator("Stock");
        TabHost.TabSpec TabMenu3 = host.newTabSpec("Upgrade").setIndicator("Upgrade");
        TabHost.TabSpec TabMenu4 = host.newTabSpec("Betting").setIndicator("Betting");

        //Adding tab1, tab2, tab3 to tabhost view.

        host.addTab(TabMenu1, MechanicActivity.class, null);
        host.addTab(TabMenu2, StockActivity.class, null);
        host.addTab(TabMenu3, UpgradeActivity.class, null);
        host.addTab(TabMenu4, BettingActivity.class, null);*/


        Log.i("calcul","CALCUL: " +  String.valueOf(calcul(300,14)));
    }

    public int calcul(int num, int times){
        int alll = 0;
        for (int i = 0; i < times; i++){
            num = (num/3) + num;
            alll += num;
        }
        return alll;
    }


    public void starThread() {
        thread.setRunning(true);
        thread.start();
    }

    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }

    public void update() {
        //Log.i("user", "update");
        timeForMachine1 += 1;
        timeForMachine2 += 1;
        timeForMachine3 += 1;
        timeForMachine4 += 1;
        timeForMachine5 += 1;
        timeForMachine6 += 1;
        timeForMachine7 += 1;
        timeForMachine8 += 1;
        timeForMachine9 += 1;
        timeForMachine10 += 1;


        Realm realm = Realm.getDefaultInstance();
        final Machine m = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine1).findFirst();
        final Machine m2 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine2).findFirst();
        final Machine m3 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine3).findFirst();
        final Machine m4 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine4).findFirst();
        final Machine m5 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine5).findFirst();
        final Machine m6 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine6).findFirst();
        final Machine m7 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine7).findFirst();
        final Machine m8 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine8).findFirst();
        final Machine m9 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine9).findFirst();
        final Machine m10 = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine10).findFirst();


        if (timeForMachine1 > m.getTimerOfMachine()) {
            timeForMachine1 = 0;

            Log.i("user", "timer for" + String.valueOf(m.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m.getNameOfMaterial()).findFirst();

            if (m.getNumberOfWorkersOnMachine() > 0 ) {
                Log.i("user", "in IF STATMENT For " + m.getName());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(m.getNumberOfWorkersOnMachine(),true);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                    }
                });
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }

        if (timeForMachine2 > m2.getTimerOfMachine()) {

            timeForMachine2 = 0;

            Log.i("user", "timer for" + String.valueOf(m2.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m2.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m2.getNameOfNeededMaterial()).findFirst();

            if (m2.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m2.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m2.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });

        }

        if (timeForMachine3 > m3.getTimerOfMachine()) {

            timeForMachine3 = 0;

            Log.i("user", "timer for" + String.valueOf(m3.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m3.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m3.getNameOfNeededMaterial()).findFirst();

            if (m3.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m3.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m3.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });

        }

        if (timeForMachine4 > m4.getTimerOfMachine()) {

            timeForMachine4 = 0;

            Log.i("user", "timer for" + String.valueOf(m4.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m4.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m4.getNameOfNeededMaterial()).findFirst();

            if (m4.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m4.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m4.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());

                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }

        if (timeForMachine5 > m5.getTimerOfMachine()) {

            timeForMachine5 = 0;

            Log.i("user", "timer for" + String.valueOf(m5.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m5.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m5.getNameOfNeededMaterial()).findFirst();

            if (m5.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m5.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m5.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }


        if (timeForMachine6 > m6.getTimerOfMachine()) {

            timeForMachine6 = 0;

            Log.i("user", "timer for" + String.valueOf(m6.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m6.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m6.getNameOfNeededMaterial()).findFirst();

            if (m6.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m6.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m6.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }

        if (timeForMachine7 > m7.getTimerOfMachine()) {

            timeForMachine7 = 0;

            Log.i("user", "timer for" + String.valueOf(m7.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m7.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m7.getNameOfNeededMaterial()).findFirst();

            if (m7.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m7.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m7.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }

        if (timeForMachine8 > m8.getTimerOfMachine()) {

            timeForMachine8 = 0;

            Log.i("user", "timer for" + String.valueOf(m8.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m8.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m8.getNameOfNeededMaterial()).findFirst();

            if (m8.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m8.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m8.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }

        if (timeForMachine9 > m9.getTimerOfMachine()) {

            timeForMachine9 = 0;

            Log.i("user", "timer for" + String.valueOf(m9.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m9.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m9.getNameOfNeededMaterial()).findFirst();

            if (m9.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m9.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m9.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }


        if (timeForMachine10 > m10.getTimerOfMachine()) {

            timeForMachine10 = 0;

            Log.i("user", "timer for" + String.valueOf(m10.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m10.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m10.getNameOfNeededMaterial()).findFirst();

            if (m10.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m10.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m10.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });
            }
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    mainRealmAdapter.notifyDataSetChanged();
                    materialRealmAdapter.notifyDataSetChanged();
                }
            });
        }
    }

    public void plusWorker(View view) {
        //GETTING WORKERS AND USER COINS
        Realm realm = Realm.getDefaultInstance();
        final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainReferences.nameOfWorker).findFirst();
        final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();

        if (user.getCoins() >= worker.getCost()) {

            realm.executeTransaction(new Realm.Transaction() {
                @Override
                public void execute(Realm realm) {

                    worker.setNumberOf(1, true);

                    int calculatingNamburOfCost = worker.getCost()/5;

                    user.setCoins(worker.getCost(), false);
                    Log.i("user", String.valueOf(calculatingNamburOfCost));

                    worker.setCost(calculatingNamburOfCost, true);

                }
            });

            mechanicActivity.numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

            mechanicActivity.costOfWorkers.setText("Cost: " + String.valueOf(worker.getCost()));

            mechanicActivity.coins.setText(String.valueOf("Coins: " + user.getCoins()));
            Log.i("user", "Coins: " + user.getCoins());

        }
    }


    private void loadAd(){
        if (!mAd.isLoaded()){
            //mAd.loadAd("ca-app-pub-4686615482489412/9724660686", new AdRequest.Builder().build());
            mAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());
            Log.i("user", "AD Loaded");
        }
    }

    @Override
    public void onRewarded(RewardItem reward) {
        Realm realm = Realm.getDefaultInstance();
        final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();
       // final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainReferences.nameOfWorker).findFirst();
        int min = 100;
        int max = 1000;

        Random r = new Random();
        final int i1 = r.nextInt(max - min + 1) + min;

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {

                user.setCoins(i1, true);

            }
        });

        mechanicActivity.coins.setText(String.valueOf("Coins: " + user.getCoins()));
        Toast.makeText(this, "GOT: " + String.valueOf(i1)+ " Coins", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
    }

    @Override
    public void onRewardedVideoAdClosed() {
        playAd.setEnabled(false);

        loadAd();

        //Toast.makeText(this, "reward Getted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int errorCode) {
        Log.i("user", "Ad Failed to load");
        loadAd();
    }

    @Override
    public void onRewardedVideoAdLoaded() {
        playAd.setEnabled(true);

    }

    @Override
    public void onRewardedVideoAdOpened() {
    }

    @Override
    public void onRewardedVideoStarted() {
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        stopService(new Intent(getBaseContext(), MyService.class));
        thread = new MainThread(this,true);
        starThread();
        loadAd();
        Log.i("user", "RESTART");
    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        startService(new Intent(getBaseContext(), MyService.class));
        thread.setRunning(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // prepare intent which is triggered if the
        // notification is selected
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("END OF SERVICE")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "Call", pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "More", pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "And more", pIntent).build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }
}

package com.companybest.ondra.engineerclicker.Activitis;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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
    RealmRecyclerView upgradeRecyclerView;
    RealmRecyclerView mainScreenRecyclerView;

    public static TextView numberOfWorkers;
    public static TextView coins;
    public static TextView costOfWorkers;

    private RewardedVideoAd mAd;

    public MechanicActivity mechanicActivity;



    Button playAd;
    Button play50To50;
    Button playShufle;

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

        //AD VIEW
        AdView mAdView4 = (AdView) findViewById(R.id.adView4);
        AdRequest adRequest4 = new AdRequest.Builder().build();
        mAdView4.loadAd(adRequest4);

        //THREAD FOR GAME LOOP
        thread = new MainThread(this,true);
        starThread();


        Realm.setDefaultConfiguration(getRealmConfig());
        //Realm realm = Realm.getInstance(getRealmConfig());

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

        Realm realm = Realm.getDefaultInstance();

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
        final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();
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

        play50To50 = (Button) findViewById(R.id.playFyftyToFyfty);
        Button buttonForConfurm50To50 = (Button) findViewById(R.id.buttonConfirmForFyftyFyfty);
        final TextView textViewFor50To50 = (TextView) findViewById(R.id.textViewForFyftyToFyfty);
        final EditText editTextFor50To50 = (EditText) findViewById(R.id.editTextFyftyToFyfty);
        buttonForConfurm50To50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewFor50To50.setText("Your Bet: " + editTextFor50To50.getText());
            }
        });
        play50To50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewFor50To50.getText() != "") {

                    Realm realm = Realm.getDefaultInstance();

                    final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();

                    if (user.getCoins() > Integer.valueOf(String.valueOf(editTextFor50To50.getText()))) {

                        Log.i("user", "In On CLICK FOR 50 50");
                        int min = 0;
                        final int max = 200;

                        Random r = new Random();
                        final int i1 = r.nextInt(max - min + 1) + min;
                        Log.i("user", String.valueOf(i1));

                        play50To50.setEnabled(false);

                        if (i1 <= 100) {
                            Toast.makeText(getApplicationContext(), "YOU HAVE WONE " + textViewFor50To50.getText(), Toast.LENGTH_SHORT).show();
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    user.setCoins(Integer.valueOf(String.valueOf(editTextFor50To50.getText())), true);
                                    coins.setText(String.valueOf(user.getCoins()));
                                }
                            });
                        } else {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    user.setCoins(Integer.valueOf(String.valueOf(editTextFor50To50.getText())), false);
                                    coins.setText(String.valueOf(user.getCoins()));
                                }
                            });
                            Toast.makeText(getApplicationContext(), "YOU HAVE Lost " + textViewFor50To50.getText(), Toast.LENGTH_SHORT).show();
                        }

                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {

                            }

                            public void onFinish() {
                                play50To50.setEnabled(true);
                            }
                        }.start();
                    }
                }

            }
        });


        playShufle = (Button) findViewById(R.id.playFirstMiniGame);
        Button buttonForConfurmShufl = (Button) findViewById(R.id.buttonForConfirmShufl);
        final TextView textViewForShufl = (TextView) findViewById(R.id.textViewForShufl);
        final EditText editTextForShufl = (EditText) findViewById(R.id.editTextShufle);
        buttonForConfurmShufl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = Integer.valueOf(String.valueOf(editTextForShufl.getText()));

                int min = i - i/3;
                int max = i + i/3;
                textViewForShufl.setText("You can win from " + String.valueOf(min) + " to "  + String.valueOf(max));
            }
        });
        playShufle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (textViewForShufl.getText() != "") {

                    Realm realm = Realm.getDefaultInstance();

                    final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();

                    if (user.getCoins() > Integer.valueOf(String.valueOf(editTextForShufl.getText()))) {
                        int i = Integer.valueOf(String.valueOf(editTextForShufl.getText()));

                        int min = i - i/3;
                        int max = i + i/3;
                        Log.i("user", "In On CLICK FOR Shufl");
                        int minRan = min;
                        final int maxRan = max;

                        Random r = new Random();
                        final int i1 = r.nextInt(maxRan - minRan + 1) + minRan;
                        Log.i("user", String.valueOf(i1));

                        playShufle.setEnabled(false);

                        Toast.makeText(getApplicationContext(), "YOU HAVE WONE " + String.valueOf(i1), Toast.LENGTH_SHORT).show();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                user.setCoins(Integer.valueOf(String.valueOf(editTextForShufl.getText())), false);
                                Log.i("user", "MinuS THIS: "+ String.valueOf(editTextForShufl.getText()));
                                user.setCoins(i1, true);
                                Log.i("user", "PLUS THIS: " + String.valueOf(i1));
                                coins.setText(String.valueOf(user.getCoins()));
                            }
                        });
                        new CountDownTimer(10000, 1000) {

                            public void onTick(long millisUntilFinished) {

                            }

                            public void onFinish() {
                                playShufle.setEnabled(true);
                            }
                        }.start();

                    }
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
/*
        if(item.getItemId() == R.id.optionMenu){

        }*/
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

            machineThread(m2);

        }

        if (timeForMachine3 > m3.getTimerOfMachine()) {

            timeForMachine3 = 0;

            machineThread(m3);

        }

        if (timeForMachine4 > m4.getTimerOfMachine()) {

            timeForMachine4 = 0;

            machineThread(m4);
        }

        if (timeForMachine5 > m5.getTimerOfMachine()) {

            timeForMachine5 = 0;

            machineThread(m5);
        }


        if (timeForMachine6 > m6.getTimerOfMachine()) {

            timeForMachine6 = 0;

            machineThread(m6);
        }

        if (timeForMachine7 > m7.getTimerOfMachine()) {

            timeForMachine7 = 0;

            machineThread(m7);
        }

        if (timeForMachine8 > m8.getTimerOfMachine()) {

            timeForMachine8 = 0;

            machineThread(m8);
        }

        if (timeForMachine9 > m9.getTimerOfMachine()) {

            timeForMachine9 = 0;

            machineThread(m9);


        }


        if (timeForMachine10 > m10.getTimerOfMachine()) {

            timeForMachine10 = 0;

            machineThread(m10);
        }
    }

    private void machineThread(Machine mech){
        Log.i("user", "timer for" + String.valueOf(mech.getTimerOfMachine()));
        realm = Realm.getDefaultInstance();
        final Material material = realm.where(Material.class).equalTo("name", mech.getNameOfMaterial()).findFirst();
        final Material material2 = realm.where(Material.class).equalTo("name", mech.getNameOfNeededMaterial()).findFirst();

        if (mech.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
            Log.i("user", "in IF STATMENT For " + mech.getName());
            int numberOfMaterialsAdd = 0;
            int numberOfMaterials = material2.getNumberOf();

            for (int i = 0; i < mech.getNumberOfWorkersOnMachine(); i++) {
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

            numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

            costOfWorkers.setText("Cost: " + String.valueOf(worker.getCost()));

            coins.setText(String.valueOf("Coins: " + user.getCoins()));
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

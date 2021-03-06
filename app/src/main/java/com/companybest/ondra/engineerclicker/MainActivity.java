package com.companybest.ondra.engineerclicker;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.Activitis.BettingTab;
import com.companybest.ondra.engineerclicker.Activitis.CreditFragment;
import com.companybest.ondra.engineerclicker.Activitis.InfTab;
import com.companybest.ondra.engineerclicker.Activitis.IntroActivity;
import com.companybest.ondra.engineerclicker.Activitis.MechTab;
import com.companybest.ondra.engineerclicker.Activitis.ResetGameFragment;
import com.companybest.ondra.engineerclicker.Activitis.SettingFragment;
import com.companybest.ondra.engineerclicker.Activitis.StockTab;
import com.companybest.ondra.engineerclicker.Activitis.UpgradeTab;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.References.MainReferences;
import com.google.android.gms.ads.MobileAds;

import io.realm.Realm;

// Running on android studio 3.0 and gradle 4.1

public class MainActivity extends RealmBaseActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    public ViewPager mViewPager;

    public static MainReferences mainReferences;


    TextView coins;

    //VARIABLES FOR MUSIC
    MediaPlayer mediaPlayer;
    public static AudioManager audioManager;

    private Realm realm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("");

        setContentView(R.layout.activity_main);

        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3940256099942544~3347511713");


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);


        // IF SERVICE IS NOT RUNNING START IT
        if (!isMyServiceRunning(MyService.class)) {
            startService(new Intent(getBaseContext(), MyService.class).putExtra("outOfApp", false));
            Log.i("user", "new RUN");
        } else {
            Log.i("user", "RUNNING");

        }

        //DEFAULT REALM INSTANCE/CONFIG GETTING FROM RealmBaseActivity
        Realm.setDefaultConfiguration(getRealmConfig());

        //SHARED PREFERENCES IS USED FOR FIRST TIME CREATING SO THE MACHINES CAN BE CREATED AND FOR SOUND AND MUSIC SET
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);

        //REFERENCE FOR REAL OBJECT
        mainReferences = new MainReferences();

        if (sharedPreferences.getInt("created", 0) == 0) {
            //CREATING MACHINES JUST WHEN APP IS CREATED FOR THE FIRST TIME
            sharedPreferences.edit().putInt("created", 1).apply();
            mainReferences.createAllMachines();
            mainReferences.createAllMaterials();
            mainReferences.createAllUpgrades();
            mainReferences.createWorker();
            mainReferences.createUser();
            sharedPreferences.edit().putInt("music", 0).apply();
            sharedPreferences.edit().putInt("sound", 0).apply();
            Intent i = new Intent(this, IntroActivity.class);
            startActivity(i);
        } else if (sharedPreferences.getInt("created", 0) == 1) {
            //SECOND CREATE
            sharedPreferences.edit().putInt("created", 2).apply();
        } else if (sharedPreferences.getInt("created", 0) == 2) {
            // PROBLEMS WITH ONE MACHINE AND ONE UPGRADE, IF SOMEONE DOWNLOAD
            // THE GAME THE DAY IT CAME OUT HE NEEDS TO UPDATE, DOWNLOAD LATER DONT NEED TO UPDATE

            /*
            //THIRD CREATE
            sharedPreferences.edit().putInt("created", 3).apply();
            Realm realm = Realm.getDefaultInstance();
            try {
                final Upgrade upgrade = realm.where(Upgrade.class).equalTo("name", "Upgrade hole cost +4").findFirst();
                final Machine machine = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine10).findFirst();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        upgrade.setNameOfMaterialGive(mainReferences.nameOfMaterialToGiveUpgrade4);
                        machine.setMaxTimerOfMachine(mainReferences.maxTimerOfMachine10, true);
                        machine.setTimerOfMachine(mainReferences.maxTimerOfMachine10, true);
                        machine.setExpGive(mainReferences.expGiveMach10);
                        Log.i("user", "Machine UPGRADE WAS DONE");
                    }
                });

            }finally {
                realm.close();
            }*/
        } else if (sharedPreferences.getInt("created", 0) == 3) {
            /*
            //FOURTH CREATE
            sharedPreferences.edit().putInt("created", 3).apply();
            Realm realm = Realm.getDefaultInstance();
            try {
                final Machine machine = realm.where(Machine.class).equalTo("name", mainReferences.nameOfMachine10).findFirst();

                if (machine.getExpGive() != 60000 || machine.getTimerOfMachine() > 1800) {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            machine.setMaxTimerOfMachine(mainReferences.maxTimerOfMachine10, true);
                            machine.setTimerOfMachine(mainReferences.maxTimerOfMachine10, true);
                            machine.setExpGive(mainReferences.expGiveMach10);
                            Log.i("user", "Machine UPGRADE WAS DOMNE VERSION 3: " + String.valueOf(machine.getTimerOfMachine()));
                        }
                    });
                }else {
                    Log.i("user", "ELSE LOOP");

                }
            } finally {
                realm.close();
            }*/
        }

        //START MUSIC
        startMusic();


        //COIN IMAGE
        ImageView coinsImg = (ImageView) findViewById(R.id.coinsImg);
        Glide.with(this).load(getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(coinsImg);

        //SETTING USERS COINS
        realm = Realm.getDefaultInstance();
        final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();

        /*
        //TEST METHOD
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                user.setCoins(600000000, true);
            }
        });*/
        coins = (TextView) findViewById(R.id.coins);
        coins.setText("" + String.valueOf(user.getCoins()));

    }

    public void startMusic() {
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.bac_mus);
        mediaPlayer.start();
        mediaPlayer.setLooping(true);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, sharedPreferences.getInt("music", 0), 0);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
            //SETTINGS
            FragmentManager fm = getSupportFragmentManager();
            SettingFragment settingFragment = new SettingFragment(getApplicationContext());
            settingFragment.show(fm, "user");

            return true;
        } else if (id == R.id.action_credit) {
            //CREDIT
            FragmentManager fm = getSupportFragmentManager();
            CreditFragment cretidFragment = new CreditFragment(getApplicationContext());
            cretidFragment.show(fm, "user");

            return true;
        } else if (id == R.id.action_help) {
            //HELP
            Intent i1 = new Intent(this, IntroActivity.class);
            startActivity(i1);

            return true;
        } else if (id == R.id.resetGame) {
            //RESET GAME
            FragmentManager fm = getSupportFragmentManager();
            ResetGameFragment resetGameFragment = new ResetGameFragment(getApplicationContext());
            resetGameFragment.show(fm, "user");

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        startMusic();
    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        mediaPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) mediaPlayer.release();
        realm.close();
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    MechTab mechTab = new MechTab();
                    return mechTab;
                case 1:
                    StockTab stockTab = new StockTab();
                    return stockTab;
                case 2:
                    InfTab infTab = new InfTab();
                    return infTab;
                case 3:
                    UpgradeTab upgradeTab = new UpgradeTab();
                    return upgradeTab;
                case 4:
                    BettingTab bettingTab = new BettingTab();
                    return bettingTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 5 total pages.
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MACH";
                case 1:
                    return "STOCK";
                case 2:
                    return "INF";
                case 3:
                    return "UPG";
                case 4:
                    return "Bet";
            }
            return null;
        }
    }
}

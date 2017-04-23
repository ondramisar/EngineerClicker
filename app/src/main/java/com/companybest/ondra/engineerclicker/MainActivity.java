package com.companybest.ondra.engineerclicker;

import android.app.ActivityManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Activitis.BettingTab;
import com.companybest.ondra.engineerclicker.Activitis.CreditFragment;
import com.companybest.ondra.engineerclicker.Activitis.MechTab;
import com.companybest.ondra.engineerclicker.Activitis.SettingFragment;
import com.companybest.ondra.engineerclicker.Activitis.StockTab;
import com.companybest.ondra.engineerclicker.Activitis.UpgradeTab;
import com.companybest.ondra.engineerclicker.GameLoop.MainThread;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.References.MainReferences;
import com.google.android.gms.ads.MobileAds;

import io.realm.Realm;

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
    private ViewPager mViewPager;

    public static MainReferences mainReferences;

    MainThread thread;
    StockTab stockTab;

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

    MechTab mechTab;


    public static TextView coins;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
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

        //THREAD FOR GAME LOOP
        thread = new MainThread(this,true);
        starThread();

        Realm.setDefaultConfiguration(getRealmConfig());

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);

        //REFERENCE FOR REAL OBJECT
        mainReferences = new MainReferences();

        /*
        new ShowcaseView.Builder(this)
                .setTarget(new ViewTarget(R.id.coins, this))
                .setContentTitle("ShowcaseView")
                .setContentText("This is highlighting the Home button")
                .hideOnTouchOutside()
                .build();*/

        //CREATING MACHINES
        if (sharedPreferences.getInt("created", 0) == 0) {
            sharedPreferences.edit().putInt("created", 1).apply();
            mainReferences.createAllMachines();
            mainReferences.createAllMaterials();
            mainReferences.createAllUpgrades();
            mainReferences.createWorker();
            mainReferences.createUser();
            sharedPreferences.edit().putInt("music", 100).apply();
            sharedPreferences.edit().putInt("sound", 100).apply();
            Log.i("user", "first Time Created");
        } else if (sharedPreferences.getInt("created", 0) == 1) {
            Log.i("user", "was created");

        }



        if(isMyServiceRunning(MyService.class)) {
            stopService(new Intent(getBaseContext(), MyService.class));
        }

        Realm realm = Realm.getDefaultInstance();
        final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();
        coins = (TextView) findViewById(R.id.coins);
        coins.setText("" + String.valueOf(user.getCoins()));
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
                    MechTab.mainRealmAdapter.notifyDataSetChanged();
                    StockTab.materialRealmAdapter.notifyDataSetChanged();
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
        Realm realm = Realm.getDefaultInstance();
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
                MechTab.mainRealmAdapter.notifyDataSetChanged();
                StockTab.materialRealmAdapter.notifyDataSetChanged();
            }
        });


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
            FragmentManager fm = getSupportFragmentManager();

            SettingFragment settingFragment = new SettingFragment(getApplicationContext());
            settingFragment.show(fm, "user");
            return true;
        } else if (id == R.id.action_credit) {
            FragmentManager fm = getSupportFragmentManager();

            CreditFragment cretidFragment = new CreditFragment(getApplicationContext());
            cretidFragment.show(fm, "user");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }




    @Override
    protected void onRestart() {
        super.onRestart();
        stopService(new Intent(getBaseContext(), MyService.class));
        //thread = new MainThread(this,true);
        starThread();
        //loadAd();
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
        Intent intent = new Intent(this, com.companybest.ondra.engineerclicker.MainActivity.class);
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
            switch (position){
                case 0:
                    MechTab mechTab = new MechTab();
                    return mechTab;
                case 1:
                    StockTab stockTab = new StockTab();
                    return stockTab;
                case 2:
                    UpgradeTab upgradeTab = new UpgradeTab();
                    return upgradeTab;
                case 3:
                    BettingTab bettingTab = new BettingTab();
                    return bettingTab;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "MECH";
                case 1:
                    return "STOCK";
                case 2:
                    return "UPGRADE";
                case 3:
                    return "Betting";
            }
            return null;
        }
    }
}

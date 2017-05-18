package com.companybest.ondra.engineerclicker;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
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
import com.companybest.ondra.engineerclicker.Activitis.IntroActivity;
import com.companybest.ondra.engineerclicker.Activitis.MechTab;
import com.companybest.ondra.engineerclicker.Activitis.SettingFragment;
import com.companybest.ondra.engineerclicker.Activitis.StockTab;
import com.companybest.ondra.engineerclicker.Activitis.UpgradeTab;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.References.MainReferences;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.MobileAds;

import io.realm.Realm;
import io.realm.RealmResults;

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


    public static TextView coins;

    RealmResults<Machine> machines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this.getApplicationContext());

        setTitle("");

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





        if (!isMyServiceRunning(MyService.class)) {
            startService(new Intent(getBaseContext(), MyService.class).putExtra("outOfApp", false));
            Log.i("user", "SERVICE IN CREATE");
        }

        //DEFAULT REALM INSTANCE/CONFIG
        Realm.setDefaultConfiguration(getRealmConfig());

        //SHARED PREFERENCES IS USED FOR FIRST TIME CREATING SO THE MACHINES CAN BE CREATED AND FOR SOUND AND MUSIC SET
        SharedPreferences sharedPreferences = this.getSharedPreferences("com.companybest.ondra.engineerclicker.Activitis", Context.MODE_PRIVATE);

        //REFERENCE FOR REAL OBJECT
        mainReferences = new MainReferences();


        //CREATING MACHINES JUST WHEN APP IS CREATED FOR THE FIRST TIME
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
            Intent i = new Intent(this, IntroActivity.class);
            startActivity(i);
        }

        //COIN IMAGE
        SimpleDraweeView coinsImg = (SimpleDraweeView) findViewById(R.id.coinsImg);
        int resourceId1 = this.getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri1 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId1))
                .build();
        coinsImg.setImageURI(uri1);


        //USE OF REALM INSTANCE AND CLOSING IT
        Realm realm = Realm.getDefaultInstance();
        try {
            final User user = realm.where(User.class).equalTo("name", mainReferences.name).findFirst();
            coins = (TextView) findViewById(R.id.coins);
            coins.setText("" + String.valueOf(user.getCoins()));
        } finally {
            realm.close();
        }
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
            FragmentManager fm = getSupportFragmentManager();

            SettingFragment settingFragment = new SettingFragment(getApplicationContext());
            settingFragment.show(fm, "user");
            return true;
        } else if (id == R.id.action_credit) {
            FragmentManager fm = getSupportFragmentManager();

            CreditFragment cretidFragment = new CreditFragment(getApplicationContext());
            cretidFragment.show(fm, "user");
            return true;
        } else if (id == R.id.action_help) {

            Intent i1 = new Intent(this, IntroActivity.class);
            startActivity(i1);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.i("user", "RESTART");
    }

    @Override
    protected void onStop() {
        // call the superclass method first
        super.onStop();
        Log.i("user", "STOP");
        //startService(new Intent(getBaseContext(), MyService.class).putExtra("outOfApp", true));
        //thread.setRunning(false);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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

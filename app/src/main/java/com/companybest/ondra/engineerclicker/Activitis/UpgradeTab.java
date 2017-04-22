package com.companybest.ondra.engineerclicker.Activitis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.companybest.ondra.engineerclicker.Adapters.UpgradeRealAdapter;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class UpgradeTab extends Fragment {

    UpgradeRealAdapter upgradeRealAdapter;
    RealmRecyclerView upgradeRecyclerView;

    //REALM DATABASE
    RealmResults<Upgrade> upgrades;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.upgrade_tab, container, false);

        Realm realm = Realm.getDefaultInstance();

        //AD VIEW
        AdView mAdView3 = (AdView) rootView.findViewById(R.id.adView3);
        AdRequest adRequest3 = new AdRequest.Builder().build();
        mAdView3.loadAd(adRequest3);

        //FOR ADAPTER LIST OF MACHINES
        upgrades = realm
                .where(Upgrade.class)
                .findAll();

        //Log.i("user", String.valueOf(machines));
        upgradeRealAdapter = new UpgradeRealAdapter(getContext(), upgrades, true, false);


        //RECYCLERVIEW
        upgradeRecyclerView = (RealmRecyclerView) rootView.findViewById(R.id.realm_recycler_view_for_upgrades);
        upgradeRecyclerView.setAdapter(upgradeRealAdapter);

        return rootView;
    }
}

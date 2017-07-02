package com.companybest.ondra.engineerclicker.Activitis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.companybest.ondra.engineerclicker.Adapters.MaterialRealmAdapter;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class StockTab extends Fragment {

    MaterialRealmAdapter materialRealmAdapter;
    RealmRecyclerView materialRecyclerView;

    //REALM DATABASE
    RealmResults<Material> materials;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.stock_tab, container, false);



        //AD VIEW
        AdView mAdView2 = (AdView) rootView.findViewById(R.id.adView2);
        AdRequest adRequest2 = new AdRequest.Builder().build();
        //mAdView2.loadAd(adRequest2);

        Realm realm = Realm.getDefaultInstance();
        try {
            //FOR ADAPTER LIST OF MACHINES
            materials = realm
                    .where(Material.class)
                    .findAll();

            materialRealmAdapter = new MaterialRealmAdapter(getContext(), materials, true, false);


            //RECYCLERVIEW
            materialRecyclerView = (RealmRecyclerView) rootView.findViewById(R.id.realm_recycler_view_for_products);
            materialRecyclerView.setAdapter(materialRealmAdapter);
        } finally {
            realm.close();
        }

        return rootView;
    }

}

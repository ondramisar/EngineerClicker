package com.companybest.ondra.engineerclicker.Activitis;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.Adapters.InfoAdapter;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class InfTab extends Fragment {

    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.inf_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        RealmRecyclerView infoList = (RealmRecyclerView) rootView.findViewById(R.id.info_rcycler_view);

        ImageView clickImg = (ImageView) rootView.findViewById(R.id.clickImg);


        //IMG OF BUILDING
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("build", "drawable", "com.companybest.ondra.engineerclicker")).into(clickImg);


        realm = Realm.getDefaultInstance();
        RealmResults<User> users = realm
                .where(User.class)
                .findAll();

        InfoAdapter infoAdapter = new InfoAdapter(getContext(), users, true, false);

        infoList.setAdapter(infoAdapter);


        clickImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final User user = realm.where(User.class).findFirst();

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        user.setCoins((float) user.getLevel(), true);
                    }
                });


                TextView txtView = (TextView) ((MainActivity) getContext()).findViewById(R.id.coins);
                txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
            }
        });


        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

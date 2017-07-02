package com.companybest.ondra.engineerclicker.Activitis;


import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Adapters.InfoAdapter;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;

public class InfTab extends Fragment{



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.inf_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView5);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        RealmRecyclerView infoList = (RealmRecyclerView) rootView.findViewById(R.id.info_rcycler_view);

        SimpleDraweeView clickImg = (SimpleDraweeView) rootView.findViewById(R.id.clickImg);


        int resourceId = getContext().getResources().getIdentifier("build", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId))
                .build();
        clickImg.setImageURI(uri);



        final Realm realm = Realm.getDefaultInstance();
        try {
        RealmResults<User> users =  realm
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


                    TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                    txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                }
            });

        }finally {
            realm.close();
        }

        return rootView;
    }
}

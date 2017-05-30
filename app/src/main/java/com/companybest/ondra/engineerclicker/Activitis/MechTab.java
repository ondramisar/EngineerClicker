package com.companybest.ondra.engineerclicker.Activitis;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Adapters.MainRealmAdapter;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;
import com.companybest.ondra.engineerclicker.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class MechTab extends Fragment {
    RealmResults<Machine> machines;
    MainRealmAdapter mainRealmAdapter;
    static public TextView numberOfWorkers;
    Button plusWorker;
    static public TextView costOfWorkers;
    MainActivity mainActivity;

    RealmRecyclerView mainScreenRecyclerView;

    SimpleDraweeView workerImg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.mech_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final Realm realm = Realm.getDefaultInstance();
        try {
            //FOR ADAPTER LIST OF MACHINES
            machines = realm
                    .where(Machine.class)
                    .findAll();
            mainRealmAdapter = new MainRealmAdapter(getContext(), machines, true, false);

            //RECYCLERVIEW
            mainScreenRecyclerView = (RealmRecyclerView) rootView.findViewById(R.id.realm_recycler_view);
            mainScreenRecyclerView.setAdapter(mainRealmAdapter);


            SimpleDraweeView costOfWorker = (SimpleDraweeView) rootView.findViewById(R.id.costOfWorker);
            int resourceId1 = getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
            Uri uri1 = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(resourceId1))
                    .build();
            costOfWorker.setImageURI(uri1);

            workerImg = (SimpleDraweeView) rootView.findViewById(R.id.workerImg);
            int resourceId = getContext().getResources().getIdentifier("worker_helmet", "drawable", "com.companybest.ondra.engineerclicker");
            Uri uri = new Uri.Builder()
                    .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                    .path(String.valueOf(resourceId))
                    .build();
            workerImg.setImageURI(uri);

            //TEXT VIEWS OF WORKERS COINS AND COST OF WORKERS AND SETTING VALUE
            numberOfWorkers = (TextView) rootView.findViewById(R.id.numberOfWorkers);
            costOfWorkers = (TextView) rootView.findViewById(R.id.costOfWorkers);
            plusWorker = (Button) rootView.findViewById(R.id.plusWorker);
            plusWorker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //GETTING WORKERS AND USER COINS
                    final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
                    final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();

                    if (user.getCoins() >= worker.getCost()) {

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                worker.setNumberOf(1, true);

                                int calculatingNamburOfCost = worker.getCost() / 5;

                                user.setCoins(worker.getCost(), false);

                                worker.setCost(calculatingNamburOfCost, true);

                            }
                        });

                        numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

                        costOfWorkers.setText("" + String.valueOf(worker.getCost()));

                        TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                        txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));

                    }
                }
            });

            BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
            numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));
            costOfWorkers.setText("" + String.valueOf(worker.getCost()));

        }finally {
            //realm.close();
        }

        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}

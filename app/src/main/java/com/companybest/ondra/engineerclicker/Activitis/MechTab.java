package com.companybest.ondra.engineerclicker.Activitis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class MechTab extends Fragment {
    RealmResults<Machine> machines;
    public static MainRealmAdapter mainRealmAdapter;
    public static TextView numberOfWorkers;
    TextView costOfWorkers;
    MainActivity mainActivity;

    RealmRecyclerView mainScreenRecyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.mech_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Realm realm = Realm.getDefaultInstance();

        //FOR ADAPTER LIST OF MACHINES
        machines = realm
                .where(Machine.class)
                .findAll();

        Log.i("user", String.valueOf(machines));
        mainRealmAdapter = new MainRealmAdapter(getContext(), machines, true, false);

        //RECYCLERVIEW
        mainScreenRecyclerView = (RealmRecyclerView) rootView.findViewById(R.id.realm_recycler_view);
        mainScreenRecyclerView.setAdapter(mainRealmAdapter);



        //TEXT VIEWS OF WORKERS COINS AND COST OF WORKERS AND SETTING VALUE
        numberOfWorkers = (TextView) rootView.findViewById(R.id.numberOfWorkers);
        costOfWorkers = (TextView) rootView.findViewById(R.id.costOfWorkers);
        Button plusWorker = (Button) rootView.findViewById(R.id.plusWorker);
        plusWorker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GETTING WORKERS AND USER COINS
                Realm realm = Realm.getDefaultInstance();
                final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
                final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();

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

                    costOfWorkers.setText("" + String.valueOf(worker.getCost()));

                    mainActivity.coins.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                    Log.i("user", "" + user.getCoins());

                }
            }
        });


        BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
        final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();
        Log.i("user", String.valueOf(worker.getNumberOf()));
        numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));
        costOfWorkers.setText("" + String.valueOf(worker.getCost()));
        return rootView;
    }


}

package com.companybest.ondra.engineerclicker.Activitis;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.Adapters.MachineRealmAdapter;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.BasicWorker;
import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class MechTab extends Fragment {
    RealmResults<Machine> machines;
    MachineRealmAdapter machineRealmAdapter;
    static public TextView numberOfWorkers;
    Button plusWorker;
    static public TextView costOfWorkers;
    MainActivity mainActivity;

    RealmRecyclerView mainScreenRecyclerView;

    ImageView workerImg;

    private Realm realm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.mech_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        //mAdView.loadAd(adRequest);

        realm = Realm.getDefaultInstance();
        //FOR ADAPTER LIST OF MACHINES
        machines = realm
                .where(Machine.class)
                .findAll();
        machineRealmAdapter = new MachineRealmAdapter(getContext(), machines, true, false);

        //RECYCLERVIEW
        mainScreenRecyclerView = (RealmRecyclerView) rootView.findViewById(R.id.realm_recycler_view);
        mainScreenRecyclerView.setAdapter(machineRealmAdapter);


        //COIN IMG
        ImageView costOfWorker = (ImageView) rootView.findViewById(R.id.costOfWorker);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(costOfWorker);

        //WORKER IMG
        workerImg = (ImageView) rootView.findViewById(R.id.workerImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("worker_helmet", "drawable", "com.companybest.ondra.engineerclicker")).into(workerImg);

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

                    TextView txtView = (TextView) ((MainActivity) getContext()).findViewById(R.id.coins);
                    txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));

                }
            }
        });

        BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", mainActivity.mainReferences.nameOfWorker).findFirst();
        numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));
        costOfWorkers.setText("" + String.valueOf(worker.getCost()));


        return rootView;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

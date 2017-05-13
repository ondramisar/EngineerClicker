package com.companybest.ondra.engineerclicker.Activitis;

import android.net.Uri;
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
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import co.moonmonkeylabs.realmrecyclerview.RealmRecyclerView;
import io.realm.Realm;
import io.realm.RealmResults;


public class MechTab extends Fragment {
    RealmResults<Machine> machines;
    public static MainRealmAdapter mainRealmAdapter;
    public static TextView numberOfWorkers;
    public static Button plusWorker;
    TextView costOfWorkers;
    MainActivity mainActivity;

    RealmRecyclerView mainScreenRecyclerView;

    public static SimpleDraweeView workerImg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.mech_tab, container, false);

        //AD VIEW
        AdView mAdView = (AdView) rootView.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        final Realm realm = Realm.getDefaultInstance();
            //FOR ADAPTER LIST OF MACHINES
            machines = realm
                    .where(Machine.class)
                    .findAll();
        Log.i("user", String.valueOf(machines));
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

        /*
        // sequence example
        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(500); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(getActivity(), "FIRST");

        sequence.setConfig(config);

        sequence.addSequenceItem(workerImg,
                "These are yours workers, They will work on your machines", "GOT IT");

        sequence.addSequenceItem(plusWorker,
                "This is Button for buying workers", "GOT IT");

        sequence.addSequenceItem(numberOfWorkers,
                "This is number of workers you have", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "These are tabs of your machines", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "On the left you have number of machines you own", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "Then under is number of workers on machines", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "On the right you have cost of machine", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "Then time of machine to make a material when work is working", "GOT IT");

        sequence.addSequenceItem(mainScreenRecyclerView,
                "Then what kind of material is machine making", "GOT IT");

        sequence.start();*/


        return rootView;
    }


}

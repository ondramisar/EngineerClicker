package com.companybest.ondra.engineerclicker.Adapters;

import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Activitis.MechTab;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;
import com.companybest.ondra.engineerclicker.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

public class MainRealmAdapter extends RealmBasedRecyclerViewAdapter<Machine, MainRealmAdapter.ViewHolder> {


    public class ViewHolder extends RealmViewHolder {

        public TextView numberOfMachines;
        public TextView numberOfWorkersOnMach;
        public TextView costOfMachine;
        public TextView nameOfMachine;
        public Button plusMachine;
        public Button plusWorkerOnMachine;
        public Button minusWorkerOnMachine;
        public TextView timer;
        public TextView materialMake;
        //public ImageView imageView;
        public SimpleDraweeView imageView;
        public SimpleDraweeView costOfMachineImg;
        public SimpleDraweeView timeOfMachineImg;
        public SimpleDraweeView materialOfMachineImg;
        public SimpleDraweeView workerOnMachineImg;

        public ViewHolder(FrameLayout container) {
            super(container);
            this.numberOfMachines = (TextView) container.findViewById(R.id.numberOfMachine);
            this.numberOfWorkersOnMach = (TextView) container.findViewById(R.id.numberOfWokersOnMach);
            this.costOfMachine = (TextView) container.findViewById(R.id.costOfMachine);
            this.nameOfMachine = (TextView) container.findViewById(R.id.nameOfMachine);
            this.timer = (TextView) container.findViewById(R.id.timer);
            this.plusMachine = (Button) container.findViewById(R.id.plusMachine);
            this.plusWorkerOnMachine = (Button) container.findViewById(R.id.plusWorkerOnMach);
            this.minusWorkerOnMachine = (Button) container.findViewById(R.id.minusWorkerOnMach);
            this.materialMake = (TextView) container.findViewById(R.id.materialMake);
            //this.imageView = (ImageView) container.findViewById(R.id.imageView);
            this.imageView = (SimpleDraweeView) container.findViewById(R.id.imageView);
            this.costOfMachineImg = (SimpleDraweeView) container.findViewById(R.id.costOfMachineImg);
            this.timeOfMachineImg = (SimpleDraweeView) container.findViewById(R.id.timeOfMachineImg);
            this.materialOfMachineImg = (SimpleDraweeView) container.findViewById(R.id.materialOfMachineImg);
            this.workerOnMachineImg = (SimpleDraweeView) container.findViewById(R.id.workerOnMachImg);
        }
    }


    public MainRealmAdapter(android.content.Context context, RealmResults<Machine> realmResults, boolean automaticUpdate, boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.item_main_menu, viewGroup, false);
        ViewHolder vh = new ViewHolder((FrameLayout) v);
        return vh;
    }




    @Override
    public void onBindRealmViewHolder(final ViewHolder viewHolder, int position) {
        final Machine machine = realmResults.get(position);

        viewHolder.numberOfMachines.setText(String.valueOf(machine.getNumberOf()));
        viewHolder.costOfMachine.setText("" + String.valueOf(machine.getCost()));
        viewHolder.numberOfWorkersOnMach.setText(String.valueOf(machine.getNumberOfWorkersOnMachine()));
        viewHolder.nameOfMachine.setText(machine.getName());
        viewHolder.timer.setText("" + String.valueOf(machine.getTimerOfMachine()));
        viewHolder.materialMake.setText("" + machine.getNameOfMaterial());

        int resourceId = getContext().getResources().getIdentifier(machine.getNameOfImage(), "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId))
                .build();
        viewHolder.imageView.setImageURI(uri);

        int resourceId1 = getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri1 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId1))
                .build();
        viewHolder.costOfMachineImg.setImageURI(uri1);

        int resourceId2 = getContext().getResources().getIdentifier("time", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri2 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId2))
                .build();
        viewHolder.timeOfMachineImg.setImageURI(uri2);

        int resourceId3 = getContext().getResources().getIdentifier("gold", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri3 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId3))
                .build();
        viewHolder.materialOfMachineImg.setImageURI(uri3);


        int resourceId4 = getContext().getResources().getIdentifier("worker_on_mach", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri4 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId4))
                .build();
        viewHolder.workerOnMachineImg.setImageURI(uri4);

        final Realm realm = Realm.getDefaultInstance();
        viewHolder.plusMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                if (user.getCoins() >= machine.getCost()) {

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            user.setCoins(machine.getCost(), false);
                            Log.i("user","Cost of machine: "+ String.valueOf(machine.getCost()));
                            machine.setNumberOf(1,true);
                            machine.setCost(machine.getCost(), true);

                        }
                    });

                    viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));
                    viewHolder.costOfMachine.setText("" + String.valueOf(machine.getCost()));
                    MainActivity.coins.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                }

                Log.i("user", "COINS: "+ String.valueOf(user.getCoins()));
                Log.i("user","Machine: "+ String.valueOf(machine.getNumberOf()));
                Log.i("user","Cost of machine: "+ String.valueOf(machine.getCost()));
            }
        });

        viewHolder.plusWorkerOnMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", MainActivity.mainReferences.nameOfWorker).findFirst();
                Log.i("user","number of worker: " +  String.valueOf(worker.getNumberOf()));

                if (worker.getNumberOf() > 0 && machine.getNumberOf() > 0 ) {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            machine.setNumberOfWorkersOnMachine(1, true);

                            worker.setNumberOf(1, false);

                            machine.setNumberOf(1,false);

                        }
                    });

                    viewHolder.numberOfWorkersOnMach.setText("" + String.valueOf(machine.getNumberOfWorkersOnMachine()));

                    MechTab.numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

                    viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));

                    Log.i("user", String.valueOf(machine.getNumberOfWorkersOnMachine()));
                }
            }
        });

        viewHolder.minusWorkerOnMachine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", MainActivity.mainReferences.nameOfWorker).findFirst();
                if (machine.getNumberOfWorkersOnMachine() > 0) {

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            machine.setNumberOfWorkersOnMachine(1, false);

                            worker.setNumberOf(1, true);

                            machine.setNumberOf(1,true);

                        }
                    });

                    viewHolder.numberOfWorkersOnMach.setText("" + String.valueOf(machine.getNumberOfWorkersOnMachine()));

                    MechTab.numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

                    viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));

                }
            }
        });
    }
}
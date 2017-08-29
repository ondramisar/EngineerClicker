package com.companybest.ondra.engineerclicker.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.Activitis.MechTab;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.BasicWorker;
import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;

import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;

//ADAPTER FOR MACHINE RECYCLER VIEW

public class MachineRealmAdapter extends RealmBasedRecyclerViewAdapter<Machine, MachineRealmAdapter.ViewHolder> {


    class ViewHolder extends RealmViewHolder {

        TextView numberOfMachines;
        TextView numberOfWorkersOnMach;
        TextView costOfMachine;
        TextView nameOfMachine;
        Button plusMachine;
        Button plusWorkerOnMachine;
        Button minusWorkerOnMachine;
        TextView timer;
        TextView materialMake;
        ImageView imageView;
        ImageView costOfMachineImg;
        ImageView timeOfMachineImg;
        ImageView materialOfMachineImg;
        ImageView workerOnMachineImg;
        ImageView smallMachImg;
        ImageView bacForText;
        TextView workingTextView;

        ViewHolder(FrameLayout container) {
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
            this.imageView = (ImageView) container.findViewById(R.id.imageView);
            this.costOfMachineImg = (ImageView) container.findViewById(R.id.costOfMachineImg);
            this.timeOfMachineImg = (ImageView) container.findViewById(R.id.timeOfMachineImg);
            this.materialOfMachineImg = (ImageView) container.findViewById(R.id.materialOfMachineImg);
            this.workerOnMachineImg = (ImageView) container.findViewById(R.id.workerOnMachImg);
            this.smallMachImg = (ImageView) container.findViewById(R.id.smallMachImg);
            this.workingTextView = (TextView) container.findViewById(R.id.workingTextView);
            this.bacForText = (ImageView) container.findViewById(R.id.bac_for_text);
        }
    }


    public MachineRealmAdapter(android.content.Context context, RealmResults<Machine> realmResults, boolean automaticUpdate, boolean animateResults) {
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

        if (machine.getNumberOfWorkersOnMachine() > 0) {
            viewHolder.workingTextView.setText("WORKING...");
        } else {
            viewHolder.workingTextView.setText("STOPPED");
        }

        //MACHINE IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier(machine.getNameOfImage(), "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.imageView);

        //COIN IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.costOfMachineImg);

        //TIME IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("time", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.timeOfMachineImg);

        //MATERIAL IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("gold", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.materialOfMachineImg);

        //WORKER ON MACHINE IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("worker_on_mach", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.workerOnMachineImg);

        //DEFAULT SMALL MACHINE IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("smallmach", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.smallMachImg);

        //BACK FOR TEXT IF IT IS WORKING OR NOT IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("bac_for_text", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.bacForText);


        final Realm realm = Realm.getDefaultInstance();
        try {
            viewHolder.plusMachine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                    if (user.getCoins() >= machine.getCost()) {

                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                user.setCoins(machine.getCost(), false);
                                machine.setNumberOf(1, true);
                                machine.setCost(machine.getCost(), true);

                                user.setExp(machine.getExpGive(), 0);
                            }
                        });

                        viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));
                        viewHolder.costOfMachine.setText("" + String.valueOf(machine.getCost()));

                        TextView txtView = (TextView) ((MainActivity) getContext()).findViewById(R.id.coins);
                        txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                    }

                }
            });

            viewHolder.plusWorkerOnMachine.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final BasicWorker worker = realm.where(BasicWorker.class).equalTo("name", MainActivity.mainReferences.nameOfWorker).findFirst();

                    if (worker.getNumberOf() > 0 && machine.getNumberOf() > 0) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                machine.setNumberOfWorkersOnMachine(1, true);

                                worker.setNumberOf(1, false);

                                machine.setNumberOf(1, false);

                            }
                        });

                        viewHolder.numberOfWorkersOnMach.setText("" + String.valueOf(machine.getNumberOfWorkersOnMachine()));

                        MechTab.numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));


                        viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));

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

                                machine.setNumberOf(1, true);

                            }
                        });

                        viewHolder.numberOfWorkersOnMach.setText("" + String.valueOf(machine.getNumberOfWorkersOnMachine()));

                        MechTab.numberOfWorkers.setText("" + String.valueOf(worker.getNumberOf()));

                        viewHolder.numberOfMachines.setText("" + String.valueOf(machine.getNumberOf()));

                    }
                }
            });

        } finally {
            realm.close();
        }
    }
}
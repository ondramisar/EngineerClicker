package com.companybest.ondra.engineerclicker.Activitis;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.BasicWorker;
import com.companybest.ondra.engineerclicker.R;
import com.companybest.ondra.engineerclicker.References.MainReferences;

import io.realm.Realm;
import io.realm.RealmResults;


public class ResetGameFragment extends DialogFragment {

    Context context;
    private Realm realm;

    public ResetGameFragment(Context context) {
        // Empty constructor required for DialogFragment
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.reset_game_fragment, container,
                false);

        TextView desriptionTextView = (TextView) rootView.findViewById(R.id.descripResetTextView);
        desriptionTextView.setText("Here you can reset your game from start");

        TextView whatYouGetText = (TextView) rootView.findViewById(R.id.whatYouGetTextView);
        whatYouGetText.setText("If you have 5 different kinds of machine working and you will restart the game you will get upgrade on your material to new start.\n" +
                "If you have 10 different kinds of machine working and you will restart the game you will get upgrade on your material to new start and you will get a new machine");

        final MainReferences mainReferences = new MainReferences();

        Button resetGameButton = (Button) rootView.findViewById(R.id.resetGameButton);
        resetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                realm = Realm.getDefaultInstance();

                BasicWorker worker = realm.where(BasicWorker.class).findFirst();
                final User user = realm.where(User.class).findFirst();
                RealmResults<Machine> machine = realm.where(Machine.class).findAll();
                int numberOfMachine = 0;

                for (int i = 0; i < machine.size(); i++) {
                    Machine m = machine.get(i);
                    if (m.getNumberOfWorkersOnMachine() > 0) {
                        numberOfMachine += 1;
                    }
                }

                //Log.i("user", "NUMEBR OF MACHINES " + String.valueOf(numberOfMachine));
                if (numberOfMachine < 5) {
                    deleteUpgrade();
                    mainReferences.createAllMachines();
                    mainReferences.createAllMaterials();
                    mainReferences.createAllUpgrades();
                    mainReferences.createWorker();
                    mainReferences.createPartOfUser();

                } else if (numberOfMachine >= 5 && numberOfMachine < 10) {
                    deleteUpgrade();
                    mainReferences.createMaterialBetter(user.getLevel() * 10);
                    Log.i("user", "NUMBER GIVIN FROM LEVEL " + String.valueOf(user.getLevel() * 10));
                    mainReferences.createAllMachines();
                    mainReferences.createAllUpgrades();
                    mainReferences.createWorker();
                    mainReferences.createPartOfUser();

                } else if (numberOfMachine == 10) {
                    deleteUpgrade();
                    mainReferences.createMaterialBetter(user.getLevel() * 10);
                    Log.i("user", "NUMBER GIVIN FROM LEVEL " + String.valueOf(user.getLevel() * 10));
                    mainReferences.createNewMaterial();
                    mainReferences.createAllMachines();
                    mainReferences.createNewMachinesFirst();
                    mainReferences.createAllUpgrades();
                    mainReferences.createNewUpgrade();
                    mainReferences.createWorker();
                    mainReferences.createPartOfUser();

                } else if (numberOfMachine > 10) {
                    deleteUpgrade();
                    mainReferences.createMaterialBetter(user.getLevel() * 10);
                    Log.i("user", "NUMBER GIVIN FROM LEVEL " + String.valueOf(user.getLevel() * 10));
                    mainReferences.createNewMaterialBetter(user.getLevel() * 10);
                    mainReferences.createAllMachines();
                    mainReferences.createNewMachinesFirst();
                    mainReferences.createAllUpgrades();
                    mainReferences.createNewUpgrade();
                    mainReferences.createWorker();
                    mainReferences.createPartOfUser();

                }


                MechTab.numberOfWorkers.setText(String.valueOf(worker.getNumberOf()));
                MechTab.costOfWorkers.setText(String.valueOf(worker.getCost()));
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        user.setCoins(user.getCoins(), false);
                        user.setCoins(5000, true);
                        user.setExp(500, 1);
                    }
                });

                if (user.getExp() < 0) {
                    if (user.getLevel() == 1) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                user.setExp(0, 2);

                            }
                        });
                    } else if (user.getLevel() > 1) {
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {
                                user.setLevel(1, false);
                                user.setExpNeeded(user.getExpNeeded() / 2, false);
                                user.setExp(user.getExpNeeded() + user.getExp(), 2);
                            }
                        });
                    }
                }
                TextView txtView = (TextView) ((MainActivity) getContext()).findViewById(R.id.coins);
                txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));


                ResetGameFragment.this.dismiss();
            }
        });

        // Do something else
        return rootView;
    }


    private void deleteUpgrade() {

        final RealmResults<Upgrade> upgrades = realm.where(Upgrade.class).findAll();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                upgrades.deleteAllFromRealm();
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        realm.close();
    }
}

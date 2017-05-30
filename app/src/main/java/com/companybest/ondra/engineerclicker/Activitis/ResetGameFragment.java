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
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.Models.Workers.BasicWorker;
import com.companybest.ondra.engineerclicker.R;
import com.companybest.ondra.engineerclicker.References.MainReferences;

import io.realm.Realm;
import io.realm.RealmResults;


public class ResetGameFragment extends DialogFragment {

    Context context;
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
        desriptionTextView.setText("HERE YOU CAN RESET YOUR GAME FROM START");
        //desriptionTextView.setText("THERE IS A NEW UPDATE AND YOU NEED TO START AGAIN, BUT YOU NOW YOU WILL HAVE LEVELS AND YOU WILL HAVE A NEW FEATURES");

        TextView whatYouGetText = (TextView) rootView.findViewById(R.id.whatYouGetTextView);
        whatYouGetText.setText("IF YOU WILL HAVE MORE THAN 5 DIFFERENT KINDS OF MACHINES AND RESTART GAME YOU WILL GET A BOOST TO A NEW START THAT DEPENDS ON YOUR LEVEL, YOUR MATERIALS WILL BE SELLING FOR A LOT MORE");

        final MainReferences mainReferences = new MainReferences();

        Button resetGameButton = (Button) rootView.findViewById(R.id.resetGameButton);
        resetGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Realm realm = Realm.getDefaultInstance();
                try{
                    BasicWorker worker = realm.where(BasicWorker.class).findFirst();
                    final User user = realm.where(User.class).findFirst();
                    RealmResults<Machine> machine = realm.where(Machine.class).findAll();
                    int numberOfMachine = 0;

                    for (int i = 0; i < machine.size();i++) {
                        Machine m = machine.get(i);
                        if (m.getNumberOfWorkersOnMachine() > 0) {
                            numberOfMachine += 1;
                        }
                    }

                    Log.i("user", "NUMEBR OF MACHINES" + String.valueOf(numberOfMachine));
                    if (numberOfMachine > 5){

                        mainReferences.createMaterialBetter(user.getLevel() * 10);
                    }



                    mainReferences.createAllMachines();
                    mainReferences.createAllMaterials();
                    mainReferences.createAllUpgrades();
                    mainReferences.createWorker();

                    MechTab.numberOfWorkers.setText(String.valueOf(worker.getNumberOf()));
                    MechTab.costOfWorkers.setText(String.valueOf(worker.getCost()));
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {
                            user.setCoins(user.getCoins(), false);
                            user.setCoins(5000, true);
                        }
                    });
                    TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                    txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));
                }finally {
                    realm.close();
                }

                ResetGameFragment.this.dismiss();
            }
        });

        // Do something else
        return rootView;
    }

}

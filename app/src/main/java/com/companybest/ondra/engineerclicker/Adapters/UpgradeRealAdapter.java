package com.companybest.ondra.engineerclicker.Adapters;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Activitis.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.Upgrade;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;

import java.util.Objects;

import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;


public class UpgradeRealAdapter extends RealmBasedRecyclerViewAdapter<Upgrade, UpgradeRealAdapter.ViewHolder> {

    public class ViewHolder extends RealmViewHolder {

        public TextView nameOfUpgrade;
        public TextView costOfUpgrade;
        public Button buyUpgrade;

        public ViewHolder(FrameLayout container) {
            super(container);
            this.nameOfUpgrade = (TextView) container.findViewById(R.id.nameOgUpgrade);
            this.costOfUpgrade = (TextView) container.findViewById(R.id.costOfUpgrade);
            this.buyUpgrade = (Button) container.findViewById(R.id.buyUpgrade);
        }
    }


    private Realm realm;
    private MainActivity mainActivity;

    public UpgradeRealAdapter(android.content.Context context, RealmResults<Upgrade> realmResults,boolean automaticUpdate, boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public UpgradeRealAdapter.ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.upgrade_menu, viewGroup, false);
        UpgradeRealAdapter.ViewHolder vh = new UpgradeRealAdapter.ViewHolder((FrameLayout) v);
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(final UpgradeRealAdapter.ViewHolder viewHolder, int position) {
        final Upgrade upgrade = realmResults.get(position);

        viewHolder.nameOfUpgrade.setText(String.valueOf(upgrade.getName()));
        viewHolder.costOfUpgrade.setText("Cost: " + String.valueOf(upgrade.getCost()));
        viewHolder.buyUpgrade.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                realm = Realm.getDefaultInstance();
                final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                if (user.getCoins() >= upgrade.getCost()) {

                    Log.i("user", upgrade.getForWhatToDo());
                    if (Objects.equals(upgrade.getForWhatToDo(), "time")){


                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    user.setTimeOutOfApp(upgrade.getWhatDo(), true);

                                    user.setCoins(upgrade.getCost(), false);
                                    Log.i("user", String.valueOf(user.getCost()));

                                    upgrade.setCost(upgrade.getCost() , true);

                                }
                            });
                            viewHolder.nameOfUpgrade.setText("Upgrade Time: " + String.valueOf(user.getTimeOutOfApp() * 100));
                        }
                    if (Objects.equals(upgrade.getForWhatToDo(), "material")){

                        realm = Realm.getDefaultInstance();
                        final Material material = realm.where(Material.class).equalTo("name", upgrade.getNameOfMaterialGive()).findFirst();
                        realm.executeTransaction(new Realm.Transaction() {
                            @Override
                            public void execute(Realm realm) {

                                user.setCoins(upgrade.getCost(),false);

                                material.setCost(upgrade.getWhatDo(),true);

                                upgrade.setCost(upgrade.getCost()/3 , true);
                                Log.i("user","Material Cost: " +  String.valueOf(material.getCost()));

                            }
                        });
                    }

                    if (Objects.equals(upgrade.getForWhatToDo(), "machine")){


                        realm = Realm.getDefaultInstance();
                        final Machine machine = realm.where(Machine.class).equalTo("name", upgrade.getNameOfMachinetoGive()).findFirst();
                        if (machine.getTimerOfMachine() >= 20) {
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    user.setCoins(upgrade.getCost(), false);

                                    machine.setTimerOfMachine(machine.getTimerOfMachine() / 20, false);

                                    upgrade.setCost(upgrade.getCost() / 3, true);
                                }
                            });
                        } else{
                            viewHolder.buyUpgrade.setEnabled(false);
                        }

                    }

                    mainActivity.mechanicActivity.coins.setText("Coins: " + String.valueOf(user.getCoins()));

                    viewHolder.costOfUpgrade.setText("Cost: " + String.valueOf(upgrade.getCost()));

                }


            }
        });

    }
}

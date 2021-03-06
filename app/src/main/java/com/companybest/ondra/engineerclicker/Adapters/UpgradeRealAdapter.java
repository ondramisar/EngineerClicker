package com.companybest.ondra.engineerclicker.Adapters;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Machine;
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
        public ImageView upgradeImg;
        public ImageView upgradeCostImg;

        public ViewHolder(FrameLayout container) {
            super(container);
            this.nameOfUpgrade = (TextView) container.findViewById(R.id.nameOgUpgrade);
            this.costOfUpgrade = (TextView) container.findViewById(R.id.costOfUpgrade);
            this.buyUpgrade = (Button) container.findViewById(R.id.buyUpgrade);
            this.upgradeImg = (ImageView) container.findViewById(R.id.imageViewOfUpgrade);
            this.upgradeCostImg = (ImageView) container.findViewById(R.id.costOfUpgrdImg);
        }
    }


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
        viewHolder.costOfUpgrade.setText("" + String.valueOf(upgrade.getCost()));

        //UPGRADE IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier(upgrade.getNameOfImg(), "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.upgradeImg);

        //COIN IMG
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(viewHolder.upgradeCostImg);

        final Realm realm = Realm.getDefaultInstance();
        try {
            viewHolder.buyUpgrade.setOnClickListener(new View.OnClickListener() {
                @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                @Override
                public void onClick(View v) {
                    final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                    if (user.getCoins() >= upgrade.getCost()) {

                        //MATERIL UPGRADE
                        if (Objects.equals(upgrade.getForWhatToDo(), "material")) {

                            final Material material = realm.where(Material.class).equalTo("name", upgrade.getNameOfMaterialGive()).findFirst();
                            realm.executeTransaction(new Realm.Transaction() {
                                @Override
                                public void execute(Realm realm) {

                                    user.setCoins(upgrade.getCost(), false);

                                    material.setCost(upgrade.getWhatDo(), true);

                                    upgrade.setCost(upgrade.getCost() / 3, true);

                                }
                            });
                        }

                        //MACHINE UPGRADE
                        if (Objects.equals(upgrade.getForWhatToDo(), "machine")) {

                            final Machine machine = realm.where(Machine.class).equalTo("name", upgrade.getNameOfMachinetoGive()).findFirst();
                            if (machine.getTimerOfMachine() >= 20) {
                                realm.executeTransaction(new Realm.Transaction() {
                                    @Override
                                    public void execute(Realm realm) {

                                        user.setCoins(upgrade.getCost(), false);

                                        if (machine.getTimerOfMachine() > 100){
                                            machine.setTimerOfMachine(machine.getTimerOfMachine() / 20, false);
                                        } else if (machine.getTimerOfMachine() <= 100){
                                            viewHolder.buyUpgrade.setEnabled(false);
                                        }


                                        upgrade.setCost(upgrade.getCost() / 3, true);
                                    }
                                });
                            } else {
                                viewHolder.buyUpgrade.setEnabled(false);
                            }

                        }

                        TextView txtView = (TextView) ((MainActivity)getContext()).findViewById(R.id.coins);
                        txtView.setText(String.valueOf("" + String.valueOf(user.getCoins())));

                        viewHolder.costOfUpgrade.setText("Cost: " + String.valueOf(upgrade.getCost()));

                    }


                }
            });
        }finally {
            realm.close();
        }

    }
}

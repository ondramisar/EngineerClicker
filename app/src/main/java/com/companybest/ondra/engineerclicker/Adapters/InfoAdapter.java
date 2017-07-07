package com.companybest.ondra.engineerclicker.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;

import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;


public class InfoAdapter  extends RealmBasedRecyclerViewAdapter<User, InfoAdapter.ViewHolder> {

    class ViewHolder extends RealmViewHolder {
        TextView levelOfUser;
        TextView exp;
        ProgressBar levelProgress;
        TextView clickTextView;
        /*
        TextView maxMachine;
        TextView maxWorkers;
        TextView maxUpgrade;*/

        ViewHolder(FrameLayout container) {
            super(container);
            this.levelOfUser = (TextView) container.findViewById(R.id.levelOfUser);
            this.exp = (TextView) container.findViewById(R.id.expNumber);
            this.levelProgress = (ProgressBar) container.findViewById(R.id.progressOfLevel);
            this.clickTextView = (TextView) container.findViewById(R.id.clickTextView);
            //this.maxMachine = (TextView) container.findViewById(R.id.maxMachine);
            //this.maxWorkers = (TextView) container.findViewById(R.id.maxWorkers);
            //this.maxUpgrade = (TextView) container.findViewById(R.id.maxUpgrade);
        }
    }


    public InfoAdapter(android.content.Context context, RealmResults<User> realmResults, boolean automaticUpdate, boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public InfoAdapter.ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.item_of_info_list, viewGroup, false);
        InfoAdapter.ViewHolder vh = new InfoAdapter.ViewHolder((FrameLayout) v);
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(ViewHolder viewHolder, int i) {
        final User user = realmResults.get(i);

        viewHolder.levelOfUser.setText("YOU ARE LEVEL" + String.valueOf(user.getLevel()));
        viewHolder.exp.setText(String.valueOf(user.getExp()) + " / "  + String.valueOf(user.getExpNeeded()));
        //PROGRESS BAR
        viewHolder.levelProgress.setMax(user.getExpNeeded());
        viewHolder.levelProgress.setProgress(user.getExp());

        viewHolder.clickTextView.setText("YOU ARE MAKING " + user.getLevel() + " COINS BY CLICK");
        //viewHolder.maxMachine.setText("MAXIMAL NUMBER OF MACHINE YOU CAN HAVE " + String.valueOf(user.getMaxMachine()));
        //viewHolder.maxWorkers.setText("MAXIMAL NUMBER OF WORKERS YOU CAN HAVE " + String.valueOf(user.getMaxWorkers()));
        //viewHolder.maxUpgrade.setText("MAXIMAL NUMBER OF UPGRADE YOU CAN HAVE " + String.valueOf(user.getMaxUpgrade()));

        Realm realm = Realm.getDefaultInstance();
        try {
            if (user.getExp() >= user.getExpNeeded()) {
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        user.setLevel(1, true);
                        user.setExp(0, 2);
                        user.setExpNeeded(user.getExpNeeded(), true);

                    }
                });
            }
        } finally {
            realm.close();
        }
    }

}
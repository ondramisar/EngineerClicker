package com.companybest.ondra.engineerclicker.Adapters;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.User;
import com.companybest.ondra.engineerclicker.R;

import io.realm.Realm;
import io.realm.RealmBasedRecyclerViewAdapter;
import io.realm.RealmResults;
import io.realm.RealmViewHolder;



public class MaterialRealmAdapter extends RealmBasedRecyclerViewAdapter<Material, MaterialRealmAdapter.ViewHolder> {

    public class ViewHolder extends RealmViewHolder {

        public TextView nameOfMaterial;
        public TextView costOfMaterial;
        public TextView numberOfMaterials;
        public Button sellMaterial;
        public Button sellMaterialAll;
        public ImageView upgradeImg;

        public ViewHolder(FrameLayout container) {
            super(container);
            this.nameOfMaterial = (TextView) container.findViewById(R.id.nameOfMaterial);
            this.costOfMaterial = (TextView) container.findViewById(R.id.costOfMaterial);
            this.numberOfMaterials = (TextView) container.findViewById(R.id.numberOfMaterial);
            this.sellMaterial = (Button) container.findViewById(R.id.sellMaterial);
            this.sellMaterialAll = (Button) container.findViewById(R.id.sellMaterialAll);
            this.upgradeImg = (ImageView) container.findViewById(R.id.upgradeImg);
        }
    }


    private Realm realm;
    private MainActivity mainActivity;

    public MaterialRealmAdapter(android.content.Context context, RealmResults<Material> realmResults, boolean automaticUpdate, boolean animateResults) {
        super(context, realmResults, automaticUpdate, animateResults);
    }

    @Override
    public MaterialRealmAdapter.ViewHolder onCreateRealmViewHolder(ViewGroup viewGroup, int viewType) {
        View v = inflater.inflate(R.layout.material_menu, viewGroup, false);
        MaterialRealmAdapter.ViewHolder vh = new MaterialRealmAdapter.ViewHolder((FrameLayout) v);
        return vh;
    }

    @Override
    public void onBindRealmViewHolder(final ViewHolder viewHolder, int position) {
        final Material material = realmResults.get(position);

        viewHolder.nameOfMaterial.setText("Name: " + String.valueOf(material.getName()));
        viewHolder.costOfMaterial.setText("Cost: " + String.valueOf(material.getCost()));
        viewHolder.numberOfMaterials.setText("" + String.valueOf(material.getNumberOf()));

        int resourceId = getContext().getResources().getIdentifier(material.getNameOfImg(), "drawable", "com.companybest.ondra.engineerclicker");
        viewHolder.upgradeImg.setImageResource(resourceId);


        viewHolder.sellMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (material.getNumberOf() > 0) {
                    realm = Realm.getDefaultInstance();
                    final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            material.setNumberOf(1, false);

                            user.setCoins(material.getCost(), true);

                        }
                    });
                    viewHolder.numberOfMaterials.setText("" + String.valueOf(material.getNumberOf()));
                    mainActivity.coins.setText("" + String.valueOf(user.getCoins()));
                }
            }
        });

        viewHolder.sellMaterialAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (material.getNumberOf() > 0) {
                    realm = Realm.getDefaultInstance();
                    final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();

                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            user.setCoins(material.getCost() * material.getNumberOf(), true);

                            material.setNumberOf(material.getNumberOf(), false);

                        }
                    });
                    viewHolder.numberOfMaterials.setText("Number: " + String.valueOf(material.getNumberOf()));
                    mainActivity.coins.setText("" + String.valueOf(user.getCoins()));
                }

            }
        });
    }
}

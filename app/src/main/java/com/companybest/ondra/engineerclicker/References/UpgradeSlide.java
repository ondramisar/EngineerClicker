package com.companybest.ondra.engineerclicker.References;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.R;
import com.facebook.common.util.UriUtil;
import com.facebook.drawee.view.SimpleDraweeView;

import agency.tango.materialintroscreen.SlideFragment;



public class UpgradeSlide extends SlideFragment {

    boolean worker = true;

    public UpgradeSlide(boolean worker){
        this.worker = worker;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.upgrade_slide, container, false);

        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker) {

            decription.setText("On the top is name and description of upgrade, Buy button is for buying the upgrade, On the right is cost of upgrade");

        }


        SimpleDraweeView costOfUpgrdImg = (SimpleDraweeView) view.findViewById(R.id.costOfUpgrdImg);
        int resourceId8 = getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri8 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId8))
                .build();
        costOfUpgrdImg.setImageURI(uri8);

        SimpleDraweeView upgradeImg = (SimpleDraweeView) view.findViewById(R.id.imageViewOfUpgrade);
        int resourceId9 = getContext().getResources().getIdentifier("upgrade_money_for_mat", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri9 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId9))
                .build();
        upgradeImg.setImageURI(uri9);


        return view;
    }



    @Override
    public int backgroundColor() {
        return R.color.BlueSapphire;
    }

    @Override
    public int buttonsColor() {
        return R.color.Bluegray;
    }

    @Override
    public boolean canMoveFurther() {
        return true;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "you cant move";
    }
}

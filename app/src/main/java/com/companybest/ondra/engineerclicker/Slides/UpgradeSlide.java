package com.companybest.ondra.engineerclicker.Slides;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.companybest.ondra.engineerclicker.R;

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

        //DESCRIPTION
        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker) {

            decription.setText("On the top is name and description of upgrade, Buy button is for buying the upgrade, On the right is cost of upgrade");

        }

        //COIN IMG
        ImageView costOfUpgrdImg = (ImageView) view.findViewById(R.id.costOfUpgrdImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(costOfUpgrdImg);

        //UPGRADE IMG
        ImageView upgradeImg = (ImageView) view.findViewById(R.id.imageViewOfUpgrade);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("upgrade_money_for_mat", "drawable", "com.companybest.ondra.engineerclicker")).into(upgradeImg);


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

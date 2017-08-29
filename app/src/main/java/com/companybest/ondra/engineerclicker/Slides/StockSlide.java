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


public class StockSlide extends SlideFragment {

    boolean worker = true;

    public StockSlide(boolean worker){
        this.worker = worker;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.stock_slide, container, false);

        //DESCRIPTION
        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker) {

            decription.setText("On the top is name of the material, On the left is number of material you have, Sell button sells one material and sell all sells every material of that kind you have in stock, On the right is number of coins you get for selling one material");

        }


        //COIN IMG
        ImageView costOfMaterialImg = (ImageView) view.findViewById(R.id.costOfMaterialImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(costOfMaterialImg);

        //MATERIAL IMG
        ImageView upgradeImg = (ImageView) view.findViewById(R.id.upgradeImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("gold", "drawable", "com.companybest.ondra.engineerclicker")).into(upgradeImg);


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

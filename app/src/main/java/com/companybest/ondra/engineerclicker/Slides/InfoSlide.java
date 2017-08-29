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

public class InfoSlide extends SlideFragment {


    public InfoSlide(){

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.info_slide, container, false);

        //CLICKING IMG
        ImageView clickImg = (ImageView) view.findViewById(R.id.clickImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("build", "drawable", "com.companybest.ondra.engineerclicker")).into(clickImg);

        //DESCRIPTION
        TextView decription = (TextView) view.findViewById(R.id.descriptionOfInfoSlide);

            decription.setText("In this slide you will find a information about your level, how much exp you have and you click on img of building and make coins from it");

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
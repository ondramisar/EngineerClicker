package com.companybest.ondra.engineerclicker.References;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.R;

import agency.tango.materialintroscreen.SlideFragment;


public class LastSlide extends SlideFragment {


    public LastSlide(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.last_slide, container, false);

        TextView decription = (TextView) view.findViewById(R.id.decription);
        TextView decription2 = (TextView) view.findViewById(R.id.decription2);

        decription.setText("When you close the game you will see on a top bar icon that is showing if your workers are working, when you don't see the icon your workers are not working and you need to get back to app");

        decription2.setText("If you find any issue you can contact me here: ondramisar124@seznam.cz and if you will enjoy the game please consider rating it");
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

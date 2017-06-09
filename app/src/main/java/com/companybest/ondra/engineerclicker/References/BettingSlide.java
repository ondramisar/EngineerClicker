package com.companybest.ondra.engineerclicker.References;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.companybest.ondra.engineerclicker.R;

import agency.tango.materialintroscreen.SlideFragment;



public class BettingSlide extends SlideFragment {

    int worker = 0;

    public BettingSlide(int worker){
        this.worker = worker;

    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.betting_slide, container, false);

        //DESCRIPTION
        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker == 0 ) {

            decription.setText("On the top is button play ad for coins when you press it ad will start playing if you watch the ad to the end you will receive coins");

        } else if (worker == 1){

            decription.setText("Under you have first mini game, It is 50/50 you can put number of coins you want to play with then you press confirm button and when you want to start a game you press play 50/50 button, There will be shown a message if you have won or no, You can win double the coins you set or lose everything you set");

        } else if (worker == 2){

            decription.setText("Under you have second mini game, It is shufl you can put number of coins you want to play with then you press confirm button and when you want to start a game you press play shufl button, There will be shown a message how much you have won, You will always win back but you can win maximally 25% more then you have set or win 25% less then you have set");

        }


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

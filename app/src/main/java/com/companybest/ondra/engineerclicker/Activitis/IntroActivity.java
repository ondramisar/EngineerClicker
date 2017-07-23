package com.companybest.ondra.engineerclicker.Activitis;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.companybest.ondra.engineerclicker.Slides.BettingSlide;
import com.companybest.ondra.engineerclicker.Slides.MachineSlide;
import com.companybest.ondra.engineerclicker.Slides.InfoSlide;
import com.companybest.ondra.engineerclicker.Slides.LastSlide;
import com.companybest.ondra.engineerclicker.Slides.StockSlide;
import com.companybest.ondra.engineerclicker.Slides.UpgradeSlide;

import agency.tango.materialintroscreen.MaterialIntroActivity;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        //ALL SLIDES OF HELP/TUTORIAL
        addSlide(new MachineSlide(0));

        addSlide(new MachineSlide(1));

        addSlide(new MachineSlide(2));

        addSlide(new StockSlide(true));

        addSlide(new UpgradeSlide(true));

        addSlide(new BettingSlide(0));

        addSlide(new BettingSlide(1));

        addSlide(new BettingSlide(2));

        addSlide(new InfoSlide());

        addSlide(new LastSlide());


    }
}

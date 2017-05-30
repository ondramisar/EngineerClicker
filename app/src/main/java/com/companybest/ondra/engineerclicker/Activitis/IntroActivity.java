package com.companybest.ondra.engineerclicker.Activitis;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.companybest.ondra.engineerclicker.References.BettingSlide;
import com.companybest.ondra.engineerclicker.References.CustomSlide;
import com.companybest.ondra.engineerclicker.References.InfoSlide;
import com.companybest.ondra.engineerclicker.References.LastSlide;
import com.companybest.ondra.engineerclicker.References.StockSlide;
import com.companybest.ondra.engineerclicker.References.UpgradeSlide;

import agency.tango.materialintroscreen.MaterialIntroActivity;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        enableLastSlideAlphaExitTransition(true);

        addSlide(new CustomSlide(0));

        addSlide(new CustomSlide(1));

        addSlide(new CustomSlide(2));

        addSlide(new StockSlide(true));

        addSlide(new UpgradeSlide(true));

        addSlide(new BettingSlide(0));

        addSlide(new BettingSlide(1));

        addSlide(new BettingSlide(2));

        addSlide(new InfoSlide());

        addSlide(new LastSlide());


    }
}

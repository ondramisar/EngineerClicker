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



public class MachineSlide extends SlideFragment {

    int worker = 0;

    public MachineSlide(int worker){
        this.worker = worker;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.custom_slide_machine, container, false);

        //DESCRIPTION
        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker == 0) {

            decription.setText("Machines are making material only when there is worker on them and you will get as much material as you have workers on machine per time. With a first machine you won't need any material, but for every next machine you will need a material that is from machine before.");

        } else  if (worker == 1){
            decription.setText("On the top are your workers, They will work on your machines, Buy Button is for buying workers, Next to the button is number of workers you have, On the other side of button is cost of worker");
        } else  if (worker == 2){
            decription.setText("Under workers are tabs of your machines, On the left you have number of machines you own, Then under is number of workers on machines, On the right you have cost of machine, Then time of machine to make a material when work is working, Then what kind of material is machine making");
        }


        //COIN IMG
        ImageView costOfWorker = (ImageView) view.findViewById(R.id.costOfWorker);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(costOfWorker);

        //WORKER IMG
        ImageView workerImg = (ImageView) view.findViewById(R.id.workerImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("worker_helmet", "drawable", "com.companybest.ondra.engineerclicker")).into(workerImg);

        //MINE IMG
        ImageView machImg = (ImageView) view.findViewById(R.id.imageView);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("mine", "drawable", "com.companybest.ondra.engineerclicker")).into(machImg);

        //COIN IMG
        ImageView coin = (ImageView) view.findViewById(R.id.costOfMachineImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker")).into(coin);

        //TIME IMG
        ImageView timeOfMachineImg = (ImageView) view.findViewById(R.id.timeOfMachineImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("time", "drawable", "com.companybest.ondra.engineerclicker")).into(timeOfMachineImg);

        //MATERIAL IMG
        ImageView materialOfMachineImg = (ImageView) view.findViewById(R.id.materialOfMachineImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("gold", "drawable", "com.companybest.ondra.engineerclicker")).into(materialOfMachineImg);

        //WORKER ON MACHINE IMG
        ImageView workerOnMachineImg = (ImageView) view.findViewById(R.id.workerOnMachImg);
        Glide.with(getContext()).load(getContext().getResources().getIdentifier("worker_on_mach", "drawable", "com.companybest.ondra.engineerclicker")).into(workerOnMachineImg);

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

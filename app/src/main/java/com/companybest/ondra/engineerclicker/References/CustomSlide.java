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



public class CustomSlide extends SlideFragment {

    boolean worker = true;

    public CustomSlide(boolean worker){
        this.worker = worker;

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.custom_slide_machine, container, false);

        TextView decription = (TextView) view.findViewById(R.id.decription);
        if (worker) {

            decription.setText("On the top are yours workers, They will work on your machines, Buy Button is for buying workers, Next to the button is number of workers you have, On the other side of button is cost of worker\n\n");

        } else {
            decription.setText("Under workers are tabs of your machines, On the left you have number of machines you own, Then under is number of workers on machines, On the right you have cost of machine, Then time of machine to make a material when work is working, Then what kind of material is machine making");
        }


        SimpleDraweeView costOfWorker = (SimpleDraweeView) view.findViewById(R.id.costOfWorker);
        int resourceId8 = getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri8 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId8))
                .build();
        costOfWorker.setImageURI(uri8);

        SimpleDraweeView workerImg = (SimpleDraweeView) view.findViewById(R.id.workerImg);
        int resourceId9 = getContext().getResources().getIdentifier("worker_helmet", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri9 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId9))
                .build();
        workerImg.setImageURI(uri9);



        SimpleDraweeView machImg = (SimpleDraweeView) view.findViewById(R.id.imageView);
        int resourceId = getContext().getResources().getIdentifier("mine", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId))
                .build();
        machImg.setImageURI(uri);


        SimpleDraweeView coin = (SimpleDraweeView) view.findViewById(R.id.costOfMachineImg);
        int resourceId1 = getContext().getResources().getIdentifier("ui_coin", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri1 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId1))
                .build();
        coin.setImageURI(uri1);


        SimpleDraweeView timeOfMachineImg = (SimpleDraweeView) view.findViewById(R.id.timeOfMachineImg);
        int resourceId2 = getContext().getResources().getIdentifier("time", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri2 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId2))
                .build();
        timeOfMachineImg.setImageURI(uri2);


        SimpleDraweeView materialOfMachineImg = (SimpleDraweeView) view.findViewById(R.id.materialOfMachineImg);
        int resourceId3 = getContext().getResources().getIdentifier("gold", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri3 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId3))
                .build();
        materialOfMachineImg.setImageURI(uri3);


        SimpleDraweeView workerOnMachineImg = (SimpleDraweeView) view.findViewById(R.id.workerOnMachImg);
        int resourceId4 = getContext().getResources().getIdentifier("worker_on_mach", "drawable", "com.companybest.ondra.engineerclicker");
        Uri uri4 = new Uri.Builder()
                .scheme(UriUtil.LOCAL_RESOURCE_SCHEME) // "res"
                .path(String.valueOf(resourceId4))
                .build();
        workerOnMachineImg.setImageURI(uri4);

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

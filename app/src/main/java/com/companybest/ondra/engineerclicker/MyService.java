package com.companybest.ondra.engineerclicker;


import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;

import com.companybest.ondra.engineerclicker.GameLoop.MainThread;
import com.companybest.ondra.engineerclicker.Models.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyService extends Service {

    MainThread mainThread;

    //TIMERS
    int timeForMachine1 = 0;
    int timeForMachine2 = 0;
    int timeForMachine3 = 0;
    int timeForMachine4 = 0;
    int timeForMachine5 = 0;
    int timeForMachine6 = 0;
    int timeForMachine7 = 0;
    int timeForMachine8 = 0;
    int timeForMachine9 = 0;
    int timeForMachine10 = 0;
    int timeForMachine11 = 0;


    PowerManager.WakeLock wl;

    RealmResults<Machine> machines;

    private Realm realm;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        //NOTIFICATION IN A BAR
        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ikona)
                .setContentTitle("Engineer Clicker")
                .setContentText("Doing some work...")
                .setContentIntent(pendingIntent).build();

        startForeground(1337, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        //GAME LOOP
        mainThread = new MainThread(this);
        mainThread.setRunning(true);
        mainThread.start();

        //THIS MAKE DEVICE WORK ALL THE TIME,
        // IF SET SOME TIME WHEN THE APP WILL STOP SET METHOD acquire. better for battery
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Tag");
        wl.acquire();

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        wl.release();
        super.onDestroy();
    }

    public void update() {

        //ADDING TO EVERY TIMER
        timeForMachine1 += 1;
        timeForMachine2 += 1;
        timeForMachine3 += 1;
        timeForMachine4 += 1;
        timeForMachine5 += 1;
        timeForMachine6 += 1;
        timeForMachine7 += 1;
        timeForMachine8 += 1;
        timeForMachine9 += 1;
        timeForMachine10 += 1;
        timeForMachine11 += 1;


        realm = Realm.getDefaultInstance();
        try {
            //LIST OF ALL MACHINES
            machines = realm.where(Machine.class).findAll();

            int numberOfMachine = 0;
            //THIS MAKES COUNT OF EVERY MACHINE THAT HAVE A WORKER ON THEM
            for (int i = 0; i < machines.size(); i++) {
                Machine m = machines.get(i);
                if (m.getNumberOfWorkersOnMachine() > 0) {
                    numberOfMachine += 1;
                }
            }


            //SET UP ALL MACHINES FROM MACHINES LIST
            final Machine m = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine1).findFirst();
            final Machine m2 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine2).findFirst();
            final Machine m3 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine3).findFirst();
            final Machine m4 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine4).findFirst();
            final Machine m5 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine5).findFirst();
            final Machine m6 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine6).findFirst();
            final Machine m7 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine7).findFirst();
            final Machine m8 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine8).findFirst();
            final Machine m9 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine9).findFirst();
            final Machine m10 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine10).findFirst();


            //NEW PLUS MACHINE IF YOU DONT HAVE RESTARTED THE GAME DONT SHOW
            Machine m11 = null;
            if (numberOfMachine > 10) {
                m11 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine11).findFirst();

            }


            //MACHINE 1 IS DIFFERENT THAN EVERY OTHER
            if (timeForMachine1 > m.getTimerOfMachine()) {
                timeForMachine1 = 0;

                final Material material = realm.where(Material.class).equalTo("name", m.getNameOfMaterial()).findFirst();

                if (m.getNumberOfWorkersOnMachine() > 0) {
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            material.setNumberOf(m.getNumberOfWorkersOnMachine(), true);

                        }
                    });


                }
            }


            //CHECKING EVERY MACHINES TIMER
            //WILL BE SIMPLIFIED IN A FUTURE
            if (timeForMachine2 > m2.getTimerOfMachine()) {

                timeForMachine2 = 0;

                machineThread(m2);

            }

            if (timeForMachine3 > m3.getTimerOfMachine()) {

                timeForMachine3 = 0;

                machineThread(m3);

            }

            if (timeForMachine4 > m4.getTimerOfMachine()) {

                timeForMachine4 = 0;

                machineThread(m4);
            }

            if (timeForMachine5 > m5.getTimerOfMachine()) {

                timeForMachine5 = 0;

                machineThread(m5);
            }


            if (timeForMachine6 > m6.getTimerOfMachine()) {

                timeForMachine6 = 0;

                machineThread(m6);
            }

            if (timeForMachine7 > m7.getTimerOfMachine()) {

                timeForMachine7 = 0;

                machineThread(m7);
            }

            if (timeForMachine8 > m8.getTimerOfMachine()) {

                timeForMachine8 = 0;

                machineThread(m8);
            }

            if (timeForMachine9 > m9.getTimerOfMachine()) {

                timeForMachine9 = 0;

                machineThread(m9);

            }

            if (timeForMachine10 > m10.getTimerOfMachine()) {

                timeForMachine10 = 0;

                machineThread(m10);

            }

            //NEW MACHINE, ONLY ABLE WHEN YOU RESTARTED GAME
            if (m11 != null) {
                if (timeForMachine11 > m11.getTimerOfMachine()) {

                    timeForMachine11 = 0;

                    machineThread(m11);

                }
            }
        } finally {
            realm.close();
        }

    }

    //METHOD FOR MACHINE SET UP AND ADDING
    private void machineThread(final Machine mach) {
        realm = Realm.getDefaultInstance();
        try {
            final Material material = realm.where(Material.class).equalTo("name", mach.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", mach.getNameOfNeededMaterial()).findFirst();

            if (mach.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {

                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                //METHOD FOR GETTING NUMBER OF MATERIALS TO ADD
                for (int i = 0; i < mach.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd, true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                    }
                });
            }
        } finally {
            realm.close();
        }

    }
}
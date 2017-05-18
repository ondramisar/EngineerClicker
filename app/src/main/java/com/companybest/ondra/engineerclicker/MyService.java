package com.companybest.ondra.engineerclicker;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import com.companybest.ondra.engineerclicker.GameLoop.MainThread;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.User;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyService extends Service {

    MainThread mainThread;

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

    float timeOfDestructionThred = 0.f;
    PowerManager.WakeLock wl;
    RealmResults<Machine> machines;

    boolean isOutOfApp = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Intent notificationIntent = new Intent(this, MainActivity.class);


        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Engineer Clicker")
                .setContentText("Doing some work...")
                .setContentIntent(pendingIntent).build();

        startForeground(1337, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.

        try {
            isOutOfApp = intent.getBooleanExtra("outOfApp", false);
            Log.i("user", "IS OUT OF APP " + String.valueOf(intent.getBooleanExtra("outOfApp", false)));
        } catch (Exception e){
            e.printStackTrace();
        }


        mainThread = new MainThread(this, false);
        mainThread.setRunning(true);
        mainThread.start();
        Log.i("user", "SERVICE MAIN THREAD");

        Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
        PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Tag");
        wl.acquire();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        wl.release();
        mainThread.setRunning(false);

        // prepare intent which is triggered if the
        // notification is selected

        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent, 0);

        // build notification
        // the addAction re-use the same intent to keep the example short
        Notification n  = new Notification.Builder(this)
                .setContentTitle("END OF SERVICE")
                .setContentText("Subject")
                .setSmallIcon(R.drawable.common_google_signin_btn_icon_dark)
                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "Call", pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "More", pIntent)
                .addAction(R.drawable.common_google_signin_btn_icon_dark, "And more", pIntent).build();


        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationManager.notify(0, n);
    }

    public void update() {
        //Log.i("user", "update");
        timeOfDestructionThred += 0.01f;

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


        Realm realm = Realm.getDefaultInstance();
        try {
            machines = realm.where(Machine.class).findAll();
            final Machine m =  machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine1).findFirst();
            final Machine m2 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine2).findFirst();
            final Machine m3 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine3).findFirst();
            final Machine m4 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine4).findFirst();
            final Machine m5 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine5).findFirst();
            final Machine m6 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine6).findFirst();
            final Machine m7 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine7).findFirst();
            final Machine m8 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine8).findFirst();
            final Machine m9 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine9).findFirst();
            final Machine m10 = machines.where().equalTo("name", MainActivity.mainReferences.nameOfMachine10).findFirst();



            if (timeForMachine1 > m.getTimerOfMachine()) {
                timeForMachine1 = 0;

                final Material material = realm.where(Material.class).equalTo("name", m.getNameOfMaterial()).findFirst();

                if (m.getNumberOfWorkersOnMachine() > 0) {
                    Log.i("user", "in IF STATMENT For " + m.getName());
                    realm.executeTransaction(new Realm.Transaction() {
                        @Override
                        public void execute(Realm realm) {

                            material.setNumberOf(m.getNumberOfWorkersOnMachine(), true);
                            //Log.i("user", "Material Added: " + material.getNumberOf());

                        }
                    });


                }
            }

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

            if (isOutOfApp) {
                //Log.i("user", "IN END LOOP");
                final User user = realm.where(User.class).equalTo("name", MainActivity.mainReferences.name).findFirst();
                if (timeOfDestructionThred > user.getTimeOutOfApp()) {
                    Log.i("user", "SERVICE END");

                    stopSelf();
                    timeOfDestructionThred = 0;
                }
            }
        }finally {
            realm.close();
        }
    }

    private void machineThread(Machine mach){
        //Log.i("user", "timer for" + String.valueOf(mach.getTimerOfMachine()));
        Realm realm = Realm.getDefaultInstance();
        try {
            final Material material = realm.where(Material.class).equalTo("name", mach.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", mach.getNameOfNeededMaterial()).findFirst();

            if (mach.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + mach.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

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
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });
            }
        } finally {
                realm.close();
            }


    }
}
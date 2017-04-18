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

import com.companybest.ondra.engineerclicker.Activitis.MainActivity;
import com.companybest.ondra.engineerclicker.GameLoop.MainThread;
import com.companybest.ondra.engineerclicker.Models.Machines.Machine;
import com.companybest.ondra.engineerclicker.Models.Material;
import com.companybest.ondra.engineerclicker.Models.User;

import io.realm.Realm;

public class MyService extends Service {

    private Realm realm;
    private MainActivity mainActivity;
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
                .setContentTitle("My Awesome App")
                .setContentText("Doing some work...")
                .setContentIntent(pendingIntent).build();

        startForeground(1337, notification);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Let it continue running until it is stopped.

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
        final Machine m = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine1).findFirst();
        final Machine m2 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine2).findFirst();
        final Machine m3 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine3).findFirst();
        final Machine m4 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine4).findFirst();
        final Machine m5 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine5).findFirst();
        final Machine m6 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine6).findFirst();
        final Machine m7 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine7).findFirst();
        final Machine m8 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine8).findFirst();
        final Machine m9 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine9).findFirst();
        final Machine m10 = realm.where(Machine.class).equalTo("name", mainActivity.mainReferences.nameOfMachine10).findFirst();


        if (timeForMachine1 > m.getTimerOfMachine()) {
            timeForMachine1 = 0;

            Log.i("user", "timer for" + String.valueOf(m.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m.getNameOfMaterial()).findFirst();

            if (m.getNumberOfWorkersOnMachine() > 0 ) {
                Log.i("user", "in IF STATMENT For " + m.getName());
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(m.getNumberOfWorkersOnMachine(),true);
                        Log.i("user", "Material Added: " + material.getNumberOf());

                    }
                });

            }
        }

        if (timeForMachine2 > m2.getTimerOfMachine()) {

            timeForMachine2 = 0;

            Log.i("user", "timer for" + String.valueOf(m2.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m2.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m2.getNameOfNeededMaterial()).findFirst();

            if (m2.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m2.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m2.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }

        }

        if (timeForMachine3 > m3.getTimerOfMachine()) {

            timeForMachine3 = 0;

            Log.i("user", "timer for" + String.valueOf(m3.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m3.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m3.getNameOfNeededMaterial()).findFirst();

            if (m3.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m3.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m3.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
        }

        if (timeForMachine4 > m4.getTimerOfMachine()) {

            timeForMachine4 = 0;

            Log.i("user", "timer for" + String.valueOf(m4.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m4.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m4.getNameOfNeededMaterial()).findFirst();

            if (m4.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m4.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m4.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());

                    }
                });

            }
        }

        if (timeForMachine5 > m5.getTimerOfMachine()) {

            timeForMachine5 = 0;

            Log.i("user", "timer for" + String.valueOf(m5.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m5.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m5.getNameOfNeededMaterial()).findFirst();

            if (m5.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m5.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m5.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }
                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });


            }
        }

        if (timeForMachine6 > m6.getTimerOfMachine()) {

            timeForMachine6 = 0;

            Log.i("user", "timer for" + String.valueOf(m6.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m6.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m6.getNameOfNeededMaterial()).findFirst();

            if (m6.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m6.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m6.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
        }

        if (timeForMachine7 > m7.getTimerOfMachine()) {

            timeForMachine7 = 0;

            Log.i("user", "timer for" + String.valueOf(m7.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m7.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m7.getNameOfNeededMaterial()).findFirst();

            if (m7.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m7.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m7.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
        }

        if (timeForMachine8 > m8.getTimerOfMachine()) {

            timeForMachine8 = 0;

            Log.i("user", "timer for" + String.valueOf(m8.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m8.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m8.getNameOfNeededMaterial()).findFirst();

            if (m8.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m8.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m8.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });


            }
        }

        if (timeForMachine9 > m9.getTimerOfMachine()) {

            timeForMachine9 = 0;

            Log.i("user", "timer for" + String.valueOf(m9.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m9.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m9.getNameOfNeededMaterial()).findFirst();

            if (m9.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m9.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m9.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });

            }
        }

        if (timeForMachine10 > m10.getTimerOfMachine()) {

            timeForMachine10 = 0;

            Log.i("user", "timer for" + String.valueOf(m10.getTimerOfMachine()));
            realm = Realm.getDefaultInstance();
            final Material material = realm.where(Material.class).equalTo("name", m10.getNameOfMaterial()).findFirst();
            final Material material2 = realm.where(Material.class).equalTo("name", m10.getNameOfNeededMaterial()).findFirst();

            if (m10.getNumberOfWorkersOnMachine() > 0 && material2.getNumberOf() > 0) {
                Log.i("user", "in IF STATMENT For " + m10.getName());
                int numberOfMaterialsAdd = 0;
                int numberOfMaterials = material2.getNumberOf();

                for (int i = 0; i < m10.getNumberOfWorkersOnMachine(); i++) {
                    if (numberOfMaterials > 0) {
                        numberOfMaterialsAdd += 1;
                        numberOfMaterials -= 1;
                    }
                }

                final int finalNumberOfMaterialsAdd = numberOfMaterialsAdd;

                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {

                        material.setNumberOf(finalNumberOfMaterialsAdd,true);

                        material2.setNumberOf(finalNumberOfMaterialsAdd, false);
                        Log.i("user", "Material Added: " + material.getNumberOf());
                        Log.i("user", "Material Getted: " + material2.getNumberOf());
                    }
                });


            }
        }

        //Log.i("user", String.valueOf(timeOfDestructionThred));

        final User user = realm.where(User.class).equalTo("name", mainActivity.mainReferences.name).findFirst();
        if (timeOfDestructionThred > user.getTimeOutOfApp()){
            Log.i("user", "SERVICE END");

            stopSelf();
            timeOfDestructionThred = 0;
        }
    }
}
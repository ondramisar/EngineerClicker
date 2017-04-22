package com.companybest.ondra.engineerclicker.GameLoop;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

import com.companybest.ondra.engineerclicker.MainActivity;
import com.companybest.ondra.engineerclicker.MyService;

public class MainThread extends Thread {

    private int FPS = 30;
    private double averageFPS;
    private SurfaceHolder surfaceHolder;
    private MainActivity mainActivity;
    private MyService myService;
    private boolean running;
    public static Canvas canvas;
    private boolean isMain;

    public MainThread(MainActivity MainActivity, boolean isMain) {
        super();
        this.mainActivity = MainActivity;
        this.isMain = isMain;
    }

    public MainThread(MyService myService, boolean isMain){
        super();
        this.myService = myService;
        this.isMain = isMain;
    }

    @Override
    public void run() {

        Log.i("user", String.valueOf(running));

        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount =0;
        long targetTime = 1000/FPS;

        while(running) {
            startTime = System.nanoTime();
            canvas = null;


            //try locking the canvas for pixel editing
            try {

                if (isMain){
                    this.mainActivity.update();
                }else{
                    this.myService.update();
                }

                //canvas = this.surfaceHolder.lockCanvas();
                //synchronized (surfaceHolder) {
                  //  this.gamePanel.update();
                    //this.gamePanel.draw(canvas);
                //}
            } catch (Exception e) {
            }



            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime-timeMillis;

            try{
                this.sleep(waitTime);
            }catch(Exception e){}

            totalTime += System.nanoTime()-startTime;
            frameCount++;

            if(frameCount == FPS) {

                averageFPS = 1000/((totalTime/frameCount)/1000000);
                frameCount = 0;
                totalTime = 0;
               // System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean b) {
        running=b;
    }
}

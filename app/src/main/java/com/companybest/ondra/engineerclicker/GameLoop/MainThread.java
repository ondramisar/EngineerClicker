package com.companybest.ondra.engineerclicker.GameLoop;

import android.graphics.Canvas;

import com.companybest.ondra.engineerclicker.MyService;

//CLASS FOR GAME LOOP, WORK WITH 30fps

public class MainThread extends Thread {

    private int FPS = 30;
    private double averageFPS;
    private MyService myService;
    private boolean running;
    public static Canvas canvas;

    public MainThread(MyService myService) {
        super();
        this.myService = myService;
    }

    @Override
    public void run() {

       // Log.i("user", String.valueOf(running));

        long startTime;
        long timeMillis;
        long waitTime;
        long totalTime = 0;
        int frameCount = 0;
        long targetTime = 1000 / FPS;

        while (running) {
            startTime = System.nanoTime();
            canvas = null;


            //try locking the canvas for pixel editing
            try {
                //UPDATING SERVICE
                this.myService.update();
            } catch (Exception e) {
            }


            timeMillis = (System.nanoTime() - startTime) / 1000000;
            waitTime = targetTime - timeMillis;

            try {
                this.sleep(waitTime);
            } catch (Exception e) {
            }

            totalTime += System.nanoTime() - startTime;
            frameCount++;

            if (frameCount == FPS) {

                averageFPS = 1000 / ((totalTime / frameCount) / 1000000);
                frameCount = 0;
                totalTime = 0;
                // System.out.println(averageFPS);
            }
        }
    }

    public void setRunning(boolean b) {
        running = b;
    }
}

package com.viz.tools;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by viz on 2014/10/29.
 */
public class PressAgainExit {
    private static Exit exit =new Exit();
    /**
     * 再按一次退出程序。
     */
    public static void pressAgainExit(Context context) {
        pressAgainExit(context,false);
    }
    
    /**
     * 再按一次退出程序。
     */
    public static void pressAgainExit(Context context,boolean isKillProcess) {
        if (exit.isExit()) {
            if(isKillProcess){
                android.os.Process.killProcess(android.os.Process.myPid());
            }else{
                ((Activity)context).finish();
            }
        } else {
            Toast.showShort(context, "再按一次退出程序");
            exit.doExitInOneSecond();
        }
    }


    static class Exit {
        private boolean isExit = false;
        private final Runnable task = new Runnable() {
            @Override
            public void run() {
                isExit = false;
            }
        };


        public void doExitInOneSecond() {
            isExit = true;
            HandlerThread thread = new HandlerThread("doTask");
            thread.start();
            new Handler(thread.getLooper()).postDelayed(task, 2000);
        }


        public boolean isExit() {
            return isExit;
        }


        public void setExit(boolean isExit) {
            this.isExit = isExit;
        }
    }
}

package com.viz.tools;

import android.os.Handler;
import android.os.HandlerThread;

/**
 * Created by viz on 2014/11/11.
 * 调用方法说明：在onkeydown/onkeyup中相应的键值中直接调用ContinuationPressKey.pressKey(8),返回true即为按键8次
 * if(ContinuationPressKey.pressKey(8)){Log.i("ContinuationPressKey","ContinuationPressKey.pressKey(8)");}
 * ------->默认10秒内连续按键有效
 */
public class ContinuationPressKey {
    private static PressKey pressKey = new PressKey();

    /**
     * 连续按键
     *
     * @param times 连续按键次数
     */
    public static boolean pressKey(int times) {
        Log.i("ContinuationPressKey","连续按键次数---> "+pressKey.getPressKeyTimes());
        if (pressKey.getPressKeyTimes() == times) {
            pressKey.addTimes();
            return true;
        } else {
            pressKey.addTimes();
            return false;
        }
    }


    static class PressKey {
        private int time = 10000;//默认10秒内连续按键有效
        private int presstimes = 1;
        private boolean start = true;
        private final Runnable task = new Runnable() {
            @Override
            public void run() {
                Log.i("ContinuationPressKey","连续按键超时");
                presstimes = 1;
                start = true;
            }
        };


        public void addTimes() {
            presstimes++;
            if (start) {
                start = false;
                HandlerThread thread = new HandlerThread("doTask");
                thread.start();
                new Handler(thread.getLooper()).postDelayed(task, time);
            }
        }


        public int getPressKeyTimes() {
            return presstimes;
        }


        public void setPressKeyTimes(int presstimes) {
            this.presstimes = presstimes;
        }
    }
}

package com.viz.tools.net;

/**
 * Created by viz on 2014/11/11.
 */
public class NativeMacAdress {

    static {
        System.loadLibrary("macaddress");
    }

    public static native String getMacFromJNI();

    public static String getMacAddress() {
        return getMacFromJNI();
    }

}

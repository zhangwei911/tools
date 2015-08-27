package com.viz.tools;

import android.annotation.TargetApi;
import android.os.Build;

/**
 * Created by viz on 2014/11/11.
 * getBOARD():stuttgart                                                                              //系统代号
 * getRadioVersion():K860i_1_SAM-1217_3_001_0065_130625                                              //固件版本信息
 * getMODEL():Lenovo K860i                                                                           //呈现给用户的最终产品名称
 * getOSVersion():4.2.1                                                                              //固件系统版本
 * getCODENAME():REL                                                                                 //当前的开发代号或字符串“REL”
 * getSDK_INT():17                                                                                   //SDK版本号
 * getBOOTLOADER():unknown                                                                           //系统引导程序版本号
 * getCPU_ABI():armeabi-v7a                                                                          //指令集的名称
 * getCPU_ABI2():armeabi                                                                             //第二道指令集
 * getBRAND():Lenovo                                                                                 //品牌
 * getDEVICE():K860i                                                                                 //设备名称
 * getDISPLAY():联想手机论坛_VIBEROM_V1.0_cs0028                                                     //显示给用户的固件版本信息
 * getFINGERPRINT():Lenovo/K860i/K860i:4.2.1/JOP40D/K860i_1_S_2_003_0097_130807:user/release-keys    //指纹
 * getHARDWARE():stuttgart                                                                           //硬件的名称(内核命令行或/ proc)
 * getHOST():bjws01                                                                                  //主机
 * getID():JOP40D                                                                                    //数量变更列表或一个标签如“M4-rc20”
 * getMANUFACTURER():LENOVO                                                                          //产品的生产商/硬件
 * getPRODUCT():K860i                                                                                //整个产品的名称
 * getSERIAL():unknown                                                                               //硬件序列号(如果可用)。
 * getTAGS():release-keys                                                                            //逗号分隔标签描述构建,如“unsigned,debug”。
 * getTIME():1375873430000                                                                           //时间
 * getUNKNOWN():unknown                                                                              //未知
 * getUSER():buildslave                                                                              //用户
 * getTYPE():user                                                                                    //构建的类型,如“user”或“eng”
 */
public class GetAndroidInfo {
    //呈现给用户的最终产品名称
    public static String getMODEL() {
        return Build.MODEL;
    }

    //固件版本信息
    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public static String getRadioVersion() {
        return Build.getRadioVersion();
    }

    //固件系统版本
    public static String getOSVersion() {
        return Build.VERSION.RELEASE;
    }

    //当前的开发代号或字符串“REL”
    public static String getCODENAME() {
        return Build.VERSION.CODENAME;
    }

    //SDK版本号
    public static int getSDK_INT() {
        return Build.VERSION.SDK_INT;
    }

    //系统代号
    public static String getBOARD() {
        return Build.BOARD;
    }

    //系统引导程序版本号
    public static String getBOOTLOADER() {
        return Build.BOOTLOADER;
    }

    //品牌
    public static String getBRAND() {
        return Build.BRAND;
    }

    //指令集的名称
    public static String getCPU_ABI() {
        return Build.CPU_ABI;
    }

    //第二道指令集
    public static String getCPU_ABI2() {
        return Build.CPU_ABI2;
    }

    //设备名称
    public static String getDEVICE() {
        return Build.DEVICE;
    }

    //显示给用户的固件版本信息
    public static String getDISPLAY() {
        return Build.DISPLAY;
    }

    //指纹
    public static String getFINGERPRINT() {
        return Build.FINGERPRINT;
    }

    //硬件的名称(内核命令行或/ proc)
    public static String getHARDWARE() {
        return Build.HARDWARE;
    }

    //主机
    public static String getHOST() {
        return Build.HOST;
    }

    //数量变更列表或一个标签如“M4-rc20”
    public static String getID() {
        return Build.ID;
    }

    //产品的生产商/硬件
    public static String getMANUFACTURER() {
        return Build.MANUFACTURER;
    }

    //整个产品的名称
    public static String getPRODUCT() {
        return Build.PRODUCT;
    }

    //硬件序列号(如果可用)。
    public static String getSERIAL() {
        return Build.SERIAL;
    }

    //逗号分隔标签描述构建,如“unsigned,debug”。
    public static String getTAGS() {
        return Build.TAGS;
    }

    //时间
    public static long getTIME() {
        return Build.TIME;
    }

    //未知
    public static String getUNKNOWN() {
        return Build.UNKNOWN;
    }

    //用户
    public static String getUSER() {
        return Build.USER;
    }

    //构建的类型,如“user”或“eng”
    public static String getTYPE() {
        return Build.TYPE;
    }

    public static void print() {
        Log.i("GetAndroidInfo", "系统代号:" + getBOARD());
        Log.i("GetAndroidInfo", "固件版本信息:" + getRadioVersion());
        Log.i("GetAndroidInfo", "呈现给用户的最终产品名称:" + getMODEL());
        Log.i("GetAndroidInfo", "固件系统版本:" + getOSVersion());
        Log.i("GetAndroidInfo", "当前的开发代号或字符串\"REL\":" + getCODENAME());
        Log.i("GetAndroidInfo", "SDK版本号:" + getSDK_INT());
        Log.i("GetAndroidInfo", "系统引导程序版本号:" + getBOOTLOADER());
        Log.i("GetAndroidInfo", "指令集的名称:" + getCPU_ABI());
        Log.i("GetAndroidInfo", "第二道指令集:" + getCPU_ABI2());
        Log.i("GetAndroidInfo", "品牌:" + getBRAND());
        Log.i("GetAndroidInfo", "设备名称:" + getDEVICE());
        Log.i("GetAndroidInfo", "显示给用户的固件版本信息:" + getDISPLAY());
        Log.i("GetAndroidInfo", "指纹:" + getFINGERPRINT());
        Log.i("GetAndroidInfo", "硬件的名称(内核命令行或/ proc):" + getHARDWARE());
        Log.i("GetAndroidInfo", "主机:" + getHOST());
        Log.i("GetAndroidInfo", "数量变更列表或一个标签如\"M4-rc20\":" + getID());
        Log.i("GetAndroidInfo", "产品的生产商/硬件:" + getMANUFACTURER());
        Log.i("GetAndroidInfo", "整个产品的名称:" + getPRODUCT());
        Log.i("GetAndroidInfo", "硬件序列号(如果可用):" + getSERIAL());
        Log.i("GetAndroidInfo", "逗号分隔标签描述构建,如\"unsigned,debug\":" + getTAGS());
        Log.i("GetAndroidInfo", "系统时间:" + getTIME());
        Log.i("GetAndroidInfo", "未知:" + getUNKNOWN());
        Log.i("GetAndroidInfo", "用户:" + getUSER());
        Log.i("GetAndroidInfo", "构建的类型,如\"user\"或\"eng\":" + getTYPE());
    }
}

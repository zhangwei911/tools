package com.viz.tools;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

/**
 * Created by viz on 10/01/15.
 */
public class Activity {

    /**
     * 启动本应用Activity
     *
     * @param context 上下文
     * @param _class  类
     */
    public static void startActivity(Context context, Class _class) {
        Intent intent = new Intent(context, _class);
        context.startActivity(intent);
    }


    /**
     * 这些代码是启动另外的一个应用程序的主Activity，当然也可以启动任意一个Activity
     * @param context 上下文
     * @param packageName apk包名
     * @param Activity activity类名含包名
     */
    public static void startOtherActivity(Context context, String packageName, String Activity) {
        ComponentName componetName = new ComponentName(
                //这个是另外一个应用程序的包名
                packageName,
                //这个参数是要启动的Activity
                Activity);
        try {
            Intent intent = new Intent();
            intent.setComponent(componetName);
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.show(context, "没有找到Activity");
        }
    }

    /**
     * Fragment跳转到Activity
     * @param activity 在Fragment中getActivity()
     * @param mclass 目标Activity类
     */
    public static void fragmentToAcitivity(android.app.Activity activity, Class mclass) {
        Intent intent = new Intent(activity, mclass);
        activity.startActivity(intent);
    }
}

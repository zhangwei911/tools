package com.viz.tools;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by viz on 2014/9/19.
 */
public class Toast {
    private static TextView textView_toast;

    /**
     * 自定义Toast
     *
     * @param activity        调用所在Activity
     * @param text            toast显示的文字
     * @param dur             显示时间
     * @param textColor       文字颜色
     * @param backgroundColor toast背景颜色
     * @param view            Toast视图
     */
    public static void show(Activity activity, String text, int dur, int textColor, int backgroundColor, View view) {
        // 动态生成布局视图--适用于复杂UI布局
        android.widget.Toast toast = new android.widget.Toast(activity);
        toast.setDuration(dur);
        // 设置重心
        toast.setGravity(Gravity.CENTER, 0, 0);
        // 设置视图--Toast继承自Widget,不是容器,只能调用设置视图方法
        toast.setView(view);
        toast.show();
    }

    /**
     * 自定义Toast
     *
     * @param activity        调用所在Activity
     * @param text            toast显示的文字
     * @param dur             显示时间
     * @param textColor       文字颜色
     * @param backgroundColor toast背景颜色
     */
    public static void show(Activity activity, String text, int dur, int textColor, int backgroundColor) {
        // 创建inflater
        LinearLayout linearLayout = new LinearLayout(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.gravity = Gravity.CENTER;
        linearLayout.setLayoutParams(params);
        textView_toast = new TextView(activity);
        textView_toast.setText(text);
        LinearLayout.LayoutParams params_textView_toast = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView_toast.setLayoutParams(params_textView_toast);
        textView_toast.setPadding(8, 8, 8, 8);
        textView_toast.setTextSize(20);
        textView_toast.setTextColor(textColor);
        textView_toast.setBackgroundColor(backgroundColor);
        linearLayout.addView(textView_toast);
        show(activity, text, dur, textColor, backgroundColor, linearLayout);
    }

    /**
     * 自定义Toast(默认文字颜色为白色，背景为70%黑色)
     *
     * @param activity 调用所在Activity
     * @param text     toast显示的文字
     * @param dur      显示时间
     */
    public static void show(Activity activity, String text, int dur) {
        show(activity, text, dur, 0xffffffff, 0xb2000000);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void show(Activity activity, String text) {
        show(activity, text, 1000);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showShort(Activity activity, String text) {
        show(activity, text, android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showLong(Activity activity, String text) {
        show(activity, text, android.widget.Toast.LENGTH_LONG);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Context
     * @param text    Toast提示内容
     */
    public static void show(Context context, String text) {
        show((Activity) context, text);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Context
     * @param text    Toast提示内容
     */
    public static void showShort(Context context, String text) {
        showShort((Activity) context, text);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Context
     * @param text    Toast提示内容
     */
    public static void showLong(Context context, String text) {
        showLong((Activity) context, text);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void show(Context context, int rid) {
        show((Activity) context, context.getString(rid));
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void showShort(Context context, int rid) {
        showShort((Activity) context, context.getString(rid));
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void showLong(Context context, int rid) {
        showLong((Activity) context, context.getString(rid));
    }


    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAny(Activity activity, Object text) {
        show(activity, text.toString(), 1000);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAnyShort(Activity activity, Object text) {
        show(activity, text.toString(), android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAnyLong(Activity activity, Object text) {
        show(activity, text.toString(), android.widget.Toast.LENGTH_LONG);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAny(Activity activity, String text, Object... args) {
        show(activity, String.format(text, args), 1000);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAnyShort(Activity activity, String text, Object... args) {
        show(activity, String.format(text, args), android.widget.Toast.LENGTH_SHORT);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param activity 调用所在Activity
     * @param text     Toast提示内容
     */
    public static void showAnyLong(Activity activity, String text, Object... args) {
        show(activity, String.format(text, args), android.widget.Toast.LENGTH_LONG);
    }
}

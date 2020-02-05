package com.viz.tools;

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
    private static android.widget.Toast toast = null;
    private static Context appCtx = null;

    public static void init(Context context) {
        Toast.appCtx = context;
    }

    public static void show(String text, int dur, int textColor, int backgroundColor, View view) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        show(appCtx, dur, view);
    }

    /**
     * 自定义Toast
     *
     * @param context 调用所在Activity
     * @param dur     显示时间
     * @param view    Toast视图
     */
    public static void show(Context context, int dur, View view) {
        if (toast != null) {
            toast.cancel();
            toast = null;
        }
        // 动态生成布局视图--适用于复杂UI布局
        toast = new android.widget.Toast(context);
        toast.setDuration(dur);
        // 设置重心
        toast.setGravity(Gravity.CENTER, 0, 0);
        // 设置视图--Toast继承自Widget,不是容器,只能调用设置视图方法
        toast.setView(view);
        toast.show();
    }

    public static void show(String text, int dur, int textColor, int backgroundColor, int gravity) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        show(appCtx, text, dur, textColor, backgroundColor, gravity);
    }

    /**
     * 自定义Toast
     *
     * @param context         调用所在Activity
     * @param text            toast显示的文字
     * @param dur             显示时间
     * @param textColor       文字颜色
     * @param backgroundColor toast背景颜色
     * @param gravity         toast位置（Gravity.TOP|Gravity.CENTER|Gravity.BOTTOM）
     */
    public static void show(Context context, String text, int dur, int textColor, int backgroundColor, int gravity) {
        // 创建inflater
        LinearLayout linearLayout = new LinearLayout(context);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT);
        params.gravity = gravity;
        linearLayout.setLayoutParams(params);
        textView_toast = new TextView(context);
        textView_toast.setText(text);
        LinearLayout.LayoutParams params_textView_toast = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        textView_toast.setLayoutParams(params_textView_toast);
        textView_toast.setPadding(8, 8, 8, 8);
        textView_toast.setTextSize(20);
        textView_toast.setTextColor(textColor);
        textView_toast.setBackgroundColor(backgroundColor);
        linearLayout.addView(textView_toast);
        show(context, dur, linearLayout);
    }

    public static void show(Object text, int dur) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        show(appCtx, text, dur);
    }

    /**
     * 自定义Toast(默认文字颜色为白色，背景为70%黑色)
     *
     * @param context 调用所在Activity
     * @param text    toast显示的文字
     * @param dur     显示时间
     */
    public static void show(Context context, Object text, int dur) {
        show(context, TextUtils.getText(context, text), dur, 0xffffffff, 0xb2000000, Gravity.CENTER);
    }

    public static void show(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        show(appCtx, text);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void show(Context context, Object text) {
        show(context, text, 1000);
    }

    public static void showShort(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showShort(appCtx, text);
    }


    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showShort(Context context, Object text) {
        show(context, text, android.widget.Toast.LENGTH_SHORT);
    }

    public static void showLong(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showLong(appCtx, text);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showLong(Context context, Object text) {
        show(context, text, android.widget.Toast.LENGTH_LONG);
    }

    public static void show(int rid) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        show(appCtx, rid);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void show(Context context, int rid) {
        show(context, context.getString(rid));
    }

    public static void showShort(int rid) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showShort(appCtx, rid);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void showShort(Context context, int rid) {
        showShort(context, context.getString(rid));
    }

    public static void showLong(int rid) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showLong(appCtx, rid);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Context
     * @param rid     Toast提示内容资源id
     */
    public static void showLong(Context context, int rid) {
        showLong(context, context.getString(rid));
    }

    public static void showAny(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAny(appCtx, text);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAny(Context context, Object text) {
        show(context, text.toString(), 1000);
    }

    public static void showAnyShort(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAnyShort(appCtx, text);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAnyShort(Context context, Object text) {
        show(context, text.toString(), android.widget.Toast.LENGTH_SHORT);
    }

    public static void showAnyLong(Object text) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAnyLong(appCtx, text);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAnyLong(Context context, Object text) {
        show(context, text.toString(), android.widget.Toast.LENGTH_LONG);
    }

    public static void showAny(Object text, Object... args) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAny(appCtx, text, args);
    }

    /**
     * 自定义Toast(默认显示1000ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAny(Context context, Object text, Object... args) {
        show(context, String.format(TextUtils.getText(context, text), args), 1000);
    }

    public static void showAnyShort(Object text, Object... args) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAnyShort(appCtx, text, args);
    }

    /**
     * 自定义Toast(默认显示0ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAnyShort(Context context, Object text, Object... args) {
        show(context, String.format(TextUtils.getText(context, text), args), android.widget.Toast.LENGTH_SHORT);
    }

    public static void showAnyLong(Object text, Object... args) {
        if (appCtx == null) {
            l.e("please init Toast in the application");
            return;
        }
        showAnyLong(appCtx, text, args);
    }

    /**
     * 自定义Toast(默认显示1ms)
     *
     * @param context 调用所在Activity
     * @param text    Toast提示内容
     */
    public static void showAnyLong(Context context, Object text, Object... args) {
        show(context, String.format(TextUtils.getText(context, text), args), android.widget.Toast.LENGTH_LONG);
    }

}

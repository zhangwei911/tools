package com.viz.tools.net;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.TextView;

/**
 * Created by viz on 2014/11/13.
 */
public class NetWork {

    /**
     * 判断网络状态
     *
     * @param context 上下文
     * @return true表示有网络，false表示无网络
     */
    public static boolean isNetworkAvailable(Context context) {
        //get the network statue manager
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivityManager == null) {
            return false;
        } else {
            NetworkInfo[] infos = connectivityManager.getAllNetworkInfo();
            if (infos != null) {
                for (NetworkInfo networkInfo : infos) {
                    if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 无网络时提示并提供跳转到网络设置的方法
     *
     * @param context 上下文
     */
    public static void checkNetwork(final Context context) {
        if (!isNetworkAvailable(context)) {
            TextView msg = new TextView(context);
            msg.setText("没有连接网络，请设置！");
            new AlertDialog.Builder(context).setIcon(android.R.drawable.stat_sys_warning)//set the icon of the AlertDialog
                    .setTitle("离线")//set the title of the AlertDialog
                    .setView(msg)//set the view(layout) of the AlertDialog content
                    .setPositiveButton("设置网络", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            context.startActivity(new Intent(Settings.ACTION_SETTINGS));
                        }
                    })//set the ok button and ClickListener
                    .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })
                    .create().show();
        }
    }
}

package com.viz.tools.apk;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import com.viz.tools.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by viz on 2014/10/27.
 */
public class APKInfo {

    /**
     * 获取apk信息
     *
     * @param context
     * @return apk信息 0,包名;1,版本名;2,版本号
     */
    public static String[] getAppInfo(Context context) {
        String apkinfo[] = new String[3];
        try {
            apkinfo[0] = context.getPackageName();
            apkinfo[1] = context.getPackageManager().getPackageInfo(
                    apkinfo[0], 0).versionName;
            apkinfo[2] = "" + context.getPackageManager()
                    .getPackageInfo(apkinfo[0], 0).versionCode;
            return apkinfo;
        } catch (Exception e) {
        }
        return null;
    }

    //检查应用程序是否安装并安装应用程序
    public static boolean checkApkExist(Context context, String packageName) {
        if (packageName == null || "".equals(packageName))
            return false;
        try {
            ApplicationInfo info = context.getPackageManager()
                    .getApplicationInfo(packageName,
                            PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    /**
     * 从assets文件夹复制文件到sdcard
     *
     * @param context
     * @param fileName
     * @param path
     * @return
     */
    public static boolean copyApkFromAssets(Context context, String fileName, String path) {
        boolean copyIsFinish = false;
        try {
            InputStream is = context.getAssets().open(fileName);
            File file = new File(path);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();
            copyIsFinish = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copyIsFinish;
    }

    /**
     * 从assets安装APK
     *
     * @param context
     * @param apkName
     */
    public static void InstallAPKFromAssets(final Context context, String apkName) {
        String apk = apkName + ".apk";
        if (copyApkFromAssets(context, apk, Environment.getExternalStorageDirectory().getAbsolutePath() + apk)) {
            AlertDialog.Builder m = new AlertDialog.Builder(context).setMessage("是否安装？")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Intent intent = new Intent(Intent.ACTION_VIEW);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            intent.setDataAndType(Uri.parse("file://" + Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.apk"),
                                    "application/vnd.android.package-archive");
                            context.startActivity(intent);
                        }
                    });
            m.show();
        }
    }


    /**
     * 这些代码是启动另外的一个应用程序的主Activity，当然也可以启动任意一个Activity
     *
     * @param context
     * @param packageName 另外一个应用程序的包名
     * @param Activity    要启动的Activity
     */
    public static void startOtherActivity(Context context, String packageName, String activity) {
        startOtherActivity(context,packageName,activity);
    }

    /**
     * 这些代码是启动另外的一个应用程序的主Activity，当然也可以启动任意一个Activity
     *
     * @param context
     * @param packageName 另外一个应用程序的包名
     * @param activity    要启动的Activity
     * @param bundle 传递的数据
     */
    public static void startOtherActivity(Context context, String packageName, String activity, Bundle bundle) {
        ComponentName componetName = new ComponentName(packageName, activity);
        try {
            Intent intent = new Intent();
            if(bundle!=null) {
                intent.putExtras(bundle);
            }
            intent.setComponent(componetName);
            context.startActivity(intent);
        } catch (Exception e) {
            Log.i("找不到Activity");
            //              Toast.makeText(getApplicationContext(), "可以在这里提示用户没有找到应用程序，或者是做其他的操作！", 0).show();
        }
    }

    public ArrayList<AppInfo> getAllAppInfo(Context context) {
        ArrayList<AppInfo> appList = new ArrayList<AppInfo>(); //用来存储获取的应用信息数据
        List<PackageInfo> packages = context.getPackageManager().getInstalledPackages(0);

        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = packages.get(i);
            AppInfo tmpInfo = new AppInfo();
            tmpInfo.appName = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
            tmpInfo.packageName = packageInfo.packageName;
            tmpInfo.versionName = packageInfo.versionName;
            tmpInfo.versionCode = packageInfo.versionCode;
            tmpInfo.appIcon = packageInfo.applicationInfo.loadIcon(context.getPackageManager());
            appList.add(tmpInfo);
        }
        return appList;
    }
}

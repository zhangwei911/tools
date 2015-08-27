package com.viz.tools;

import java.io.DataOutputStream;
import java.io.File;

/**
 * Created by viz on 10/01/15.
 */
public class ROOT {

    //let the fielExplorer get the right of System root
    public static boolean upgradeRootPermission(String pkgCodePath) {
        Process process = null;
        DataOutputStream os = null;

        if (!getRootAuth()) {
            try {
                String cmd = "chmod 777 " + pkgCodePath;
                process = Runtime.getRuntime().exec("su");//transfer to root
                os = new DataOutputStream(process.getOutputStream());
                os.writeBytes(cmd + "\n");
                os.writeBytes("exit\n");
                os.flush();
                process.waitFor();
            } catch (Exception e) {
                return false;
            } finally {
                try {
                    if (os != null) {
                        os.close();
                        process.destroy();
                    }
                } catch (Exception e) {

                }
            }
            return true;
        } else {
            return false;
        }
    }


    //判断机器是否Root
    public static boolean isRoot() {
        boolean bool = false;
        try {
            if (!new File("/system/bin/su").exists() && !new File("/system/xbin/su").exists()) {
                bool = false;
            } else {
                bool = true;
            }
            Log.i( "isRoot   " + bool);
        } catch (Exception e) {

        }
        return bool;
    }

    public static synchronized boolean getRootAuth() {
        Process process = null;
        DataOutputStream os = null;
        try {
            process = Runtime.getRuntime().exec("su");
            os = new DataOutputStream(process.getOutputStream());
            os.writeBytes("exit\n");
            os.flush();
            int exitValue = process.waitFor();
            if (exitValue == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            Log.d("*** DEBUG ***", "Unexpected error - Here is what I know: "
                    + e.getMessage());
            return false;
        } finally {
            try {
                if (os != null) {
                    os.close();
                }
                process.destroy();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

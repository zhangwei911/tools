package com.viz.tools;
/*
 * Copyright (C) 2010 Lytsing Huang http://lytsing.org
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import com.viz.tools.apk.StringUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Math;

/**
 * Wrapper API for sending log output.
 */
public class Log {
    public static String TAG = "MyApplication";
    public static String AUTHOR = "";
    protected static Config config = new Config("logfilter");

    public static boolean allowV = true;
    public static boolean allowD = true;
    public static boolean allowI = true;
    public static boolean allowW = true;
    public static boolean allowE = true;

    public static boolean saveV = false;
    public static boolean saveD = false;
    public static boolean saveI = false;
    public static boolean saveW = false;
    public static boolean saveE = false;

    public enum LOG_TYPE {V, D, I, W, E}

    // 存放日志文件的目录全路径
    public static String m_strLogFolderPath = "";

    private static Context context = null;

    public static String SUFFIX = ".java";

    public Log() {
    }

    public static void init(Context context) {
        Log.context = context;
    }
//============================V=======================

    /**
     * Send a VERBOSE log message.
     *
     * @param msg The message you would like logged.
     */
    public static void v(Object msg) {
        log(allowV, saveV, null, msg, LOG_TYPE.V);
    }

    public static void vf(String msg, Object... args) {
        log(allowV, saveV, null, format(msg, args), LOG_TYPE.V);
    }

    public static void vf(Object... args) {
        log(allowV, saveV, null, format(null, args), LOG_TYPE.V);
    }

    /**
     * Send a VERBOSE log message.
     *
     * @param msg The message you would like logged.
     */
    public static void v(String tag, Object msg) {
        log(allowV, saveV, tag, msg, LOG_TYPE.V);
    }

    public static void v(String tag, String msg, Object... args) {
        log(allowV, saveV, tag, String.format(msg, args), LOG_TYPE.V);
    }

    public static void v() {
        log(allowV, saveV, null, "", LOG_TYPE.V);
    }

    public static void vj(String json) {
        vj(null, json);
    }

    public static void vj(String tag, String json) {
        log(allowV, saveV, tag, formatJson(json), LOG_TYPE.V);
    }

    public static void vj(String json, String msg, Object... args) {
        vj(null, formatJson(json, msg, args));
    }

    public static void vj(String tag, String json, String msg, Object... args) {
        vj(tag, formatJson(json, msg, args));
    }

    //============================D=======================

    /**
     * Send a DEBUG log message.
     *
     * @param msg
     */
    public static void d(Object msg) {
        log(allowD, saveD, null, msg, LOG_TYPE.D);
    }

    public static void df(String msg, Object... args) {
        log(allowD, saveD, null, format(msg, args), LOG_TYPE.D);
    }

    public static void df(Object... args) {
        log(allowD, saveD, null, format(null, args), LOG_TYPE.D);
    }

    /**
     * Send a DEBUG log message.
     *
     * @param msg
     */
    public static void d(String tag, Object msg) {
        log(allowD, saveD, tag, msg, LOG_TYPE.D);
    }

    public static void d(String tag, String msg, Object... args) {
        if(args.length == 0){
            d(tag,msg);
            return;
        }
        log(allowD, saveD, tag, String.format(msg, args), LOG_TYPE.D);
    }

    public static void d() {
        log(allowD, saveD, null, "", LOG_TYPE.D);
    }

    public static void dj(String json) {
        dj(null, json);
    }

    public static void dj(String tag, String json) {
        log(allowV, saveV, tag, formatJson(json), LOG_TYPE.V);
    }

    public static void dj(String json, String msg, Object... args) {
        dj(null, formatJson(json, msg, args));
    }

    public static void dj(String tag, String json, String msg, Object... args) {
        dj(tag, formatJson(json, msg, args));
    }

    //============================I=======================

    /**
     * Send an INFO log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(Object msg) {
        log(allowI, saveI, null, msg, LOG_TYPE.I);
    }

    public static void ifo(String msg, Object... args) {
        log(allowI, saveI, null, format(msg, args), LOG_TYPE.I);
    }

    public static void ifo(Object... args) {
        log(allowI, saveI, null, format(null, args), LOG_TYPE.I);
    }

    /**
     * Send an INFO log message.
     *
     * @param msg The message you would like logged.
     */
    public static void i(String tag, Object msg) {
        log(allowI, saveI, tag, msg, LOG_TYPE.I);
    }

    public static void i(String tag, String msg, Object... args) {
        log(allowI, saveI, tag, String.format(msg, args), LOG_TYPE.I);
    }

    public static void i() {
        log(allowI, saveI, null, "", LOG_TYPE.I);
    }

    public static void ij(String json) {
        ij(null, json);
    }

    public static void ij(String tag, String json) {
        log(allowV, saveV, tag, formatJson(json), LOG_TYPE.V);
    }

    public static void ij(String json, String msg, Object... args) {
        ij(null, formatJson(json, msg, args));
    }

    public static void ij(String tag, String json, String msg, Object... args) {
        ij(tag, formatJson(json, msg, args));
    }

    //============================W=======================

    /**
     * Send a WARN log message
     *
     * @param msg The message you would like logged.
     */
    public static void w(Object msg) {
        log(allowW, saveW, null, msg, LOG_TYPE.W);
    }

    public static void wf(String msg, Object... args) {
        log(allowW, saveW, null, format(msg, args), LOG_TYPE.W);
    }

    public static void wf(Object... args) {
        log(allowW, saveW, null, format(null, args), LOG_TYPE.W);
    }

    /**
     * Send a WARN log message
     *
     * @param msg The message you would like logged.
     */
    public static void w(String tag, Object msg) {
        log(allowW, saveW, tag, msg, LOG_TYPE.W);
    }

    public static void w(String tag, String msg, Object... args) {
        log(allowW, saveW, tag, String.format(msg, args), LOG_TYPE.W);
    }

    public static void w() {
        log(allowW, saveW, null, "", LOG_TYPE.W);
    }

    public static void wj(String json) {
        wj(null, json);
    }

    public static void wj(String tag, String json) {
        log(allowV, saveV, tag, formatJson(json), LOG_TYPE.V);
    }

    public static void wj(String json, String msg, Object... args) {
        wj(null, formatJson(json, msg, args));
    }

    public static void wj(String tag, String json, String msg, Object... args) {
        wj(tag, formatJson(json, msg, args));
    }

    //============================E=======================

    /**
     * Send an ERROR log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(Object msg) {
        log(allowE, saveE, null, msg, LOG_TYPE.E);
    }

    public static void ef(String msg, Object... args) {
        log(allowE, saveE, null, format(msg, args), LOG_TYPE.E);
    }

    public static void ef(Object... args) {
        log(allowE, saveE, null, format(null, args), LOG_TYPE.E);
    }

    /**
     * Send an ERROR log message.
     *
     * @param msg The message you would like logged.
     */
    public static void e(String tag, Object msg) {
        log(allowE, saveE, tag, msg, LOG_TYPE.E);
    }

    public static void e(String tag, String msg, Object... args) {
        log(allowE, saveE, tag, String.format(msg, args), LOG_TYPE.E);
    }

    public static void e() {
        log(allowE, saveE, null, "", LOG_TYPE.E);
    }

    public static void ej(String json) {
        ej(null, json);
    }

    public static void ej(String tag, String json) {
        log(allowV, saveV, tag, formatJson(json), LOG_TYPE.V);
    }

    public static void ej(String json, String msg, Object... args) {
        ej(null, formatJson(json, msg, args));
    }

    public static void ej(String tag, String json, String msg, Object... args) {
        ej(tag, formatJson(json, msg, args));
    }

    /**
     * Handy function to get a loggable stack trace from a Throwable
     *
     * @param tr An exception to log
     */
    public static String getStackTraceString(Throwable tr) {
        return android.util.Log.getStackTraceString(tr);
    }

    /**
     * Building Message
     *
     * @param msg The message you would like logged.
     * @return Message String
     */
    protected static String buildMessage(Object msg, boolean isSave) {
        StackTraceElement[] sts = Thread.currentThread().getStackTrace();
        if (sts == null) {
            return null;
        }
        for (StackTraceElement st : sts) {
            //String cn = st.getClassName();
            //String[] cni = cn.split("\\.");
            //if (cni.length > 0) {
            //    cn = cni[cni.length - 1] + SUFFIX;
            //}
            //
            //if (cn.contains("$")) {
            //    cn = cn.split("\\$")[0] + SUFFIX;
            //}
            //System.out.println("Log.buildMessage " + st.getClassName() + "(" + cn + ":" + st.getLineNumber() + ")");
            if (st.isNativeMethod()) {
                continue;
            }
            if (st.getClassName().equals(Thread.class.getName())) {
                continue;
            }
            if (st.getClassName().equals("com.viz.tools.Log")) {
                continue;
            }
            if (st.getMethodName().equals("Log")) {
                continue;
            }

            String className = st.getClassName();
            String[] classNameInfo = className.split("\\.");
            if (classNameInfo.length > 0) {
                className = classNameInfo[classNameInfo.length - 1] + SUFFIX;
            }

            if (className.contains("$")) {
                className = className.split("\\$")[0] + SUFFIX;
            }

            String logMsg = new StringBuilder()
                    .append(TextUtils.isEmpty(AUTHOR) ? "" : "@" + AUTHOR + " ")
                    .append(st.getClassName())
                    .append(".")
                    .append(st.getMethodName())
                    .append("(")
                    .append(className)
                    .append(":")
                    .append(st.getLineNumber())
                    .append(")")
                    .append(isEmpty(ObjectToString(msg)) ? "" : ": ")
                    .append(ObjectToString(msg)).toString();
            save(isSave, logMsg);
            return logMsg;
        }
        return null;
    }

    private static boolean isEmpty(String text) {
        if (text.length() == 0 || text == null) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isPrint(Object msg) {
        try {
            return arryContains(config.getStringValue("filter").split("@log@"), ObjectToString(msg));
        } catch (Exception e) {
            return true;
        }
    }

    /**
     * 判断某个字符串是否存在于数组中
     *
     * @param stringArray 原数组
     * @param source      查找的字符串
     * @return 是否找到
     */
    private static boolean arryContains(String[] stringArray, String source) {
        if (stringArray != null) {
            for (String str : stringArray) {
                if (str.contains(source)) {
                    return false;
                }
            }
        }
//        // 转换为list
//        List<String> tempList = Arrays.asList(stringArray);
//        // 利用list的包含方法,进行判断
//        return tempList.contains(source);
        return true;
    }

    private static void log(boolean isAllow, boolean isSave, String tag, Object log, LOG_TYPE log_type) {
        String logMsg = buildMessage(ObjectToString(log), isSave);
        if (logMsg == null) {
            logMsg = "null";
        }

        if (tag == null) {
            if (context == null) {
                tag = TAG;
            } else {
                tag = context.getPackageName();
            }
        }

        if (isAllow && isPrint(logMsg)) {
            logSplit(tag, logMsg, log_type);
        }
    }

    private static void logSplit(String tag, String logMsg, LOG_TYPE log_type) {
        final int logLen = logMsg.length();
        final int splitLen = 1024;
        final int logcount = Integer.parseInt((Math.ceil((double) (logLen / splitLen)) + "").substring(0, (Math.ceil((double) (logLen / splitLen)) + "").indexOf(".")));
        if (logLen > splitLen) {
            for (int i = 0; i < logcount; ++i) {
                if (i == logcount - 1) {
                    logOriginal(tag, logMsg.substring(i * splitLen, logLen), log_type);
                } else {
                    logOriginal(tag, logMsg.substring(i * splitLen, (i + 1) * splitLen), log_type);
                }
            }
        } else {
            logOriginal(tag, logMsg, log_type);
        }
    }

    private static void logOriginal(String tag, String msg, LOG_TYPE log_type) {
        switch (log_type) {
            case V: {
                android.util.Log.v(tag, msg);
                break;
            }
            case D: {
                android.util.Log.d(tag, msg);
                break;
            }
            case I: {
                android.util.Log.i(tag, msg);
                break;
            }
            case W: {
                android.util.Log.w(tag, msg);
                break;
            }
            case E: {
                android.util.Log.e(tag, msg);
                break;
            }
        }
    }

    private static void
    SaveLog2File(String strMsg) {
        FileWriter objFilerWriter = null;
        BufferedWriter objBufferedWriter = null;

        do // 非循环，只是为了减少分支缩进深度
        {
            String state = Environment.getExternalStorageState();
            // 未安装 SD 卡
            if (true != Environment.MEDIA_MOUNTED.equals(state)) {
                android.util.Log.d(TAG, "Not mount SD card!");
                break;
            }

            // SD 卡不可写
            if (true == Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
                android.util.Log.d(TAG, "Not allow write SD card!");
                break;
            }

            // 只有存在外部 SD 卡且可写入的情况下才允许保存日志文件到指定目录路径下
            // 没有指定日志文件存放位置的话，就写到默认位置，即 SD 卡根目录下的 custom_android_log 目录中
            if (true == m_strLogFolderPath.trim().equals("")) {
                String strSaveLogPath = Environment.getExternalStorageDirectory() +
                        "/custom_android_log";

                File fileSaveLogFolderPath = new File(strSaveLogPath);
                // 保存日志文件的路径不存在的话，就创建它
                if (true != fileSaveLogFolderPath.exists()) {
                    fileSaveLogFolderPath.mkdirs();
                }

                // 如果这里保存日志文件的路径还不存在的话，则要提醒用户了
                if (true != fileSaveLogFolderPath.exists()) {
                    android.util.Log.d(TAG, "Create log folder failed!");
                    break;
                }

                // 指定日志文件保存的路径，文件名由内部按日期时间形式
                m_strLogFolderPath = strSaveLogPath;
            }

            // 得到当前日期时间的指定格式字符串
            String strDateTimeFileName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());

            File fileLogFilePath = new File(m_strLogFolderPath, strDateTimeFileName + (context == null ? "" : context.getPackageName()) + ".log");
            // 如果日志文件不存在，则创建它
            if (true != fileLogFilePath.exists()) {
                try {
                    fileLogFilePath.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }

            // 如果执行到这步日志文件还不存在，就不写日志到文件了
            if (true != fileLogFilePath.exists()) {
                android.util.Log.d(TAG, "Create log file failed!");
                break;
            }

            try {
                objFilerWriter = new FileWriter(fileLogFilePath, //
                        true);          // 续写不覆盖
            } catch (IOException e1) {
                android.util.Log.d(TAG, "New FileWriter Instance failed");
                e1.printStackTrace();
                break;
            }

            objBufferedWriter = new BufferedWriter(objFilerWriter);

            // 得到当前日期时间的指定格式字符串
            String strDateTimeLogHead = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss").format(new Date());

            // 将日期时间头与日志信息体结合起来
            strMsg = TAG + " " + strDateTimeLogHead + " " + strMsg + "\n\n";

            try {
                objBufferedWriter.write(strMsg);
                objBufferedWriter.flush();
            } catch (IOException e) {
                android.util.Log.d(TAG, "objBufferedWriter.write or objBufferedWriter.flush failed");
                e.printStackTrace();
            }

        } while (false);

        if (null != objBufferedWriter) {
            try {
                objBufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if (null != objFilerWriter) {
            try {
                objFilerWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void save(boolean isSave, String logMsg) {
        if (isSave) {
            SaveLog2File(logMsg);
        }
    }

    public static String ObjectToString(Object msg) {
        if (msg != null) {
            return msg.toString();
        } else {
            return "[null]";
        }
    }

    private static String formatJson(String json, String msg, Object... args) {
        return String.format(msg, args) + "\n" + StringUtils.format(StringUtils.convertUnicode(json));
    }

    private static String formatJson(String json) {
        return StringUtils.format(StringUtils.convertUnicode(json));
    }

    private static String format(String msg, Object... args) {
        if (msg == null) {
            StringBuilder msgBuilder = new StringBuilder();
            for (Object obj : args) {
                if (obj != null) {
                    msgBuilder.append(obj.toString()).append(" ");
                } else {
                    msgBuilder.append("[null]").append(" ");
                }
            }
            msg = msgBuilder.toString();
            return msg;
        } else {
            return String.format(msg, args);
        }
    }
}

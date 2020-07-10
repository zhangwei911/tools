package com.viz.tools;

import android.os.Environment;

/**
 * Created by viz on 2014/10/29.
 */
public class SDCardTool {
    /**
     * 判断是否存在SD卡
     *
     * @return true存在，false不存在
     */
    public static boolean isExistSDCard() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }
}

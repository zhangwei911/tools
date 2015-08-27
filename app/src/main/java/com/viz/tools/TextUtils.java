package com.viz.tools;

/**
 * Created by swtf in project tools on 15-1-13 09:31 .
 */
public class TextUtils {
    /**
     * 判断是否为空
     *
     * @param c 需要判断的对象
     * @return true为空，false不为空
     */
    public static boolean isEmpty(CharSequence c) {
        if (c.length() == 0 || c == null) {
            return true;
        } else {
            return false;
        }
    }
}

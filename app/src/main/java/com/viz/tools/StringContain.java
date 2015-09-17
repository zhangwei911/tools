package com.viz.tools;

/**
 * Created by wellchang in project tools on 10/01/15 16:21.
 */
public class StringContain {
    /**
     * 判断某个字符串是否存在于数组中
     *
     * @param stringArray 原数组
     * @param source      查找的字符串
     * @param isEquals    是否完全匹配
     * @return 是否找到
     */
    public static boolean arryContains(String[] stringArray, String source, boolean isEquals,int index) {
        if (stringArray != null&&!TextUtils.isEmpty(source)) {
            int i = 0 ;
            for (String str : stringArray) {
                if (isEquals) {
                    if (str.equals(source)) {
                        index = i;
                        return true;
                    }
                } else {
                    if (str.contains(source)) {
                        index = i;
                        return true;
                    }
                }
                i++;
            }
        }
        return false;
    }
}

package com.viz.tools;

import android.content.Context;

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
        if (c == null || c.length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isEmpty(CharSequence... c) {
        return !isNotEmpty(c);
    }

    public static boolean isNotEmpty(CharSequence c) {
        return !isEmpty(c);
    }

    public static boolean isNotEmpty(CharSequence... c) {
        int emptyCount = 0;
        for(CharSequence cs:c){
            if(isEmpty(cs)){
                emptyCount++;
            }
        }
        return emptyCount == 0;
    }

    public static String getText(Context context,Object text){
        String t;
        try{
            if(text instanceof Integer) {
                t = context.getString((Integer) text);
            }else{
                t = text.toString();
            }
        }catch (Exception e){
            t = text.toString();
        }
        return t;
    }
}

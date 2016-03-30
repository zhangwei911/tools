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
        if (c.length() == 0 || c == null) {
            return true;
        } else {
            return false;
        }
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

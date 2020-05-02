package com.viz.tools;

import java.math.BigDecimal;

/**
 * Created by viz on 2014/10/29.
 */
public class Math {
    //+
    public static BigDecimal add(String a1, String a2) {
        BigDecimal b1 = new BigDecimal(a1);
        BigDecimal b2 = new BigDecimal(a2);
        return b1.add(b2);
    }

    //-
    public static BigDecimal subtract(String s1, String s2) {
        BigDecimal b1 = new BigDecimal(s1);
        BigDecimal b2 = new BigDecimal(s2);
        return b1.subtract(b2);
    }

    //÷
    public static BigDecimal divide(String d1, String d2) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        return b1.divide(b2, 2, BigDecimal.ROUND_HALF_EVEN);
    }

    //X
    public static BigDecimal multiply(String m1, String m2) {
        BigDecimal b1 = new BigDecimal(m1);
        BigDecimal b2 = new BigDecimal(m2);
        return b1.multiply(b2);
    }

    //N次方
    public static BigDecimal multiplyN(String d1, int count) {
        BigDecimal b1 = new BigDecimal(d1);
        String d2 = b1 + "";
        BigDecimal b2 = multiply(b1 + "", d2);
        BigDecimal b3 = b2;
        if (count > 2) {
            for (int i = 0; i < count - 2; i++) {
                b3 = b3.multiply(b1);
            }
        }
        return b3;
    }

    //开根号
    public static BigDecimal kgh(String kgh) {
        BigDecimal b1 = new BigDecimal(kgh);
        return blxs(new BigDecimal(java.lang.Math.sqrt(b1.doubleValue())) + "", 2);
    }

    //方差
    public static BigDecimal fc(String[] bzc, String av_count) {
        BigDecimal b1 = new BigDecimal("0.00");
        int len = bzc.length;
        for (int i = 0; i < len; i++) {
            BigDecimal abs = subtract(bzc[i], av_count).abs();
            BigDecimal m = multiplyN(abs + "", 2);
            b1 = b1.add(m);
        }
        return blxs(divide(b1 + "", len + "") + "", 2);
    }

    //标准方差
    public static BigDecimal bzc(String[] bzc, String av_count) {
        return kgh(fc(bzc, av_count) + "");
    }

    //保留小数
    public static BigDecimal blxs(String b, int weishu) {
        BigDecimal b1 = new BigDecimal(b);
        return b1.setScale(weishu, BigDecimal.ROUND_HALF_UP);
    }
}

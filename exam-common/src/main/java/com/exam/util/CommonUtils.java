package com.exam.util;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.regex.Pattern;

public class CommonUtils {

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Collection collection) {
        return collection == null || collection.size() < 1;
    }

    @SuppressWarnings("rawtypes")
    public static boolean isEmpty(Map map) {
        return map == null || map.size() < 1;
    }

    //检查字符串长度，字符串为null返回true
    public static boolean isLengthEnough(String str, int length) {
        if (str == null) {
            return false;
        }
        return str.length() >= length;
    }

    public static boolean isEmail(String email) {
        if (email == null) {
            return false;
        }
        return Pattern.matches("^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$", email);
    }

    public static boolean isPhone(String phoneNum) {
        if (phoneNum == null) {
            return false;
        }
        return Pattern.matches("^1(\\d{11})$", phoneNum);
    }

    //计算两个日期相差天数的绝对值
    public static long calculateApartDays(Date date1, Date date2) {
        //一天对应的毫秒值
        long day = 1000L * 60 * 60 * 24;
        return Math.abs(date1.getTime() / day - date2.getTime() / day);
    }

}

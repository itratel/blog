package com.yinhao.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * <p>StrUtil字符串工具类</p>
 * @author yinhao
 * @date 2019/12/18 15:46
 */
public final class StrUtil {

    private static final String BASE_STR = "abcdefghijklmnopqrstuvwxyz0123456789";
    /***
     * 判断当前字符串是否是null或者空白字符串
     * @param str str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    /***
     * 判断当前字符串是否是null或者空白字符串
     * @param str str
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    /**
     * 包装int类型的数据到String类型
     * @param intValue intValue
     * @return String
     */
    public static String wrapperInt(int intValue) {
        return intValue + "";
    }


    /***
     *  获取指定位数的有字母和数组组成的字符串
     * @param length length
     * @return String
     */
    public static String randomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        if (length < 1) {
            length = 1;
        }
        int baseLength = BASE_STR.length();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for(int i = 0; i < length; ++i) {
            int number = random.nextInt(baseLength);
            sb.append(BASE_STR.charAt(number));
        }
        return sb.toString();
    }


}

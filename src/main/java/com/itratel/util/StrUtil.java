package com.itratel.util;

/**
 * <p>StrUtil字符串工具类</p>
 * @author yinhao
 * @date 2019/12/18 15:46
 */
public final class StrUtil {

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


}

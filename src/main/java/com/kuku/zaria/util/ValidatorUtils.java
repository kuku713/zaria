package com.kuku.zaria.util;

import java.util.regex.Pattern;

/**
 * @author kuku713
 * @description
 * @date 2019-06-03
 */
public class ValidatorUtils {

    private static final String MOBILE_REG = "^(13[0-9]|14[579]|15[0-3,5-9]|16[6]|17[0135678]|18[0-9]|19[89])\\d{8}$";
    private static final String EMAIL_REG = "^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";

    /**
     * 正则判断字符串是否是手机号
     * @param str
     * @return
     */
    public static boolean isMobile(final String str) {
        return Pattern.matches(MOBILE_REG, str);
    }

    /**
     * 正则判断字符串是否是邮箱
     * @param str
     * @return
     */
    public static boolean isEmail(final String str) {
        return Pattern.matches(EMAIL_REG, str);
    }

}

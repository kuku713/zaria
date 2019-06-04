package com.kuku.zaria.common;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-13
 */
public class UserConsts {

    public static final String SESSION_USER_ID_KEY = "userId";

    public static final String SESSION_NICK_NAME_KEY = "nickName";

    /** 登录类型-userId */
    public static final int LOGIN_TYPE_USER_ID = 1;
    /** 登录类型-手机号 */
    public static final int LOGIN_TYPE_MOBILE = 2;
    /** 登录类型-邮箱 */
    public static final int LOGIN_TYPE_EMAIL = 3;

    public static final String USER_STATUS_INACTIVE = "0";

    public static final String USER_STATUS_ACTIVE = "1";

    public static final String USER_STATUS_LOCK = "2";

    public static final String USER_STATUS_BLACK_LIST = "4";

    public static final String USER_STATUS_DELETE = "9";

}

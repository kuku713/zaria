package com.kuku.zaria.common;

/**
 * @author luzh21574
 * @description 用户状态枚举
 * @date 2019-05-21
 */
public enum UserStatusEnum {

    /** 未激活 */
    INACTIVE(0, "未激活", "用户未激活，请先激活"),
    /** 正常 */
    ACTIVE(1, "正常", "正常"),
    /** 已锁定 */
    LOCK(2, "已锁定", "用户已锁定，请重新验证解锁"),
    /** 黑名单 */
    BLACK_LIST(4, "黑名单", "用户已被列入黑名单，请联系管理员"),
    /** 删除 */
    DELETE(9, "删除", "该用户已删除");

    /** 用户状态值 **/
    private int status;
    /** 用户状态描述 **/
    private String desc;
    /** 用户状态错误提示 **/
    private String errMsg;

    UserStatusEnum(int status, String desc, String errMsg) {
        this.status = status;
        this.desc = desc;
        this.errMsg = errMsg;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public String getErrMsg() {
        return errMsg;
    }

}

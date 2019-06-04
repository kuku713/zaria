package com.kuku.zaria.exception;

import org.apache.shiro.ShiroException;

/**
 * @author luzh21574
 * @description
 * @date 2019-06-03
 */
public class CustomShiroException extends ShiroException {

    public CustomShiroException() {
        super();
    }

    public CustomShiroException(String message) {
        super(message);
    }

}

package com.kuku.zaria.bean.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
@Data
public class BaseDTO implements Serializable {

    private String returnCode;

    private String returnMsg;

    public BaseDTO() {
    }

    public BaseDTO(String returnCode, String returnMsg) {
        this.returnCode = returnCode;
        this.returnMsg = returnMsg;
    }
}

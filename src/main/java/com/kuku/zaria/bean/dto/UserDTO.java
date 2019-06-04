package com.kuku.zaria.bean.dto;

import com.kuku.zaria.domain.entity.User;
import lombok.Data;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-12
 */
@Data
public class UserDTO extends BaseDTO {

    private User user;
    private String loginIp;
    private String loginName;
    private Integer loginType;

    public UserDTO(String returnCode, String returnMsg) {
        super(returnCode, returnMsg);
    }

    public UserDTO(User user) {
        super();
        this.user = user;
    }

}

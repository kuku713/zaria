package com.kuku.zaria.bean.dto;

import com.kuku.zaria.domain.entity.UserRole;
import lombok.Data;

import java.util.List;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-21
 */
@Data
public class UserRoleDTO extends BaseDTO {

    private List<UserRole> userRoleList;

    public UserRoleDTO(List<UserRole> userRoleList) {
        this.userRoleList = userRoleList;
    }

}

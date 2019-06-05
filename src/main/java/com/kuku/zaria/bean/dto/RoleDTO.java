package com.kuku.zaria.bean.dto;

import com.kuku.zaria.domain.entity.Role;
import lombok.Data;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-21
 */
@Data
public class RoleDTO extends BaseDTO {

    private List<Role> roleList;

    public RoleDTO(List<Role> roleList) {
        this.roleList = roleList;
    }
}

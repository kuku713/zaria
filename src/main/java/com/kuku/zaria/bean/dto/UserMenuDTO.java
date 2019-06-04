package com.kuku.zaria.bean.dto;

import com.kuku.zaria.domain.entity.UserMenu;
import lombok.Data;

import java.util.List;

/**
 * @author luzh21574
 * @description
 * @date 2019-05-21
 */
@Data
public class UserMenuDTO extends BaseDTO {

    private List<UserMenu> userMenuList;

    public UserMenuDTO(List<UserMenu> userMenuList) {
        this.userMenuList = userMenuList;
    }
}

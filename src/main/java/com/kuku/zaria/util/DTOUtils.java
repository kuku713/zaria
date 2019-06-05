package com.kuku.zaria.util;

import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.bean.dto.UserDTO;
import com.kuku.zaria.bean.dto.UserMenuDTO;
import com.kuku.zaria.bean.dto.UserRoleDTO;
import com.kuku.zaria.common.ErrorCodeConsts;
import com.kuku.zaria.domain.entity.User;
import com.kuku.zaria.domain.entity.UserMenu;
import com.kuku.zaria.domain.entity.UserRole;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-13
 */
public class DTOUtils {

    public static BaseDTO genSuccessBaseDTO() {
        return new BaseDTO(ErrorCodeConsts.RETURN_CODE_SUCCESS, "ok");
    }

    public static UserDTO genFailUserDTO(String failMsg) {
        return new UserDTO(ErrorCodeConsts.RETURN_CODE_FAIL, failMsg);
    }

    public static UserDTO genEmptyUserDTO() {
        return new UserDTO(ErrorCodeConsts.RETURN_CODE_SUCCESS, "");
    }

    public static UserDTO genSuccessUserDTO(User user) {
        UserDTO dto = new UserDTO(user);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

    public static UserRoleDTO genSuccessUserRoleDTO(List<UserRole> list) {
        UserRoleDTO dto = new UserRoleDTO(list);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

    public static UserMenuDTO genSuccessUserMenuDTO(List<UserMenu> list) {
        UserMenuDTO dto = new UserMenuDTO(list);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

}

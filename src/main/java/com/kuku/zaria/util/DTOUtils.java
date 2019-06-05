package com.kuku.zaria.util;

import com.kuku.zaria.bean.MenuTree;
import com.kuku.zaria.bean.dto.*;
import com.kuku.zaria.common.ErrorCodeConsts;
import com.kuku.zaria.domain.entity.*;

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

    public static RoleDTO genSuccessRoleDTO(List<Role> list) {
        RoleDTO dto = new RoleDTO(list);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

    public static MenuDTO genSuccessMenuDTO(List<Menu> list) {
        MenuDTO dto = new MenuDTO(list);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

    public static MenuTreeDTO genSuccessMenuTreeDTO(List<MenuTree> list) {
        MenuTreeDTO dto = new MenuTreeDTO(list);
        dto.setReturnCode(ErrorCodeConsts.RETURN_CODE_SUCCESS);
        return dto;
    }

}

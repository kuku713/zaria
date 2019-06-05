package com.kuku.zaria.service;

import com.kuku.zaria.bean.dto.RoleDTO;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
public interface RoleService {

    /**
     * 根据userId查询用户所有角色
     * @param userId
     * @return
     */
    RoleDTO listUserRolesByUserId(String userId);

}

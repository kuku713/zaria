package com.kuku.zaria.domain.mapper;

import com.kuku.zaria.domain.entity.Role;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
public interface RoleMapper extends Mapper<Role> {

    /**
     * 根据userId查询所有用户角色
     * @param userId
     * @return
     */
    List<Role> listRolesByUserId(String userId);

    /**
     * 查询所有角色信息
     * @return
     */
    List<Role> listAllRoles();
}

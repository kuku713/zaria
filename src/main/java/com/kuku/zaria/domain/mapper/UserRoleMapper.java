package com.kuku.zaria.domain.mapper;

import com.kuku.zaria.domain.entity.UserMenu;
import com.kuku.zaria.domain.entity.UserRole;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
public interface UserRoleMapper extends Mapper<UserRole> {

    /**
     * 根据userId查询所有用户角色
     * @param userId
     * @return
     */
    List<UserRole> listRolesByUserId(String userId);

    /**
     * 根据userId查询所有菜单权限
     * @param userId
     * @return
     */
    List<UserMenu> listMenusByUserId(String userId);
}

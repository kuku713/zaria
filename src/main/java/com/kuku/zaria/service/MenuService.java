package com.kuku.zaria.service;

import com.kuku.zaria.bean.dto.MenuDTO;
import com.kuku.zaria.bean.dto.MenuTreeDTO;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
public interface MenuService {

    /**
     * 查询所有菜单信息
     * @return
     */
    MenuDTO listAllMenus();

    /**
     * 查询所有菜单信息，返回树状结构
     * @return
     */
    MenuTreeDTO listAllMenuTree();

    /**
     * 根据userId查询用户所有菜单权限
     * @param userId
     * @return
     */
    MenuDTO listUserMenusByUserId(String userId);

    /**
     * 根据userId查询用户所有菜单权限，返回树状结构
     * @param userId
     * @return
     */
    MenuTreeDTO listUserMenuTreeByUserId(String userId);

}

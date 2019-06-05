package com.kuku.zaria.util;

import com.kuku.zaria.bean.MenuTree;
import com.kuku.zaria.domain.entity.Menu;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
@Slf4j
public class MenuUtils {

    private static final String ROOT_MENU_CODE = "root";

    public static List<MenuTree> convertMenuTree(final List<Menu> menuList) {
        if (CollectionUtils.isEmpty(menuList)) {
            return new ArrayList<>();
        }
        Map<String, MenuTree> childMap = new HashMap<>(menuList.size());
        Map<String, MenuTree> rootMap = new HashMap<>(menuList.size());
        menuList.forEach(menu -> {
            MenuTree menuTree = new MenuTree();
            menuTree.setMenuId(menu.getId());
            menuTree.setMenuCode(menu.getMenuCode());
            menuTree.setMenuName(menu.getMenuName());
            menuTree.setMenuIcon(menu.getMenuIcon());
            menuTree.setMenuUrl(menu.getMenuUrl());
            menuTree.setOrderNo(menu.getOrderNo());
            menuTree.setParentCode(menu.getParentCode());
            if (ROOT_MENU_CODE.equals(menu.getParentCode())) {
                rootMap.put(menu.getMenuCode(), menuTree);
            } else {
                childMap.put(menu.getMenuCode(), menuTree);
            }
        });
        childMap.forEach((menuCode, menuTree) -> {
            if (rootMap.containsKey(menuTree.getParentCode())) {
                rootMap.get(menuTree.getParentCode()).getChildMenu().add(menuTree);
            } else {
                if (null != childMap.get(menuTree.getParentCode())) {
                    childMap.get(menuTree.getParentCode()).getChildMenu().add(menuTree);
                } else {
                    log.error("错误的菜单数据，父菜单节点未赋权或找不到，请检查菜单数据:" + menuTree.toString());
                }
            }
        });
        List<MenuTree> treeList = new ArrayList<>(rootMap.size());
        rootMap.forEach((menuCode, menuTree) -> treeList.add(menuTree));
        return treeList;
    }

}
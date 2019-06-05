package com.kuku.zaria.controller.management;

import com.kuku.zaria.bean.dto.MenuTreeDTO;
import com.kuku.zaria.service.MenuService;
import com.kuku.zaria.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Slf4j
@RestController
@RequestMapping(value = "/mgt/permission")
public class PermissionController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/listAllMenuTree")
    public MenuTreeDTO list() {
        return menuService.listAllMenuTree();
    }

}

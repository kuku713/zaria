package com.kuku.zaria.controller.client;

import com.kuku.zaria.bean.dto.BaseDTO;
import com.kuku.zaria.bean.dto.MenuTreeDTO;
import com.kuku.zaria.service.MenuService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kuku713
 * @description
 * @date 2019-06-04
 */
@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/listUserMenuTree")
    public MenuTreeDTO listUserMenuTree() {
        String userId = (String) SecurityUtils.getSubject().getPrincipal();
        return menuService.listUserMenuTreeByUserId(userId);
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public BaseDTO testJson(HttpServletRequest request) {
        return new BaseDTO("1", "/test");
    }

}

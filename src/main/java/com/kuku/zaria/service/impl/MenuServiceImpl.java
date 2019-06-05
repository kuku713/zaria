package com.kuku.zaria.service.impl;

import com.kuku.zaria.bean.dto.MenuDTO;
import com.kuku.zaria.bean.dto.MenuTreeDTO;
import com.kuku.zaria.domain.mapper.MenuMapper;
import com.kuku.zaria.service.MenuService;
import com.kuku.zaria.util.DTOUtils;
import com.kuku.zaria.util.MenuUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author kuku713
 * @description
 * @date 2019-06-05
 */
@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Override
    public MenuDTO listAllMenus() {
        return DTOUtils.genSuccessMenuDTO(menuMapper.listAllMenus());
    }

    @Override
    public MenuTreeDTO listAllMenuTree() {
        return DTOUtils.genSuccessMenuTreeDTO(MenuUtils.convertMenuTree(menuMapper.listAllMenus()));
    }

    @Override
    public MenuDTO listUserMenusByUserId(String userId) {
        return DTOUtils.genSuccessMenuDTO(menuMapper.listMenusByUserId(userId));
    }

    @Override
    public MenuTreeDTO listUserMenuTreeByUserId(String userId) {
        return DTOUtils.genSuccessMenuTreeDTO(MenuUtils.convertMenuTree(menuMapper.listMenusByUserId(userId)));
    }

}

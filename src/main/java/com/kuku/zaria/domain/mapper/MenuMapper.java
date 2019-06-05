package com.kuku.zaria.domain.mapper;

import com.kuku.zaria.domain.entity.Menu;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @author kuku713
 * @description
 * @date 2019-05-12
 */
public interface MenuMapper extends Mapper<Menu> {

    /**
     * 根据userId查询所有菜单权限
     * @param userId
     * @return
     */
    List<Menu> listMenusByUserId(String userId);

    /**
     * 查询所有菜单信息
     * @return
     */
    List<Menu> listAllMenus();

}

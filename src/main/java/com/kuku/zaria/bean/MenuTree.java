package com.kuku.zaria.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luzh21574
 * @description
 * @date 2019-06-04
 */
@Data
public class MenuTree {

    private Long menuId;

    private String menuCode;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

    private String parentCode;

    private Long orderNo;

    private List<MenuTree> childMenu = new ArrayList<>();

}

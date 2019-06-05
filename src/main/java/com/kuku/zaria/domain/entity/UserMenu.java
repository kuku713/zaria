package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description
 * @date 2019-05-21
 */
@Data
public class UserMenu {

    private Long menuId;

    private String userId;

    private String menuCode;

    private String menuName;

    private String menuUrl;

    private String menuIcon;

}

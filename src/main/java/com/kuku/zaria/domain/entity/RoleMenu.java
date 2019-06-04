package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class RoleMenu {

	private Long id;

	private String roleCode;

	private String menuCode;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

}

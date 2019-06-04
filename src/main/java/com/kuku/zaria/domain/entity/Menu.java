package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class Menu {

	private Long id;

	private String menuCode;

	private String menuName;

	private String menuUrl;

	private String menuIcon;

	private String parentCode;

	private Long orderNo;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private String remark;

}

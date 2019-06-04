package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class UserRole {

	private Long id;

	private String userId;

	private String roleCode;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private String roleName;

}

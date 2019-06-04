package com.kuku.zaria.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class Role {

	private Long roleId;

	private String roleCode;

	private String roleName;

	private String creator;

	private Long parentId;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private String remark;

}

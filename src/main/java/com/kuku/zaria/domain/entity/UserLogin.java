package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class UserLogin {

	private Long id;

	private String userId;

	private String loginName;

	private Integer loginType;

	private java.util.Date loginTime;

	private String loginIp;

	private String remark;

}

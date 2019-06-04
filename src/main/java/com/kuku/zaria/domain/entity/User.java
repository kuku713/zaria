package com.kuku.zaria.domain.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class User {

	private Long id;

	private String userId;

	private String nickName;

	@JSONField(serialize = false)
	private String userPwd;

	private Integer userStatus;

	private String mobile;

	private String email;

	private String creator;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private java.util.Date pwdModifyTime;

	private String remark;

}

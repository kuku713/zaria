package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class UserMessage {

	private Long msgId;

	private String msgTitle;

	private String sendUserId;

	private String receiveUserId;

	private java.util.Date sendTime;

	private String msgContent;

	private Long msgTypeId;

	private Long msgStatus;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

}

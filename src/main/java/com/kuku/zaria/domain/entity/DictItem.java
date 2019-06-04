package com.kuku.zaria.domain.entity;

import lombok.Data;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class DictItem {

	private Long id;

	private String itemCode;

	private String entryCode;

	private String entryName;

	private String itemName;

	private Long orderNo;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private String remark;

}

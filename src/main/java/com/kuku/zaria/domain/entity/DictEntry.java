package com.kuku.zaria.domain.entity;

import lombok.Data;

import java.util.List;

/**
 * @author kuku713
 * @description auto create by Mybatis groovy
 * @date 2019-05-19
 */
@Data
public class DictEntry {

	private Long id;

	private String entryCode;

	private String entryName;

	private java.util.Date gmtCreate;

	private java.util.Date gmtModified;

	private String remark;

	private List<DictItem> dictItems;
}

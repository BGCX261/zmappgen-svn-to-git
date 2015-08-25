package com.haode.appgen.entity.initData;

import java.util.List;

public class TableInitData {
	// 表名
	private String tableName;

	// 字段类型List
	private List<String> fieldTypeList;

	// 字段类型List
	private List<String> fieldNameList;
	
	// 字段值table
	private List<List<String>> valueTable;

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<String> getFieldTypeList() {
		return fieldTypeList;
	}

	public void setFieldTypeList(List<String> fieldTypeList) {
		this.fieldTypeList = fieldTypeList;
	}

	public List<List<String>> getValueTable() {
		return valueTable;
	}

	public void setValueTable(List<List<String>> valueTable) {
		this.valueTable = valueTable;
	}

	public List<String> getFieldNameList() {
		return fieldNameList;
	}

	public void setFieldNameList(List<String> fieldNameList) {
		this.fieldNameList = fieldNameList;
	}

}

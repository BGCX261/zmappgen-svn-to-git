package com.haode.appgen.entity.initData;

import java.util.List;

public class TableInitData {
	// ����
	private String tableName;

	// �ֶ�����List
	private List<String> fieldTypeList;

	// �ֶ�����List
	private List<String> fieldNameList;
	
	// �ֶ�ֵtable
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

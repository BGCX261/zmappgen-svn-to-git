package com.haode.appgen.entity.table;

public class Column {
	private String columnName;
	private String columnType;
	private String attributeName;
	private String attributeType;
	private String description;
	private boolean theNull;
	private String remark;
	private boolean primaryKey;
	private String foreignKeyTable;
	private String foreignKeyColumn;
	private String jdbcType;
	
	/**
	 * get Null String
	 * @return NULL or NOT NULL
	 */
	public String getNullStr(){
		return this.isNull()?"":"NOT NULL";
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getAttributeName() {
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getAttributeType() {
		return attributeType;
	}

	public void setAttributeType(String attributeType) {
		this.attributeType = attributeType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isNull() {
		return theNull;
	}

	public void setNull(boolean theNull) {
		this.theNull = theNull;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public boolean isPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(boolean primaryKey) {
		this.primaryKey = primaryKey;
	}

	public String getForeignKeyTable() {
		return foreignKeyTable;
	}

	public void setForeignKeyTable(String foreignKeyTable) {
		this.foreignKeyTable = foreignKeyTable;
	}

	public String getForeignKeyColumn() {
		return foreignKeyColumn;
	}

	public void setForeignKeyColumn(String foreignKeyColumn) {
		this.foreignKeyColumn = foreignKeyColumn;
	}

	public String getJdbcType() {
		return jdbcType;
	}

	public void setJdbcType(String jdbcType) {
		this.jdbcType = jdbcType;
	}

}

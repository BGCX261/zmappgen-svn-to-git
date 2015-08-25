package com.haode.appgen.entity.table;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.lang.StringUtils;

public class Table {
	private String tableName;
	private String modelName;
	private String tableDescription;
	
	private List<Column> columns = new ArrayList<Column>();

	/**
	 * get column name by ','splice
	 * 
	 * @return
	 */
	public String getColumnNameString() {
		return StringUtils.join(this.getColumnNames(), ',');
	}

	/**
	 * get column name string array
	 * 
	 * @return
	 */
	public String[] getColumnNames() {
		List<String> cols = new ArrayList<String>();
		for (Column col : this.columns) {
			cols.add(col.getColumnName());
		}
		return cols.toArray(new String[1]);
	}
	
	/**
	 * 得到以 ':' 为前缀的列名数组，作为参数名用
	 * 
	 * @return
	 */
	public String[] getParamColumnNames() {
		List<String> cols = new ArrayList<String>();
		for (Column col : this.columns) {
			cols.add(":"+col.getColumnName());
		}
		return cols.toArray(new String[1]);
	}
	
	/**
	 * 得到以 ':' 为前缀,并且以 ',' 分割的字符串，作为参数名用
	 * 
	 * @return
	 */
	public String getParamColumnNameString() {
		return StringUtils.join(this.getParamColumnNames(), ',');
	}
	
	/**
	 * get primary key by ','splice
	 * 
	 * @return
	 */
	public String getPrimaryKeyString() {
		StringBuffer pks = new StringBuffer();
		for (Iterator<Column> iter = this.columns.iterator(); iter.hasNext();) {
			Column col = iter.next();
			if (col.isPrimaryKey()) {
				if (pks.length() != 0) {
					pks.append(",");
				}
				pks.append(col.getColumnName());
			}
		}
		return pks.toString();
	}

	/**
	 * get primary key string array
	 * 
	 * @return
	 */
	public Column[] getPrimaryKeys() {
		List<Column> pk = new ArrayList<Column>();
		for (Column col : this.columns) {
			if (col.isPrimaryKey()) {
				pk.add(col);
			}
		}
		return pk.toArray(new Column[1]);
	}
	
	/**
	 * get primary key string array
	 * 
	 * @return
	 */
	public Column[] getUnPrimaryKeys() {
		List<Column> unpk = new ArrayList<Column>();
		for (Column col : this.columns) {
			if (!col.isPrimaryKey()) {
				unpk.add(col);
			}
		}
		return unpk.toArray(new Column[1]);
	}

	/**
	 * get foreign key string array
	 * 
	 * @return
	 */
	public Column[] getForeignKeys() {
		List<Column> fk = new ArrayList<Column>();
		for (Column col : this.columns) {
			if (StringUtils.isNotEmpty(col.getForeignKeyTable())) {
				fk.add(col);
			}
		}
		if (fk.size()>0) {
			return fk.toArray(new Column[1]);
		}else{
			return null;
		}
	}
	
	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public void addColumn(Column column) {
		this.columns.add(column);
	}

	public List<Column> getColumns() {
		return columns;
	}

	public void setColumns(List<Column> columns) {
		this.columns = columns;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getTableDescription() {
		return tableDescription;
	}

	public void setTableDescription(String tableDescription) {
		this.tableDescription = tableDescription;
	}


}

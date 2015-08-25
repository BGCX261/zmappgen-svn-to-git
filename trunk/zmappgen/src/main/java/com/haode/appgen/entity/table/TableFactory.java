package com.haode.appgen.entity.table;

import java.util.List;

public interface TableFactory {

	public Table getTable(String sheetName);
	
	public List<Table> getTables();
}

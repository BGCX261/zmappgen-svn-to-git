package com.haode.appgen.entity.initData;

import java.util.List;

public interface TableInitDataFactory {

	public TableInitData getTableInitData(String sheetName) throws Exception;
	
	public List<TableInitData> getAllTableInitData() throws Exception;
	
}


package com.haode.appgen.entity.table;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.haode.appgen.entity.initData.TableInitData;

public class TableExcelFactory implements TableFactory {

	private String excelFile = "";

	public TableExcelFactory(String excelFile) {
		this.excelFile = excelFile;
	}

	public Table getTable(HSSFSheet sheet) {

		Table table = new Table();

		// get table name
		table.setTableName(getCellStringValue(sheet, 0, 3));
		// get model name
		table.setModelName(getCellStringValue(sheet, 0, 5));
		// get table description
		table.setTableDescription(getCellStringValue(sheet, 0, 7));

		for (int ci = 3; StringUtils.isNotBlank(getCellStringValue(sheet, ci, 0)); ci++) {
			Column col = new Column();
			col.setPrimaryKey("PK".equalsIgnoreCase(getCellStringValue(sheet, ci, 1)));
			col.setDescription(getCellStringValue(sheet, ci, 2));
			col.setColumnName(getCellStringValue(sheet, ci, 3));
			col.setAttributeName(getCellStringValue(sheet, ci, 4));
			col.setColumnType(getCellStringValue(sheet, ci, 5));
			col.setAttributeType(getCellStringValue(sheet, ci, 6));
			col.setNull("NULL".equalsIgnoreCase(getCellStringValue(sheet, ci, 7)));
			col.setForeignKeyTable(getCellStringValue(sheet, ci, 8));
			col.setForeignKeyColumn(getCellStringValue(sheet, ci, 9));
			col.setJdbcType(getCellStringValue(sheet, ci, 10));
			col.setRemark(getCellStringValue(sheet, ci, 11));
			table.addColumn(col);
		}

		return table;
	}

	/**
	 * get a table
	 */
	public Table getTable(String sheetName) {
		HSSFWorkbook wb = null;
		FileInputStream fileOut = null;
		try {
			fileOut = new FileInputStream(excelFile);
			wb = new HSSFWorkbook(fileOut);
			HSSFSheet sheet = wb.getSheet(sheetName);
			return this.getTable(sheet);

		} catch (IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				fileOut.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	/**
	 * get all table
	 */
	public List<Table> getTables() {
		List<Table> tables = new ArrayList<Table>();
		HSSFWorkbook wb = null;
		FileInputStream fileOut = null;
		try {
			fileOut = new FileInputStream(excelFile);
			wb = new HSSFWorkbook(fileOut);

			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				tables.add(this.getTable(wb.getSheetAt(i)));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return tables;
	}

	/**
	 * 取单元格文本
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	private String getCellStringValue(HSSFSheet sheet, int rowNum, int cellNum) {
		if (sheet == null) {
			return null;
		}
		HSSFRow row = sheet.getRow(rowNum);
		if (row == null) {
			return "";
		}
		HSSFCell cell = row.getCell(cellNum);
		if (cell == null) {
			return "";
		}
		return cell.getRichStringCellValue().getString();
	}
}

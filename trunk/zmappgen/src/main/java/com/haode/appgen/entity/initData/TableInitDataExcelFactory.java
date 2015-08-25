package com.haode.appgen.entity.initData;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class TableInitDataExcelFactory implements TableInitDataFactory {
	
	private final static DecimalFormat NumericFormat = new DecimalFormat("#.#"); 

	private String excelFile = "";

	public TableInitDataExcelFactory(String excelFile) {
		this.excelFile = excelFile;
	}

	/**
	 * @throws Exception
	 * 
	 */
	private TableInitData getTableInitData(HSSFSheet sheet) throws Exception {

		TableInitData data = new TableInitData();

		// set table name
		data.setTableName(sheet.getSheetName());

		// get field name info, row=1
		List<String> fieldNameList = new ArrayList<String>();
		for (int celli = 0; StringUtils.isNotBlank(getCellStringValue(sheet, 1, celli)); celli++) {
			fieldNameList.add(getCellStringValue(sheet, 1, celli));
		}
		data.setFieldNameList(fieldNameList);

		// field count
		int fieldCount = fieldNameList.size();

		// get field type info, row=0
		List<String> fieldTypeList = new ArrayList<String>();
		for (int celli = 0; celli < fieldCount; celli++) {
			fieldTypeList.add(getCellStringValue(sheet, 0, celli));
		}
		data.setFieldTypeList(fieldTypeList);

		// ---------------
		// get field value table, row >= 2
		List<List<String>> valueTable = new ArrayList<List<String>>();
		for (int ri = 2; StringUtils.isNotBlank(getCellStringValue(sheet, ri, 0)); ri++) {
			List<String> record = new ArrayList<String>();
			for (int celli = 0; celli < fieldCount; celli++) {
				String _v = getCellStringValue(sheet, ri, celli);
				if ("s".equalsIgnoreCase(fieldTypeList.get(celli)) && _v != null) {
					_v = "'" + _v + "'";
				}

				record.add(_v);
			}
			valueTable.add(record);
		}
		data.setValueTable(valueTable);

		return data;
	}

	/**
	 * get a table data
	 * 
	 * @throws Exception
	 */
	public TableInitData getTableInitData(String sheetName) throws Exception {
		HSSFWorkbook wb = null;
		FileInputStream fileOut = null;
		try {
			fileOut = new FileInputStream(excelFile);
			wb = new HSSFWorkbook(fileOut);
			HSSFSheet sheet = wb.getSheet(sheetName);
			return this.getTableInitData(sheet);

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
	 * get all data
	 * 
	 * @throws Exception
	 */
	public List<TableInitData> getAllTableInitData() throws Exception {
		List<TableInitData> tableInitDataList = new ArrayList<TableInitData>();
		HSSFWorkbook wb = null;
		FileInputStream fileOut = null;
		try {
			fileOut = new FileInputStream(excelFile);
			wb = new HSSFWorkbook(fileOut);

			for (int i = 0; i < wb.getNumberOfSheets(); i++) {
				tableInitDataList.add(this.getTableInitData(wb.getSheetAt(i)));
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

		return tableInitDataList;
	}

	/**
	 * 取单元格文本
	 * 
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Exception
	 */
	private String getCellStringValue(HSSFSheet sheet, int rowNum, int cellNum) throws Exception {
		String rs = "";
		try {
			if (sheet == null) {
				return null;
			}
			HSSFRow row = sheet.getRow(rowNum);
			if (row == null) {
				return null;
			}
			HSSFCell cell = row.getCell(cellNum);
			if (cell == null) {
				return null;
			}
			if (cell.getCellType()==Cell.CELL_TYPE_BLANK) {
				return null;
			}else if (cell.getCellType()==Cell.CELL_TYPE_STRING) {
				rs = cell.getStringCellValue();
			}else{
				rs = NumericFormat.format(cell.getNumericCellValue());
			}
//			rs = cell.getRichStringCellValue().getString();
//			rs = cell.getStringCellValue();
		} catch (Exception e) {
			System.out.println(e.toString() + ": " + sheet.getSheetName() + " " + rowNum + "," + cellNum);
			throw e;
		}
		return rs.length() == 0 ? null : rs;
	}
}

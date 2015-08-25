package com.haode.appgen.sjj;

import java.util.List;

import org.apache.velocity.app.Velocity;

import com.haode.appgen.builder.InitDataSqlBuilder;
import com.haode.appgen.builder.SjjAppBuilder;
import com.haode.appgen.builder.SqlBuilder;
import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.initData.TableInitData;
import com.haode.appgen.entity.initData.TableInitDataExcelFactory;
import com.haode.appgen.entity.initData.TableInitDataFactory;
import com.haode.appgen.entity.table.Table;
import com.haode.appgen.entity.table.TableExcelFactory;
import com.haode.appgen.entity.table.TableFactory;

public class GenCollect {

	public static void main(String[] args) {

		// 项目名称
		String projectName = "com.haodechina.platform.collect.dao";

		// 项目ID
		String projectId = "com.haodechina.platform.collect.dao";

		// 生成项目 目的位置(绝对路径)
		String projectPath = "F:\\usr\\eclipse372workspace\\com.haodechina.platform.collect.dao\\generationCode";

		// 生成项目 所需模板的 相对位置
		String templetPath = "vm/sjj";

		// 基本包结构
		String basePackage = "com.haodechina.platform.collect.dao";

		// Java文件输出根路径(相对projectPath)
		String javaPath = "src/main/java";

		// Jsp文件输出根路径(相对projectPath)
		String jspPath = "webapp/jsp";

		ProjectBean project = new ProjectBean(projectId, projectName, basePackage, projectPath, templetPath, javaPath,
				jspPath);

		String excelPath = "F:\\usr\\eclipse372workspace\\hidcm\\docment\\3--系统设计\\数据采集\\";

		String excelFile = "collectDB.xls";

		excelFile = excelPath + excelFile;

		TableFactory tableFactory = new TableExcelFactory(excelFile);
		List<Table> tables = tableFactory.getTables();

		//
		Velocity.setProperty(Velocity.RUNTIME_LOG, "zmappgen_velocity.log");
		Velocity.setProperty(Velocity.INPUT_ENCODING, "GBK");
		Velocity.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
		Velocity.setProperty(Velocity.ENCODING_DEFAULT, "GBK");

		Velocity.init();

		for (Table t : tables) {
			try {
				// create sql script
				SqlBuilder sqlBulider = new SqlBuilder(project, t);
				sqlBulider.generateDdlSql();

				// entity java
				SjjAppBuilder builder = new SjjAppBuilder(project, t);
				builder.generateEntity();

				builder.generateService();

				builder.generateMainjsp();

				builder.generateViewjsp();

				builder.generateActionjsp();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			TableInitDataFactory tableInitDataFactory = new TableInitDataExcelFactory(excelPath + "collectData.xls");
			List<TableInitData> tableInitDataList = tableInitDataFactory.getAllTableInitData();
			for (TableInitData tableInitData : tableInitDataList) {
				try {
					InitDataSqlBuilder initDataSqlBuilder = new InitDataSqlBuilder(project, tableInitData);
					initDataSqlBuilder.generateInitDataSql();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		

		System.out.println("[finish..]");
		System.out.println(excelFile);
		System.out.println(projectPath);

	}

}

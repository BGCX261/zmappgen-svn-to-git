package com.haode.appgen.sjj;

import java.util.List;

import org.apache.velocity.app.Velocity;

import com.haode.appgen.builder.SjjAppBuilder;
import com.haode.appgen.builder.SqlBuilder;
import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.table.Table;
import com.haode.appgen.entity.table.TableExcelFactory;
import com.haode.appgen.entity.table.TableFactory;

public class Testsjj {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// 项目名称
		String projectName = "aso";

		// 项目ID
		String projectId = "testp";

		// 生成项目 目的位置(绝对路径)
		String projectPath = "E:\\aso\\project\\zmnos-provision\\design\\generationCode";

		// 生成项目 所需模板的 相对位置
		String templetPath = "vm/sjj";

		// 基本包结构
		String basePackage = "com.zoom.emv.pon.wo";

		// Java文件输出根路径(相对projectPath)
		String javaPath = "src/main/java";

		// Jsp文件输出根路径(相对projectPath)
		String jspPath = "webapp/jsp";

		ProjectBean project = new ProjectBean(projectId, projectName, basePackage, projectPath, templetPath, javaPath,
				jspPath);

		String excelPath = "E:\\aso\\project\\zmnos-provision\\design\\";

		String excelFile = "localDB.xls";
		// String excelFile = "mainDB.xls";
		// String excelFile = "ServiceVlan.xls";

		excelFile = excelPath + excelFile;

		TableFactory tableFactory = new TableExcelFactory(excelFile);
		List<Table> tables = tableFactory.getTables();
		
		//
		Velocity.setProperty( Velocity.RUNTIME_LOG, "zmappgen_velocity.log");
		Velocity.setProperty( Velocity.INPUT_ENCODING, "GBK");
		Velocity.setProperty( Velocity.OUTPUT_ENCODING, "GBK");		
		Velocity.init();

		for (Table t : tables) {
			try {

				// create sql script
				SqlBuilder sqlBuilder = new SqlBuilder(project, t);
				sqlBuilder.generateDdlSql();

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

		System.out.println("[finish..]");
		System.out.println(excelFile);

	}

}

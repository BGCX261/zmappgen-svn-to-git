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

		// ��Ŀ����
		String projectName = "aso";

		// ��ĿID
		String projectId = "testp";

		// ������Ŀ Ŀ��λ��(����·��)
		String projectPath = "E:\\aso\\project\\zmnos-provision\\design\\generationCode";

		// ������Ŀ ����ģ��� ���λ��
		String templetPath = "vm/sjj";

		// �������ṹ
		String basePackage = "com.zoom.emv.pon.wo";

		// Java�ļ������·��(���projectPath)
		String javaPath = "src/main/java";

		// Jsp�ļ������·��(���projectPath)
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

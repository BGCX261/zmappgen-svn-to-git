package com.haode.appgen.sjj;

import java.util.List;

import org.apache.velocity.app.Velocity;

import com.haode.appgen.builder.SjjAppBuilder;
import com.haode.appgen.builder.SqlBuilder;
import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.table.Table;
import com.haode.appgen.entity.table.TableExcelFactory;
import com.haode.appgen.entity.table.TableFactory;

public class GenCollectMon {


	public static void main(String[] args) {

		// ��Ŀ����
		String projectName = "com.haodechina.platform.collectmon";

		// ��ĿID
		String projectId = "com.haodechina.platform.collectmon";

		// ������Ŀ Ŀ��λ��(����·��)
		String projectPath = "F:\\usr\\eclipse372workspace\\com.haodechina.platform.collectmon\\generationCode";

		// ������Ŀ ����ģ��� ���λ��
		String templetPath = "vm/sjj";

		// �������ṹ
		String basePackage = "com.haodechina.platform.collectmon";

		// Java�ļ������·��(���projectPath)
		String javaPath = "src/main/java";

		// Jsp�ļ������·��(���projectPath)
		String jspPath = "webapp/jsp";

		ProjectBean project = new ProjectBean(projectId, projectName, basePackage, projectPath, templetPath, javaPath,
				jspPath);
		
		String excelPath = "F:\\usr\\eclipse372workspace\\com.haodechina.platform.collectmon\\design\\";

		String excelFile = "collectmonDB.xls";

		excelFile = excelPath + excelFile;

		TableFactory tableFactory = new TableExcelFactory(excelFile);
		List<Table> tables = tableFactory.getTables();
		
		//
		Velocity.setProperty( Velocity.RUNTIME_LOG, "zmappgen_velocity.log");
		Velocity.setProperty( Velocity.INPUT_ENCODING, "GBK");
		Velocity.setProperty( Velocity.OUTPUT_ENCODING, "UTF-8");
		Velocity.setProperty( Velocity.ENCODING_DEFAULT, "GBK");
		
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

		System.out.println("[finish..]");
		System.out.println(excelFile);

	}


}

package com.haode.appgen.sjj;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.haode.appgen.entity.table.Table;
import com.haode.appgen.entity.table.TableExcelFactory;
import com.haode.appgen.entity.table.TableFactory;

public class CodeGenerate {

	private static Logger log = LoggerFactory.getLogger(CodeGenerate.class);

	private final String TEMPLATE_PATH = ".\\vm";
	private final String IMPLEMENT_PATH = "E:\\work\\myEclipse\\appgen-test-hr";

	private final String VM_CREATE_TABLE = TEMPLATE_PATH + File.separator
			+ "createTable.vm";
	private final String VM_MODEL=  TEMPLATE_PATH + File.separator + "model.vm";
	private final String VM_DAO=  TEMPLATE_PATH + File.separator + "dao.vm";
	private final String VM_DAO_IBATIS=  TEMPLATE_PATH + File.separator + "daoIbatis.vm";

	private final String SPRING_DAO_CONFIG = IMPLEMENT_PATH
			+ "\\src\\main\\resources\\applicationContext-dao.xml";
	private final String SQL_MAP_CONFIG = IMPLEMENT_PATH
			+ "\\src\\main\\resources\\sql-map-config.xml";
	private final String SQL_MAP_PATH = IMPLEMENT_PATH
			+ "\\src\\main\\resources\\sqlmap\\";

	private final String DAO_PATH = IMPLEMENT_PATH
			+ "\\src\\main\\java\\com\\mds\\hr\\dao\\";
	private final String MODEL_PATH = IMPLEMENT_PATH
			+ "\\src\\main\\java\\com\\mds\\hr\\model\\";
	private final String CREATE_TABLE_SQL_PATH = IMPLEMENT_PATH
			+ "\\design\\db\\ddl\\";
	
	private final String DAO_PACKAGE="com.mds.hr.dao.ibatis";
	private final String DAO_IBATIS_PACKAGE="com.mds.hr.dao.ibatis";
	private final String MODEL_PACKAGE="com.mds.hr.model";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		(new CodeGenerate()).test();
	}

	/**
	 * test
	 */
	public void test() {
		String excelFile = "E:\\work\\myEclipse\\"
				+ "appgen-test-hr\\design\\hr??????.xls";

		TableFactory tableFactory = new TableExcelFactory(excelFile);
		List<Table> tables = tableFactory.getTables();

		for (Table t : tables) {
//			this.genCreateTableSql(t);
//			this.genModel(t);
			 this.genDao(t);
			// this.genSqlMap(t);
			 
		}
		// this.genSqlMapConfig(tables);
		// this.genSpringDaoConfig(tables);

		log.info("[finish]");
	}

	/**
	 * generate create table sql script
	 * 
	 * @param table
	 */
	public void genCreateTableSql(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("table", table);

		String targetFile = CREATE_TABLE_SQL_PATH + table.getTableName()
				+ ".sql";

		generateCode(VM_CREATE_TABLE, context, targetFile);
	}


	/**
	 * generate model
	 * 
	 * @param table
	 */
	public void genModel(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("table", table);
		context.put("stringUtil", new StringUtils());
		context.put("daoPackage", DAO_PACKAGE);
		
		String targetFile = MODEL_PATH + table.getModelName() + ".java";

		generateCode(VM_MODEL, context, targetFile);
	}


	/**
	 * generate dao
	 * 
	 * @param table
	 */
	public void genDao(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("table", table);
		context.put("stringUtil", new StringUtils());
		context.put("daoIbatisPackage", DAO_IBATIS_PACKAGE);
		context.put("modelPackage", MODEL_PACKAGE);

		String targetFile = DAO_PATH + table.getModelName() + "Dao.java";

		generateCode(VM_DAO_IBATIS, context, targetFile);
	}

	
	/**
	 * generate applicationContext-dao.xml
	 * 
	 * @param applicationContext-dao.xml
	 */
	public void genSpringDaoConfig(List<Table> tables) {
		VelocityContext context = new VelocityContext();
		context.put("daoPackage", "com.mds.hr.dao");
		context.put("stringUtil", new StringUtils());
		context.put("tables", tables);

		String templateFile = TEMPLATE_PATH + File.separator
				+ "applicationContext-dao.vm";
		String targetFile = SPRING_DAO_CONFIG;

		generateCode(templateFile, context, targetFile);
	}

	/**
	 * generate sql-map-config.xml
	 * 
	 * @param sql-map-config.xml
	 */
	public void genSqlMapConfig(List<Table> tables) {
		VelocityContext context = new VelocityContext();
		context.put("tables", tables);

		String templateFile = TEMPLATE_PATH + File.separator
				+ "sql-map-config.vm";
		String targetFile = SQL_MAP_CONFIG;

		generateCode(templateFile, context, targetFile);
	}

	/**
	 * generate sqlMap
	 * 
	 * @param table
	 */
	public void genSqlMap(Table table) {
		VelocityContext context = new VelocityContext();
		context.put("table", table);
		context.put("stringUtil", new StringUtils());
		context.put("package", "com.mds.hr.dao.po");

		String templateFile = TEMPLATE_PATH + File.separator + "sqlMap.vm";
		String targetFile = SQL_MAP_PATH + table.getModelName() + ".xml";

		generateCode(templateFile, context, targetFile);

	}

	/**
	 * 
	 * @param table
	 * @param templateFile
	 * @param path
	 */
	private void generateCode(String templateFile, VelocityContext context,
			String targetFile) {
		try {
			Velocity.init("velocity.properties");

			Template template = null;

			try {
				template = Velocity.getTemplate(templateFile);
			} catch (ResourceNotFoundException rnfe) {
				log.error(rnfe.toString());
				rnfe.printStackTrace();
			} catch (ParseErrorException pee) {
				log.error(pee.toString());
				pee.printStackTrace();
			}

			Writer writer = new BufferedWriter(new FileWriter(targetFile));

			if (template != null)
				template.merge(context, writer);
			// flush and cleanup
			writer.flush();
			writer.close();
		} catch (Exception e) {
			log.error(e.toString());
		}
	}
}

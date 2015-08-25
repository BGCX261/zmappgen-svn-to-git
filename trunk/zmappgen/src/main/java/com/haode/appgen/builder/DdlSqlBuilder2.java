package com.haode.appgen.builder;


/**
 * 根据数据库中的元数据生成代码
 * @author zm
 *
 */
public class DdlSqlBuilder2 {

//	/**
//	 * create a DdlSqlBulider
//	 * 
//	 * @param entityName
//	 */
//	public DdlSqlBuilder2(ProjectBean project, Table table) {
//		this.project = project;
//		this.table = table;
//
//		//
//		this.templet = "createTable.vm";
//	}
//
//	/**
//	 * generate model
//	 * 
//	 * @param table
//	 * @throws Exception
//	 */
//	public void generate(ObjectTable obj) throws Exception {
//		VelocityContext context = new VelocityContext();
//		context.put("table", obj);
//
//		String targetFile = this.getSqlAbsolutePath() + File.separator + "ddl" + File.separator + table.getTableName() + ".sql";
//
//		generateCode(getAbsoluteTemplet(), context, targetFile, project.getEncoding());
//	}
}

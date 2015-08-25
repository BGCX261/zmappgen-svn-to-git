package com.haode.appgen.builder;

import java.io.File;

import org.apache.velocity.VelocityContext;

import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.table.Table;

public class SqlBuilder extends BaseBuilder {

	//
	private Table table;

	public SqlBuilder(ProjectBean project, Table table) {
		this.project = project;
		this.table = table;

	}

	/**
	 * generate model
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void generateDdlSql() throws Exception {
		VelocityContext context = new VelocityContext();
		context.put("table", table);

		String targetFile = project.getSqlAbsolutePath() + File.separator + "ddl" + File.separator
				+ table.getTableName() + ".sql";

		String templetFile = project.getTempletPath() + "/createTable.vm";

		generateCode(templetFile, context, targetFile);
	}
}

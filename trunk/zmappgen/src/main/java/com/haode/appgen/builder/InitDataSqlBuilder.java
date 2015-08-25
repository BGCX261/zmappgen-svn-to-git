package com.haode.appgen.builder;

import java.io.File;

import org.apache.velocity.VelocityContext;

import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.initData.TableInitData;

public class InitDataSqlBuilder extends BaseBuilder {

	//
	private TableInitData data;

	public InitDataSqlBuilder(ProjectBean project, TableInitData data) {
		this.project = project;
		this.data = data;

	}

	/**
	 * generate model
	 * 
	 * @param table
	 * @throws Exception
	 */
	public void generateInitDataSql() throws Exception {
		VelocityContext context = new VelocityContext();
		context.put("data", data);

		String targetFile = project.getSqlAbsolutePath() + File.separator + "dml" + File.separator
				+ data.getTableName() + ".data.sql";

		String templetFile = project.getTempletPath() + "/createInitData.vm";

		generateCode(templetFile, context, targetFile);
	}
}

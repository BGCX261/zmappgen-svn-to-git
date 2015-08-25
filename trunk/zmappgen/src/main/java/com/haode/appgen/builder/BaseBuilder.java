package com.haode.appgen.builder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

import com.haode.appgen.entity.ProjectBean;

public abstract class BaseBuilder {

	protected ProjectBean project;

	/**
	 * 
	 * @param templateFile
	 * @param context
	 * @param targetNameFile
	 * @throws Exception
	 */
	protected void generateCode(String templateFile, VelocityContext context, String targetNameFile) throws Exception {
//		VelocityEngine velo = new VelocityEngine();
//		Properties prop = new Properties();
//		// String path = this.getServletContext().getRealPath("/");
//		// //"template/" 是指定你的vm文件放在WEBROOT下的template，根据
//		// // 你工程的vm文件位置的不同而作相应的变化
//		// prop.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, path +
//		// "template/");
//
//		// 设置velocity的编码
//		prop.setProperty(Velocity.ENCODING_DEFAULT, "GBK");
//		prop.setProperty(Velocity.INPUT_ENCODING, "GBK");
//		prop.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
//		// 初始化设置，下面用到getTemplate("*.vm")输出时
//		// 一定要调用velo对象去做,即velo.getTemplate("*.vm")
//		velo.init(prop);
//		template = velo.getTemplate(templateFile, "GBK");
		//////////////////////////////////////////////////////////////
		
		
		//eclipse run configurations set utf-8

		Template template = null;

		template = Velocity.getTemplate(templateFile);

		File targetFile = new File(targetNameFile);

		targetFile.getParentFile().mkdirs();
		// targetFile.createNewFile();

		Writer writer = new BufferedWriter(new FileWriter(targetFile));

		if (template != null)
			template.merge(context, writer);
		// flush and cleanup
		writer.flush();
		writer.close();

	}
}

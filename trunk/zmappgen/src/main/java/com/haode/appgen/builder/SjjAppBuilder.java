package com.haode.appgen.builder;

import org.apache.commons.lang.StringUtils;
import org.apache.velocity.VelocityContext;

import com.haode.appgen.entity.ProjectBean;
import com.haode.appgen.entity.table.Table;

public class SjjAppBuilder extends BaseBuilder {

	private String oid;

	private String entityClassname;
	private String entityPackage;

	private String serviceClassname;
	private String servicePackage;

	private VelocityContext velocityContext;

	/**
	 * create a EntityJavaBuilder
	 * 
	 * @param entityName
	 */
	public SjjAppBuilder(ProjectBean project, Table table) {
		this.project = project;
		this.oid = StringUtils.uncapitalize(table.getModelName());

		this.entityClassname = table.getModelName();
		this.entityPackage = project.getBasePackage() + ".entity";

		this.serviceClassname = table.getModelName() + "Service";
		this.servicePackage = project.getBasePackage() + ".service";

		//
		velocityContext = new VelocityContext();
		velocityContext.put("table", table);
		velocityContext.put("oid", oid);
		velocityContext.put("stringUtils", new StringUtils());
		velocityContext.put("entityClassname", entityClassname);
		velocityContext.put("entityPackage", entityPackage);
		velocityContext.put("serviceClassname", serviceClassname);
		velocityContext.put("servicePackage", servicePackage);
	}

	/**
	 * generate java Entity
	 * 
	 * @throws Exception
	 */
	public void generateEntity() throws Exception {

		String templetFile = project.getTempletPath() + "/java/entity.vm.java";

		String targetFile = project.getAbsoluteJavaPath() + "/entity/" + entityClassname + ".java";

		generateCode(templetFile, velocityContext, targetFile);
	}

	/**
	 * generate java Service
	 * 
	 * @throws Exception
	 */
	public void generateService() throws Exception {

		String templetFile = project.getTempletPath() + "/java/service.vm.java";

		String targetFile = project.getAbsoluteJavaPath() + "/service/" + serviceClassname + ".java";

		generateCode(templetFile, velocityContext, targetFile);
	}

	/**
	 * generate main jsp
	 * 
	 * @throws Exception
	 */
	public void generateMainjsp() throws Exception {

		String templetFile = project.getTempletPath() + "/jsp/mainjsp.vm.jsp";

		String targetFile = project.getAbsoluteJspPath() + "/" + oid + "/" + oid + ".jsp";

		generateCode(templetFile, velocityContext, targetFile);
	}

	/**
	 * generate view jsp
	 * 
	 * @throws Exception
	 */
	public void generateViewjsp() throws Exception {

		String templetFile = project.getTempletPath() + "/jsp/viewjsp.vm.jsp";

		String targetFile = project.getAbsoluteJspPath() + "/" + oid + "/" + oid + "View.jsp";

		generateCode(templetFile, velocityContext, targetFile);
	}

	/**
	 * generate action jsp
	 * 
	 * @throws Exception
	 */
	public void generateActionjsp() throws Exception {

		String templetFile = project.getTempletPath() + "/jsp/actionjsp.vm.jsp";

		String targetFile = project.getAbsoluteJspPath() + "/" + oid + "/" + oid + "Action.jsp";

		generateCode(templetFile, velocityContext, targetFile);
	}
}

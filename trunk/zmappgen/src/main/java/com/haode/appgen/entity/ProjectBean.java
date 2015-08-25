package com.haode.appgen.entity;

import java.io.File;

public class ProjectBean {

	/**
	 * 项目名称
	 */
	private String projectName = "";

	/**
	 * 项目ID
	 */
	private String projectId = "";

	/**
	 * 生成项目 目的位置(绝对路径)
	 */
	private String projectPath = "";

	/**
	 * 生成项目 所需模板的 相对位置
	 */
	private String templetPath = "";

	/**
	 * 基本包结构
	 */
	private String basePackage = "";

	/**
	 * Java文件输出根路径(相对projectPath)
	 */
	private String javaPath = "";

	/**
	 * Jsp文件输出根路径(相对projectPath)
	 */
	private String jspPath = "";

	/**
	 * create a ProjectBean
	 * 
	 * @param projectId
	 * @param projectName
	 * @param packageNameBase
	 * @param projectPath
	 * @param templetPath
	 * @param javaPath
	 * @param jspPath
	 */
	public ProjectBean(String projectId, String projectName, String basePackage, String projectPath,
			String templetPath, String javaPath, String jspPath) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.basePackage = basePackage;
		this.projectPath = projectPath;
		this.templetPath = templetPath;
		this.javaPath = javaPath;
		this.jspPath = jspPath;
	}

	public String getAbsoluteJavaPath() {
		return projectPath + File.separator + javaPath + File.separator
				+ getBasePackage().replace('.', File.separatorChar);
	}

	public String getAbsoluteJspPath() {
		return projectPath + File.separator + jspPath;
	}

	/**
	 * 得到sql文件输出绝对根路径
	 * 
	 * @return
	 */
	public String getSqlAbsolutePath() {
		return this.projectPath + File.separator + File.separator + "db";
	}

	// --------------------------------------
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectPath() {
		return projectPath;
	}

	public void setProjectPath(String projectPath) {
		this.projectPath = projectPath;
	}

	public String getTempletPath() {
		return templetPath;
	}

	public void setTempletPath(String templetPath) {
		this.templetPath = templetPath;
	}

	public String getBasePackage() {
		return basePackage;
	}

	public void setBasePackage(String basePackage) {
		this.basePackage = basePackage;
	}

	public String getJavaPath() {
		return javaPath;
	}

	public void setJavaPath(String javaPath) {
		this.javaPath = javaPath;
	}

	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}


	@Override
	public String toString() {
		return "ProjectBean [projectName=" + projectName + ", projectId=" + projectId + ", projectPath=" + projectPath
				+ ", templetPath=" + templetPath + ", basePackage=" + basePackage + ", javaPath=" + javaPath
				+ ", jspPath=" + jspPath + "]";
	}

}

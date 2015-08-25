package ${actionPackage};

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.config.ParentPackage;
import org.apache.struts2.config.Result;
import org.apache.struts2.config.Results;
import org.apache.struts2.dispatcher.ServletActionRedirectResult;
import org.springframework.beans.factory.annotation.Required;

import com.zoom.appcore.exception.ServiceException;
import com.zoom.appcore.orm.hibernate.Page;
import com.zoom.appcore.utils.CollectionUtils;
import com.zoom.appcore.web.struts2.CRUDActionSupport;

import ${entityPackage}.${entityClassname};
import ${servicePackage}.${serviceClassname};


/**
 * Action.
 * 
 * @see CRUDActionSupport
 * 
 * @author calvin
 */
@ParentPackage("default")
@Results( { @Result(name = CRUDActionSupport.RELOAD, value = "/${lcname}", type = ServletActionRedirectResult.class) })
public class ${ucname}Action extends CRUDActionSupport<${ucname}> {

	private ${serviceClassname} service;

	private Page<${ucname}> page = new Page<${ucname}>(5, true);//每页5项，自动查询计算总页数.

	private ${ucname} entity;

	private Long id;


	public ${ucname} getModel() {
		return entity;
	}

	public Page<${ucname}> getPage() {
		return page;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null) {
			entity = service.get${ucname}(id);
		} else {
			entity = new ${ucname}();
		}
	}

	@Override
	public String list() throws Exception {
		page = service.getAll${ucname}s(page);
		return SUCCESS;
	}

	@Override
	public String save() throws Exception {
		service.save${ucname}(entity);
		addActionMessage("保存成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			service.delete${ucname}(id);
			addActionMessage("删除成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage(e.getMessage());
		}
		return RELOAD;
	}

	/**
	 * 支持使用Jquery.validate Ajax检验用户名是否重复.
	 */
	public String checkLoginName() throws Exception {
		HttpServletRequest request = ServletActionContext.getRequest();
		String loginName = request.getParameter("loginName");
		String orgLoginName = request.getParameter("orgLoginName");

		//if (service.isLoginNameUnique(loginName, orgLoginName))
			//return renderText("true");
		//else
			return renderText("false");
	}

	@Required
	public void set${ucname}Service(${ucname}Service service) {
		this.service = service;
	}
}
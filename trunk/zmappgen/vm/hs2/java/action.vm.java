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

import ${entityPackage}.${uobjname};
import ${servicePackage}.${serviceClassname};


/**
 * Action.
 * 
 * @see CRUDActionSupport
 * 
 * @author calvin
 */
@ParentPackage("default")
@Results( { @Result(name = CRUDActionSupport.RELOAD, value = "/${lobjname}", type = ServletActionRedirectResult.class) })
public class ${uobjname}Action extends CRUDActionSupport<${uobjname}> {

	private ${serviceClassname} service;

	private Page<${uobjname}> page = new Page<${uobjname}>(5, true);//每页5项，自动查询计算总页数.

	private ${uobjname} entity;

	private Long id;


	public ${uobjname} getModel() {
		return entity;
	}

	public Page<${uobjname}> getPage() {
		return page;
	}


	public void setId(Long id) {
		this.id = id;
	}

	@Override
	protected void prepareModel() throws Exception {
		if (id != null) {
			entity = service.get${uobjname}(id);
		} else {
			entity = new ${uobjname}();
		}
	}

	@Override
	public String list() throws Exception {
		page = service.getAll${uobjname}s(page);
		return SUCCESS;
	}

	@Override
	public String filterQuery() throws Exception {
		entity.emptystringToNull();
		page = service.get${uobjname}sByExample(page,entity);		
		return SUCCESS;
	}

	@Override
	public String input() throws Exception {
		return INPUT;
	}

	@Override
	public String save() throws Exception {
		service.save${uobjname}(entity);
		addActionMessage("保存成功");
		return RELOAD;
	}

	@Override
	public String delete() throws Exception {
		try {
			service.delete${uobjname}(id);
			addActionMessage("删除成功");
		} catch (ServiceException e) {
			logger.error(e.getMessage(), e);
			addActionMessage(e.getMessage());
		}
		return RELOAD;
	}

	@Required
	public void set${uobjname}Service(${uobjname}Service service) {
		this.service = service;
	}
}
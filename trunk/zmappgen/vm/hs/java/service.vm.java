package ${servicePackage};

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zoom.appcore.exception.ServiceException;
import com.zoom.appcore.orm.hibernate.Page;
import com.zoom.appcore.orm.hibernate.SimpleHibernateTemplate;

import ${entityPackage}.${entityClassname};



@Service
@Transactional
public class ${entityClassname}Service {

	private SimpleHibernateTemplate<${entityClassname}, Long> ${oid}Dao;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		${oid}Dao = new SimpleHibernateTemplate<${entityClassname}, Long>(sessionFactory, ${entityClassname}.class);
	}

	@Transactional(readOnly = true)
	public ${entityClassname} get${entityClassname}(Long id) {
		return ${oid}Dao.get(id);
	}

	@Transactional(readOnly = true)
	public Page<${entityClassname}> getAll${entityClassname}s(Page<${entityClassname}> page) {
		return ${oid}Dao.findAll(page);
	}

	public void save${entityClassname}(${entityClassname} ${oid}) {
		${oid}Dao.save(${oid});
	}

	public void delete${entityClassname}(Long id) {
		${entityClassname} ${oid} = ${oid}Dao.get(id);
		${oid}Dao.delete(${oid});
	}
}
	





package ${servicePackage};

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zoom.appcore.exception.ServiceException;
import com.zoom.appcore.orm.hibernate.Page;
import com.zoom.appcore.orm.hibernate.SimpleHibernateTemplate;

import ${entityPackage}.${uobjname};


@Service
@Transactional
public class ${uobjname}Service {

	private SimpleHibernateTemplate<${uobjname}, Long> ${lobjname}Dao;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		${lobjname}Dao = new SimpleHibernateTemplate<${uobjname}, Long>(sessionFactory, ${uobjname}.class);
	}

	@Transactional(readOnly = true)
	public ${uobjname} get${uobjname}(Long id) {
		return ${lobjname}Dao.get(id);
	}

	@Transactional(readOnly = true)
	public Page<${uobjname}> getAll${uobjname}s(Page<${uobjname}> page) {
		return ${lobjname}Dao.findAll(page);
	}

	@Transactional(readOnly = true)
	public Page<${uobjname}> get${uobjname}sByExample(Page<${uobjname}> page, ${uobjname} ${lobjname}) {
		return ${lobjname}Dao.findByCriteria(page, Example.create(${lobjname}));
	}

	public void save${uobjname}(${uobjname} ${lobjname}) {
		${lobjname}Dao.save(${lobjname});
	}

	public void delete${uobjname}(Long id) {
		${uobjname} ${lobjname} = ${lobjname}Dao.get(id);
		${lobjname}Dao.delete(${lobjname});
	}
}
	


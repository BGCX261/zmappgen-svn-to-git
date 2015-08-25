package com.haode.appgen.table.service.metaData;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haode.appcore.orm.springjdbc.SimpleJdbcSupport;
import com.haode.appgen.entity.metaData.ObjectTable;

@Service
@Transactional
public class ObjectTableService extends SimpleJdbcSupport {

	private static String QUERY_ALL_SQL = "select ID,TABLE_NAME,OBJECT_NAME,TABLE_DESCRIPTION from ObjectTable";

	private static String QUERY_SQL = "select ID,TABLE_NAME,OBJECT_NAME,TABLE_DESCRIPTION from ObjectTable where   ID=? ";

	private static String INSERT_SQL = "insert into ObjectTable (ID,TABLE_NAME,OBJECT_NAME,TABLE_DESCRIPTION) values (  :id  , :tableName  , :objectName  , :tableDescription )";

	private static String DELETE_SQL = "delete from ObjectTable where   ID=? ";

	/**
	 * get all ObjectTable
	 */
	@Transactional(readOnly = true)
	public List<ObjectTable> getAllObjectTable() {
		return jdbcTemplate.query(QUERY_ALL_SQL,
				resultBeanMapper(ObjectTable.class));
	}

	/**
	 * get a ObjectTable
	 */
	@Transactional(readOnly = true)
	public ObjectTable getObjectTable(Long id) {
		return jdbcTemplate.queryForObject(QUERY_SQL,
				resultBeanMapper(ObjectTable.class), id);
	}

	/**
	 * create a ObjectTable
	 */
	public void createObjectTable(ObjectTable entity) {
		jdbcTemplate.update(INSERT_SQL, paramBeanMapper(entity));
	}

	/**
	 * delete a ObjectTable
	 */
	public void deleteObjectTable(Long id) {
		jdbcTemplate.update(DELETE_SQL, id);
	}
}

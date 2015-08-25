package com.haode.appgen.table.service.metaData;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haode.appcore.orm.springjdbc.SimpleJdbcSupport;
import com.haode.appgen.entity.metaData.EnumValue;

@Service
@Transactional
public class EnumValueService extends SimpleJdbcSupport {

	private static String QUERY_ALL_SQL = "select ID,ENKEY,ENVALUE,META_DATA_ID from EnumValue";

	private static String QUERY_SQL = "select ID,ENKEY,ENVALUE,META_DATA_ID from EnumValue where   ID=? ";

	private static String INSERT_SQL = "insert into EnumValue (ID,ENKEY,ENVALUE,META_DATA_ID) values (  :id  , :enkey  , :envalue  , :metaDataId )";

	private static String DELETE_SQL = "delete from EnumValue where   ID=? ";

	/**
	 * get all EnumValue
	 */
	@Transactional(readOnly = true)
	public List<EnumValue> getAllEnumValue() {
		return jdbcTemplate.query(QUERY_ALL_SQL,
				resultBeanMapper(EnumValue.class));
	}

	/**
	 * get a EnumValue
	 */
	@Transactional(readOnly = true)
	public EnumValue getEnumValue(Long id) {
		return jdbcTemplate.queryForObject(QUERY_SQL,
				resultBeanMapper(EnumValue.class), id);
	}

	/**
	 * create a EnumValue
	 */
	public void createEnumValue(EnumValue entity) {
		jdbcTemplate.update(INSERT_SQL, paramBeanMapper(entity));
	}

	/**
	 * delete a EnumValue
	 */
	public void deleteEnumValue(Long id) {
		jdbcTemplate.update(DELETE_SQL, id);
	}
}

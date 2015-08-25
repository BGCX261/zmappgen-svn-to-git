package com.haode.appgen.table.service.metaData;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.haode.appcore.orm.springjdbc.SimpleJdbcSupport;
import com.haode.appgen.entity.metaData.EnumValue;
import com.haode.appgen.entity.metaData.MetaData;

@Service
@Transactional
public class MetaDataService extends SimpleJdbcSupport {

	private static String QUERY_ALL_SQL = "select ID,DESCRIPTION,IS_PRIMARY_KEY,FIELD_NAME,FIELD_TYPE,ALLOW_NULL,JDBC_TYPE,ASSOCIATIONS_TABLE_ID,ASSOCIATIONS_TABLECOLUMN_ID,ATTRIBUTE_NAME,ATTRIBUTE_TYPE,VIEW_TYPE,MAX_LENGTH,VALIDATE_RULE,IS_REQUIRED,REMARK,OBJECT_TABLE_ID from MetaData";

	private static String QUERY_SQL = "select ID,DESCRIPTION,IS_PRIMARY_KEY,FIELD_NAME,FIELD_TYPE,ALLOW_NULL,JDBC_TYPE,ASSOCIATIONS_TABLE_ID,ASSOCIATIONS_TABLECOLUMN_ID,ATTRIBUTE_NAME,ATTRIBUTE_TYPE,VIEW_TYPE,MAX_LENGTH,VALIDATE_RULE,IS_REQUIRED,REMARK,OBJECT_TABLE_ID from MetaData where   ID=? ";

	private static String INSERT_SQL = "insert into MetaData (ID,DESCRIPTION,IS_PRIMARY_KEY,FIELD_NAME,FIELD_TYPE,ALLOW_NULL,JDBC_TYPE,ASSOCIATIONS_TABLE_ID,ASSOCIATIONS_TABLECOLUMN_ID,ATTRIBUTE_NAME,ATTRIBUTE_TYPE,VIEW_TYPE,MAX_LENGTH,VALIDATE_RULE,IS_REQUIRED,REMARK,OBJECT_TABLE_ID) values (  :id  , :description  , :isPrimaryKey  , :fieldName  , :fieldType  , :allowNull  , :jdbcType  , :associationsTableId  , :associationsTablecolumnId  , :attributeName  , :attributeType  , :viewType  , :maxLength  , :validateRule  , :isRequired  , :remark  , :objectTableId )";

	private static String DELETE_SQL = "delete from MetaData where   ID=? ";

	/**
	 * get all MetaData
	 */
	@Transactional(readOnly = true)
	public List<MetaData> getAllMetaData() {
		return jdbcTemplate.query(QUERY_ALL_SQL,
				resultBeanMapper(MetaData.class));
	}

	/**
	 * get a MetaData
	 */
	@Transactional(readOnly = true)
	public MetaData getMetaData(Long id) {
		return jdbcTemplate.queryForObject(QUERY_SQL,
				resultBeanMapper(MetaData.class), id);
	}

	/**
	 * create a MetaData
	 */
	public void createMetaData(MetaData entity) {
		jdbcTemplate.update(INSERT_SQL, paramBeanMapper(entity));
	}

	/**
	 * delete a MetaData
	 */
	public void deleteMetaData(Long id) {
		jdbcTemplate.update(DELETE_SQL, id);
	}
	
	private static String QUERY_BY_OBJECTTABLEID_SQL = "select ID,DESCRIPTION,IS_PRIMARY_KEY,FIELD_NAME,FIELD_TYPE,ALLOW_NULL,JDBC_TYPE,ASSOCIATIONS_TABLE_ID,ASSOCIATIONS_TABLECOLUMN_ID,ATTRIBUTE_NAME,ATTRIBUTE_TYPE,VIEW_TYPE,MAX_LENGTH,VALIDATE_RULE,IS_REQUIRED,REMARK,OBJECT_TABLE_ID " +
			" from MetaData"+
			" where OBJECT_TABLE_ID=?";
	
	private static String QUERY_BY_OBJECTTABLEID_SQL_2 = "select ID,ENKEY,ENVALUE,META_DATA_ID " +
			"from EnumValue" +
			" where META_DATA_ID=?";
	/**
	 * get all MetaData
	 */
	@Transactional(readOnly = true)
	public List<MetaData> getMetaDatasBy(Long objectTableId) {
		 List<MetaData> list= jdbcTemplate.query(QUERY_BY_OBJECTTABLEID_SQL,
				resultBeanMapper(MetaData.class),objectTableId);
		 for (MetaData metaData : list) {
			 List<EnumValue> enumValues= jdbcTemplate.query(QUERY_BY_OBJECTTABLEID_SQL_2,
						resultBeanMapper(EnumValue.class), metaData.getId());
			 metaData.setEnumValues(enumValues);
		}
		 
		 return list;
	}
}

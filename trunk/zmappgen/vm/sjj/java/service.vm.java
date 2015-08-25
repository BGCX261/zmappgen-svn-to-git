package ${servicePackage};

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.transaction.annotation.Transactional;

import com.haodechina.platform.mqconf.entity.MqconfServer;

import ${entityPackage}.${entityClassname};


@Service
@Transactional
public class ${serviceClassname} extends SimpleJdbcSupport {

	private static final String ALL_FEILD = " ${table.columnNameString} ";
##"select name,login_name,password from users"
    private static final String QUERY_ALL_SQL = "select "+ALL_FEILD+" from ${table.tableName}";

##"select name,login_name,password from users where login_name=?"
    private static final String QUERY_SQL = "select "+ALL_FEILD+" from ${table.tableName} where #foreach(${pk} in ${table.primaryKeys}) #if(!${foreach.first}) and #end${pk.columnName}=? #end";

##"insert into users (name,login_name,password) values(:name,:loginName,:password)"
    private static final String INSERT_SQL = "insert into ${table.tableName} ("+ALL_FEILD+") values (#foreach(${col} in ${table.columns})#if(!${foreach.first}) , #end:${col.attributeName}#end)";

    private static final String DELETE_SQL = "delete from ${table.tableName} where #foreach(${pk} in ${table.primaryKeys}) #if(!${foreach.first}) and #end${pk.columnName}=? #end";

    /**
    * get all ${entityClassname}
    */
    @Transactional(readOnly = true)
    public List<${entityClassname}> getAll${entityClassname}() {
        return jdbcTemplate.query(QUERY_ALL_SQL, resultBeanMapper(${entityClassname}.class));
    }

    /**
    * get a ${entityClassname}
    */
    @Transactional(readOnly = true)
    public ${entityClassname} get${entityClassname}(
#*----------------------------------*##foreach(${pk}in${table.primaryKeys})
#*------------------------------------*##if(!${foreach.first}) , #end 
#*------------------------------------*#${pk.attributeType} ${pk.attributeName}
#*----------------------------------*##end ) {
        return jdbcTemplate.queryForObject(QUERY_SQL, resultBeanMapper(${entityClassname}.class),
#*---------------------------------------*##foreach(${pk} in ${table.primaryKeys})
#*-----------------------------------------*##if(!${foreach.first}) , #end
#*-----------------------------------------*#${pk.attributeName}
#*---------------------------------------*##end );
    }

    /**
    * create a ${entityClassname}
    */
    public void create${entityClassname}(${entityClassname} entity) {
    	jdbcTemplate.update(INSERT_SQL, new BeanPropertySqlParameterSource(entity));
    }

    /**
    * delete a ${entityClassname}
    */
    public void delete${entityClassname}(
#*-------------------------------------*##foreach( ${pk} in ${table.primaryKeys} )
#*---------------------------------------*##if(!${foreach.first}) , #end
#*---------------------------------------*#${pk.attributeType} ${pk.attributeName}
#*-------------------------------------*##end ) {
    	jdbcTemplate.update(DELETE_SQL,
#*------------------------*##foreach( ${pk} in ${table.primaryKeys} )
#*--------------------------*##if(!${foreach.first}) , #end
#*--------------------------*#${pk.attributeName}
#*------------------------*##end);
    }
    ##end class
}


package com.haode.appgen.entity.metaData;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ObjectTable {

    // ID
    private Long id;
    
    // 表名
    private String tableName;
    
    // 对象名
    private String objectName;
    
    // 表描述
    private String tableDescription;
    
    
    private List<MetaData> metaDatas;
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	

    /**
     * get ID
     */    
    public Long getId() {
        return id;
    }

    /**
     * set ID
     */  
    public void setId(Long id) {
        this.id=id;
    }
    /**
     * get 表名
     */    
    public String getTableName() {
        return tableName;
    }

    /**
     * set 表名
     */  
    public void setTableName(String tableName) {
        this.tableName=tableName;
    }
    /**
     * get 对象名
     */    
    public String getObjectName() {
        return objectName;
    }

    /**
     * set 对象名
     */  
    public void setObjectName(String objectName) {
        this.objectName=objectName;
    }
    /**
     * get 表描述
     */    
    public String getTableDescription() {
        return tableDescription;
    }

    /**
     * set 表描述
     */  
    public void setTableDescription(String tableDescription) {
        this.tableDescription=tableDescription;
    }

	public List<MetaData> getMetaDatas() {
		return metaDatas;
	}

	public void setMetaDatas(List<MetaData> metaDatas) {
		this.metaDatas = metaDatas;
	}

}
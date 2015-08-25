
package com.haode.appgen.entity.metaData;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ObjectTable {

    // ID
    private Long id;
    
    // ����
    private String tableName;
    
    // ������
    private String objectName;
    
    // ������
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
     * get ����
     */    
    public String getTableName() {
        return tableName;
    }

    /**
     * set ����
     */  
    public void setTableName(String tableName) {
        this.tableName=tableName;
    }
    /**
     * get ������
     */    
    public String getObjectName() {
        return objectName;
    }

    /**
     * set ������
     */  
    public void setObjectName(String objectName) {
        this.objectName=objectName;
    }
    /**
     * get ������
     */    
    public String getTableDescription() {
        return tableDescription;
    }

    /**
     * set ������
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
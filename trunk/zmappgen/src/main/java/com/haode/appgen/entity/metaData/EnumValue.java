
package com.haode.appgen.entity.metaData;

import org.apache.commons.lang.builder.ToStringBuilder;

public class EnumValue {

    // ID
    private Long id;
    
    // 键
    private String enkey;
    
    // 值
    private String envalue;
    
    // 元数据id
    private Long metaDataId;
    
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
     * get 键
     */    
    public String getEnkey() {
        return enkey;
    }

    /**
     * set 键
     */  
    public void setEnkey(String enkey) {
        this.enkey=enkey;
    }
    /**
     * get 值
     */    
    public String getEnvalue() {
        return envalue;
    }

    /**
     * set 值
     */  
    public void setEnvalue(String envalue) {
        this.envalue=envalue;
    }
    /**
     * get 元数据id
     */    
    public Long getMetaDataId() {
        return metaDataId;
    }

    /**
     * set 元数据id
     */  
    public void setMetaDataId(Long metaDataId) {
        this.metaDataId=metaDataId;
    }

}
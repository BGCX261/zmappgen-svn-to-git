
package com.haode.appgen.entity.metaData;

import org.apache.commons.lang.builder.ToStringBuilder;

public class EnumValue {

    // ID
    private Long id;
    
    // ��
    private String enkey;
    
    // ֵ
    private String envalue;
    
    // Ԫ����id
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
     * get ��
     */    
    public String getEnkey() {
        return enkey;
    }

    /**
     * set ��
     */  
    public void setEnkey(String enkey) {
        this.enkey=enkey;
    }
    /**
     * get ֵ
     */    
    public String getEnvalue() {
        return envalue;
    }

    /**
     * set ֵ
     */  
    public void setEnvalue(String envalue) {
        this.envalue=envalue;
    }
    /**
     * get Ԫ����id
     */    
    public Long getMetaDataId() {
        return metaDataId;
    }

    /**
     * set Ԫ����id
     */  
    public void setMetaDataId(Long metaDataId) {
        this.metaDataId=metaDataId;
    }

}

package com.haode.appgen.entity.metaData;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MetaData {

    // id
    private Long id;
    
    // 描述
    private String description;
    
    // 是否主键
    private String isPrimaryKey;
    
    // 字段名
    private String fieldName;
    
    // 字段类型
    private String fieldType;
    
    // 允许为空
    private String allowNull;
    
    // jdbc类型
    private String jdbcType;
    
    // 外键，关联表
    private Long associationsTableId;
    
    // 外键，关联字段
    private Long associationsTablecolumnId;
    
    // 属性名
    private String attributeName;
    
    // 属性类型
    private String attributeType;
    
    // 页面展现类型
    private String viewType;
    
    // 最大输入长度
    private Integer maxLength;
    
    // 验证规则
    private String validateRule;
    
    // 是否必填
    private String isRequired;
    
    // 备注
    private String remark;
    
    // 对象id
    private Long objectTableId;
    

    private List<EnumValue> enumValues;
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
    /**
     * get 首字母大写属性名
     */    
    public String getCapitalizeAttributeName() {
        return StringUtils.capitalize(attributeName);
    }
    
    //------------------------------------ 
    /**
     * get id
     */    
    public Long getId() {
        return id;
    }

    /**
     * set id
     */  
    public void setId(Long id) {
        this.id=id;
    }
    /**
     * get 描述
     */    
    public String getDescription() {
        return description;
    }

    /**
     * set 描述
     */  
    public void setDescription(String description) {
        this.description=description;
    }
    /**
     * get 是否主键
     */    
    public String getIsPrimaryKey() {
        return isPrimaryKey;
    }

    /**
     * set 是否主键
     */  
    public void setIsPrimaryKey(String isPrimaryKey) {
        this.isPrimaryKey=isPrimaryKey;
    }
    /**
     * get 字段名
     */    
    public String getFieldName() {
        return fieldName;
    }

    /**
     * set 字段名
     */  
    public void setFieldName(String fieldName) {
        this.fieldName=fieldName;
    }
    /**
     * get 字段类型
     */    
    public String getFieldType() {
        return fieldType;
    }

    /**
     * set 字段类型
     */  
    public void setFieldType(String fieldType) {
        this.fieldType=fieldType;
    }
    /**
     * get 允许为空
     */    
    public String getAllowNull() {
        return allowNull;
    }

    /**
     * set 允许为空
     */  
    public void setAllowNull(String allowNull) {
        this.allowNull=allowNull;
    }
    /**
     * get jdbc类型
     */    
    public String getJdbcType() {
        return jdbcType;
    }

    /**
     * set jdbc类型
     */  
    public void setJdbcType(String jdbcType) {
        this.jdbcType=jdbcType;
    }
    /**
     * get 外键，关联表
     */    
    public Long getAssociationsTableId() {
        return associationsTableId;
    }

    /**
     * set 外键，关联表
     */  
    public void setAssociationsTableId(Long associationsTableId) {
        this.associationsTableId=associationsTableId;
    }
    /**
     * get 外键，关联字段
     */    
    public Long getAssociationsTablecolumnId() {
        return associationsTablecolumnId;
    }

    /**
     * set 外键，关联字段
     */  
    public void setAssociationsTablecolumnId(Long associationsTablecolumnId) {
        this.associationsTablecolumnId=associationsTablecolumnId;
    }
    /**
     * get 属性名
     */    
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * set 属性名
     */  
    public void setAttributeName(String attributeName) {
        this.attributeName=attributeName;
    }
    /**
     * get 属性类型
     */    
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * set 属性类型
     */  
    public void setAttributeType(String attributeType) {
        this.attributeType=attributeType;
    }
    /**
     * get 页面展现类型
     */    
    public String getViewType() {
        return viewType;
    }

    /**
     * set 页面展现类型
     */  
    public void setViewType(String viewType) {
        this.viewType=viewType;
    }
    /**
     * get 最大输入长度
     */    
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * set 最大输入长度
     */  
    public void setMaxLength(Integer maxLength) {
        this.maxLength=maxLength;
    }
    /**
     * get 验证规则
     */    
    public String getValidateRule() {
        return validateRule;
    }

    /**
     * set 验证规则
     */  
    public void setValidateRule(String validateRule) {
        this.validateRule=validateRule;
    }
    /**
     * get 是否必填
     */    
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * set 是否必填
     */  
    public void setIsRequired(String isRequired) {
        this.isRequired=isRequired;
    }
    /**
     * get 备注
     */    
    public String getRemark() {
        return remark;
    }

    /**
     * set 备注
     */  
    public void setRemark(String remark) {
        this.remark=remark;
    }
    /**
     * get 对象id
     */    
    public Long getObjectTableId() {
        return objectTableId;
    }

    /**
     * set 对象id
     */  
    public void setObjectTableId(Long objectTableId) {
        this.objectTableId=objectTableId;
    }

	public List<EnumValue> getEnumValues() {
		return enumValues;
	}

	public void setEnumValues(List<EnumValue> enumValues) {
		this.enumValues = enumValues;
	}

}
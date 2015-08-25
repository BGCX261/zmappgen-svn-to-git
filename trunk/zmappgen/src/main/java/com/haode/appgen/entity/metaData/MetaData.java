
package com.haode.appgen.entity.metaData;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.builder.ToStringBuilder;

public class MetaData {

    // id
    private Long id;
    
    // ����
    private String description;
    
    // �Ƿ�����
    private String isPrimaryKey;
    
    // �ֶ���
    private String fieldName;
    
    // �ֶ�����
    private String fieldType;
    
    // ����Ϊ��
    private String allowNull;
    
    // jdbc����
    private String jdbcType;
    
    // �����������
    private Long associationsTableId;
    
    // ����������ֶ�
    private Long associationsTablecolumnId;
    
    // ������
    private String attributeName;
    
    // ��������
    private String attributeType;
    
    // ҳ��չ������
    private String viewType;
    
    // ������볤��
    private Integer maxLength;
    
    // ��֤����
    private String validateRule;
    
    // �Ƿ����
    private String isRequired;
    
    // ��ע
    private String remark;
    
    // ����id
    private Long objectTableId;
    

    private List<EnumValue> enumValues;
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
    /**
     * get ����ĸ��д������
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
     * get ����
     */    
    public String getDescription() {
        return description;
    }

    /**
     * set ����
     */  
    public void setDescription(String description) {
        this.description=description;
    }
    /**
     * get �Ƿ�����
     */    
    public String getIsPrimaryKey() {
        return isPrimaryKey;
    }

    /**
     * set �Ƿ�����
     */  
    public void setIsPrimaryKey(String isPrimaryKey) {
        this.isPrimaryKey=isPrimaryKey;
    }
    /**
     * get �ֶ���
     */    
    public String getFieldName() {
        return fieldName;
    }

    /**
     * set �ֶ���
     */  
    public void setFieldName(String fieldName) {
        this.fieldName=fieldName;
    }
    /**
     * get �ֶ�����
     */    
    public String getFieldType() {
        return fieldType;
    }

    /**
     * set �ֶ�����
     */  
    public void setFieldType(String fieldType) {
        this.fieldType=fieldType;
    }
    /**
     * get ����Ϊ��
     */    
    public String getAllowNull() {
        return allowNull;
    }

    /**
     * set ����Ϊ��
     */  
    public void setAllowNull(String allowNull) {
        this.allowNull=allowNull;
    }
    /**
     * get jdbc����
     */    
    public String getJdbcType() {
        return jdbcType;
    }

    /**
     * set jdbc����
     */  
    public void setJdbcType(String jdbcType) {
        this.jdbcType=jdbcType;
    }
    /**
     * get �����������
     */    
    public Long getAssociationsTableId() {
        return associationsTableId;
    }

    /**
     * set �����������
     */  
    public void setAssociationsTableId(Long associationsTableId) {
        this.associationsTableId=associationsTableId;
    }
    /**
     * get ����������ֶ�
     */    
    public Long getAssociationsTablecolumnId() {
        return associationsTablecolumnId;
    }

    /**
     * set ����������ֶ�
     */  
    public void setAssociationsTablecolumnId(Long associationsTablecolumnId) {
        this.associationsTablecolumnId=associationsTablecolumnId;
    }
    /**
     * get ������
     */    
    public String getAttributeName() {
        return attributeName;
    }

    /**
     * set ������
     */  
    public void setAttributeName(String attributeName) {
        this.attributeName=attributeName;
    }
    /**
     * get ��������
     */    
    public String getAttributeType() {
        return attributeType;
    }

    /**
     * set ��������
     */  
    public void setAttributeType(String attributeType) {
        this.attributeType=attributeType;
    }
    /**
     * get ҳ��չ������
     */    
    public String getViewType() {
        return viewType;
    }

    /**
     * set ҳ��չ������
     */  
    public void setViewType(String viewType) {
        this.viewType=viewType;
    }
    /**
     * get ������볤��
     */    
    public Integer getMaxLength() {
        return maxLength;
    }

    /**
     * set ������볤��
     */  
    public void setMaxLength(Integer maxLength) {
        this.maxLength=maxLength;
    }
    /**
     * get ��֤����
     */    
    public String getValidateRule() {
        return validateRule;
    }

    /**
     * set ��֤����
     */  
    public void setValidateRule(String validateRule) {
        this.validateRule=validateRule;
    }
    /**
     * get �Ƿ����
     */    
    public String getIsRequired() {
        return isRequired;
    }

    /**
     * set �Ƿ����
     */  
    public void setIsRequired(String isRequired) {
        this.isRequired=isRequired;
    }
    /**
     * get ��ע
     */    
    public String getRemark() {
        return remark;
    }

    /**
     * set ��ע
     */  
    public void setRemark(String remark) {
        this.remark=remark;
    }
    /**
     * get ����id
     */    
    public Long getObjectTableId() {
        return objectTableId;
    }

    /**
     * set ����id
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
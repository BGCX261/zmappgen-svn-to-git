--

CREATE TABLE enumvalue ( 
    ID          	int(11) AUTO_INCREMENT NOT NULL,
    ENKEY       	varchar(200) NOT NULL,
    ENVALUE     	varchar(200) NOT NULL,
    META_DATA_ID	int(11) NOT NULL,
    PRIMARY KEY(ID)
)

CREATE TABLE metadata ( 
    ID                         	int(11) AUTO_INCREMENT NOT NULL,
    DESCRIPTION                	varchar(200) NOT NULL,
    IS_PRIMARY_KEY             	char(1) NOT NULL,
    FIELD_NAME                 	varchar(50) NOT NULL,
    FIELD_TYPE                 	varchar(50) NOT NULL,
    ALLOW_NULL                 	char(1) NOT NULL,
    JDBC_TYPE                  	varchar(50) NOT NULL,
    ASSOCIATIONS_TABLE_ID      	int(11) NULL,
    ASSOCIATIONS_TABLECOLUMN_ID	int(11) NULL,
    ATTRIBUTE_NAME             	varchar(50) NOT NULL,
    ATTRIBUTE_TYPE             	varchar(50) NOT NULL,
    VIEW_TYPE                  	varchar(50) NOT NULL,
    MAX_LENGTH                 	int(11) NOT NULL,
    VALIDATE_RULE              	varchar(200) NULL,
    IS_REQUIRED                	char(1) NOT NULL,
    REMARK                     	varchar(200) NULL,
    OBJECT_TABLE_ID            	int(11) NOT NULL,
    PRIMARY KEY(ID)
)

--
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('id', 'Y', 'ID', 'INT(11)', 'N', 'INTEGER', NULL, NULL, 'id', 'Long', 'textfield', 10, '', 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('description', 'N', 'DESCRIPTION', 'VARCHAR(200)', 'N', 'VARCHAR', NULL, NULL, 'description', 'String', 'textfield', 200, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('isPrimaryKey', 'N', 'IS_PRIMARY_KEY', 'CHAR(1)', 'N', 'VARCHAR', NULL, NULL, 'isPrimaryKey', 'String', 'textfield', 1, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('fieldName', 'N', 'FIELD_NAME', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'fieldName', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('fieldType', 'N', 'FIELD_TYPE', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'fieldType', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('allowNull', 'N', 'ALLOW_NULL', 'CHAR(1)', 'N', 'VARCHAR', NULL, NULL, 'allowNull', 'String', 'textfield', 1, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('jdbcType', 'N', 'JDBC_TYPE', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'jdbcType', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('associationsTableId', 'N', 'ASSOCIATIONS_TABLE_ID', 'INT(11)', 'Y', 'INTEGER', NULL, NULL, 'associationsTableId', 'Integer', 'textfield', 200, NULL, 'N', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('associationsTablecolumnId', 'N', 'ASSOCIATIONS_TABLECOLUMN_ID', 'INT(11)', 'Y', 'INTEGER', NULL, NULL, 'associationsTablecolumnId', 'Integer', 'textfield', 200, NULL, 'N', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('attributeName', 'N', 'ATTRIBUTE_NAME', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'attributeName', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('attributeType', 'N', 'ATTRIBUTE_TYPE', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'attributeType', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('viewType', 'N', 'VIEW_TYPE', 'VARCHAR(50)', 'N', 'VARCHAR', NULL, NULL, 'viewType', 'String', 'textfield', 50, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('maxLength', 'N', 'MAX_LENGTH', 'INT(11)', 'N', 'INTEGER', NULL, NULL, 'maxLength', 'Integer', 'textfield', 200, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('validateRule', 'N', 'VALIDATE_RULE', 'VARCHAR(200)', 'Y', 'VARCHAR', NULL, NULL, 'validateRule', 'String', 'textfield', 200, NULL, 'N', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('isRequired', 'N', 'IS_REQUIRED', 'CHAR(1)', 'N', 'VARCHAR', NULL, NULL, 'isRequired', 'Integer', 'textfield', 1, NULL, 'Y', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('remark', 'N', 'REMARK', 'VARCHAR(200)', 'Y', 'VARCHAR', NULL, NULL, 'remark', 'String', 'textfield', 200, NULL, 'N', NULL, 3)
GO
INSERT INTO `test`.`metadata`(`DESCRIPTION`, `IS_PRIMARY_KEY`, `FIELD_NAME`, `FIELD_TYPE`, `ALLOW_NULL`, `JDBC_TYPE`, `ASSOCIATIONS_TABLE_ID`, `ASSOCIATIONS_TABLECOLUMN_ID`, `ATTRIBUTE_NAME`, `ATTRIBUTE_TYPE`, `VIEW_TYPE`, `MAX_LENGTH`, `VALIDATE_RULE`, `IS_REQUIRED`, `REMARK`, `OBJECT_TABLE_ID`)
VALUES('objectTableId', 'N', 'OBJECT_TABLE_ID', 'INT(11)', 'N', 'INTEGER', NULL, NULL, 'objectTableId', 'Integer', 'textfield', 200, NULL, 'Y', NULL, 3)
GO


CREATE TABLE objecttable ( 
    ID               	int(11) AUTO_INCREMENT NOT NULL,
    TABLE_NAME       	varchar(100) NOT NULL,
    OBJECT_NAME      	varchar(100) NOT NULL,
    TABLE_DESCRIPTION	varchar(200) NULL,
    PRIMARY KEY(ID)
)

INSERT INTO `test`.`objecttable`(ID`,`TABLE_NAME`, `OBJECT_NAME`, `TABLE_DESCRIPTION`)
VALUES(3, 'ZMAPPGEN', 'Zmappgen', 'zmappgen')
GO
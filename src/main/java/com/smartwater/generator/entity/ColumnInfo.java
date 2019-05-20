package com.smartwater.generator.entity;

import com.smartwater.generator.utils.StringUtil;

import java.io.Serializable;

/**
 *表对象列属性信息
 * 主要是用来生成mapper使用 根据需要自行扩展
 */
public class ColumnInfo implements Serializable {
    private String columnName; // 列名
    private int type; // 列的数据类型代码
    private String propertyName; // 属性名
    private boolean isPrimaryKey; // 是否主键

    private String columnTypeName;//列的数据类型名称 对应mapper文件jdbcType属性
    private String comment;//数据库备注信息

    public ColumnInfo() {

    }

    public ColumnInfo(String columnName, int type,
                      boolean isPrimaryKey,String columnTypeName,String comment) {
        this.columnName = columnName;
        this.type = type;
        this.propertyName = StringUtil.columnName2PropertyName(columnName);
        this.isPrimaryKey = isPrimaryKey;
        this.columnTypeName = columnTypeName;
        this.comment = comment;

    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public boolean isPrimaryKey() {
        return isPrimaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        isPrimaryKey = primaryKey;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}

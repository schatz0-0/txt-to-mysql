package com.lin.db;

/**
 * 表-字段信息
 */
public class Column {
    /** 列名 */
    private String columnName;
    /** 列的数据类型名 */
    private String columnTypeName;
    /** 对应数据类型的类 */
    private String columnClassName;
    /** 在数据库中类型的最大字符个数 */
    private Integer columnDisplaySize;
    /** 某列类型的精确度(类型的长度) */
    private Integer precision;
    /** 小数点后的位数 */
    private Integer scale;
    /** 获取某列对应的表名 */
    private String tableName;
    /** 是否自动递增 */
    private Boolean autoInctement;
    /** 是否允许为空 */
    private Integer nullable;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnTypeName() {
        return columnTypeName;
    }

    public void setColumnTypeName(String columnTypeName) {
        this.columnTypeName = columnTypeName;
    }

    public String getColumnClassName() {
        return columnClassName;
    }

    public void setColumnClassName(String columnClassName) {
        this.columnClassName = columnClassName;
    }

    public Integer getColumnDisplaySize() {
        return columnDisplaySize;
    }

    public void setColumnDisplaySize(Integer columnDisplaySize) {
        this.columnDisplaySize = columnDisplaySize;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Boolean getAutoInctement() {
        return autoInctement;
    }

    public void setAutoInctement(Boolean autoInctement) {
        this.autoInctement = autoInctement;
    }

    public Integer getNullable() {
        return nullable;
    }

    public void setNullable(Integer nullable) {
        this.nullable = nullable;
    }
}

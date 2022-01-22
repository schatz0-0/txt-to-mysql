package com.lin.db;

import java.util.List;

/**
 * 表信息
 */
public class Table {

    /** 表名 */
    private String tableName;
    /** 数据库 */
    private String databaseName;
    /** 表字段名 */
    private List<Column> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }
}

package com.lin.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库-表字段
 */
public class DbTableInfo {

    /** 数据库链接 */
    private Connection connection;
    /** 数据库 */
    private String schemaPattern;
    /** 数据库-表 */
    private static Map<String, Table> tablesMap = new HashMap<>(8);


    public DbTableInfo(Connection connection, String schemaPattern) {
        this.connection = connection;
        this.schemaPattern = schemaPattern;
    }

    /**
     * 获取所有表信息
     * @return 所有表信息
     */
    public static Map<String, Table> getTablesMap() {
        return tablesMap;
    }

    /**
     * 获取表信息
     * @param tableName 表名
     * @return 表信息
     */
    public static Table getTable(String tableName) {
        return tablesMap.get(tableName);
    }

    public String getSchemaPattern() {
        return schemaPattern;
    }

    /**
     * 获取数据库中所有表信息
     * @throws SQLException
     */
    public void buildTables() throws SQLException {
        DatabaseMetaData dbMetaData = connection.getMetaData();
        ResultSet rs = dbMetaData.getTables(null, schemaPattern, null, new String[] { "TABLE" });
        while (rs.next()) {
            String dbName = rs.getString("TABLE_CAT");
            if (!dbName.equals(schemaPattern)) {
                continue;
            }

            String tableName = rs.getString("TABLE_NAME");
            Table table = new Table();
            table.setTableName(tableName);
            table.setDatabaseName(dbName);
            table.setColumns(getTableColumnList(tableName));
            tablesMap.put(tableName, table);
        }
    }

    /**
     *  获取某表的所有column信息
     * @param tableName 表名
     * @return column信息
     * @throws SQLException
     */
    private List<Column> getTableColumnList(String tableName) throws SQLException {
        List<Column> columnList = new ArrayList<>();
        String sql = "SELECT * FROM " + tableName + " LIMIT 1;";
        PreparedStatement stmt;
        try  {
            stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            ResultSetMetaData data = rs.getMetaData();
            for  (int i = 1; i <= data.getColumnCount(); i++)  {
                Column column = new Column();
                // 获得指定列的列名
                String columnName = data.getColumnName(i);
                // 获得指定列的数据类型名
                String columnTypeName = data.getColumnTypeName(i);
                // 对应数据类型的类
                String columnClassName = data.getColumnClassName(i);
                // 在数据库中类型的最大字符个数
                int columnDisplaySize = data.getColumnDisplaySize(i);
                // 某列类型的精确度(类型的长度)
                int precision = data.getPrecision(i);
                // 小数点后的位数
                int scale = data.getScale(i);
                // 是否自动递增
                // 排除自动递增的字段名 TODO，例如： id
                boolean isAutoInctement = data.isAutoIncrement(i);
                if (isAutoInctement) {
                    continue;
                }
                // 是否为空
                int isNullable = data.isNullable(i);
                column.setColumnName(columnName);
                column.setColumnTypeName(columnTypeName);
                column.setColumnClassName(columnClassName);
                column.setTableName(tableName);
                column.setColumnDisplaySize(columnDisplaySize);
                column.setPrecision(precision);
                column.setScale(scale);
                column.setAutoInctement(isAutoInctement);
                column.setNullable(isNullable);
                columnList.add(column);
            }
        } catch  (SQLException  e)  {
            e.printStackTrace();
        }
        return columnList;
    }

}

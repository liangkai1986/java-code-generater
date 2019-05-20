package com.smartwater.generator.db;


import com.smartwater.generator.entity.ColumnInfo;
import com.smartwater.generator.utils.ConfigUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据库连接工具类 主要是用来连接数据库以及获取数据库表的一些信息
 */
public class ConnectionUtil {
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;

    /**
     * 初始化数据库连接
     *
     * @return
     */
    public boolean initConnection() {
        try {
            Class.forName(DriverFactory.getDriver(ConfigUtil.getConfiguration().getDb().getUrl()));
            String url = ConfigUtil.getConfiguration().getDb().getUrl();
            String username = ConfigUtil.getConfiguration().getDb().getUsername();
            String password = ConfigUtil.getConfiguration().getDb().getPassword();
            connection = DriverManager.getConnection(url, username, password);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 获取表结构数据
     * @param tableName 表名
     * @return 包含表结构数据的列表
     */
    public List<ColumnInfo> getMetaData(String tableName) throws SQLException {
        ResultSet tempResultSet = connection.getMetaData().getPrimaryKeys(null, null, tableName);
        String primaryKey = null;
        if (tempResultSet.next()) {
            primaryKey = tempResultSet.getObject(4).toString();
        }
        //获取表的字段注释信息
        Map<String,String> commentMap = new HashMap<>();
        String commentSql = "SHOW FULL COLUMNS FROM " + tableName;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(commentSql);
        System.out.println("-------开始获取表"+tableName+"的信息-------");
        while (resultSet.next()){
            System.out.println("字段属性 : " + resultSet.getString("Field") +"  备注信息 : " + resultSet.getString("Comment"));
            commentMap.put(resultSet.getString("Field").toUpperCase(),resultSet.getString("Comment"));
        }
        System.out.println("---------------End--------------------");
        List<ColumnInfo> columnInfos = new ArrayList<>();
        statement = connection.createStatement();
        String sql = "SELECT * FROM " + tableName + " WHERE 1 != 1";
        resultSet = statement.executeQuery(sql);
        ResultSetMetaData metaData = resultSet.getMetaData();
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            ColumnInfo info;
            if (metaData.getColumnName(i).equals(primaryKey)) {
                info = new ColumnInfo(metaData.getColumnName(i), metaData.getColumnType(i),
                        true, metaData.getColumnTypeName(i),getFieldComment(metaData.getColumnName(i),commentMap));
            } else {
                info = new ColumnInfo(metaData.getColumnName(i), metaData.getColumnType(i),
                        false,metaData.getColumnTypeName(i),getFieldComment(metaData.getColumnName(i),commentMap));
            }
            columnInfos.add(info);
        }
        statement.close();
        resultSet.close();
        return columnInfos;
    }


    /***
     *  返回字段的备注信息
     * @param columnName
     * @param commentMap
     * @return
     */
    public String getFieldComment(String columnName,Map<String,String> commentMap) {
        if(commentMap.get(columnName.toUpperCase())!=null){
            return commentMap.get(columnName.toUpperCase());
        }else {
            return columnName;
        }

    }
    //其他数据库不需要这个方法 oracle和db2需要
//    private static String getSchema(Connection conn) throws Exception {
//        String schema;
//        schema = conn.getMetaData().getUserName();
//        if ((schema == null) || (schema.length() == 0)) {
//            throw new Exception("ORACLE数据库模式不允许为空");
//        }
//        return schema.toUpperCase().toString();
//
//    }

    public void close() {
        try {
            if (!connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package com.smartwater.generator.db;

/**
 * 数据库初始化工具类
 * 支持Mysql Oracle SqlServer
 */
public class DriverFactory {
    private final static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";
    private final static String DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
    private final static String DRIVER_SQLSERVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final static String DRIVER_MARIADB = "org.mariadb.jdbc.Driver";

    public static String getDriver(String url) {
        if (url.contains("mysql")) {
            return DRIVER_MYSQL;
        }
        if (url.contains("oracle")) {
            return DRIVER_ORACLE;
        }
        if (url.contains("sqlserver")) {
            return DRIVER_SQLSERVER;
        }
        if (url.contains("mariadb")) {
            return DRIVER_MARIADB;
        }
        return null;
    }

}

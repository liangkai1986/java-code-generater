package com.smartwater.generator.utils;

import java.sql.Types;

/**
 *
 */
public class TypeUtil {

    /**
     * 将数据库数据类型转换为Java基本数据类型
     *
     * @param sqlType
     * @return
     */
    public static String parseTypeFormSqlType(int sqlType) {
        StringBuilder sb = new StringBuilder();
        switch (sqlType) {
            case Types.BIT:
            case Types.BOOLEAN:
                sb.append("boolean");
                break;
            case Types.TINYINT:
                sb.append("byte");
                break;
            case Types.SMALLINT:
                sb.append("short");
                break;
            case Types.INTEGER:
                sb.append("int");
                break;
            case Types.BIGINT:
                sb.append("long");
                break;
            case Types.REAL:
                sb.append("float");
                break;
            case Types.FLOAT:
            case Types.DOUBLE:
                sb.append("double");
                break;
            case Types.DECIMAL:
            case Types.NUMERIC:
                sb.append("BigDecimal");
                break;
            case Types.VARCHAR:
            case Types.CHAR:
            case Types.NCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
                sb.append("String");
                break;
            case Types.DATE:
                sb.append("Date");
                break;
            case Types.TIME:
                sb.append("Time");
                break;
            case Types.TIMESTAMP:
                sb.append("Timestamp");
                break;
            case Types.NCLOB:
            case Types.CLOB:
            case Types.BLOB:
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                sb.append("byte[]");
                break;
            case Types.NULL:
            case Types.OTHER:
            case Types.JAVA_OBJECT:
                sb.append("Object");
                break;
            default:
                sb.append("Object");

        }
        return sb.toString();
    }


    /**
     * 将数据库数据类型转换为Java包装类数据类型
     *
     * @param sqlType
     * @return
     */
    public static String parseWrapperClassFormSqlType(int sqlType) {
        StringBuilder sb = new StringBuilder();
        switch (sqlType) {
            case Types.BIT:
            case Types.BOOLEAN:
                sb.append("Boolean");
                break;
            case Types.TINYINT:
                sb.append("Byte");
                break;
            case Types.SMALLINT:
                sb.append("Short");
                break;
            case Types.INTEGER:
                sb.append("Integer");
                break;
            case Types.BIGINT:
                sb.append("Long");
                break;
            case Types.REAL:
                sb.append("Float");
                break;
            case Types.FLOAT:
            case Types.DOUBLE:
                sb.append("Double");
                break;
            case Types.DECIMAL:
            case Types.NUMERIC:
                sb.append("BigDecimal");
                break;
            case Types.VARCHAR:
            case Types.CHAR:
            case Types.NCHAR:
            case Types.NVARCHAR:
            case Types.LONGVARCHAR:
            case Types.LONGNVARCHAR:
                sb.append("String");
                break;
            case Types.DATE:
                sb.append("Date");
                break;
            case Types.TIME:
                sb.append("Time");
                break;
            case Types.TIMESTAMP:
                sb.append("Timestamp");
                break;
            case Types.NCLOB:
            case Types.CLOB:
            case Types.BLOB:
            case Types.BINARY:
            case Types.VARBINARY:
            case Types.LONGVARBINARY:
                sb.append("Byte[]");
                break;
            case Types.NULL:
            case Types.OTHER:
            case Types.JAVA_OBJECT:
                sb.append("Object");
                break;
            default:
                sb.append("Object");

        }
        return sb.toString();
    }


    /**
     * 将数据库数据类型转换为Java包装类数据类型
     *
     * @param sqlType
     * @return
     */
    public static String parseJdbcTypeFormSqlType(int sqlType) {
        StringBuilder sb = new StringBuilder();
        switch (sqlType) {
            case Types.BIT:
                sb.append("BIT");
                break;
            case Types.BOOLEAN:
                sb.append("BOOLEAN");
                break;
            case Types.TINYINT:
                sb.append("TINYINT");
                break;
            case Types.SMALLINT:
                sb.append("SMALLINT");
                break;
            case Types.INTEGER:
                sb.append("INTEGER");
                break;
            case Types.BIGINT:
                sb.append("BIGINT");
                break;
            case Types.REAL:
                sb.append("REAL");
                break;
            case Types.FLOAT:
                sb.append("FLOAT");
                break;
            case Types.DOUBLE:
                sb.append("DOUBLE");
                break;
            case Types.DECIMAL:
                sb.append("DECIMAL");
                break;
            case Types.NUMERIC:
                sb.append("NUMERIC");
                break;
            case Types.VARCHAR:
                sb.append("VARCHAR");
                break;
            case Types.CHAR:
                sb.append("CHAR");
                break;
            case Types.NCHAR:
                sb.append("NCHAR");
                break;
            case Types.NVARCHAR:
                sb.append("NVARCHAR");
                break;
            case Types.LONGVARCHAR:
                sb.append("LONGVARCHAR");
                break;
            case Types.LONGNVARCHAR:
                sb.append("LONGNVARCHAR");
                break;
            case Types.DATE:
                sb.append("DATE");
                break;
            case Types.TIME:
                sb.append("TIME");
                break;
            case Types.TIMESTAMP:
                sb.append("TIMESTAMP");
                break;
            case Types.NCLOB:
                sb.append("NCLOB");
                break;
            case Types.CLOB:
                sb.append("CLOB");
                break;
            case Types.BLOB:
                sb.append("BLOB");
                break;
            case Types.BINARY:
                sb.append("BINARY");
                break;
            case Types.VARBINARY:
                sb.append("VARBINARY");
                break;
            case Types.LONGVARBINARY:
                sb.append("LONGVARBINARY");
                break;
            case Types.NULL:
                sb.append("NULL");
                break;
            case Types.OTHER:
                sb.append("OTHER");
                break;
            case Types.JAVA_OBJECT:
                sb.append("JAVA_OBJECT");
                break;
            default:
                sb.append("Object");
        }
        return sb.toString();
    }

}

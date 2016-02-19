package com.jhlishero.code.generator.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.jhlishero.code.generator.util.ColumnToPropertyUtil;
import com.jhlishero.code.generator.util.DatabaseUtils;

public class TableOptService {

	public static void main(String[] args) throws SQLException {
		generateJavaCode("oms_tmall_test", "t_sys_increment_assistant");
	}
	
//	@Test
//	public void test01() throws SQLException {
//		Map<String, String> dataMap = getDataMap("oms_tmall_test", "t_wms_order_status");
//		
//		DatabaseUtils.DB_URL = getDbUrl("oms_tmall_test");
//		Connection conn = DatabaseUtils.newInstance();
//		PreparedStatement pstat = conn.prepareStatement("select * from t_wms_order_status");
//		ResultSet rs = pstat.executeQuery();
//		ResultSetMetaData rsmd = rs.getMetaData();
//		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//			System.out.println(String.format("/** %s **/", dataMap.get(rsmd.getColumnName(i))));
//			System.out.println(field(rsmd.getColumnClassName(i), rsmd.getColumnName(i)));
//		}
//		System.out.println();
//		System.out.println();
//		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//			System.out.println(setField(rsmd.getColumnClassName(i), rsmd.getColumnName(i)));
//			System.out.println();
//			System.out.println(getField(rsmd.getColumnClassName(i), rsmd.getColumnName(i)));
//			System.out.println();
//		}
//		DatabaseUtils.closeConnection();
//	}
	
	private static String getDbUrl(String tableSchema) {
		return "jdbc:mysql://10.8.4.35:3306/" + tableSchema + "?useUnicode=true&characterEncoding=UTF-8&autoReconnect=true&zeroDateTimeBehavior=convertToNull&transformedBitIsBoolean=true";
	}
	
	private static Map<String, String> getDataMap(String tableSchema, String tableName) throws SQLException {
		Map<String, String> dataMap = new HashMap<String, String>();
		DatabaseUtils.DB_URL = getDbUrl("information_schema");
		Connection conn = DatabaseUtils.newInstance();
		PreparedStatement pstat = conn.prepareStatement("select COLUMN_NAME, COLUMN_COMMENT from COLUMNS where TABLE_SCHEMA='" + tableSchema + "' and TABLE_NAME='" + tableName + "' ORDER BY ORDINAL_POSITION ASC");
		ResultSet rs = pstat.executeQuery();
		while (rs.next()) {
			dataMap.put(rs.getString("COLUMN_NAME"), rs.getString("COLUMN_COMMENT"));
		}
		DatabaseUtils.closeConnection();
		return dataMap;
	}
	
	public static void generateJavaCode(String tableSchema, String tableName) throws SQLException {
		Map<String, String> dataMap = getDataMap(tableSchema, tableName);
		
		DatabaseUtils.DB_URL = getDbUrl(tableSchema);
		Connection conn = DatabaseUtils.newInstance();
		PreparedStatement pstat = conn.prepareStatement("select * from " + tableName);
		ResultSet rs = pstat.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(String.format("/** %s **/", dataMap.get(rsmd.getColumnName(i))));
			System.out.println("private " + field(rsmd.getColumnClassName(i), rsmd.getColumnName(i)) + ";");
		}
		System.out.println();
		System.out.println();
		for (int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(getField(rsmd.getColumnClassName(i), rsmd.getColumnName(i)));
			System.out.println();
			System.out.println(setField(rsmd.getColumnClassName(i), rsmd.getColumnName(i)));
			System.out.println();
		}
		DatabaseUtils.closeConnection();
	}
	
	private static String filedColumnClassName(String columnClassName) {
		if ("java.sql.Timestamp".equals(columnClassName)) {
			columnClassName = java.util.Date.class.getCanonicalName();
		}
		return columnClassName;
	}
	
	private static String field(String columnClassName, String column) {
		return String.format("%s %s", filedColumnClassName(columnClassName), ColumnToPropertyUtil.columnToProperty2(column.toLowerCase()));
	}
	
	private static String setField(String columnClassName, String column) {
		StringBuilder fieldSb = new StringBuilder();
		String propertyColumn = ColumnToPropertyUtil.columnToProperty2(column);
		fieldSb.append(String.format("public void set%s(%s) {", firstLetterToUpcase(propertyColumn), field(columnClassName, column)));
		fieldSb.append(String.format("\r\n	this.%s = %s;", propertyColumn, propertyColumn));
		fieldSb.append("\r\n}");
		return fieldSb.toString();
	}
	
	private static String firstLetterToUpcase(String propertyColumn) {
		return propertyColumn.substring(0, 1).toUpperCase() + propertyColumn.substring(1, propertyColumn.length());
	}
	
	
	private static String getField(String columnClassName, String column) {
		StringBuilder fieldSb = new StringBuilder();
		String propertyColumn = ColumnToPropertyUtil.columnToProperty2(column);
		
		if (column.equalsIgnoreCase("ID")) {
			fieldSb.append("@Id\r\n");
		    fieldSb.append("@Column(name=\"ID\")\r\n");
		    fieldSb.append("@GeneratedValue(strategy=GenerationType.AUTO)\r\n");
		} else {
			fieldSb.append(String.format("@Column(name=\"%s\")\r\n", column));
		}
		
		fieldSb.append(String.format("public %s get%s() {", filedColumnClassName(columnClassName), firstLetterToUpcase(propertyColumn)));
		fieldSb.append(String.format("\r\n	return this.%s;", propertyColumn));
		fieldSb.append("\r\n}");
		return fieldSb.toString();
	}
	
}

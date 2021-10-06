package com.kh.common;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {
	private static Connection conn = null;
	
	private JDBCTemplate() {}
	
//	싱글 톤 패턴 : 기본생성자를 private으로 해서 객체 생성을 막고 모든 구조를 static으로 해놓은 것(ex.Math)
//	자주 쓰는 것이라면 메모리에 객체를 딱 한 번만 기록한 후 계속 갖다 쓸 수 있게 함
	
	public static Connection getConnection() { // = DriverManager.getConnection()를 내 입맛대로 만들 것임
		// 원래 계속 써줘야 하는 것을 미리 만들어놓고 계속 가져다 쓸 수 있음
		
		if(conn == null) {
			try {
				
				Properties prop = new Properties(); // 여기까진 아무 값도 안 들어가 있는 상태
				prop.load(new FileReader("driver.properties")); 
				// properties파일에 있는 데이터를 읽어와서 Properties객체에 저장하는 메소드
				
				
//				Class.forName("oracle.jdbc.driver.OracleDriver");
				Class.forName(prop.getProperty("driver"));
				
//				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "MEMBER", "MEMBER");
				conn = DriverManager.getConnection(prop.getProperty("url"),
													prop.getProperty("user"),
													prop.getProperty("password"));
				
				conn.setAutoCommit(false);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return conn;
	}
	
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection conn) {
		try {
			if(conn != null & !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(ResultSet rset) {
		try {
			if(rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// PreparedStatement는 Statement를 상속받음(다형성 적용)
}

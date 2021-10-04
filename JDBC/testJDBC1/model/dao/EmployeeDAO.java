package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.model.vo.Employee;

public class EmployeeDAO {

	public ArrayList<Employee> selectAll() {
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Employee> list = null;
		
		
		// ����̹��� �����ϴ��� ����� �������� Ȯ���ϱ� ���� try~catch �߰�
		try {
			// 1. DB�� ���� Driver ��� : Class.forName("JDBC ����̹�"); -> ����Ŭ�̸� ����Ŭ�� ���� �Ѵٴ� �Ҹ�
			// DBMS������ ���� ����̹��� �޶���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ���� �۾�
			// DriverManager : Connection�� ������ֱ� ���� Ŭ����
			//		DriverManager.getConnection(String url, String user, String password):Connection
			//			Ư�� DB�� ����� Connection ��ȯ�ϴ� �޼ҵ�
			//				url : ��� ��ǻ�� DB�� ������ ������
			//				user : ������ ���� �̸�
			//				password : ������ ���� ��й�ȣ
			// Connection : DB�� ����� ��
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", 
														  "SCOTT", "SCOTT");
			// jdbc:oracle:thin		-> jdbc����̹��� thinŸ����
			// @127.0.0.1			-> ������ �����ͺ��̽��� �� ��ǻ�Ϳ� ����(�� ��ǻ�Ϳ� ���� ip�ּ�)
			// 1521:xe				-> ��Ʈ��ȣ�� xeŸ��
			
			// 3. ���� �ۼ� �� ���� ����
			// 4. ���� ��� �� �ޱ�
			String query = "SELECT * FROM EMP"; // SELECT�� �����ݷ� �� �ٿ��� ��
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query); // ������ SELECT������ ���±� ������ �� ������� ������ ����
			// -->�ٷ� Ȱ���� �� ���� ������ ��ȯ���Ѽ� �������� ��
			
			// 5. �޾ƿ� ��� �� ��ȯ
			// ResultSet �ȿ� 0~n���� ���� �� ���� ���ɼ��� �ִٸ� while������ ���� : ���� ���� �ִ��� ������
			// ResultSet �ȿ� 0~1���� �ุ �� ���� ���ɼ��� �ִٸ� if������ ���� : ���� �ִ��� ������
			list = new ArrayList<>(); // Ÿ�� �߷�, ���� Ÿ���� �����ص� ��
			while(rset.next()) { // next():boolean ���� ���� �����Ѵٸ� true��ȯ
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
//				--> ResultSet�� �÷����� ���� ������ ���̺��� ���� �� �ƴ�
//				--> �÷��� ��Ī �پ� ������ �װ͵� ������� ��
				
				Employee emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // try~catch�� ��� ���� close �ع����� ���� �� ��� �� �ڿ� �߰���
			// 6. �ڿ� �ݳ� �� ������ ��ȯ(�������)
			try {
//				finally �ȿ� �־ ������ �� -> ���������� �ʱ�ȭ����� ��
				rset.close(); 
				stmt.close();
				conn.close();
//				�̰͵鵵 ���� try~catch ����� ������ �����
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}

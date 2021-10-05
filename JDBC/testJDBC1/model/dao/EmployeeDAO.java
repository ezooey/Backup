package com.kh.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
		
		
		// 드라이버가 존재하는지 제대로 들어갔는지를 확인하기 위해 try~catch 추가
		try {
			// 1. DB에 대한 Driver 등록 : Class.forName("JDBC 드라이버"); -> 오라클이면 오라클이 들어가야 한다는 소리
			// DBMS종류에 따라 드라이버가 달라짐
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결 작업
			// DriverManager : 직접 객체 생성이 불가능하기 때문에 Connection을 만들어주기 위한 클래스
			//		DriverManager.getConnection(String url, String user, String password):Connection
			//			특정 DB에 연결된 Connection 반환하는 메소드
			//				url : 어느 컴퓨터 DB에 연결할 것인지
			//				user : 연결할 계정 이름
			//				password : 연결할 계정 비밀번호
			// Connection : DB와 연결된 길
			conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:xe", 
														  "SCOTT", "SCOTT");
			// jdbc:oracle:thin		-> jdbc드라이버가 thin타입임
			// @127.0.0.1			-> 접근할 데이터베이스가 내 컴퓨터에 있음(내 컴퓨터에 대한 ip주소)
			// 1521:xe				-> 포트번호와 xe타입
			
			// 3. 쿼리 작성 및 쿼리 전송
			// 4. 쿼리 결과 값 받기
			String query = "SELECT * FROM EMP"; 
			// DB에 보낼 때 자동으로 세미콜론 붙기 때문에 여기서는 SELECT에 세미콜론 안 붙여도 됨
			stmt = conn.createStatement(); // Connection클래스 안의 createStatement()메소드 이용
			rset = stmt.executeQuery(query); // 쿼리를 SELECT문으로 보냈기 때문에 그 결과값을 저장할 클래스를 만든 것
			// -->내용을 바로 활용할 수 없기 때문에 변환시켜서 출력해줘야 함
			
			// 5. 받아온 결과 값 변환
			// ResultSet 안에 0~n개의 행이 들어가 있을 가능성이 있다면 while문으로 진행 : 다음 값이 있느냐 없느냐
			// ResultSet 안에 0~1개의 행만 들어가 있을 가능성이 있다면 if문으로 진행 : 행이 있느냐 없느냐
			list = new ArrayList<>(); // 타입 추론, 뒤의 타입은 생략해도 됨
			while(rset.next()) { // next():boolean 다음 행이 존재한다면 true반환
				int empNo = rset.getInt("EMPNO");
				String empName = rset.getString("ENAME");
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
//				--> ResultSet의 컬럼명을 보는 것이지 테이블을 보는 게 아님
//				--> 컬럼명 별칭 붙어 있으면 그것도 따라줘야 함
				
				Employee emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
				list.add(emp);
			}
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally { // try~catch로 잡기 전에 close 해버리면 닿을 수 없어서 맨 뒤에 추가함
			// 6. 자원 반납 및 데이터 반환(순서대로)
			try {
//				finally 안에 있어서 빨간줄 뜸 -> 전역변수로 초기화해줘야 함
				rset.close(); 
				stmt.close();
				conn.close();
//				이것들도 따로 try~catch 해줘야 빨간줄 사라짐
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

	public Employee selectEmployee(int empNo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
//		Statement stmt = null;
		ResultSet rset = null;
		Employee emp = null;
		
		try {
			// 1. DB에 대한 Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. DB와 연결 : DriverManager를 통한 Connection객체 생성
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			// 127 대신 localhost라고 해도 됨
			
			// 3. query 작성 및 전송
			String query = "SELECT * FROM EMP WHERE EMPNO = ?";
//			String query = "SELECT * FROM EMP WHERE EMPNO =" + empNo;
			pstmt = conn.prepareStatement(query); 
			// 빈 곳을 채우기 위해 쿼리를 먼저 보내고 시작하기 때문에 전송할 때는 안 써도 됨(stmt랑 차이점)
			pstmt.setInt(1, empNo);
			rset = pstmt.executeQuery(); // 여기서 query 안 써줘도 된다 (10시 48분)
//			stmt = conn.createStatement(); 
//			rset = stmt.executeQuery(query)
			
			// 4. 결과 값 변환 : ResultSet 안에는 최대 1개의 행이 들어가 있을 것이므로 if 사용
			if(rset.next()) {
//				int empNo = rset.getInt("empno"); // 매개변수로 받아온 empNo로 대체 사용하기 때문에 안 해줘도 됨
				String empName = rset.getString("ENAME"); // 대소문자 상관없음
				String job = rset.getString("JOB");
				int mgr = rset.getInt("MGR");
				Date hireDate = rset.getDate("HIREDATE");
				int sal = rset.getInt("SAL");
				int comm = rset.getInt("COMM");
				int deptNo = rset.getInt("DEPTNO");
				
				emp = new Employee(empNo, empName, job, mgr, hireDate, sal, comm, deptNo);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 5. 자원 반납 및 데이터 반환
				rset.close();
				pstmt.close();
//				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return emp;
		
	}

	public int insertEmployee(Employee emp) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false); 
			// 자동커밋 비활성화(원치 않을 때 자동커밋될 수 있기 때문에 트랜잭션 권한을 컴퓨터가 아닌 사용자에게 위임)
			
//			String query = "INSERT INTO EMP VALUES(" + emp.getEmpNo() + ", " 
//													 + emp.getEmpName() + ", " 
//													 + emp.getJob() + ", " 
//													 + emp.getMgr() + ", sysdate, " 
//													 + emp.getSal() + ", " 
//													 + emp.getComm() + ", " 
//													 + emp.getDeptNo() + ")";
			String query = "INSERT INTO EMP VALUES(?, ?, ?, ?, SYSDATE, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setString(3, emp.getJob());
			pstmt.setInt(4, emp.getMgr());
			pstmt.setInt(5, emp.getSal());
			pstmt.setInt(6, emp.getComm());
			pstmt.setInt(7, emp.getDeptNo());
			
			// SELECT문을 사용한 쿼리는 executeQuery()를 이용해서 ResultSet을 반환한다
			
			// SELECT - executeQuery() - ResultSet
			// DML(INSERT, UPDATE, DELETE) - executeUpdate() -> int 몇개의 행을 처리했는지 나타내주기 때문에
			// ex) 오라클에서 '1 행 이(가) 삽입되었습니다' 와 같은 안내문구 출력시 필요
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback(); // commit과 rollback 둘 다 SQLException을 위임한다
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	public int updateEmployee(Employee e) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "UPDATE EMP SET JOB = ?, SAL = ?, COMM = ? WHERE EMPNO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, e.getJob());
			pstmt.setInt(2, e.getSal());
			pstmt.setInt(3, e.getComm());
			pstmt.setInt(4, e.getEmpNo());
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		} catch (SQLException e1) {
			e1.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		return result;
	}

	public int deleteEmployee(int empNo) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "SCOTT");
			conn.setAutoCommit(false);
			
			String query = "DELETE FROM EMP WHERE EMPNO = ?";
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, empNo);
			
			result = pstmt.executeUpdate();
			if(result > 0) {
				conn.commit();
			} else {
				conn.rollback();
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}

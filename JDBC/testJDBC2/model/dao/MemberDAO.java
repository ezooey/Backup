package com.kh.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import com.kh.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		prop = new Properties();
		try {
			prop.load(new FileReader("query.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertMember(Connection conn, Member mem) {
		/*
		 	이전 프로젝트에서 DAO가 맡은 업무
		 		1) JDBC드라이버 등록
		 		2) DB연결 Connection 객체 생성
		 		3) SQL 실행
		 		4) 트랜잭션 처리
		 		5) 자원 반납
		 		
		 	--> 사실 DAO는 SQL문을 DB로 전달하고 결과 값을 반환 받는 일만 진행(3번 업무)
		 	--> 1, 2, 4, 5 역할을 분리
		 		--> 위 업무들은 공통적인 업무이기 때문에 한번에 묶어서 처리 : JDBCTemplate
		 */
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String query = prop.getProperty("insertMember");
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, mem.getMemberId());
			pstmt.setString(2, mem.getMemberPwd());
			pstmt.setString(3, mem.getMemberName());
			pstmt.setString(4, mem.getGender() + ""); // setChar라는 게 없기 때문에 ""를 붙여 String으로 만든다
			pstmt.setString(5, mem.getEmail());
			pstmt.setString(6, mem.getPhone());
			pstmt.setString(7, mem.getAddress());
			pstmt.setInt(8, mem.getAge());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			/*JDBCTemplate.*/ close(pstmt); // 위에 임포트 넣어줬으면 앞에 붙인 위치 정보 지워도 됨
		}
		
		return result;
	}

	public ArrayList<Member> selectAll(Connection conn) {
		Statement stmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		try {
			String query = prop.getProperty("selectAll");
			stmt = conn.createStatement();
			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				String memberId = rset.getString("MEMBER_ID");
				String memberPwd = rset.getString("MEMBER_PWD");
				String memberName = rset.getString("MEMBER_NAME");
				char gender = rset.getString("GENDER").charAt(0);
				String email = rset.getString("EMAIL");
				String phone = rset.getString("PHONE");
				String address = rset.getString("ADDRESS");
				int age = rset.getInt("AGE");
				Date enrollDate = rset.getDate("ENROLL_DATE");
				
				Member mem = new Member(memberId, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				list.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
			// 하나만 가지고 사용하기 때문에 나중에 프로그램 종료할 때만 conn을 close()해줌
		}
		
		return list;
	}

	public ArrayList<Member> selectMemberId(Connection conn, String id) {
//		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null; 
		
		String query = prop.getProperty("selectMemberId");
//		String query = prop.getProperty("selectMemberId") + "'%" + id + "'%'";
		// Statement를 사용할 때는 LIKE 뒤에 ''안에 데이터를 넣지만 PreparedStatement는 x
		// -> pstmt는 ?(위치홀더) 자리에 데이터가 들어가면 자동으로 데이터를 ''으로 감싸주기 때문에 없어도 됨
		// 즉, 위치홀더의 유무 차이(매우 중요)
		
		
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, id);
			pstmt.setString(1, "%" + id + "%");
			rset = pstmt.executeQuery();
			
			
			// Statement
//			stmt = conn.createStatement();
//			rset = stmt.executeQuery(query);
			
			list = new ArrayList<Member>();
			while(rset.next()) {
//				String memberPwd = rset.getString("MEMBER_PWD");
//				String memberName = rset.getString("MEMBER_NAME");
//				char gender = rset.getString("GENDER").charAt(0);
//				String email = rset.getString("EMAIL");
//				String phone = rset.getString("PHONE");
//				String address = rset.getString("ADDRESS");
//				int age = rset.getInt("AGE");
//				Date enrollDate = rset.getDate("ENROLL_DATE");
//				
//				Member m = new Member(id, memberPwd, memberName, gender, email, phone, age, address, enrollDate);
				Member m = new Member(rset.getString("member_id"),
									  rset.getString("member_pwd"),
									  rset.getString("member_name"),
									  rset.getString("gender").charAt(0),
									  rset.getString("email"),
									  rset.getString("phone"),
									  rset.getInt("age"),
									  rset.getString("address"),
									  rset.getDate("enroll_Date"));
				
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
//			close(stmt);
		}
		
		return list;
	}

	public ArrayList<Member> selectGender(Connection conn, char gen) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		ArrayList<Member> list = null;
		
		String query = prop.getProperty("selectGender");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, gen + "");
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Member>();
			while(rset.next()) {
				Member m = new Member(rset.getString("member_id"),
						  rset.getString("member_pwd"),
						  rset.getString("member_name"),
						  rset.getString("gender").charAt(0),
						  rset.getString("email"),
						  rset.getString("phone"),
						  rset.getInt("age"),
						  rset.getString("address"),
						  rset.getDate("enroll_Date"));
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

	public int checkMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			
			//rset의 결과는 무조건 1개의 행이 나옴(숫자 0이 한 개의 행에 담길 수도 있고 숫자 8이 한 개의 행에 담길 수도 있기 때문에)
			// --> count의 결과임
			
			if(rset.next()) {
//				result = rset.getInt("count(*)");
				result = rset.getInt(1); // index 이용해서 1번 컬럼을 불러온 것 
				// rset.getString("member_id") 대신임
				// int columIndex와 String columnLabel이 있음
				// 하나만 가져올 것이기 때문에 1번 인덱스만 써줘도 상관없는 것 (컬럼명으로 쓰는 걸 권장)
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, String memberId, String input, int sel) {
		PreparedStatement pstmt = null;
		int result = 0;
		
//		String query = prop.getProperty("updateMember");
		// UPDATE MEMBER SET ? = ? WHERE MEMBER_ID = ?
		// --> 이렇게 하면 pstmt에서 위치홀더를 ' '로 묶는 특성 때문에 
		// 첫 번째 위치홀더 자리인 컬럼명도 ' '로 감싸는 형태가 됨
		
//		updateMember1=UPDATE MEMBER SET MEMBER_PWD = ? WHERE MEMBER_ID = ?
//		이런 식으로 쿼리 작성해야 한다
		String query = prop.getProperty("updateMember" + sel);
		// sel로 경우를 나눠 쿼리 작성해야 한다
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, input);
			pstmt.setString(2, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int deleteMember(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
}

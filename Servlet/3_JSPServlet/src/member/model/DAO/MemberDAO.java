package member.model.DAO;

import static common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop = null;
	
	public MemberDAO() {
		prop = new Properties();
		
		String fileName = MemberDAO.class.getResource("/sql/member/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Member loginMember(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("login");
		// login=SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			// Connection이 null이라 prepareStatement(query);를 불러올 수 없음
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("USER_ID"),	// Result set의 컬럼명
									   rset.getString("USER_PWD"),
									   rset.getString("USER_NAME"),
									   rset.getString("NICKNAME"),
									   rset.getString("PHONE"),
									   rset.getString("EMAIL"),
									   rset.getString("ADDRESS"),
									   rset.getString("INTEREST"),
									   rset.getDate("ENROLL_DATE"),
									   rset.getDate("MODIFY_DATE"),
									   rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
	}

	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("insertMember");
		//insertMember=INSERT INTO MEMBER VALUES(?, ?, ?, ?, ?, ?, ?, ?, SYSDATE, SYSDATE, DEFAULT)
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, member.getUserId());
			pstmt.setString(2, member.getUserPwd());
			pstmt.setString(3, member.getUserName());
			pstmt.setString(4, member.getNickName());
			pstmt.setString(5, member.getPhone());
			pstmt.setString(6, member.getEmail());
			pstmt.setString(7, member.getAddress());
			pstmt.setString(8, member.getInterest());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkId(Connection conn, String inputId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		int result = 0;
		
		String query = prop.getProperty("checkId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, inputId);
			
			rset = pstmt.executeQuery(); 
			// count로 가져오기 때문에 결과는 무조건 1개 (값이 1개 또는 0개일 수 있지만 결과는 1개)
			
			if(rset.next()) {
				result = rset.getInt(1); // 결과 무조건 1개라서 1로 넣어도 됨
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	public Member selectMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member member = null;
		
		String query = prop.getProperty("selectMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				member = new Member(rset.getString("USER_ID"),
									rset.getString("USER_PWD"),
									rset.getString("USER_NAME"),
									rset.getString("NICKNAME"),
									rset.getString("PHONE"),
									rset.getString("EMAIL"),
									rset.getString("ADDRESS"),
									rset.getString("INTEREST"),
									rset.getDate("ENROLL_DATE"),
									rset.getDate("MODIFY_DATE"),
									rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return member;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getNickName());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getAddress());
			pstmt.setString(6, m.getInterest());
			pstmt.setString(7, m.getUserId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updatePwd(Connection conn, HashMap<String, String> map) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePwd");
		// updatePwd=UPDATE MEMBER SET USER_PWD=? WHERE USER_ID=? AND USER_PWD=?
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, map.get("newPwd"));
			pstmt.setString(2, map.get("userId"));
			pstmt.setString(3, map.get("userPwd"));
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteMember(Connection conn, String userId) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("deleteMember");
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

}

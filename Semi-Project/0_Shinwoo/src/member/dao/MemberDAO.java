package member.dao;
import static common.JDBCTemplate.*;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import member.vo.Member;

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

	public Member loginMember(String memberId, String memberPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = prop.getProperty("login");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, memberPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("MEMBER_ID"),
									   rset.getString("PW"),
									   rset.getString("MEMBER_NAME"),
									   rset.getString("DEPARTMENT"),
									   rset.getString("PHONE"),
									   rset.getString("ADDRESS"),
									   rset.getString("EMAIL"),
									   rset.getString("MEMBER_TYPE"),
									   rset.getString("STATUS"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return loginUser;
		
		
	}

	public String isFirstLogin(String memberId, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String status = null;
		
		String query = prop.getProperty("checkFirst");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				status = rset.getString(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return status;
		
		
	}

	public int firstUpdate(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("firstUpdate");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getPhone());
			pstmt.setString(3, m.getAddress());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getMemberId());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int updatePwd(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updatePwd");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getMemberPwd());
			pstmt.setString(2, m.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int updateMember(Connection conn, Member m) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		String query = prop.getProperty("updateMember");
		
		try {
			pstmt = conn.prepareStatement(query);
			
			pstmt.setString(1, m.getPhone());
			pstmt.setString(2, m.getAddress());
			pstmt.setString(3, m.getEmail());
			pstmt.setString(4, m.getMemberId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public String findPwd(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String email = null;
		
		String query = prop.getProperty("findPwd");
		// findPwd=SELECT EMAIL FROM MEMBER WHERE MEMBER_ID = ?
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			if(rset.next()) {
				email = rset.getString("email");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return email;
	}

}

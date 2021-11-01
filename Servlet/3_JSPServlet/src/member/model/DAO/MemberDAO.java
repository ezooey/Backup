package member.model.DAO;

import static common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import member.model.vo.Member;

public class MemberDAO {

	public Member loginMember(String userId, String userPwd, Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		Member loginUser = null;
		
		String query = "SELECT * FROM MEMBER WHERE USER_ID = ? AND USER_PWD = ?";
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userId);
			pstmt.setString(2, userPwd);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				loginUser = new Member(rset.getString("USER_ID"),
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

}

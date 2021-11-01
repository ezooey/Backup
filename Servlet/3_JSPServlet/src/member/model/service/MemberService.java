package member.model.service;

import static common.JDBCTemplate.getConnection;

import java.sql.Connection;

import member.model.DAO.MemberDAO;

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();

	public void loginMember(String userId, String userPwd) {
		Connection conn = getConnection();
		
		mDAO.loginMember(userId, userPwd, conn);
	}

}

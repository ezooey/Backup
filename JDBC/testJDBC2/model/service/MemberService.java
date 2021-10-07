package com.kh.model.service;

import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.rollback;
import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.kh.model.dao.MemberDAO;
import com.kh.model.vo.Member;

// Controller에서 DAO로 넘어가는 게 아니라 서비스에서 커넥션 객체를 생성 후 DAO로 넘어가게끔 함
// Controller -> DAO (원래 방식)
// Controller -> Service -> DAO (서비스)
// 실제로 DB를 관리하는 건 DAO기 때문에 최종적으로는 DAO에 넘겨줘야 함

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();

	public int insertMember(Member mem) {
		Connection conn = /*JDBCTemplate.*/getConnection();
		
		int result = mDAO.insertMember(conn, mem);
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}

	public ArrayList<Member> selectAll() {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectAll(conn);
		
		return list;
	}


	public ArrayList<Member> selectMemberId(String id) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectMemberId(conn, id);
		
		return list;
		
	}
	
	public ArrayList<Member> selectGender(char gen) {
		Connection conn = getConnection();
		
		ArrayList<Member> list = mDAO.selectGender(conn, gen);
		
		return list;
	}

	public int checkMember(String memberId) {
		Connection conn = getConnection();
		
		int result = mDAO.checkMember(conn, memberId);
		
		return result;
	}

	public int updateMember(String memberId, String input, int sel) {
		Connection conn = getConnection();
		
		int result = mDAO.updateMember(conn, memberId, input, sel);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
		
	}

	public int deleteMember(String memberId) {
		Connection conn = getConnection();
		
		int result = mDAO.deleteMember(conn, memberId);
		
		if(result > 0) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		return result;
	}
	
	public void exitProgram() {
		Connection conn = getConnection();
		close(conn);
	}


}

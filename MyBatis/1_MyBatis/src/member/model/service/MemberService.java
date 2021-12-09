package member.model.service;

import static common.Template.getSqlSession;

import org.apache.ibatis.session.SqlSession;

import member.model.dao.MemberDAO;
import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberService {
	
	private MemberDAO mDAO = new MemberDAO();

	public Member selectMember(Member m) throws MemberException {
		SqlSession session = getSqlSession(); // Connection과 같은 역할
		Member member = mDAO.selectMember(session, m);
		
		session.close();
		// throw해준 것은 비정상종료됨. 비정상종료됐으니까 close까지 가지도 못 하고 종료되어 문제가 발생함.
		
		return member;
	}
	

}

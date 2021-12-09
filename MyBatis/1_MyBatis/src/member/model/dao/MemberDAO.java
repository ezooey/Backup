package member.model.dao;

import org.apache.ibatis.session.SqlSession;

import member.model.exception.MemberException;
import member.model.vo.Member;

public class MemberDAO {

	public Member selectMember(SqlSession session, Member m) throws MemberException {
		
		/*
			session.selectOne(arg0); // 데이터 보낼 게 없을 떄
			session.selectOne(arg0, arg1) // 보낼 데이터가 있을 때(위치홀더에 넣을 데이터)
		
			- arg0 : 어느 매퍼에 있는 어떤 쿼리(id)에 접근할 것인가
			- arg1 : 쿼리로 보낼 데이터 작성하는 부분
		
		*/
		
		Member member = session.selectOne("memberMapper.loginMember", m);
		
		if(member == null) {
			session.close(); // throws 때문에 비정상종료될 것이기 때문에 여기서 일단 강제로 닫아준다
			throw new MemberException("로그인에 실패하였습니다.");
		}
		
		return member;
	}

}

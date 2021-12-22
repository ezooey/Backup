package com.kh.spring.member.model.service;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kh.spring.member.model.dao.MemberDAO;
import com.kh.spring.member.model.vo.Member;

@Service("mService") // 이름까지 붙여주면 좀 더 정확해짐
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	private MemberDAO mDAO;
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public Member memberLogin(Member m) {
		
		return mDAO.memberLogin(sqlSession, m);
	}
	
	@Override
	public int insertMember(Member m) {
		
		return mDAO.insertMember(sqlSession, m);
	}

	@Override
	public int updateMember(Member m) {
		
		return mDAO.updateMember(sqlSession, m);
	}

	@Override
	public int updatePwd(HashMap<String, String> map) {
		return mDAO.updatePwd(sqlSession, map);
	}

	@Override
	public int duplicateId(String id) {
		
		return mDAO.duplicateId(sqlSession, id);
	}
	
}

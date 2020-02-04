package com.ssafy.manv.repo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.manv.entity.Member;


@Repository
public class MemberRepo {
	
	public Member getMemberByID(String email) { 
		return sqlSession.selectOne(ns + "getMemberByID", email);
	}

	public void addMember(Member dto) {
		sqlSession.insert(ns + "addMember", dto);
	}

	public void deleteMember(String email) {
		sqlSession.delete(ns + "deleteMember", email);
	}

	public void changeMemberInfo(Member dto) {
		sqlSession.update(ns + "changeMemberInfo", dto);
	}

	public void changePwd(Member dto) {
		sqlSession.update(ns + "changePwd", dto);
	}
	
	public String getTokenById(String email) {
		return sqlSession.selectOne(ns+"getTokenById", email);
	}
	
	public void updateToken(Member member) {
		sqlSession.update(ns+"updateToken", member);
	}

}

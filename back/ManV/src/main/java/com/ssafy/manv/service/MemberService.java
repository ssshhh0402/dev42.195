package com.ssafy.manv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.manv.repo.MemberRepo;


@Service
public class MemberService {

	@Autowired
	private MemberRepo dao;

	@Override
	public Member getMemberByID(String email) {
		return dao.getMemberByID(email);
	}

	@Override
	public void addMember(Member dto) {
//		String encodedPassword = new BCryptPasswordEncoder().encode(dto.getPwd());
//		dto.setPwd(encodedPassword);
		dao.addMember(dto);
	}

	@Override
	public void deleteMember(String email) {
		dao.deleteMember(email);
	}

	@Override
	public void changeMemberInfo(Member dto) {
		dao.changeMemberInfo(dto);
	}

	@Override
	public void changePwd(Member dto) {
		dao.changePwd(dto);
	}
	
	@Override
	public String getTokenById(String email) {
		return dao.getTokenById(email);
	}
	
	@Override
	public void updateToken(Member member) {
		dao.updateToken(member);
	}
}

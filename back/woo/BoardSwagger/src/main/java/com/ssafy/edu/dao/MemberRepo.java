package com.ssafy.edu.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.edu.dto.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Integer>, Specification<Member> {
	Optional<Member> findByEmail(String email);
	List<Member> findAll();
}

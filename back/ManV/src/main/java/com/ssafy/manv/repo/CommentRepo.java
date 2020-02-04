package com.ssafy.manv.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssafy.manv.entity.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
	Optional<Comment> findByBoardId(int board_id);
}

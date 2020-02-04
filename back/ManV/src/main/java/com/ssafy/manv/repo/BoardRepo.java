package com.ssafy.manv.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ssafy.manv.entity.Board;

public interface BoardRepo extends JpaRepository<Board, Integer> {

	Optional<Board> findByBoardId(int board_id);
//	public int getBoardId() {
//		return sqlSession.selectOne(ns + "getBoardId");
//	}
	
	List<Board> findAll();
//	public List<Board> getBoard() {
//		return sqlSession.selectList(ns + "getBoard");
//	}

	//	save
//	public void addBoardEmail(Board_email dto) {
//		sqlSession.insert(ns + "addBoard", dto);
//	}

	
	public void addPost(Post post) {
		sqlSession.insert(ns + "addPost", post);
	}

	public void addPostBoard(Post_board pb) {
		sqlSession.insert(ns + "addPostBoard", pb);
	}

	public Board getBoardByID(int board_id) {
		return sqlSession.selectOne(ns + "getBoardByID", board_id);
	}

	public void deleteBoard(int board_id) {
		sqlSession.delete(ns + "deleteBoard", board_id);
	}

	public void addComment(Comment dto) {
		sqlSession.insert(ns + "addComment", dto);
	}

	public List<Comment> getComment(int board_id) {
		return sqlSession.selectList(ns + "getComment", board_id);
	}

	public Comment getCommentByNum(int cnum) {
		return sqlSession.selectOne(ns + "getCommentByNum", cnum);
	}

	public void deleteComment(int cnum) {
		sqlSession.delete(ns + "deleteComment", cnum);
	}

	public void updateBoardAll(Board dto) {
		sqlSession.update(ns + "updateBoardAll", dto);
	}

	public void updateBoard(Board dto) {
		sqlSession.update(ns + "updateBoard", dto);
	}

	public void deletePostRecord(Post_board dto) {
		sqlSession.delete(ns + "deletePostRecord", dto);
	}

	public int getPid(Post_board dto) {
		return sqlSession.selectOne(ns + "getPid", dto);
	}

	public void addApply(Apply apl) {
		sqlSession.insert(ns + "addApply", apl);
	}

	public void addApplyBoard(Apply_board ab) {
		sqlSession.insert(ns + "addApplyBoard", ab);
	}

	public List<Board> searchBoard(String keyword) {
		return sqlSession.selectList(ns + "searchBoard", keyword);
	}

	public void addBoard(Board dto) {
		sqlSession.insert(ns + "addBoard", dto);
	}

}

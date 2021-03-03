package com.mvcproject.board.controller.model.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.board.controller.model.vo.Board;
import com.mvcproject.board.controller.model.vo.BoardPage;

@Repository
public class BoardDao {

	 @Autowired
	 private SqlSession sqlSession;
	 
	 public int listCount() {
		 return sqlSession.selectOne("Board.listCount");
	 }
	 
	 public Board selectOne(String board_num) {
		 return sqlSession.selectOne("Board.selectOne", board_num);
	 }
	 
	 public List<Board> searchList(String keyword){
		 return sqlSession.selectList("Board.searchList", keyword);
	 }
	 
	 public List<Board> selectList(int startPage, int limit){
		 int startRow = (startPage - 1) * limit;
		 BoardPage boardPage = new BoardPage();
		 boardPage.setStart(startRow+1);
		 boardPage.setEnd(startRow+10);
		 return sqlSession.selectList("Board.selectList", boardPage);
	 }
}

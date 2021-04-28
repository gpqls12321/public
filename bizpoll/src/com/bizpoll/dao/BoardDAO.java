package com.bizpoll.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.bizpoll.dto.BoardDTO;
import com.bizpoll.mybatis.SqlMapConfig;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	public static BoardDAO getInstance() {
		return instance;
	}
	
	SqlSessionFactory sqlSessionFactory = SqlMapConfig.getSqlSession();
	SqlSession sqlSession;
	
	public List<BoardDTO> boardList() {
		sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		List<BoardDTO> boardList = null;
		
		try {
			boardList = sqlSession.selectList("selBoardList");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardList;
	}

	public Integer getNewArticleNo() {
		sqlSession = sqlSessionFactory.openSession();
		
		Integer articleNo = 0;
		
		try {
			articleNo = sqlSession.selectOne("getNewArticleNo");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return articleNo;
	}

	public int create(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();
		
		int result = 0;
		
		try {
			result = sqlSession.insert("createBoard", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	

	public BoardDTO boardDetail(int articleNo) {
		sqlSession = sqlSessionFactory.openSession();
		BoardDTO bDto = null;
		
		try {
			bDto = sqlSession.selectOne("boardDetail", articleNo);
			System.out.println("bDto ===> " + bDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		
		return bDto;
	}

	public void boardDelete(int articleNo) {
		sqlSession = sqlSessionFactory.openSession();
		
		try {
			sqlSession.delete("boardDelete", articleNo);
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}

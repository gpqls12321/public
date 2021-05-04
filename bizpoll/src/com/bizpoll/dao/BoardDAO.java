package com.bizpoll.dao;

import java.util.List;
import java.util.Map;

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

	public List<BoardDTO> boardList(Map<String, Object> boardParmMap) {
		sqlSession = sqlSessionFactory.openSession();
		System.out.println(sqlSession);
		List<BoardDTO> boardList = null;

		try {
			boardList = sqlSession.selectList("selBoardList", boardParmMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardList;
	}

	public int boardListAllCnt(Map<String, Object> boardParmMap) {
		sqlSession = sqlSessionFactory.openSession();

		int boardListAllCnt = 0;
		try {
			boardListAllCnt = sqlSession.selectOne("boardListAllCnt", boardParmMap);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return boardListAllCnt;
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
			sqlSession.commit();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	public int modify(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();

		int result = 0;
		try {
			result = sqlSession.update("modifyBoard", bDto);
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
		return result;
	}

	public int replyReStepUpdate(BoardDTO bDto) {
		sqlSession = sqlSessionFactory.openSession();

		int result = 0;

		try {
			int maxsOrder = sqlSession.selectOne("selectBoardReplyMaxOrder", bDto);
			System.out.println("maxsOrder ===> " + maxsOrder);

			if (maxsOrder == 0) { // 맨마지막에 오는 댓글
				int selectReStep = sqlSession.selectOne("selectReStep", bDto);
				int re_level = bDto.getRe_level() + 1;

				bDto.setRe_step(selectReStep);
				bDto.setRe_level(re_level);

				result = sqlSession.insert("createBoard", bDto);
			} else {
				maxsOrder = sqlSession.selectOne("selectBoardReplyMaxOrder", bDto);
				bDto.setRe_step(maxsOrder);

				sqlSession.update("replyReStepUpdate", bDto);
				bDto.setRe_step(bDto.getRe_step() + 1);

				int re_level = bDto.getRe_level() + 1;
				bDto.setRe_level(re_level);

				result = sqlSession.insert("createBoard", bDto);
				sqlSession.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

		return result;
	}
	
//	public void boardCount(String readCount) {
//		sqlSession = sqlSessionFactory.openSession();
//		
//		try {
//			sqlSession.update("readCount", readCount);
//			sqlSession.commit();
//		} catch (Exception e) {
//			e.printStackTrace();
//		} finally {
//			sqlSession.close();
//		}
//	}

}

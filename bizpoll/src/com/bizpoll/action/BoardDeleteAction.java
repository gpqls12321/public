package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bizpoll.dao.BoardDAO;

public class BoardDeleteAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "boardDelete.jsp";
		int articleNo = Integer.valueOf(request.getParameter("articleNo"));
		System.out.println("delete articleNo ==>" + articleNo);
		
		BoardDAO bDao = new BoardDAO();
		bDao.boardDelete(articleNo);
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

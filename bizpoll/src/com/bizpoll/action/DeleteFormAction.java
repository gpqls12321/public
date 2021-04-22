package com.bizpoll.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class DeleteFormAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String url = "/index.bizpoll";
		
		HttpSession session = request.getSession();
		
		String userId = (String) session.getAttribute("id");
		
		MemberDAO mDao = MemberDAO.getInstance();
		if(mDao.deleteMember(userId) == 1) {
			session.removeAttribute("id");
		} else {
			
		}
		
		MemberDTO mDto = mDao.getMember(userId);
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

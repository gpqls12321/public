package com.bizpoll.action;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bizpoll.common.DBManager;
import com.bizpoll.dao.MemberDAO;
import com.bizpoll.dto.MemberDTO;

public class LoginAction implements Action {

	@Override
	public ActionFoward excute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = "/member/login_fail.jsp";
		
		HttpSession session = request.getSession();
		
		String userId = request.getParameter("id"); // "id"  ==> login.jsp의 name 명과 같아야됨
		String userPw = request.getParameter("pwd"); 
		
		MemberDAO mDao = MemberDAO.getInstance();
		MemberDTO mDto = mDao.getMember(userId);
		
		if(mDto != null) {
			if(mDto.getPwd().equals(userPw)) { //로그인 성공
				session.removeAttribute("id");
				session.setAttribute("loginUser", mDto);
				url = "index.bizpoll";
			}
		}
		
		ActionFoward forward = new ActionFoward();
		forward.setPath(url);
		forward.setRedirect(false);
		
		return forward;
	}

}

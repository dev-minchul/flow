package com.app.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.vo.MemberVO;

public class MemberLoginOkController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		MemberDAO memberDAO = new MemberDAO();
		MemberVO memberVO = new MemberVO();
		String memberEmail = null;
		
//		세션 코드 추가
//		request를 통해 session 객체를 가져온다.
//		서버에서 모두 사용할 수 있는 저장소이다. 
		HttpSession session = req.getSession();
		
		memberVO.setMemberEmail(req.getParameter("memberEmail"));
		memberVO.setMemberPassword(req.getParameter("memberPassword"));
		
		memberEmail = memberDAO.select(memberVO);
		
		result.setRedirect(true);
		if(memberEmail == null) {
			result.setPath(req.getContextPath() + "/login.member?login=false");
			return result;
		}
		
		session.setAttribute("memberEmail", memberEmail);
		result.setPath("list.product");
		return result;
	}

}

package com.app.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.app.Action;
import com.app.Result;
import com.app.dao.MemberDAO;
import com.app.dao.OrderDAO;

public class OrderListController implements Action {

	@Override
	public Result execute(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		Result result = new Result();
		OrderDAO orderDAO = new OrderDAO();
		MemberDAO memberDAO = new MemberDAO();
		HttpSession session = req.getSession();
		
		Long memberId = memberDAO.selectByEmail((String)session.getAttribute("memberEmail")).getId();
		
		req.setAttribute("orderList", orderDAO.select(memberId));
		result.setPath("order-list.jsp");
		return result;
	}

}

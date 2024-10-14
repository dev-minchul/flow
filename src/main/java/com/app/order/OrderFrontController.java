package com.app.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.member.controller.MemberJoinOkController;
import com.app.member.controller.MemberLoginOkController;
import com.app.order.controller.OrderListController;
import com.app.order.controller.OrderWriteOkController;


public class OrderFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("write-ok")) {
			result = new OrderWriteOkController().execute(req, resp);
		}else if(target.equals("list")) {
			result = new OrderListController().execute(req, resp);
		}else if(target.equals("cancel")) {
		}else {
//			전부 notFound 404
		}
		
		if(result != null) {
			if(result.isRedirect()) {
//				redirect
				resp.sendRedirect(result.getPath());
			}else{
//				forward
				req.getRequestDispatcher(result.getPath()).forward(req, resp);
			}
		}
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}


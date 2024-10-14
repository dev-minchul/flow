package com.app.product;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.app.Result;
import com.app.product.controller.ProductDeleteController;
import com.app.product.controller.ProductListController;
import com.app.product.controller.ProductReadController;
import com.app.product.controller.ProductUpdateController;
import com.app.product.controller.ProductUpdateOkController;
import com.app.product.controller.ProductWriteOkController;

public class ProductFrontController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=utf-8");
		String target = req.getRequestURI().replace(req.getContextPath() + "/", "").split("\\.")[0];
		Result result = null;
		
		if(target.equals("write")) {
			result = new Result();
			result.setPath("write.jsp");
		}else if(target.equals("write-ok")) {
			result = new ProductWriteOkController().execute(req, resp);
		}else if(target.equals("list")) {
			result = new ProductListController().execute(req, resp);
		}else if(target.equals("read")) {
			result = new ProductReadController().execute(req, resp);
			
		}else if(target.equals("update")) {
			result = new ProductUpdateController().execute(req, resp); 
			
		}else if(target.equals("update-ok")) {
			result = new ProductUpdateOkController().execute(req, resp);
		}else if(target.equals("delete-ok")) {
			result = new ProductDeleteController().execute(req, resp);
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


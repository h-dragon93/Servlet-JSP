package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

public class InitParamServlet extends HttpServlet {
	
	String id, pwd;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		id  = config.getInitParameter("id");
//		pwd = config.getInitParameter("password");
//	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		id  = this.getInitParameter("id");
		pwd = this.getInitParameter("password");
		
		out.print("<h1>" + id + " : " + pwd);
		out.close();
	}

}

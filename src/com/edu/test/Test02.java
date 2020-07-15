package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

public class Test02 extends HttpServlet {
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String code= this.getInitParameter("charset");
		req.setCharacterEncoding(code);
		
		resp.setContentType("text/html; charset=utf-8");
		// 파라미터 출력
		PrintWriter out = resp.getWriter();
		out.print("<h1>" + req.getParameter("name"));
		out.close();
	}
}

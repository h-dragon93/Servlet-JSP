package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/queryTest")
public class QueryStringTest extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> Get Method requested");
		//파라미터 추출
		String id  = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String[] list = req.getParameterValues("color");
		//입력안된 파라미터 검증은 if == null 로 하는게 아니라 데이터 길이 == 0 으로 해야함
		out.print("<h1>" + id + ":" + pwd);
		
		for(String c:list)
			out.print("<h2>" + c);
	
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> Post Method requested");
		// 한글 인코딩 처리
		req.setCharacterEncoding("utf-8");
		// 파라미터 추출
		String id  = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		String[] list = req.getParameterValues("color");
		//입력안된 파라미터 검증은 if == null 로 하는게 아니라 데이터 길이 == 0 으로 해야함
		out.print("<h1>" + id + ":" + pwd);
		
		for(String c:list)
			out.print("<h2>" + c);
		
		out.close();
	}

}
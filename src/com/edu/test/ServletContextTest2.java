package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/context2")
public class ServletContextTest2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//ServletContext 등록된 데이터 추출
		ServletContext sc = this.getServletContext();
		
		ShareObject a = (ShareObject)sc.getAttribute("data1");
		ShareObject b = (ShareObject)sc.getAttribute("data2");
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1>" + a.getCount() + ":" + a.getStr());
		out.print("<h1>" + b.getCount() + ":" + b.getStr());
		out.close();
	}
}

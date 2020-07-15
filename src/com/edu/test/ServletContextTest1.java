package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/context1")
public class ServletContextTest1 extends HttpServlet {
	
	ServletContext sc;
	
//	@Override
//	public void init(ServletConfig config) throws ServletException {
//		sc = config.getServletContext();
//	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
	
		sc = this.getServletContext();
		String s = sc.getInitParameter("title");		
		out.print("<h1>" + s);
		out.print("<h1>" + sc.getMajorVersion() + "." + sc.getMinorVersion());
		out.print("<h1>" + sc.getServerInfo());
		out.print("<h1>" + sc.getContextPath());
		sc.log("Log Info");
		
		ShareObject obj1 = new ShareObject();
		obj1.setCount(100);
		obj1.setStr("Object Sharing Test - 1");
		
		ShareObject obj2 = new ShareObject();
		obj2.setCount(100);
		obj2.setStr("Object Sharing Test - 2");
		
		//Servlet Context에 데이터 등록
		sc.setAttribute("data1", obj1);
		sc.setAttribute("data2", obj2);
		
		out.close();
	}

}

package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/cookie1")
public class CookieTest1 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		Cookie c1 = new Cookie("id", "guest");
		c1.setPath("/");
		resp.addCookie(c1);
		
		Cookie c2 = new Cookie("code", "1004");
		c2.setMaxAge(60*60*3);
		c2.setPath("/");
		resp.addCookie(c2);
		
		Cookie c3 = new Cookie("subject", "java");
		c3.setMaxAge(60*60*24*10);
		c3.setPath("/");
		resp.addCookie(c3);
		
		out.println("Cookie Sended");
		out.close();
	}

}

package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/cookie3")
public class CookieTest3 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt = 0;
		Cookie[] list = req.getCookies();
		for (int i = 0; list != null && i < list.length; i ++) {
			if(list[i].getName().equals("count")) {
				cnt = Integer.parseInt(list[i].getValue()); 		
			}
		}
		cnt++;
		Cookie c = new Cookie("count", cnt+"");
		c.setMaxAge(24*60*60*10);
		resp.addCookie(c);
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> 방문횟수 : " + cnt);
		out.close();
	}

}

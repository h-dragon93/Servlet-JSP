package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/cookie2")
public class CookieTest2 extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> Cookie 추출");
		
		//Cookie 읽어들임
		Cookie[] list = req.getCookies();
		if (list != null) {
			for(int i = 0 ; i < list.length; i ++) {
				Cookie c = list[i];
				if(c.getName().equals("subject")){
					out.println("<h2>" + c.getValue());
				}
			}
		}
		out.close();
	}

}

package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/sessionTest")
public class SessionTestServlet extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		String param = req.getParameter("p");
		String msg = null;
		HttpSession session = null;
		//세션 생성
		if (param.equals("create")) {
			session = req.getSession();
			if(session.isNew()) {
				msg = "New Session Object created";
			} else {
				msg = "Origin Session returned";
			}
		} else if (param.equals("delete")) {
			session = req.getSession(false);
			if(session != null) {
				session.invalidate();
				msg = "Session Object deleted";
			} else {
				msg = "No Session exited";
			}
		} else if (param.equals("add")) {
			session = req.getSession(true);
			session.setAttribute("msg", "This is Message");
			msg = "Session Object Registerd";
		} else if (param.equals("get")) {
			session = req.getSession(false);
			if (session != null) {
				String str = (String) session.getAttribute("msg");
				msg = str;
			} else {
				msg = "No Session Object exited";
			}
		} else if (param.equals("remove")) {
			session = req.getSession(false);
			if (session != null) {
				session.removeAttribute("msg");	
				msg = "Session Data Delete Complete";
			} else {
				msg = "No Session Object exited";
			}
		} else if (param.equals("replace")) {
			session = req.getSession();
			session.setAttribute("msg", "New Message");	
			msg = "Session Data Delete Complete";
		}
		
		out.print("<h1> Result :" + msg);
		out.close();
	}

}

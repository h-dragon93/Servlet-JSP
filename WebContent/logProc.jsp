<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	RequestDispatcher rd = request.getRequestDispatcher("/logInOut.jsp");	

	if(request.getMethod().equals("POST")){
		// 로그인
		String id  = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if (id.isEmpty() || pwd.isEmpty()) {
			request.setAttribute("msg", "ID or Password Empty");
			rd.forward(request, response);
			return;
		}
		
		if( session.isNew() || session.getAttribute("id")==null ) {
			session.setAttribute("id", id);
			out.print("<h1> Login Complete");
		} else {
			out.print("<h1> Already Login");
		}
		
	} else {
		// 로그아웃
		if(session != null && session.getAttribute("id") != null ) {
			session.invalidate();
			out.print("<h1>Log Out");
		} else {
			out.print("<h1> Not logIn Now");
		}
	}
	
	rd.forward(request, response);
%>

<h1> OK </h1>
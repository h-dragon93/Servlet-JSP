package com.edu.test;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

@WebServlet("/logProc")
public class LogInOutServlet extends HttpServlet {
	//로그인 처리
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		
		//1. Parameter 추출
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		//2. 유효성 체크
		if(id.isEmpty() || pwd.isEmpty() ){
			out.print("ID 또는 비밀번호를 입력해주세요");
			return;
		}
		//3. DB 데이타와 비교 
		//4. 로그인 상태 여부 판단
		HttpSession session = req.getSession();
		if(session.isNew() ||  session.getAttribute("id") == null  ){
		     //5. 로그인 처리
			session.setAttribute("id", id);  
			out.print("로그인되었습니다.");
		}else{
			out.print("현재 로그인상태입니다.");
		}
		// 6. 로그인 처리 후 메인페이지로 redirect 예시
		resp.sendRedirect("/edu/name.html");
		out.close();
	}
	// 로그아웃 처리
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter out = resp.getWriter();
		HttpSession session = req.getSession(false);
		// 세션이 존재하고 있었으면
		if(session!=null && session.getAttribute("id") != null ){
			session.invalidate();
			out.print("로그아웃 되셨습니다.");
		// 세션이 존재하지 않고있었으면
		}else{
			out.print("현재 로그인 상태가 아닙니다.");
		}
		out.close();
	}
}

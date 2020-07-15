package com.edu.test;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	//오버라이드 -> 상속 받아서 재정의 했음을 의미하므로 선언부는 변경할 수 없고 바디 부분만 변경 가능
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() executed");
	}
	
	@Override
	public void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service() executed");
	}
}

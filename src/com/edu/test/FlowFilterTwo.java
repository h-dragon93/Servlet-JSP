package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

public class FlowFilterTwo implements Filter {
	
	String charset;
	
	public void init(FilterConfig fc) throws ServletException {
		System.out.println("init called");
		charset = fc.getInitParameter("code");
	}
	
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("doFilter 호출전");
		chain.doFilter(req, resp);
		System.out.println("doFilter 호출후");
	}

	public void destroy() {}

}

package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;

@WebServlet("/product_proc")
public class ProductProcTest extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> Get Method requested");
		//파라미터 추출

		//입력안된 파라미터 검증은 if == null 로 하는게 아니라 데이터 길이 == 0 으로 해야함
	
		out.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {		
		// 한글 인코딩 처리
		resp.setContentType("text/html; charset=utf-8");
		req.setCharacterEncoding("utf-8");
		// 파라미터 추출
		String product  = req.getParameter("product");
		int price = Integer.parseInt(req.getParameter("price"));
		int quantity = Integer.parseInt(req.getParameter("quantity"));
		// 화면에 출력
		PrintWriter out = resp.getWriter();
		out.print("<h1> Post Method requested");
		out.print("<h1> 상품명 : " + product + "<br> 단가 : " + price + "<br> 수량 : "+ quantity + "<br> 주문금액 : " + (price*quantity));
		
		out.close();
	}

}
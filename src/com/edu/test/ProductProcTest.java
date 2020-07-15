package com.edu.test;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		String model  = req.getParameter("product");
		int price = Integer.parseInt(req.getParameter("price"));
		int cnt = Integer.parseInt(req.getParameter("quantity"));
		// 화면에 출력
		PrintWriter out = resp.getWriter();
		out.print("<h1> Post Method requested");
		out.print("<h1> 상품명 : "   + model + 
				  "<br> 단가 : "    + price + 
				  "<br> 수량 : "    + cnt + 
				  "<br> 주문금액 : " + (price*cnt));
		// 장바구니 넣기
		// HttpSession에 상품 등록
		Product p = new Product();
		p.setModel(model);
		p.setPrice(price);
		p.setCnt(cnt);
		
		ArrayList<Product> list = null;
		HttpSession session = req.getSession();
		if(session.getAttribute("basket") == null) {
			list = new ArrayList<>();
			session.setAttribute("basket", list);
		} else{
			list = (ArrayList<Product>) session.getAttribute("basket");
		};
		
		list.add(p);
		session.setAttribute("basket", list);
		
		out.close();
	}

}
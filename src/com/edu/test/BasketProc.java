package com.edu.test;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Enumeration;

@WebServlet("/basket")
public class BasketProc extends HttpServlet {
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.print("<h1> Order List");
		HttpSession session = req.getSession(false);
		Product p = null;
		ArrayList<Product> list = null;
		if(session != null) {
			System.out.println("here?");
			list = (ArrayList<Product>) session.getAttribute("basket");
		}
		if(list != null) {
			System.out.println("list" + list);
			for (int i = 0; i < list.size(); i++){
				p = list.get(i);
				out.print("<h1> 상품명 : " + p.getModel() + 
						  "<br> 단가 : " + p.getPrice() + 
						  "<br> 수량 : "+ p.getCnt());
				out.print("<br>=======================");
			}		
		} else {
			out.print("<h2> No product on List");
			System.out.println("strange");
		}
		out.close();
	}

}

<%@page import="com.edu.test.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String model = request.getParameter("model");
	int price = 0;
	int cnt = 0;
	try {
		price = Integer.parseInt(request.getParameter("price"));
	} catch (Exception e) {
		price = 0;
	}
	try {
		cnt = Integer.parseInt(request.getParameter("cnt"));
	} catch (Exception e) {
		cnt = 0;
	}

	Product p = new Product();
	p.setModel(model);
	p.setPrice(price);
	p.setCnt(cnt);

	request.setAttribute("product", p);

	if(model.isEmpty() || price == 0 || cnt == 0 ) {
		RequestDispatcher rd = request.getRequestDispatcher("product_input.jsp");
		request.setAttribute("msg", "모든 항목 입력해주세요");
		rd.forward(request, response);
		return;
	}
	
	RequestDispatcher rd = request.getRequestDispatcher("product_output.jsp");
	rd.forward(request, response);

%>

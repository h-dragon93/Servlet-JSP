<%@ page import="com.edu.test.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	Product p = (Product) request.getAttribute("product");
	String str = (String) request.getAttribute("msg");
	
	if(str == null) str = "";
	if(p == null) {
		p = new Product();
	}
%>

	<%= str %>

	<form action="productProc.jsp" method="post">
		<input type="hidden" name="code" value="delete">
		상품명     <input type="text" name="model" value="<%= p.getModel()%>"> <br>
		단가 :  <input type="text" name="price" value="<%= p.getPrice()%>"> <br>
		수량 :  <input type="text" name="cnt" value="<%= p.getCnt()%>"> <br>		
		<input type = "submit" 	value="주문">
	</form>
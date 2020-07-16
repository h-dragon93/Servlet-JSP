<%@page import="com.edu.test.Product"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% Product p = (Product) request.getAttribute("product"); %>

상품명 : <%= p.getModel() %> <br>
단가 :  <%= p.getPrice() %> <br>
수량 :  <%= p.getCnt()   %> <br>



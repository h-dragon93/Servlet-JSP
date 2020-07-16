<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<h1>exam05.jsp</h1>

<%-- <% String str = request.getParameter("p"); %>
<jsp:forward page="<%=str%>" /> --%>

<jsp:forward page="${param.p}"/>
<%@page import="com.leemanni.vo.UserStocksVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name = request.getParameter("name");
	int ownStocks = Integer.parseInt(request.getParameter("ownStocks"));
	int p_price = Integer.parseInt(request.getParameter("pPrice"));
	int c_price = Integer.parseInt(request.getParameter("cPrice"));
	UserStocksVO vo = new UserStocksVO(name, ownStocks, p_price, c_price);
%>
</body>
</html>
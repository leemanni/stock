<%@page import="com.leemanni.vo.UserStockList"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="com.leemanni.dao.StocksDAO"%>
<%@page import="com.leemanni.service.StocksService"%>
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
	// 작업의 종류
	String job = request.getParameter("job");
	String name = "";
	int ownStocks = 0;
	int p_price =0;
	int c_price =0;
	UserStocksVO vo = null;
	
	StocksService service = StocksService.getInstance();
	StocksDAO dao = StocksDAO.getInstance();
	
	// 작업의 종류에 따라 기능 분리!
	switch(job){
		case "insert":
			name = request.getParameter("name");
			ownStocks = Integer.parseInt(request.getParameter("ownStocks"));
			p_price = Integer.parseInt(request.getParameter("pPrice"));
			c_price = Integer.parseInt(request.getParameter("cPrice"));
			vo = new UserStocksVO(name, ownStocks, p_price, c_price);
			service.insert(vo);
			UserStockList stockList = new UserStockList();
			stockList.setStockList(service.selectList());
			out.println(stockList.getStockList());
			request.setAttribute("stockList", stockList);
			response.sendRedirect("stocksView.jsp");
			break;
			
		// 앞으로 수정, 삭제 기능 구현해!
	}
	
%>
</body>
</html>
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
	request.setCharacterEncoding("UTF-8");
	// 작업의 종류
	//boolean flag = Boolean.parseBoolean(request.getParameter("flag"));
	String job = request.getParameter("job");
	String name = "";
	int ownStocks = 0;
	int p_price = 0;
	int c_price = 0;
	UserStocksVO vo = null;
	
	StocksService service = StocksService.getInstance();
	StocksDAO dao = StocksDAO.getInstance();
	UserStockList stockList = new UserStockList();
	// 작업의 종류에 따라 기능 분리!
	if(job != null){
		switch(job){
			case "insert":
				name = request.getParameter("name");
				ownStocks = Integer.parseInt(request.getParameter("ownStocks"));
				p_price = Integer.parseInt(request.getParameter("pPrice"));
				c_price = Integer.parseInt(request.getParameter("cPrice"));
				vo = new UserStocksVO(name, ownStocks, p_price, c_price);
				service.insert(vo);
				break;
			case "search":
				stockList.setStockList(service.selectList());
				request.setAttribute("stockList", stockList);
				pageContext.forward("stocksView.jsp");
				break;
			case "delete":
				name = request.getParameter("name");
				service.delete(name);
				break;
			case "show":
				name = request.getParameter("name");
				stockList.setStockList(service.selectList());
				request.setAttribute("stockList", stockList);
				vo = service.getVO(name);
				request.setAttribute("stock", vo);
				break;
			case "update":
				name = request.getParameter("name");
				ownStocks = Integer.parseInt(request.getParameter("ownStocks"));
				p_price = Integer.parseInt(request.getParameter("pPrice"));
				c_price = Integer.parseInt(request.getParameter("cPrice"));
				vo = new UserStocksVO(name, ownStocks, p_price, c_price);
				service.update(vo);
				break;
		}
	}
	stockList.setStockList(service.selectList());
	request.setAttribute("stockList", stockList);
	pageContext.forward("stocksView.jsp");
	
	
%>
</body>
</html>
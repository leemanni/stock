<%@page import="com.leemanni.service.logInService"%>
<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<%@page import="com.leemanni.service.StocksService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>log-in check</title>
<link rel="shortcut icon" href=".././images/money_icons/favicon.ico">
</head>
<body>
	<%
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id").trim();
		String pw = request.getParameter("pw").trim();
	%>
	<jsp:useBean id="vo" class="com.leemanni.vo.LoginVO">
		<jsp:setProperty property="*" name="vo"/>
	</jsp:useBean>
	
	<%
		boolean check = logInService.getInstance().checkLogin(vo);
		request.setAttribute("flag", check);
		if(check){
			response.sendRedirect("stock.jsp?job=select");
			//pageContext.forward("stock.jsp");
		}else{
			pageContext.forward("loginMain.jsp");
		}
		
	%>
	
</body>
</html>
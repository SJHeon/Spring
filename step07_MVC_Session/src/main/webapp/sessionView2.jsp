<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionView2.jsp</title>
</head>
<body>
	<h2>sessionView2.jsp</h2>
	
	<h3>세션에 저장된 Customer 객체 데이터 값을 활용</h3>
	${sessionScope.customer.id } - ${sessionScope.customer.age }
	<hr>
	<a href="session/customerDelete.do">Delete customer</a><br>
	<a href="index.jsp">go to index.jsp</a>
	
</body>
</html>
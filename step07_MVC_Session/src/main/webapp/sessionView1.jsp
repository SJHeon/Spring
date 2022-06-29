<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sessionView1.jsp</title>
</head>
<body>
	<h2>sessionView1.jsp</h2>
	
	<div>id : ${sessionScope.id } </div>
	<div>age : ${sessionScope.age }</div>
	<div>job : ${sessionScope.job }</div>
	
	<hr>
	<h3>delete section</h3>
	<a href="session/jobDelete.do">Delete job</a><br>
	<a href="session/idAgeDelete.do">Delete id, age(mine)</a><br>
	<a href="session/sessionDelete.do">Delete id, age(teacher)</a><br>
	<a href="index.jsp">go to index.jsp</a>
	
</body>
</html>
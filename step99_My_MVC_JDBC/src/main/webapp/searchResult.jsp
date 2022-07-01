<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>searchResult.jsp</title>
</head>
<body>
	<h1>SEARCH RESULT PAGE</h1>
	<hr>
	DEPTNO - ${requestScope.deptno } <br>
	DNAME - ${requestScope.dname } <br>
	LOC - ${requestScope.loc } <br>
	<hr>
	<a href="searchByDeptno.jsp">go to searchByDeptno</a>
	
</body>
</html>
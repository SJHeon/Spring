<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	Cookie cookie1 = new Cookie("id", "test");
cookie1.setMaxAge(60 * 60);
response.addCookie(cookie1);

// Customer : String id, int age
HttpSession session1 = request.getSession();
session1.setAttribute("id", "heon");
session1.setAttribute("age", 26);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index.jsp</title>
</head>
<body>
	<h2>Index.jsp</h2>

	<hr>
	<h3>Cookie API Test</h3>
	<a href="cookieTest.do">CookieTest.do</a>

	<hr>
	<h3>Session API Test</h3>
	<a href="session/sessionTest1.do">1. session/sessionTest1.do</a>
	<br>
	<a href="session/sessionTest2.do?id=spring&age=29">2.
		session/sessionTest2.do : DTO 객체를 session에 저장/삭제</a>

	<hr>
	<!-- 로그인 성공 -> 로그아웃 버튼 뜨게 -->
	<!-- 로그인 실패 -> 로그인 버튼 유지 -->

	<%-- <h3>go to login</h3>
      <a href="session/loginForm.do">loginPage</a>
      <c:if test="${sessionScope.isAdmin == ture }"><a href="session/logout.do">logout</a></c:if> --%>

	<h3>로그인 하러 가기</h3>
	<a href="session/loginForm.do">로그인 하러 가기</a>

	<c:if test="${sessionScope.admin == 'true'}">
		<a href="session/logout.do">로그아웃</a>
	</c:if>
	
	<%-- <h3>go to login</h3>
	<c:if test="${sessionScope.password == '1234' }">
		<a href="session/logout.do">logout</a>
	</c:if>
	<a href="session/login.do">login</a> --%>
	<!-- <a href="session/loginForm.do">loginPage</a> -->




</body>
</html>
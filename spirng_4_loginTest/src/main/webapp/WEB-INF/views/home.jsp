<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<hr><br>

<p>${message }</p>

<c:choose>
	<c:when test="${mdto ne null}">
		${sessionScope.mdto.id } 
		<a href="member/logout"><h2>LOG OUT</h2></a>
		
	</c:when>
	<c:otherwise>
		
		<a href="member/login"><h2>LOG IN</h2></a>
		<a href="member/join"><h2>SIGN UP</h2></a>
	</c:otherwise>
</c:choose>





</body>
</html>

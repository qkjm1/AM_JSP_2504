<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
List<Map<String, Object>> articleRows = (List<Map<String, Object>>) request.getAttribute("articleRows");
%>






<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h1>게시글 목록</h1>



	<a href="http://localhost:8080/AM_JSP_2504/article/detail"
		target="_blank">디테일 새 탭</a>


	<a href="http://localhost:8080/AM_JSP_2504/article/list"
		target="_blank">리스트 새 탭</a>
		
	<a href="http://localhost:8080/AM_JSP_2504/home/main"
		target="_blank">메인</a>

	<ul>
		<%
		for (Map<String, Object> articleRow : articleRows) {
		%>
		<li><%=articleRow.get("id")%>번,<%=articleRow.get("regDate")%>, <a
			href="detail?id=<%=articleRow.get("id")%>"><%=articleRow.get("title")%></a>,<%=articleRow.get("body")%></li>
		<%
		}
		%>
	
</body>
</html>
<%@page import="java.util.*" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<%
boolean isSigned = (boolean) request.getAttribute("isSigned");
int SignedMemberId = (int) request.getAttribute("SignedMemberId");
Map<String, Object> SignedMember = (Map<String, Object>) request.getAttribute("SignedMember");
%>

<!DOCTYPE html>
<html>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/tailwindcss/2.1.4/tailwind.min.css">
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>


 <head>
 @@ -10,11 +18,34 @@
 </head>
 <body>
 	<h1>메인 페이지</h1>
 	<div><%=SignedMemberId %>번 회원 로그인 중</div>
 	<div><%=SignedMember %></div>
 
 	<%
 	if (isSigned) {
 	%>
 	<div>
 		<a href="../member/doLogout">로그아웃</a>
 	</div>
 	<%
 	}
 	%>
 
 	<%
 	if (!isSigned) {
 	%>
 	<div>
 		<a href="../member/login">로그인</a>
 	</div>
 	<%
 	}
 	%>
 
 	<ul>
 		<li><a href="../article/list">리스트로 이동</a></li>
 		<li><a href="../article/write">글쓰기</a></li>
 		<li><a href="../member/join">회원가입</a></li>
 		<li><a href="../member/login">로그인</a></li>
 	</ul>
 
 </body>
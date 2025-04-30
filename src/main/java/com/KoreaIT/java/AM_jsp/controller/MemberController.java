package com.KoreaIT.java.AM_jsp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.KoreaIT.java.AM_jsp.service.MemberService;
import util.DBUtil;
import util.SecSql;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class MemberController {
	private HttpServletRequest request;
	private HttpServletResponse response;
	private Connection conn;

	private MemberService memverService;

	public MemberController(HttpServletRequest request, HttpServletResponse response, Connection conn) {
		this.conn = conn;
		this.request = request;
		this.response = response;

		this.memverService = new MemberService(conn);
	}

	// 멤버기능들 메서드로 넣기
	public void doJoin() throws IOException, ServletException{	
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		String name = request.getParameter("name");
		
		SecSql sql = SecSql.from("SELECT COUNT(*) AS cnt FROM `member`");
		sql.append("WHERE loginId = ?", loginId );

		boolean isJoinableLoginId = DBUtil.selectRowIntValue(conn, sql) == 0;

		if (isJoinableLoginId == false) {
			response.getWriter().append(String
					.format("<script>alert('%s는 이미 사용중'); location.replace('../member/join');</script>", loginId));
		}

		sql = SecSql.from("INSERT INTO `member`");
		sql.append("SET regDate = NOW(),");
		sql.append("loginId = ?,", loginId);
		sql.append("loginPw = ?,", loginPw);
		sql.append("`name` = ?;", name);

		int id = DBUtil.insert(conn, sql);

		response.getWriter().append(
				String.format("<script>alert('%d번 회원이 가입됨'); location.replace('../article/list');</script>", id));
	}
	
	public void doLogin() throws IOException, ServletException{	
		String loginId = request.getParameter("loginId");
		String loginPw = request.getParameter("loginPw");
		
		SecSql sql = SecSql.from("SELECT *");
		sql.append("FROM `member`");
		sql.append("WHERE loginId = ?;", loginId);

		Map<String, Object> memberRow = DBUtil.selectRow(conn, sql);

		System.out.println(memberRow);

		if (memberRow.isEmpty()) {
			response.getWriter().append(String.format(
					"<script>alert('%s는 없는 아이디야'); location.replace('../member/login');</script>", loginId));
			return;
		}
		if (memberRow.get("loginPw").equals(loginPw) == false) {
			response.getWriter().append(String
					.format("<script>alert('비밀번호 불일치'); location.replace('../member/login');</script>", loginId));
			return;
		}
		
		HttpSession session = request.getSession();
		session.setAttribute("loginedMember", memberRow);
		session.setAttribute("loginedMemberId", memberRow.get("id"));
		session.setAttribute("loginedMemberLoginId", memberRow.get("loginId"));

		response.getWriter().append(String.format(
				"<script>alert('%s님 로그인됨'); location.replace('../home/main');</script>", memberRow.get("name")));

	}
	
	public void doLogout() throws IOException, ServletException {
				
		HttpSession session = request.getSession();
		session.removeAttribute("loginedMember");
		session.removeAttribute("loginedMemberId");
		session.removeAttribute("loginedMemberLoginId");

		response.getWriter().append(String.format(
				"<script>alert('로그아웃 됨'); location.replace('../home/main');</script>"));

	}
	
	public void showJoin() throws IOException, ServletException {

			request.getRequestDispatcher("/jsp/member/join.jsp").forward(request, response);

	}
	
	public void  showLogin() throws IOException, ServletException {

			request.getRequestDispatcher("/jsp/member/login.jsp").forward(request, response);

	}
	
	
	
}

package com.KoreaIT.java.AM_jsp.service;

import java.sql.Connection;
import java.util.List;
import java.util.Map;

import util.DBUtil;
import util.SecSql;


public class MemberService {

	private Connection conn;
	
	public MemberService(Connection conn) {
		this.conn = conn;
	}

	public int getMemTotalCnt() {
		SecSql sql = SecSql.from("SELECT COUNT(*)");
		sql.append("FROM member;");

		return DBUtil.selectRowIntValue(conn, sql);
	}

}

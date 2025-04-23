package com.KoreaIT.java.AM_jsp;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/printdan")
public class printdanserlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		String parameterValue = request.getParameter("dan");
		String parameterLimit = request.getParameter("limit");
		String parameterText = request.getParameter("color");
		
		
		if(parameterValue == null) {
			parameterValue = "1";
		}
		if(parameterLimit == null) {
			parameterLimit = "1";
		}
		if(parameterText == null) {
			parameterText = "black";
		}
		
		
		System.out.println(parameterValue);
		System.out.println(parameterLimit);
		System.out.println(parameterText);
		
		
		int dan = Integer.parseInt(parameterValue);
		int limit = Integer.parseInt(parameterLimit);
		
		
//		

		response.getWriter().append(String.format("==%d단==<br>",dan));
		
		for (int i = 1; i <= limit; i++) {
			response.getWriter().append(String.format("%d * %d = %d<br>", dan, i, dan * i));
		}
		
		response.getWriter().append(String.format("<html style='color: " + parameterText + ";'></html>"));

	}
	

}

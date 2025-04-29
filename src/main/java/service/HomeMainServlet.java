package service;

import java.io.IOException;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/home/main")
public class HomeMainServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		boolean isSigned = false;
		int SignedMemberId = -1;
		Map<String, Object> SignedMember = null;
		
		if(session.getAttribute("SignedMemberId") != null) {// 뭐라도 로그인이 되어잇음
			isSigned = true;
			SignedMemberId = (int) session.getAttribute("SignedMemberId");
			SignedMember = (Map<String, Object>) session.getAttribute("SignedMemberId");
		}
		
		request.setAttribute("isSigned", isSigned);
		request.setAttribute("SignedMemberId", SignedMemberId);
		request.setAttribute("SignedMember", SignedMember);

		request.getRequestDispatcher("/jsp/home/main.jsp").forward(request, response);
	}
	

}

package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frontcontroller.IController;

/**
 * Servlet implementation class LoginService
 */

public class LoginService implements IController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String email = request.getParameter("email");
		String pw = request.getParameter("pw");
		
		MemberDTO dto=new MemberDTO(email, pw);
		MemberDAO dao= MemberDAO.getDAO();
		dto=dao.login(dto);
		//dto.toString();
		
		if (dto!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("info", dto);
		}
		response.sendRedirect("main.jsp");
	}

}

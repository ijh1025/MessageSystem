package com.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		MemberDTO dto=(MemberDTO)request.getSession().getAttribute("info");
		
		String pw = request.getParameter("pw");
		String tel = request.getParameter("tel");
		String add = request.getParameter("add");
		
		dto=new MemberDTO(dto.getEmail(),pw, tel, add);
		dto=MemberDAO.getDAO().update(dto);
		
		if (dto!=null) {
			HttpSession session= request.getSession();
			session.setAttribute("info", dto);
			response.sendRedirect("main.jsp");
		}else {
			response.sendRedirect("update.jsp");
		}
		
		
	}

}

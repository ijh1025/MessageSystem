package com.member;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.frontcontroller.IController;

/**
 * Servlet implementation class List
 */

public class List implements IController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<MemberDTO> list=MemberDAO.getDAO().selectAll();
		
		    request.setAttribute("list", list);
		    
		    RequestDispatcher dis =request.getRequestDispatcher("list.jsp"); 
			dis.forward(request, response);
		    
//			HttpSession session= request.getSession();
//			session.setAttribute("list", list);
//			response.sendRedirect("list.jsp");
//		
	}

}

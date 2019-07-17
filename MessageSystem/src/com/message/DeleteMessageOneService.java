package com.message;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class DeleteMessageOneService
 */
@WebServlet("/DeleteMessageOneService")
public class DeleteMessageOneService extends HttpServlet {
 	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");
		MessageDAO dao=new MessageDAO();
		int result=dao.deleteOne(num);
		
		response.sendRedirect("main.jsp");
				

 		
	}

}

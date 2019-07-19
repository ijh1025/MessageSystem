package com.message;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontcontroller.IController;



/**
 * Servlet implementation class DeleteMessageOneService
 */

public class DeleteMessageOneService implements IController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num=request.getParameter("num");
		MessageDAO dao=new MessageDAO();
		int result=dao.deleteOne(num);
		
		response.sendRedirect("main.jsp");
				

 		
	}

}

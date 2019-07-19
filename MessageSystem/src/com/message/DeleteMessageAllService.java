package com.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.frontcontroller.IController;

/**
 * Servlet implementation class DeleteMessageAllService
 */

public class DeleteMessageAllService implements IController{
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		
		MessageDAO dao=new MessageDAO();
		int cnt=dao.deleteAll(email);
		
		response.sendRedirect("main.jsp");
	}

}

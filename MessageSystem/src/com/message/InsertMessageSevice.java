package com.message;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.member.MemberDTO;

/**
 * Servlet implementation class InsertMessageSevice
 */
@WebServlet("/InsertMessageSevice")
public class InsertMessageSevice extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("EUC-KR");
		
		String send_name=request.getParameter("send_name");
		String recevice_email=request.getParameter("recevice_email");
		String message=request.getParameter("content");
		
		
		
		MessageDTO dto=new MessageDTO(send_name, recevice_email, message);
		MessageDAO dao= new MessageDAO();
		int cnt=dao.join(dto);
		
		
		if(cnt>0) {
			
		}
		response.sendRedirect("main.jsp");
	}

}

package com.frontcontroller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.joinService;


/**
 * Servlet implementation class MessageSystemFrontcontroller
 */
@WebServlet("*.do")
public class MessageSystemFrontcontroller extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("request ¹ß»ý");
		
		String reqUrl=request.getRequestURI();
//		System.out.println(reqUrl);
		String ctxPath=request.getContextPath();
//		System.out.println(ctxPath);
		String command=reqUrl.substring(ctxPath.length());
		System.out.println(command);
		if(command.equals("/JoinService.do")) {
			joinService joinService = new joinService();
			joinService.service(request, response);
		}
		
	}

}

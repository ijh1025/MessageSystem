package com.frontcontroller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.member.JoinService;
import com.member.List;
import com.member.LoginService;
import com.member.LogoutService;
import com.member.Update;
import com.message.DeleteMessageAllService;
import com.message.DeleteMessageOneService;
import com.message.InsertMessageSevice;



/**
 * Servlet implementation class MessageSystemFrontcontroller
 */
@WebServlet("*.do")
public class MessageSystemFrontcontroller extends HttpServlet {
	HashMap<String, IController> map;					//어레이 리스트 형식	
	@Override
	public void init() throws ServletException {		//객체가 생성될때 딱 한번만 생성되는 메소드
		map=new HashMap<String, IController>();
		map.put("/JoinService.do", new JoinService());
		map.put("/LoginService.do", new LoginService());
		map.put("/List.do", new List());
		map.put("/LogoutService.do", new LogoutService());
		map.put("/Update.do", new Update());
		map.put("/DeleteMessageAllService.do", new DeleteMessageAllService());
		map.put("/DeleteMessageOneService.do", new DeleteMessageOneService());
		map.put("/InsertMessageSevice.do", new InsertMessageSevice());
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("request 발생");
		
		String reqUrl=request.getRequestURI();
//		System.out.println(reqUrl);
		String ctxPath=request.getContextPath();
//		System.out.println(ctxPath);
		String command=reqUrl.substring(ctxPath.length());
		System.out.println(command);
		
		IController controller = map.get(command);
		
		controller.execute(request, response);
		
	}

}

package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StackNumberServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		1. 누적할 임의의 숫자를 생성
		int num = (int)(Math.random()*100)+1;
		
//		2. 누적되 있는 쿠키값(name : stackNumber)을 조회
		Cookie [] cookies = request.getCookies();
		
		String stackNumber = "";//누적된 숫자를 저장할 변수 - 쿠키로 전송될값
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				if(cookies[i].getName().equals("stackNumber")){
//					기존 Cookie에 저장된 누적 숫자들 + num(랜덤값)
					stackNumber = cookies[i].getValue()+","+num;
					break;     
				}
			}	
		}
		//첫 누적
		if(stackNumber.isEmpty()){
			stackNumber = stackNumber+num;
		}
		//쿠키 생성 및 전송 처리
		response.addCookie(new Cookie("stackNumber", stackNumber));
		
		RequestDispatcher rdp = request.getRequestDispatcher("/cookie/stack/request.jsp");
		rdp.forward(request, response);
	}
}














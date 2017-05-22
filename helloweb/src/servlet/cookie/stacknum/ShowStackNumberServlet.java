package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ShowStackNumberServlet extends HttpServlet{

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		쿠키값들 조회
		Cookie [] cookies = request.getCookies();
//		stackNumber 이름의 쿠키를 찾아 그 값을 request 속성 저장 영역에 binding
		String message = null;
		if(cookies != null){
			for(Cookie cookie : cookies){
				if(cookie.getName().equals("stackNumber")){
					message = cookie.getValue();
				}
			}
		}
		if(message != null){
			request.setAttribute("message", message);
		}else{
			request.setAttribute("message", "누적된 숫자가 없습니다.");
		}
		//response.jsp로 이동해 출력
		request.getRequestDispatcher("/cookie/stack/response.jsp").forward(request, response);
	}
}












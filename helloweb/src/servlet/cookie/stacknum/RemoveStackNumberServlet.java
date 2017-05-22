package servlet.cookie.stacknum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RemoveStackNumberServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie cookie = new Cookie("stackNumber", "");//삭제할 것이므로 값은 상관없다.
		cookie.setMaxAge(0);
		response.addCookie(cookie);
		
		
		RequestDispatcher rdp = request.getRequestDispatcher("/cookie/stack/request.jsp");
		rdp.forward(request, response);
	}

	
}

package hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * 	Servlet 클래스 구현
 * 	1.  public clss로 선언.
 * 	2.  javax.servlet.http.HttpServlet을 상속(extends) => Java EE의 api 
 * 	3.	매개변수 없는 생성자(no-argument생성자)필요 => 생성자는 default 생성자를 사용.
 * 	4. doGet() 또는  doPost() 메소드를 오버라이딩 => 서브릿이 서비스할 내용을 구현한다.
 * 		 	doGet() -> GET방식 요청을처리. doPost() -> POST방식 요청을 처리. 
 * 	5. 구현한 Servlet class를 톰캣에 등록															톰캣: Web서버 + Web Container 를 가지고 Web application 을  실행 시켜주는  소프트웨어 
 * 			 => 1.  web.xml (D.D 파일 - 배치설정자) 																					Web Container => 객체생성, 메소드 호출 한다.
 * 					2. Annotation을 이용해 등록. (서블릿 3.0부터 - 톰캣7)
 */
public class HelloServlet extends HttpServlet {

		public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
			
			Date date = new Date();//실행시점의 일시
			String current = String.format("%tY-%<tm-%<td %<tH:%<tM:%<tS", date);
			
			//SimpleDateFormat : java.util.Date --> String으로 변환 (format()) ,  String --> Date으로 변환(Parse())
			//yyyy: 년도(4자리), MM: 월(2자리), dd: 일(2), HH: 시간(24시간제-2자리), mm: 분(2자리), ss: 초(2자리)    => 한개씩 쓰면 1자리
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
			 
			String current2 = sdf.format(date);
//			Date dd = sdf.parse("2011-11-29 23:22:04");
			
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<!doctype htmml>");
			out.println("<html>");
			out.println("<head><title>현재 시간</title></head>");
			out.println("<body>");
			out.printf("현재 시간1 : %s<br>", current);
			out.printf("현재 시간2 : %s<br>", current2);
			out.println("</body></html>");
		}
	
	
	
}







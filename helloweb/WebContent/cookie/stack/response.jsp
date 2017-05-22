<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>쿠키 값들</h2>
<%= request.getAttribute("message") %>

<p>
<a href="/helloweb/cookie/stack/request.jsp">request.jsp</a>
</p>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% session.invalidate(); %>
<h3>您已成功退出本系统，两秒后跳转回首页！</h3>
<h3>如果没有跳转，请按<a href="index.jsp">这里</a>！</h3>

</body>
</html>
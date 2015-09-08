<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SuperMarket Manager</title>
</head>
<body>
	<%
		if (session.getAttribute("user") == null) {
	%>
	<form action="loginservlet" method="get">
		<input type="radio" name="select" value="cashier" checked>收银员
		<input type="radio" name="select" value="buyer">商品采购员 <input
			type="radio" name="select" value="storagemanager">库存管理员 <input
			type="radio" name="select" value="manager">超市经理<br> 账号：<input
			type="text" name="name"><br> 密码：<input type="password"
			name="pwd"><br> <input type="submit" value="登陆"><input
			type="reset" value="重置">
	</form>
	<%
		} else {
	%>
	<h2>
		您已登陆,身份是
		<%
		String job = (String) session.getAttribute("job");
			if (job.equals("cashier")) {
	%>
		Cashier(收银员)
		<%
		} else if (job.equals("manager")) {
	%>
		Manager(经理)
		<%
		} else if (job.equals("buyer")) {
	%>
		Buyer(采购员)
		<%
		} else if (job.equals("storagemanager")) {
	%>
		StorageManager(仓库管理员)
		<%
		}
	%>
		
		<br> 点击<a href="logout.jsp">注销</a>重新登录<br> 点击<a
			href="select.jsp">跳转</a>至用户页面<br>
	</h2>
	<%
		}
	%>
</body>
</html>
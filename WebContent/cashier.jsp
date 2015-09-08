<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="basicClass.*"%>
<%@ page import="tableClass.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cashier Page</title>
</head>
<body>
	<%
		if (session.getAttribute("user") != null && session.getAttribute("job").equals("cashier")) {
			String message = (String) session.getAttribute("message");
			cashier cas = (cashier) session.getAttribute("user");
			//manager man = manager.queryWithOutPwd(managerid);
			List<sell> sells = sell.cashierSell(cas.getId());
			Iterator<sell> sell = sells.iterator();
	%>
	<h2>
		工号:"<%=cas.getId()%>"收银员登录，点<a href="logout.jsp">此</a>注销
	</h2>
	<h5></h5>
	<%
		if (message != null) {
	%>
	<%=message%>
	<%
	session.setAttribute("message", null);
			}
	%>
	<form action="sellservlet" method="get">
		<table border="1" width="80%">
			<tr>
				<td>商品编号</td>
				<td>销售数量</td>
				<td>销售人员</td>
				<td>操作</td>
			</tr>
			<tr>
				<td><input type="text" name="idgoods"></td>
				<td><input type="text" name="quantity" value="0"></td>
				<td><input type="text" name="idcashier" value=<%=cas.getId()%>></td>
				<td><input type="submit" value="提交"></td>
			</tr>
		</table>
	</form>
	<hr>
	<hr>
	<h3>销售历史记录</h3>
	<table border="1" width="80%">
		<tr>
			<td>销售记录编号</td>
			<td>产品编号</td>
			<td>收银人员编号</td>
			<td>销售数量</td>
		</tr>

		<%
			while (sell.hasNext()) {
					sell se = sell.next();
		%>
		<tr>
			<td><%=se.getNumber()%></td>
			<td><%=se.getIdgoods()%></td>
			<td><%=se.getIdcashier()%></td>
			<td><%=se.getQuantity()%></td>


		</tr>
		<%
			}
		%>
	</table>
	<%
		} else {
	%>
	<h2>
		尚未登录或者非收银员账号，请<a href="index.jsp">返回首页</a>以收银员身份登录
	</h2>
	<%
		}
	%>

</body>
</html>
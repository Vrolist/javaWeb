<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="basicClass.*"%>
<%@ page import="tableClass.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Take Notes</title>
</head>
<body>
	<%
		if (session.getAttribute("id") != null ) {
			if(session.getAttribute("job").equals("cashier")){
			cashier cas = (cashier)session.getAttribute("user");
					//manager man = manager.queryWithOutPwd(managerid);
			List<sell> sells = sell.cashierSell(cas.getId());
			Iterator<sell> sell = sells.iterator();
	%>
	<h2>
		工号:"<%=cas.getId()%>"登录，点<a href="logout.jsp">此</a>注销
	</h2>
	<h5></h5>
	<form action="queryservlet" method="get">
		请输入收银人员编号或产品编号关键字:<input type="text" name="kword"> <input
			type="submit" value="查询">
	</form>
	<table border="1" width="80%">
		<tr>
			<td>销售记录编号</td>
			<td>产品编号</td>
			<td>收银人员</td>
			<td>销售数量</td>
			<td colspan="6">操 作</td>
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
		尚未登录或者非经理账号，请<a href="index.jsp">返回首页</a>以经理身份登录
	</h2>
	<%
		}}
	%>
</body>
</html>
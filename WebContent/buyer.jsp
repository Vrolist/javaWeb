<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="basicClass.*"%>
<%@ page import="tableClass.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Buyer Page</title>
</head>
<body>
	<%
		if (session.getAttribute("user") != null && session.getAttribute("job").equals("buyer")) {
			String message = (String) session.getAttribute("message");
			buyer buy = (buyer) session.getAttribute("user");
			//manager man = manager.queryWithOutPwd(managerid);
			List<factor> factors = factor.allfactor();
			Iterator<factor> fac = factors.iterator();
	%>
	<h2>
		工号:"<%=buy.getId()%>"采购员登录，点<a href="logout.jsp">此</a>注销
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
	<table border="1" width="80%">
		<tr>
			<td>表格编号</td>
			<td>工厂编号</td>
			<td>商品编号</td>
			<td>商品名</td>
			<td>商地址</td>
			<td>负责人</td>
			<td>操作</td>
		</tr>

		<%
			while (fac.hasNext()) {
					factor fa = fac.next();
		%>
		<tr>
			<td><%=fa.getNumber()%></td>
			<td><%=fa.getIdfactor()%></td>
			<td><%=fa.getIdgoods()%></td>
			<td><%=fa.getName()%></td>
			<td><%=fa.getAddress()%></td>
			<td><%=fa.getPrincipal()%></td>
			<td></td>
		</tr>
		<%
			}
		%>
	</table>
	<hr>
	<h4>增加厂家和商品信息</h4>
	<form action="factorservlet" method="get">
		<table border="1" width="80%">
			<tr>
				<td>厂商编号</td>
				<td>商品编号</td>
				<td>名字</td>
				<td>地址</td>
				<td>负责人</td>
			</tr>
			<tr>
				<td><input type="text" name="idfactor"></td>
				<td><input type="text" name="idgoods"></td>
				<td><input type="text" name="name"></td>
				<td><input type="text" name="address"></td>
				<td><input type="text" name="principal"></td>
				<td><input type="submit" value="新增"></td>
			</tr>
		</table>
	</form>
	<%
		} else {
	%>
	<h2>
		尚未登录或者非采购员账号，请<a href="index.jsp">返回首页</a>以采购员身份登录
	</h2>
	<%
		}
	%>

</body>
</html>
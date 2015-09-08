<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="basicClass.*"%>
<%@ page import="tableClass.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>StorageManager Page</title>
</head>
<body>
	<%
		if (session.getAttribute("user") != null && session.getAttribute("job").equals("storagemanager")) {

			storagemanager man = (storagemanager) session.getAttribute("user");
			String message = (String) session.getAttribute("message");
			//manager man = manager.queryWithOutPwd(managerid);
			List<storage> storages = storage.allstorage();
			Iterator<storage> storage = storages.iterator();
			
			List<factor> factors = factor.allfactor();
			Iterator<factor> fac = factors.iterator();
	%>
	<h2>
		工号:"<%=man.getId()%>"仓库管理员登录，点<a href="logout.jsp">此</a>注销
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
	<h4>库存信息</h4>
	<table border="1" width="80%">
		<tr>
			<td>商品编号</td>
			<td>库存数量</td>
			<td>商品售价</td>
			<!-- <td colspan="6">操 作</td> -->
		</tr>

		<%
			while (storage.hasNext()) {
				storage se = storage.next();
		%>
		<tr>
			<td><%=se.getIdgoods()%></td>
			<td><%=se.getQuantity()%></td>
			<td><%=se.getSell()%></td>

		</tr>
		<%
			}
		%>
	</table>
	<hr><hr>
	<h4>可供进货信息表</h4>
	<table border="1" width="80%">
		<tr>
			<td>表格编号</td>
			<td>工厂编号</td>
			<td>商品编号</td>
			<td>商品名</td>
			<td>商地址</td>
			<td>负责人</td>
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
		</tr>
		<%
			}
		%>
	</table>
	<hr><hr>
	<h4>进货单</h4>
	<form action="storagemanagerservlet" method="get">
	<table border="1" width="80%">
	<tr>
	<td>商品编号</td>
	<td>进货数量</td>
	<td>售价</td>
	<td>操作</td>
	</tr>
	<tr>
	<td><input type="text" name="idgoods"></td>
	<td><input type="text" name="quantity" value="1000"></td>
	<td><input type="text" name="sell" value="998.0"></imput>
	<td><input type="submit" value="提交"></td>
	</tr>
	</table>
	</form>
	<%
		} else {
	%>
	<h2>
		尚未登录或者非仓库管理员账号，请<a href="index.jsp">返回首页</a>以仓库管理员身份登录
	</h2>
	<%
		}
	%>
</body>
</html>
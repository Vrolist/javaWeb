<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="basicClass.*"%>
<%@ page import="tableClass.*"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		if (session.getAttribute("id") != null && session.getAttribute("job").equals("manager")) {

			String managerid = (String) session.getAttribute("id");

			//manager man = manager.queryWithOutPwd(managerid);
			List<sell> sells = sell.allSell();
			Iterator<sell> sell = sells.iterator();
	%>
	<!-- 
	<h2>
		工号:"<%=managerid%>"经理登录，点<a href="logout.jsp">此</a>注销
	</h2>
	<h5> 
		姓名：<%=man.getName()%>，电话：<%=man.getPhone()%>，工号：<%=man.getId()%>，部门：<%=man.getDepartmentNo()%>
		<a href="managerinformation.jsp">修改个人信息</a> <a href="managerpwd.jsp">修改密码</a>
		
	</h5>
	-->
	<table border="1" width="80%">
		<tr>
			<td>记录编号</td>
			<td>产品编号</td>
			<td>收银人员</td>
			<td>销售数量</td>
			<td>所属部门</td>
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
			<td><%=%></td>
			<td><a
				href="modificationStaffAllInformation.jsp?staffid=<%=emp.getId()%>&status=show&departmentid=<%=man.getDepartmentNo()%>">修改</a>
				<a
				href="alterservlet?id=<%=emp.getId()%>&status=deletestaff&departmentid=<%=man.getDepartmentNo()%>">删除</a>
			</td>
		</tr>
		<%
			}
		%>
		<td><a
			href="insertstaff.jsp?departmentid=<%=man.getDepartmentNo()%>">雇员添加</a>
		</td>
	</table>
	<%
		} else {
	%>
	<h2>
		尚未登录或者非经理账号，请<a href="index.jsp">返回首页</a>以经理身份登录
	</h2>
	<%
		}
	%>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Select</title>
</head>
<body>
	<%
		String job = (String) session.getAttribute("job");

		if (job.equals("cashier")) {
	%>
	<jsp:forward page="cashier.jsp"></jsp:forward>
	<%
		} else if (job.equals("manager")) {
	%>
	<jsp:forward page="manager.jsp"></jsp:forward>
	<%
		} else if (job.equals("buyer")) {
			
	%>
	<jsp:forward page="buyer.jsp"></jsp:forward>
	<%
		} else if(job.equals("storagemanager")){
	%>
	<jsp:forward page="storagemanager.jsp"></jsp:forward>
	<%
		} else {
	%>
	<jsp:forward page="logout.jsp"></jsp:forward>
	<%
		}
	%>
</body>
</html>
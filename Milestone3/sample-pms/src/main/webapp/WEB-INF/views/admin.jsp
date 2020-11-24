<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="bootstraplink.jsp"/>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<hr/>
	<div class="container">
	<div align=center>
	<h1>Admin Home</h1>
		</div>
		<hr/>
		<div>
			<h2>USERNAME : ${user.username}</h2>
			<h2><a href="logout">Logout</a></h2>
		</div>
		<hr/>
		<div align=center>
			<h2>MENU</h2>
			<h3><a href="${pageContext.request.contextPath}/admin/addnewrepui">Add backoffice representative</a></h3>
			<hr/>
		</div>
	 </div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
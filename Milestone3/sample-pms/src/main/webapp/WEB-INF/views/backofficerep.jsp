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
	<h1>Backoffice Representative Home</h1>
	</div>
		<hr/>
	<div>
		<span><h3>USERNAME : ${user.username}</h3></span>
		<span><h3><a href="logout">Logout</a></h3></span>
	</div>
		<hr/>
	<div align=center>
		<h2>MENU</h2>
		<h3><a href="${pageContext.request.contextPath}/backofficerep/addnewcompanyui">Add new company</a></h3>
		<h3><a href="${pageContext.request.contextPath}/backofficerep/addstockpricesui">Add stock prices</a></h3>
		<h3><a href="${pageContext.request.contextPath}/backofficerep/addcommodityui">Add commodity</a></h3>
		<h3><a href="${pageContext.request.contextPath}/backofficerep/generatecommissionreport">Generate commission report</a></h3>
		<hr/>
	 </div>
</div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PMS Dashboard</title>
</head>
<body>
	<h1>Welcome to PMS Dashboard!!!</h1>
	<hr>
	<jsp:include page="header.jsp" />
	<nav class="nav flex-column">
			<a class="nav-link" href="${pageContext.request.contextPath}/admin/home">SuperUser Dashboard</a>
			<a class="nav-link" href="${pageContext.request.contextPath}/user/home">Investor Dashboard</a>
	</nav>
</body>
</html>
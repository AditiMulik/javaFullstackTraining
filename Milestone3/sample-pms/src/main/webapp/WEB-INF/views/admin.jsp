<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
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
</html>
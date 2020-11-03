<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Portfolio Management System</title>


</head>
<body>
	<div align="center" class="container-fluid p-4">
		<div align="left" class="col-sm-4 border border-success rounded">
			<spring-form:form action="${pageContext.request.contextPath}/validate" method="POST">
				<h1 class="h3 mb-3 font-weight-normal">Welcome To PortFolio Management System</h1>
				<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
				<div class="form-group">
					<label>Enter user name</label> <input class="form-control" type="text" name="username" />
				</div>
				<div class="form-group">
					<label>Enter password</label> <input class="form-control" type="password" name="password" />
				</div>

				<div class="form-group">
					<input type="submit" value="Login" />
				</div>
				<div class="form-group">
                	<a href="register.jsp">New User</a>
                </div>
			</spring-form:form>
		</div>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="bootstraplink.jsp"/>
<title>Insert title here</title>
<style>
	.container{
		padding-left:400px;
		padding-right:400px;
	}
</style>
</head>
<body>
<jsp:include page="header.jsp"/>
	<hr/>
	<div class="container">
	<div align=center>
	<h1>Add New Backoffice Representative</h1>
		<spring:form action="addnewrep" method="post" modelAttribute="user">
			<div>
				<div class="form-group">
				<div><spring:label path="username">Enter username</spring:label></div>
				<div>
					<spring:input path="username" type="text"  class="form-control"/>
					<spring:errors path="username" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="password">Enter password</spring:label></div>
				<div>
					<spring:input path="password" type="text"  class="form-control"/>
					<spring:errors path="password" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<input type="submit" value="Save" />
			</div>
		</spring:form>
	 </div>
	 <hr/>
	 </div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
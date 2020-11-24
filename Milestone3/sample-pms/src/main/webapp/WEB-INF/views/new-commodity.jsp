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
	<h1>Add new commodity</h1>
		<spring:form action="addcommodity" method="post" modelAttribute="commodity">
			<div>
				<div class="form-group">
				<div><spring:label path="type">Enter type</spring:label></div>
				<div>
					<spring:input path="type" type="text"  class="form-control"/>
					<spring:errors path="type" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="price">Enter price</spring:label></div>
				<div>
					<spring:input path="price" type="text"  class="form-control"/>
					<spring:errors path="price" class="alert-danger"/>
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
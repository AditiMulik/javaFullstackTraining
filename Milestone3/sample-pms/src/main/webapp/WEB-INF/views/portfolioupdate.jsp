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
	<h1>Update Portfolio</h1>
		<spring:form action="portfolioupdate" method="post" modelAttribute="portfolio">
			<div>
				<div class="form-group">
				<div><spring:label path="additionamount">Enter amount to add</spring:label></div>
				<div>
					<spring:input path="additionamount" type="text"  class="form-control"/>
					<spring:errors path="additionamount" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/><div>
				<div class="form-group">
				<div><spring:label path="deletionamount">Enter amount to withdraw</spring:label></div>
				<div>
					<spring:input path="deletionamount" type="text"  class="form-control"/>
					<spring:errors path="deletionamount" class="alert-danger"/>
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
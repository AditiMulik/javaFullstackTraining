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
		<h1>Add new stock prices</h1>
			<spring:form action="addstockprices" method="post" modelAttribute="stockprices">
				<div>
					<div class="form-group">
				<div><spring:label path="companyCode">Enter companyCode</spring:label></div>
					<div>
						<spring:input path="companyCode" type="text"  class="form-control"/>
						<spring:errors path="companyCode" class="alert-danger"/>
					</div>
					</div>
				</div>
				<br/>
				<div>
					<div class="form-group">
				<div><spring:label path="stockprice">Enter stockprice</spring:label></div>
					<div>
						<spring:input path="stockprice" type="text"  class="form-control"/>
						<spring:errors path="stockprice" class="alert-danger"/>
					</div>
					</div>
				</div>
				<br/>
				<div>
					<div class="form-group">
				<div><spring:label path="currentprice">Enter currentprice</spring:label></div>
					<div>
						<spring:input path="currentprice" type="text"  class="form-control"/>
						<spring:errors path="currentprice" class="alert-danger"/>
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
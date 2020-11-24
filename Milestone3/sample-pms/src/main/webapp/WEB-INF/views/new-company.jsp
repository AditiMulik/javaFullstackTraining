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
	<h1>Add new company</h1>
		<spring:form action="addnewcompany" method="post" modelAttribute="company">
			<div>
				<div class="form-group">
				<div><spring:label path="code">Enter code</spring:label></div>
				<div>
					<spring:input path="code" type="text"  class="form-control"/>
					<spring:errors path="code" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="title">Enter title</spring:label></div>
				<div>
					<spring:input path="title" type="text"  class="form-control"/>
					<spring:errors path="title" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/><div>
				<div class="form-group">
				<div><spring:label path="operation">Enter operation</spring:label></div>
				<div>
					<spring:input path="operation" type="text"  class="form-control"/>
					<spring:errors path="operation" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="sharecount">Enter sharecount</spring:label></div>
				<div>
					<spring:input path="sharecount" type="text"  class="form-control"/>
					<spring:errors path="sharecount" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="shareprice">Enter shareprice</spring:label></div>
				<div>
					<spring:input path="shareprice" type="text"  class="form-control"/>
					<spring:errors path="shareprice" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="sector">Enter sector</spring:label></div>
				<div>
					<spring:input path="sector" type="text"  class="form-control"/>
					<spring:errors path="sector" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="currency">Enter currency</spring:label></div>
				<div>
					<spring:input path="currency" type="text"  class="form-control"/>
					<spring:errors path="currency" class="alert-danger"/>
				</div>
				</div>
			</div>
			<br/>
			<div>
				<div class="form-group">
				<div><spring:label path="turnover">Enter turnover</spring:label></div>
				<div>
					<spring:input path="turnover" type="text"  class="form-control"/>
					<spring:errors path="turnover" class="alert-danger"/>
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
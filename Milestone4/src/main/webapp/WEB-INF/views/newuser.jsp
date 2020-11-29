<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="common.jsp"/>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>New User Registration</h1>
      <hr>
      <spring:form action="newuser" method="post" modelAttribute="user">
		<div>
			<div class="form-group col-xs-4">
			<div><spring:label path="username">Enter username</spring:label></div>
			<div>
				<spring:input path="username" type="text"  class="form-control"/>
				<spring:errors path="username" class="alert-danger"/>
			</div>
			</div>
		</div>
		<br/>
			<div class="col-xs-9"></div>
		<div>
			<div class="form-group col-xs-4">
			<div><spring:label path="password">Enter password</spring:label></div>
			<div>
				<spring:input path="password" type="text"  class="form-control"/>
				<spring:errors path="password" class="alert-danger"/>
			</div>
			</div>
		</div>
		<br/>
			<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<input type="submit" value="Save" class="form-control"/>
		</div>
	</spring:form>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
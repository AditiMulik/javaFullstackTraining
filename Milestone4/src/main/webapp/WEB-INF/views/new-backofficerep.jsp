<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
	<jsp:include page="common.jsp"/>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>
      		<security:authentication property="principal.username"/>
      	</a></li>
        <li><span class="glyphicon glyphicon-log-out"></span>
        	<spring:form action="${pageContext.request.contextPath}/logout" method="POST">
				<input type="submit" value="Logout" />
			</spring:form>
        </li>
      </ul>
    </div>
  </div>
</nav>
  
<div class="container-fluid text-center">    
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <p><a href="${pageContext.request.contextPath}/admin/addnewrepui">Add backoffice representative</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Add New Backoffice Representative</h1>
      <hr>
      <spring:form action="addnewrep" method="post" modelAttribute="user">
			<div>
				<div class="form-group col-xs-4">
				<div><spring:label path="username">Enter username</spring:label></div>
				<div>
					<spring:input path="username" type="text"  class="form-control"/>
					<spring:errors path="username" class="alert-danger"/>
				</div>
				</div>
			</div>
			<div class="col-xs-9"></div>
			<br/>
			<div>
				<div class="form-group col-xs-4">
				<div><spring:label path="password">Enter password</spring:label></div>
				<div>
					<spring:input path="password" type="text"  class="form-control"/>
					<spring:errors path="password" class="alert-danger"/>
				</div>
				</div>
			</div>
			<div class="col-xs-9"></div>
			<br/>
			<div>
				<div class="form-group col-xs-4">
					<input type="submit" value="Save" class="form-control"/>
				</div>
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

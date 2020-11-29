<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring" %> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>   
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
    <div align=center> 
      <h1>Profile Management Service</h1>
      <hr>
	      <core:if test="${param.error != null}">
				<i>Invalid Credentials!</i>
			</core:if>
			<spring:form action="${pageContext.request.contextPath}/validate" method="post" modelAttribute="user">
				<div class="col-xs-5"></div>
				<div class="form-group col-xs-2">
					<div><spring:label path="username">Enter username</spring:label></div>
					<div>
						<spring:input path="username" type="text" class="form-control" />
						<spring:errors path="username" class="alert-danger"/>
					</div>
				</div>
				<div class="col-xs-9"></div>
				<div class="col-xs-5"></div>
				<div class="form-group col-xs-2">	
					<div><spring:label path="password">Enter password</spring:label></div>
					<div>
						<spring:input path="password" type="text" class="form-control"/>
						<spring:errors path="password" class="alert-danger"/>
					</div>
				</div>
				<div class="col-xs-9"></div>
				<div class="col-xs-5"></div>
				<div class="form-group col-xs-2">
				<input type="submit" value="Login" class="btn btn-primary form-control"/>
				</div>	
				<div class="form-group col-xs-9"></div>
				<div class="col-xs-4"></div>	
				<div class="form-group col-xs-4">
					<div><a href="${pageContext.request.contextPath}/registerui">Register new user here</a></div>
				</div>
			</spring:form>
		 </div>
		 </div>
			<core:if test="${param.logout != null}">
				<i>You have been logged out successfully!</i>
			</core:if>
    </div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
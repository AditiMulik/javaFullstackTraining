<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
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
      <p><span class="glyphicon glyphicon-menu-hamburger"></span>MENU</p>
      <p><a href="${pageContext.request.contextPath}/admin/addnewrepui">Add backoffice representative</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Admin Home</h1>
      <hr>
      
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>
<!--<core:if test="${param.saved != null}">
	<i>This is the saved id = ${userOutput.username}</i>
</core:if> -->
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
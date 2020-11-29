<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
  <title>Pofile Management Service</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> 
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
    .row.content {height: 450px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      padding-top: 20px;
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height:auto;} 
    }
  </style>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="${pageContext.request.contextPath}/admin/home">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
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

<footer class="container-fluid text-center">
  <jsp:include page="footer.jsp"/>
</footer>

</body>
</html>

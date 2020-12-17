<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
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
        <li class="active"><a href="${pageContext.request.contextPath}/backofficerep/home">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>
      		<security:authentication property="principal.username"/>
      	</a></li>
        <li>
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
      <p><a href="${pageContext.request.contextPath}/backofficerep/addnewcompanyui">Add new company</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/addstockpricesui">Add stock prices</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/addcommodityui">Add commodity</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/generatecommissionreport">Generate commission report</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Add new company</h1>
      <hr/>
      <spring:form action="addnewcompany" method="post" modelAttribute="company">
		<div class="form-group col-xs-4">
			<spring:label path="code">Enter code</spring:label>
			<spring:input path="code" type="text"  class="form-control input-sm"/>
			<spring:errors path="code" class="alert-danger"/>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="title">Enter title</spring:label>
				<spring:input path="title" type="text"  class="form-control input-sm"/>
				<spring:errors path="title" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="operation">Enter operation</spring:label>
				<spring:input path="operation" type="text"  class="form-control input-sm"/>
				<spring:errors path="operation" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="sharecount">Enter sharecount</spring:label>
				<spring:input path="sharecount" type="text"  class="form-control input-sm"/>
				<spring:errors path="sharecount" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="shareprice">Enter shareprice</spring:label>
				<spring:input path="shareprice" type="text"  class="form-control input-sm"/>
				<spring:errors path="shareprice" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="sector">Enter sector</spring:label>
				<spring:input path="sector" type="text"  class="form-control input-sm"/>
				<spring:errors path="sector" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="currency">Enter currency</spring:label>
				<spring:input path="currency" type="text"  class="form-control input-sm"/>
				<spring:errors path="currency" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div class="form-group col-xs-4">
			<div><spring:label path="turnover">Enter turnover</spring:label>
				<spring:input path="turnover" type="text"  class="form-control input-sm"/>
				<spring:errors path="turnover" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-11"></div>
		<div class="form-group col-xs-2">
			<input type="submit" value="Save" class="form-control"/>
		</div>
	</spring:form>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>
<footer class="container-fluid text-center">
  <p>A Java training initiative</p>
</footer>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
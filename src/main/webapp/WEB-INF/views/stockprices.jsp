<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %>  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      <p><a href="${pageContext.request.contextPath}/backofficerep/addnewcompanyui">Add new company</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/addstockpricesui">Add stock prices</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/addcommodityui">Add commodity</a></p>
	  <p><a href="${pageContext.request.contextPath}/backofficerep/generatecommissionreport">Generate commission report</a></p>
    </div>
    <div class="col-sm-8 text-left"> 
      <h1>Add new stock prices</h1>
      <hr>
      <spring:form action="addstockprices" method="post" modelAttribute="stockprices">
			<div class="form-group col-xs-4">
				<spring:label path="companyCode">Enter companyCode</spring:label>
				<div>
					<spring:input path="companyCode" type="text"  class="form-control" list="companies" name="companies" id="company" placeholder="Select company code"/>
					<datalist id="companies">
					  	<c:forEach items="${companylist}" var="companies" varStatus="count">
					  	<option value="${companies.code}">
					    </c:forEach>
					  </datalist>
					<spring:errors path="companyCode" class="alert-danger"/>
				</div>
			</div>
			<br/>
			<div class="col-xs-9"></div>
			<div class="form-group col-xs-4">
				<label path="stockprice">Current stockprice</label>
				<div>
					<input id="currentstockprice" list="companyprice" type="text"  class="form-control" readonly onclick="myFunction()"/>
					<datalist id="companyprice">
					  	<c:forEach items="${companylist}" var="companies" varStatus="count">
					  	<option value="${companies.shareprice}" id="${companies.code}">
					    </c:forEach>
					  </datalist>
				</div>
			</div>
			<br/>
			<div class="col-xs-9"></div>
			<div class="form-group col-xs-4">
				<spring:label path="currentprice">Current price (USD)</spring:label>
				<div>
					<div>
					<input id="currentprices" list="currentprice" class="form-control" readonly/>
					<datalist id="currentprice">
					  	<c:forEach items="${companylist}" var="companies" varStatus="count">
					  	<option value="${companies.sharepriceusd}" id="${companies.code}usd">
					    </c:forEach>
					  </datalist>
				</div>
				</div>
			</div>
			<br/>
			<div class="col-xs-9"></div>
			<div class="form-group col-xs-4">
				<spring:label path="stockprice">Enter latest stockprice</spring:label>
				<div>
					<spring:input id="stockprice" path="stockprice" type="text"  class="form-control"/>
					<spring:errors path="stockprice" class="alert-danger"/>
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
<script>
function myFunction() {
  var x = document.getElementById('company').value;
  var y = document.getElementById(x).value;
  document.getElementById('currentstockprice').value = y;
  var z = document.getElementById(x+'usd').value;
  document.getElementById('currentprices').value = z;
  document.getElementById('currentpricesdummy').value = z;
  
}
</script>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri= "http://www.springframework.org/tags/form" prefix="spring"%> 
<%@taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<!DOCTYPE html>
<html>
<head>
<script src="https://cdn.anychart.com/releases/8.9.0/js/anychart-base.min.js" type="text/javascript"></script>
<jsp:include page="common.jsp"/>
<script>
  anychart.onDocumentLoad(function () {
	var chart = anychart.line();
	chart.spline(
	[
	  <c:forEach items="${commissionList}" var="commission" varStatus="count">
	    ['${commission.stockdate}', ${commission.commissionAmount}],
	  </c:forEach>
	]);
    chart.title("Commission Report");
    chart.container("container");
    chart.draw();
  });
</script>
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
      <h1>Commission Report</h1>
      <div id="container" style="width: 500px; height: 400px;"></div>
      <hr>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>
<jsp:include page="footer.jsp"/>

</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
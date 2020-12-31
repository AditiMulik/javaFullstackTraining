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
	    	<c:forEach items="${portfolioReportOutputList}" var="portfolioReport" varStatus="count">
	      	['${portfolioReport.reportdate}', ${portfolioReport.portfolioReportValue}],
	      	</c:forEach>
	    ]);
    chart.title("Portfolio Report");
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
        <li class="active"><a href="${pageContext.request.contextPath}/investor/home">Home</a></li>
      </ul>
      <ul class="nav navbar-nav navbar-right">
      	<li class="active"><a href="#"><span class="glyphicon glyphicon-user"></span>
      		<security:authentication property="principal.username"/>
      	</a></li>
      	<li class="active"><a href="#">
      		Current portfolio value   : ${portfolioReportOutput.portfolioReportValue}
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
      <p><a href="${pageContext.request.contextPath}/investor/earningtrend">Check earning trend</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/searchcompanyui">Search companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/comparecompanyui">Compare companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/stockexchange">Stock exchange</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/portfolioupdateui">Update portfolio</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/generateportfolioreport">Generate portfolio report</a></p>
      </div>
    <div class="col-sm-8 text-left"> 
      <h1>Portfolio Report</h1>
      <hr>
      <div id="container" style="width: 500px; height: 400px;"></div>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
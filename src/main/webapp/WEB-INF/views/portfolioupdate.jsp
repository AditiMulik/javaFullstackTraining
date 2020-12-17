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
        <li class="active"><a href="${pageContext.request.contextPath}/investor/home">Home</a></li>
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
      <p><a href="${pageContext.request.contextPath}/investor/earningtrend">Check earning trend</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/searchcompanyui">Search companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/comparecompanyui">Compare companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/stockexchange">Stock exchange</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/portfolioupdateui">Update portfolio</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/generateportfolioreport">Generate portfolio report</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/home">Set Currency Preference</a></p>
      </div>
    <div class="col-sm-8 text-left"> 
      <h1>Update Portfolio</h1>
      <hr>
      <p>Current Portfolio amount: ${portfolioOutputDto.portfolioValue}</p>
      <button class="btn btn-default" type="submit" onclick="displayAdd()">Add amount</button>
      <button class="btn btn-default" type="submit" onclick="displayWithdraw()">Withdraw amount</button>
      <spring:form action="portfolioupdate" method="post" modelAttribute="portfolio">
		<div id="displayAdd" class="form-group col-xs-4" style="display:none">
			<div><spring:label path="additionamount">Enter amount to add</spring:label></div>
			<div>
				<spring:input path="additionamount" type="text"  class="form-control" value="0"/>
				<spring:errors path="additionamount" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="displayWithdraw" class="form-group col-xs-4" style="display:none">
			<div><spring:label path="deletionamount">Enter amount to withdraw</spring:label></div>
			<div>
				<spring:input path="deletionamount" type="text"  class="form-control" value="0"/>
				<spring:errors path="deletionamount" class="alert-danger"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="saveForm" class="form-group col-xs-4" style="display:none">
			<input type="submit" value="Save" class="form-control"/>
		</div>
	</spring:form>
    </div>
    <div class="col-sm-2 sidenav"></div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
<script>
function displayAdd(){
	var displayAdd = document.getElementById("displayAdd");
	var displayWithdraw = document.getElementById("displayWithdraw");
	var saveForm = document.getElementById("saveForm");
	displayAdd.style.display = "block";
	displayWithdraw.style.display = "none";
	saveForm.style.display = "block";
}
function displayWithdraw(){
	var displayWithdraw = document.getElementById("displayWithdraw");
	var displayAdd = document.getElementById("displayAdd");
	var saveForm = document.getElementById("saveForm");
	displayWithdraw.style.display = "block";
	displayAdd.style.display = "none";
	saveForm.style.display = "block";
}
</script>
</html>
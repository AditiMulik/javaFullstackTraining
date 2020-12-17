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
      <p><a href="${pageContext.request.contextPath}/investor/earningtrend">Check earning trend</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/searchcompanyui">Search companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/comparecompanyui">Compare companies</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/stockexchange">Stock exchange</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/portfolioupdateui">Update portfolio</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/generateportfolioreport">Generate portfolio report</a></p>
	  <p><a href="${pageContext.request.contextPath}/investor/home">Set Currency Preference</a></p>
      </div>
    <div class="col-sm-8 text-left"> 
      <h1>Stock Exchange Company</h1>
      <hr>
      <div id="display" >
       <spring:form action="tradecompany" method="post" modelAttribute="stockExchangeInputDto">
      	<h2>Selected company to trade   : <spring:input path="companyCode" type="text" id="type" class="form-control" value="${companydetail.code}"/></h2>
     	<h3>Company available sharecount: ${companydetail.sharecount}</h3>
      	<h3>Company share price         : ${companydetail.shareprice}</h3>
      	
		<div id="displayBuy" class="form-group col-xs-4" style="display:none">
			<div><label>Enter number of shares to buy</label></div>
			<div>
				<spring:input path="buyunitcount" type="text"  class="form-control" value="0"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="displaySell" class="form-group col-xs-4" style="display:none">
			<div><label>Enter number of shares to sell</label></div>
			<div>
				<spring:input path="sellunitcount" type="text"  class="form-control" value="0"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="saveForm" class="form-group col-xs-4" style="display:none">
			<input type="submit" value="Trade" class="form-control"/>
		</div>
	</spring:form>
	
      	<button class="btn btn-default" type="submit" onclick="displayBuy()">Buy stocks</button>
      	<button class="btn btn-default" type="submit" onclick="displaySell()">Sell stocks</button>
      </div>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
<script>
function displayBuy(){
	var displayBuy = document.getElementById("displayBuy");
	var displaySell = document.getElementById("displaySell");
	var saveForm = document.getElementById("saveForm");
	displayBuy.style.display = "block";
	displaySell.style.display = "none";
	saveForm.style.display = "block";
}
function displaySell(){
	var displaySell = document.getElementById("displaySell");
	var displayBuy = document.getElementById("displayBuy");
	var saveForm = document.getElementById("saveForm");
	displaySell.style.display = "block";
	displayBuy.style.display = "none";
	saveForm.style.display = "block";
}
</script>
</html>
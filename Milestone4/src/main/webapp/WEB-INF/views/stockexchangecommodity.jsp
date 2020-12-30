<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
      	<li class="active"><a href="#">
      		Current portfolio value   : ${portfolioReportOutput.portfolioReportValue}
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
      </div>
    <div class="col-sm-8 text-left"> 
      <h1>Stock Exchange Commodity</h1>
      <hr>
      <c:choose>
		    <c:when test="${empty commoditylist[0].type}">
		        No commodities to show.
		    </c:when>
		    <c:otherwise>
		        
      <div>
		<input type="text" id="myInput" onkeyup="myFunction()" placeholder="Search for names..">
		<table class="table" id="myTable">
				  <thead class="thead-light">
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Type</th>
				      <th scope="col">Price</th>
				    </tr>
				  </thead>
				  <tbody>
				  	<c:forEach items="${commoditylist}" var="commodities" varStatus="count">
				  		<tr onclick='showDisplayDiv(this)' id="${commodities.type}+${commodities.price}">
					      <th scope="row">1</th>
					      <td><c:out value="${commodities.type}"/></td>
					      <td><c:out value="${commodities.price}"/></td>
					      <td>
					      <c:set var = "unitcount" scope = "request" value="${0}" />
					      	<c:forEach items="${userItems}" var="items" varStatus="count">
					      		<c:if test="${items.commodityType eq commodities.type}">					      		
					      			<c:set var = "unitcount" scope = "request" value="${items.unitcount}" />
					      		</c:if>
					      	</c:forEach>
						      <button class="btn btn-default" type="submit" onclick='trial(${commodities.price},${portfolioOutputDto.portfolioValue},${unitcount})'>Select </button>
					     
					      </td>
					    </tr>
				  	</c:forEach>
				  </tbody>
				</table>
		
	</div>
	<div id="display" >
      <spring:form action="tradecommodity" method="post" modelAttribute="stockExchangeInputDto">
      	<h2>Selected commodity to trade   : <spring:input readonly="true" path="commodityType" type="text" id="type" class="form-control"/></h2>
     	<h4>Commodity price         : <p id="price"></p></h4>
      	<h4>Your unit count for the commodity        : ${unitcount}</h4>
     	<h4>Portfolio wallet balance : ${portfolioOutputDto.portfolioValue}</h4>
		<div id="displayBuy" class="form-group col-xs-4" style="display:none">
			<div><label>Enter number of units to buy</label></div>
			<div>
				<spring:input path="buyunitcount" type="text"  class="form-control" value="0"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="displaySell" class="form-group col-xs-4" style="display:none">
			<div><label>Enter number of units to sell</label></div>
			<div>
				<spring:input path="sellunitcount" type="text"  class="form-control" value="0"/>
			</div>
		</div>
		<div class="col-xs-9"></div>
		<div id="saveForm" class="form-group col-xs-4" style="display:none">
			<input type="submit" value="Trade" class="form-control"/>
		</div>
	</spring:form>
		<c:if test="${portfolioOutputDto.portfolioValue>0}">		      	
		  <button id="buycommodity" class="btn btn-default" type="submit" onclick="displayBuy()">Buy commodity</button>
		</c:if>
      	
    	
      		<button id="sellcommodity" class="btn btn-default" type="submit" onclick="displaySell()">Sell commodity</button>
      	
      </div>
      </c:otherwise>
	</c:choose>
    </div>
    <div class="col-sm-2 sidenav">
    </div>
  </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
<script>
function showDisplayDiv( value1){
	var displayDiv = document.getElementById("display");
	displayDiv.style.visibility="visible";
	var res = value1.id.split("+");
	document.getElementById("type").value = res[0];
	document.getElementById("price").innerHTML = res[1];
}
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
function trial(cvalue,pvalue,unitcount){
	if(cvalue>pvalue){		
		var buycommodity = document.getElementById("buycommodity");
		buycommodity.style.display = "none";
	}
	if(unitcount<1){		
		var sellcommodity = document.getElementById("sellcommodity");
		sellcommodity.style.display = "none";
	}
}
</script>
</html>
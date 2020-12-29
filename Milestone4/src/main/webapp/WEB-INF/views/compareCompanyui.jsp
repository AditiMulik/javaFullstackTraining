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
      <h1>Compare companies</h1>
      <hr>
      <div>
	   <div class="input-group form-group col-xs-3">
	   		<input list="list1" name="companies" id="company1" placeholder="Select first company" class="form-control input-sm" >
			  <datalist id="list1">
			  	<c:forEach items="${companylist}" var="companies" varStatus="count">
			  	<option value="${companies.code}">
			    </c:forEach>
			  </datalist>
	    </div>
		<div class="input-group form-group col-xs-3">
	    	<input list="list2" name="companies" id="company2" placeholder="Select second company" class="form-control input-sm" >
			  <datalist id="list2">
			  	<c:forEach items="${companylist}" var="companies" varStatus="count">
			  	<option value="${companies.code}">
			    </c:forEach>
			  </datalist>
	    </div>
	    <button class="btn btn-default" type="submit" onclick="displayresult()">Compare</button>   
	    
	</div>
	<hr>
	<div class="col-sm-6" >
		<table class="table" id="myTable">
		  <thead class="thead-light">
		    <tr id="myTableHead">
		      <th scope="col">#</th>
		      <th scope="col">Code</th>
		      <th scope="col">Title</th>
		      <th scope="col">Operation</th>
		      <th scope="col">Sharecount</th>
		      <th scope="col">Shareprice</th>
		      <th scope="col">Sector</th>
		      <th scope="col">Currency</th>
		      <th scope="col">Turnover</th>
		    </tr>
		  </thead>
		  <tbody>
		  	<c:forEach items="${companylist}" var="companies" varStatus="count">
		  		<tr id="${companies.code}" style="visibility:hidden">
			      <th scope="row">1</th>
			      <td><c:out value="${companies.code}"/></td>
			      <td><c:out value="${companies.title}"/></td>
			      <td><c:out value="${companies.operation}"/></td>
			      <td><c:out value="${companies.sharecount}"/></td>
			      <td><c:out value="${companies.shareprice}"/></td>
			      <td><c:out value="${companies.sector}"/></td>
			      <td><c:out value="${companies.currency}"/></td>
			      <td><c:out value="${companies.turnover}"/></td>
			    </tr>
		  	</c:forEach>
		  </tbody>
		</table>
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
function displayresult(){
    var myTable=document.getElementById("myTable");
    var company1 = document.getElementById("company1").value;
    var company2 = document.getElementById("company2").value;
    console.log(company1);
    for (let row of myTable.rows) 
    {
    	row.style.visibility = "hidden";
    }
    document.getElementById("myTableHead").style.visibility = "visible";
    document.getElementById(company1).style.visibility = "visible";
    document.getElementById(company2).style.visibility = "visible";
}
</script>

</html>
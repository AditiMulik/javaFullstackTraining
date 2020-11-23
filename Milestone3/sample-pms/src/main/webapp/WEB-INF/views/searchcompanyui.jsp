<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
	<hr/>
	<div class="container">
	<div align=center>
	<h1>Search Company</h1>
	<div>
		<!--<form action="searchcompany"> </form> -->
		    <div class="input-group">
		    	<label for="company">Enter company code to search</label>
		      <input list="companies" name="companies" id="company">
				  <datalist id="companies">
				  	<c:forEach items="${companylist}" var="companies" varStatus="count">
				  	<option value="${companies.code}">
				    </c:forEach>
				  </datalist>
		        <button class="btn btn-default" type="submit" onclick="displayresult()"><i class="glyphicon glyphicon-search"></i></button>
		      
		    </div>
		  
	</div>
	<hr>
	<div id="display"></div>
	<hr/>
	</div>
</div>
<jsp:include page="footer.jsp"/>
</body>

<script>
function displayresult(){
    var display=document.getElementById("display");
    var company=document.getElementById("company");
    display.innerHTML="<h2>Search result:-</h2></br><h3>"+company.value+"</h3>";
}
</script>

</html>
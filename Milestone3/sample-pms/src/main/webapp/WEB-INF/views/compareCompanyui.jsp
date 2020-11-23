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
	<h1>Select companies to compare</h1>
	<div>
	   <div class="input-group">
	    	<label for="company1">Enter company code to search</label>
	      <input list="list1" name="companies" id="company1">
			  <datalist id="list1">
			  	<c:forEach items="${companylist}" var="companies" varStatus="count">
			  	<option value="${companies.code}">
			    </c:forEach>
			  </datalist>
	    </div>
		<div class="input-group">
	    	<label for="company2">Enter company code to search</label>
	      <input list="list2" name="companies" id="company2">
			  <datalist id="list2">
			  	<c:forEach items="${companylist}" var="companies" varStatus="count">
			  	<option value="${companies.code}">
			    </c:forEach>
			  </datalist>
	    </div>
	    <button class="btn btn-default" type="submit" onclick="displayresult()">Compare</button>   
	</div>
	<hr>
	<div>
		<table id="display" class="table">
		</table>
	</div>
	<hr/>
	</div>
	</div>
<jsp:include page="footer.jsp"/>
</body>

<script>
function displayresult(){
    /*var c1=document.getElementById("c1");
    var c2=document.getElementById("c2");
    var company1=document.getElementById("company1");
    var company2=document.getElementById("company2");
    c1.innerHTML=company1.value;
    c2.innerHTML=company2.value;*/
    var display=document.getElementById("display");
    display.innerHTML="<thead class='thead-dark'><tr><td>Company1</td><td>Company2</td></tr></thead><tbody><tr><td>"+document.getElementById("company1").value+"</td><td>"+document.getElementById("company2").value+"</td></tr></tbody>"
}
</script>

</html>
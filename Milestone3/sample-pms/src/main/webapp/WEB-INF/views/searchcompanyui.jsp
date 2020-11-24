<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<jsp:include page="bootstraplink.jsp"/>
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
<jsp:include page="bootstrapscripts.jsp"/>

<script>
function displayresult(){
    var display=document.getElementById("display");
    var company=document.getElementById("company");
    display.innerHTML="<h2>Search result:-</h2></br><h3>"+company.value+"</h3>";
}
</script>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Investor Home</h1>
		</div>
		<hr/>
		<div>
			<span><h3>USERNAME : ${user.username}</h3></span>
			<span><h3><a href="logout">Logout</a></h3></span>
		</div>
			<hr/>
		<div align=center>
		<h2>MENU</h2>
		<hr/>
		<h3><a href="${pageContext.request.contextPath}/investor/earningtrend">Check earning trend</a></h3>
		<h3><a href="${pageContext.request.contextPath}/investor/searchcompanyui">Search companies</a></h3>
		<h3><a href="${pageContext.request.contextPath}/investor/comparecompanyui">Compare companies</a></h3>
		<h3><a href="${pageContext.request.contextPath}/investor/stockexchange">Stock exchange</a></h3>
		<h3><a href="${pageContext.request.contextPath}/investor/portfolioupdateui">Update portfolio</a></h3>
		<h3><a href="${pageContext.request.contextPath}/investor/generateportfolioreport">Generate portfolio report</a></h3>
		<div>
			<label for="currencytype"><h3>Currency selection:</h3></label>
			  <select id="currency">
			    <option value="INR">INR</option>
			    <option value="USD">USD</option>
			  </select>
		</div>
		<hr/>
	 </div>
	 </div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
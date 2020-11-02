<!DOCTYPE html>
<html>
<head>
<title>Dashboard</title>

</head>
<body>
	<h2>SuperUser Home</h2>
	<hr>
	<jsp:include page="header.jsp" />

	<div style="padding-left: 30px">
		<h3>Select an option</h3>
		<ul>
				<li><a href="${pageContext.request.contextPath}/admin/backOfficeRep-entry">Add Backoffice Rep</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/backOfficeRep-entry">Edit Backoffice Rep</a></li>
				<li><a href="${pageContext.request.contextPath}/admin/backOfficeRep-entry">Delete Backoffice Rep</a></li>
		</ul>
	</div>
</body>
</html>
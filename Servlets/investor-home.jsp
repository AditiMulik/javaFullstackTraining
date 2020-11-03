<!DOCTYPE html>
<html>
<head>
<title>Investor Dashboard</title>

</head>
<body>
	<h2>Investor Details</h2>
	<hr>

	<div style="padding-left: 30px">
		<h3>Click to view Investment by Asset or Companies</h3>
		<ul>
			<li><a href="${pageContext.request.contextPath}/user/show-assets">View Assets</a></li>
			<li><a href="${pageContext.request.contextPath}/user/show-companies">View Companies</a></li>
		</ul>
	</div>
	<div class="form-group">
    			<label>Enter CompanyID</label> <input class="form-control" type="text" name="companyID" />
    </div>
	<div class="form-group">
    					<input type="submit" value="Enter" />
    </div>

</body>
</html>
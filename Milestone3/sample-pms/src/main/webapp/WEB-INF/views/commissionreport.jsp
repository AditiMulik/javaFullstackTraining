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
	<h1>Commission Report</h1>
		<form action="sendcommissionreport" method="post">
			
				<div><label>Select time range</label></div>
				<div class="radio">
			      <label><input type="radio" name="resulttype" value="Monthly">Monthly</label>
			    </div>
			    <div class="radio">
			      <label><input type="radio" name="resulttype" value="Quarterly">Quarterly</label>
			    </div>
			    <div class="radio">
			      <label><input type="radio" name="resulttype" value="Annual">Annual</label>
			    </div>
			
			<input type="submit" value="Select" class="btn btn-primary"/>
		</form>
	 </div>
	 <hr/>
	 </div>
<jsp:include page="footer.jsp"/>
</body>
<jsp:include page="bootstrapscripts.jsp"/>
</html>
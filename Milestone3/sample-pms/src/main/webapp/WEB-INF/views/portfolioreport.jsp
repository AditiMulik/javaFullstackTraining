<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
	<h1>Portfolio Report</h1>
		<form action="sendportfolioreport" method="post">
			
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
</html>
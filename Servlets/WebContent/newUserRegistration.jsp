<!DOCTYPE html>
<html>
<head>
<title>New Investor Registration</title>
</head>
<body>
	<h2>Enter Details here to Sign Up</h2>
	<hr/>


        <form action="user" method="doUser">
              FirstName  : <input type="text" name="FirstName" required><br/><br/>
              MiddleName : <input type="text" name="MiddleName" required><br/><br/>
              LastName   : <input type="text" name="LastName" required><br/><br/>
              Date of Birth : <input type="text" name="Date of Birth" required><br/><br/>
              PAN        : <input type="text" name="PAN" required><br/><br/>
              Mobile No  : <input type="text" name="Mobile" pattern="[1-9] [0-9]{9}" required/></label><br/><br/>
              eMail ID   : <input type="email" name="eMailID" required/></label><br/><br/>
              Currency Preference   : <input type="text" name="Currency Preference" required><br/><br/>
              Password   : <input type="password" name="Password" required><br/><br/>
              Confirm Password   : <input type="password" name="ConfirmPassword" required><br/><br/>

<input type="submit" value="SignUp">

		<div class="form-group">
                	<a href="login.jsp">Existing User</a>
                </div>

</body>
</html>
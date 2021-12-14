<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/admin_login.css" />
<title>TCS Administrator</title>
    <link rel="icon" href="https://cdn-icons-png.flaticon.com/512/2120/2120197.png" type="image/x-icon">
</head>
<body>

	<div class="login-box">
		<h1>Login</h1>
		<form action="adminlogin" method="post">
			<div class="textbox">
				<input type="text" name="username" placeholder="Username"
					required="required">
			</div>

			<div class="textbox">
				<input type="password" name="password" placeholder="Password"
					required="required">
			</div>
			<input class="btn" type="submit" name="" value="Sign In">
		</form>
	</div>

</body>
</html>
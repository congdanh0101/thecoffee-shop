<%@page import="com.google.gson.JsonObject"%>
<%@page import="com.google.gson.Gson"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="">
		<select name="select" id="haha" onchange="myFunction()">
			<option value='{"code":"123","name":"Danh"}' selected="selected">haha</option>
			<option value='{"code":"124","name":"Danh"}'>hehe</option>
			<option value='{"code":"125","name":"Danh"}'>hihi</option>
			<option value='{"code":"126","name":"Danh"}'>hoho</option>
		</select>
		<input type="submit"/>
	</form>
	<%
		String val = request.getParameter("select");
		
		System.out.println(val);
	%>
	
	<script type="text/javascript">
		function myFunction() {
			var asd = document.getElementById("haha").value;
			var x = JSON.parse(asd);
			console.log(x.code);
		}
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>User Registration</title>
<style type="text/css">
.error{
color:red;
}
input {
        width: 500px;
        margin: 10px;
        
    }
select {
        width: 500px;
        margin: 10px;
        
    }
</style>
</head>
<body>
	<div align="center">
		<h2>Save User Details</h2>
		<sform:form method = "post" action ="addUser" modelAttribute="userCommand">
			<table border="1px">
				<tr>
					<td><sform:label path = "username">User Name</sform:label></td>
					<td><sform:input path = "username"/></td>
					<td><sform:errors path = "username" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "password">Password</sform:label></td>
					<td><sform:input type = "password"  path = "password"/></td>
					<td><sform:errors path = "password" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
		</sform:form>
		<span style="color:red">${errorMessageRegister}</span><br/>
		<h3><a href="userLogin">Back</a><br/><br/></h3>
		<h3><a href="home">Home</a><br/><br/></h3>
	</div>
</body>
</html>
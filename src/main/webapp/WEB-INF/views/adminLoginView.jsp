<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>User Login</title>
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
		<h2>Select User</h2>
		<sform:form method = "post" action ="adminLoginView" modelAttribute="adminSelectCommand">
			<table >
				<tr>
					<sform:select path="userId">
    				<sform:options items = "${userListMap}"></sform:options>
 					</sform:select>
				</tr>
				<tr>
					<td><input type="submit" value = "Get Started"/></td>
				</tr>
			</table>
		</sform:form>
		<h3><a href="home">Home</a><br/><br/></h3>
	</div>
	
</body>
</html>
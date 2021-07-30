<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Get Started</title>
</head>
<body>
	<div align="center">
	<h1>Menu</h1>
	<br/>
	<a href="getQuote">Get Quote</a><br/><br/>
	<a href="retrieveQuote">Retrieve Quote</a><br/><br/>
	<a href="buyPolicy">Buy Policy</a><br/><br/>
	<c:if test = "${boughtPolicy==true}"><a href="viewPolicy">View Policy</a><br/><br/></c:if>
	<c:if test = "${adminId>-1}"><a href="adminLoginView">Select User Again</a><br/><br/></c:if>
	<a href="logout">Logout</a>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Quote</title>
<style>
	table
	{
		width:50%;
	}
	td
	{
		height:40px;
		text-align:center;
  		vertical-align:middle;
	}
</style>
</head>
<body>
	<div align="center">
	<h1>Retrieve Quote Details</h1>
	<table border = "1">
		<tr>
			<td>Quote Id</td>
			<td>${validQuote.quoteId}</td>
		</tr>
		<tr>
			<td>Residence Type</td>
			<td>${userLoc.residenceType}</td>
		</tr>
		<tr>
			<td>Address line 1</td>
			<td>${userLoc.address}</td>
		</tr>
		<tr>
			<td>City</td>
			<td>${userLoc.city}</td>
		</tr>
		<tr>
			<td>State</td>
			<td>${userLoc.state}</td>
		</tr>
		<tr>
			<td>Zip</td>
			<td>${userLoc.zip}</td>
		</tr>
		<tr>
			<td>Residence User</td>
			<td>${userLoc.residenceUse}</td>
		</tr>
	</table>
	<h3><a href="retrieveQuote">Back</a><br/></h3>
	</div>
</body>
</html>
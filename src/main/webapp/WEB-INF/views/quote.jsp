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
	<h1>Quote Details</h1>
	<table border = "1">
		<tr>
			<th>Quote Id</th>
			<td>${validQuote.quoteId}</td>
		</tr>
		<tr>
			<th>Monthly Premium</th>
			<td>${validQuote.premium}</td>
		</tr>
		<tr>	
			<th>Dwelling Coverage</th>
			<td>${validQuote.dwelling_coverage}</td>
		</tr>
		<tr>
			<th>Detached Structures</th>
			<td>${validQuote.detached_structures}</td>
		</tr>
		<tr>
			<th>Personal Property</th>
			<td>${validQuote.personal_property}</td>
		</tr>
		<tr>
			<th>Additional Living Expense</th>
			<td>${validQuote.living_expense}</td>
		</tr>
		<tr>
			<th>Medical Expense</th>
			<td>${validQuote.medical_expense}</td>
		</tr>
		<tr>
			<th>Deductible</th>
			<td>${validQuote.deductible}</td>
		</tr>
	</table>
	<span style="color:red">${errorMesssageValid}</span><br/>
	<h3><a href="getQuote">Back</a><br/></h3>
	</div>
</body>
</html>
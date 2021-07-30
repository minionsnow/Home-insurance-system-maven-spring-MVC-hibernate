<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>View Policy</title>
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
	<h1>Policy Details</h1>
	<table border = "1">
		<tr>
			<td>Policy Key</td>
			<td>${userPolicy.policyKey}</td>
		</tr>
		<tr>
			<td>Quote Id</td>
			<td>${userPolicy.quoteId}</td>
		</tr>
		<tr>
			<td>Policy Effective Date</td>
			<td>${userPolicy.effectiveDate}</td>
		</tr>
		<tr>
			<td>Policy End Date</td>
			<td>${userPolicy.endDate}</td>
		</tr>
		<tr>
			<td>Policy Term</td>
			<td>${userPolicy.policyTerm}</td>
			<td><c:if test = "${adminId>-1}"><a href="editTerms">Edit</a><br/></c:if></td>
		</tr>
		<tr>
			<td>Policy Status</td>
			<td>${userPolicy.policyStatus}</td>
		</tr>
	</table>
	<c:if test = "${adminId>-1}"><a href="renewPolicy">Renew Policy</a><br/></c:if>
	<c:if test = "${adminId>-1}"><a href="cancelPolicy">Cancel Policy</a><br/></c:if>
	<h3><a href="getStarted">Back</a><br/></h3>
	</div>
</body>
</html>
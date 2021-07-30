<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Quote Summary</title>
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
	<h1>Quote Summary</h1>
	<br/>
	<br/>
	<h2>Location Details</h2>
	<table border = "1">
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
	<br/>
	<br/>
	<h2>Home Owner Details</h2>
	<table border = "1">
		<tr>
			<td>First Name</td>
			<td>${homeOwner.firstNmae}</td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td>${homeOwner.lastName}</td>
		</tr>
		<tr>
			<td>Date of Birth</td>
			<td>${homeOwner.dob}</td>
		</tr>
		<tr>
			<td>Are you retired?</td>
			<td>${homeOwner.retired}</td>
		</tr>
		<tr>
			<td>Social Security Number</td>
			<td>${homeOwner.ssNumber}</td>
		</tr>
		<tr>
			<td>Email Address</td>
			<td>${homeOwner.email}</td>
		</tr>
	</table>
	<br/>
	<br/>
	<h2>Property Details</h2>
	<table border = "1">
		<tr>
			<td>What is the market value of your home?(in $)</td>
			<td>${userProp.marketValue}</td>
		</tr>
		<tr>
			<td>What year was your home originally built?</td>
			<td>${userProp.builtYear}</td>
		</tr>
		<tr>
			<td>Square footage(in sq. foot)</td>
			<td>${userProp.sqFoot}</td>
		</tr>
		<tr>
			<td>Dwelling style</td>
			<td>${userProp.dwellingStyle}</td>
		</tr>
		<tr>
			<td>Roof material</td>
			<td>${userProp.roofMaterial}</td>
		</tr>
		<tr>
			<td>Type of Garage</td>
			<td>${userProp.garageType}</td>
		</tr>
		<tr>
			<td>Number of full baths</td>
			<td>${userProp.fullBath}</td>
		</tr>
		<tr>
			<td>Number half baths</td>
			<td>${userProp.halfBath}</td>
		</tr>
		<tr>
			<td>Does your home have a swimming pool?</td>
			<td>${userProp.swimmingPool}</td>
		</tr>
	</table>
	<br/>
	<br/>
	<h2>Coverage Details</h2>
	<table border = "1">
		<tr>
			<td>Quote Id</td>
			<td>${validQuote.quoteId}</td>
		</tr>
		<tr>
			<td>Monthly Premium</td>
			<td>${validQuote.premium}</td>
		</tr>
		<tr>
			<td>Dwelling Coverage</td>
			<td>${validQuote.dwelling_coverage}</td>
		</tr>
		<tr>
			<td>Detached Structures</td>
			<td>${validQuote.detached_structures}</td>
		</tr>
		<tr>
			<td>Personal Property</td>
			<td>${validQuote.personal_property}</td>
		</tr>
		<tr>
			<td>Additional Living Expense</td>
			<td>${validQuote.living_expense}</td>
		</tr>
		<tr>
			<td>Medical Expense</td>
			<td>${validQuote.medical_expense}</td>
		</tr>
		<tr>
			<td>Deductible</td>
			<td>${validQuote.deductible}</td>
		</tr>
	</table>
	<h3><a href="retrieveQuote">Back</a><br/></h3>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>User Location Details</title>
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
		<h2>Save User Location Details</h2>
		<sform:form method = "post" action ="addUserLocation" modelAttribute="userLocationCommand">
			<table border="1px">
				<tr>
					<td><sform:label path = "residenceType" >Residence Type</sform:label></td>
					<td><sform:select path = "residenceType">
						<option value = "Single_Family_Home">Single-Family Home</option>
						<option value = "Condo">Condo</option>
						<option value = "Townhouse">Townhouse</option>
						<option value = "Row_house">Row house</option>
						<option value = "Duplex">Duplex</option>
						<option value = "Apartment">Apartment</option>
					</sform:select></td>
					<td><sform:errors path = "residenceType" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "address">Address line 1</sform:label></td>
					<td><sform:input path = "address" /></td>
					<td><sform:errors path = "address" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "city">City</sform:label></td>
					<td><sform:input path = "city" /></td>
					<td><sform:errors path = "city" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "state">State</sform:label></td>
					<td><sform:input path = "state" /></td>
					<td><sform:errors path = "state" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "zip">Zip</sform:label></td>
					<td><sform:input path = "zip" /></td>
					<td><sform:errors path = "zip" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "residenceUse">Residence Use</sform:label></td>
					<td><sform:select path = "residenceUse">
						<option value = "Primary">Primary</option>
						<option value = "Secondary">Secondary</option>
						<option value = "Rental_Property">Rental Property</option>
					</sform:select></td>
					<td><sform:errors path = "residenceUse" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
			<h3><a href="getQuote">Back</a><br/></h3>
			<span style="color:green">${filledStat}</span>
		</sform:form>
	</div>
</body>
</html>
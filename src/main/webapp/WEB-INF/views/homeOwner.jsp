<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Home Owner Details</title>
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
		<h2>Save Home-owner Information Details</h2>
		<sform:form method = "post" action ="addHomeOwner" modelAttribute="homeOwnerCommand">
			<table border="1px">
				<tr>
					<td><sform:label path = "firstNmae"> First Name </sform:label></td>
					<td><sform:input path = "firstNmae"/></td>
					<td><sform:errors path = "firstNmae" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "lastName">Last Name</sform:label></td>
					<td><sform:input path = "lastName"/></td>
					<td><sform:errors path = "lastName" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "dob">Date of Birth (dd/mm/yyyy)</sform:label></td>
					<td><sform:input path = "dob"/></td>
					<td><sform:errors path = "dob" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "retired">Are you retired?</sform:label></td>
					<td><sform:select path = "retired">
						<option value = "No">No</option>
						<option value = "Yes">Yes</option>
					</sform:select></td>
					<td><sform:errors path = "retired" cssClass="error"/></td>
					
				</tr>
				<tr>
					<td><sform:label path = "ssNumber">Social Security Number</sform:label></td>
					<td><sform:input path = "ssNumber"/></td>
					<td><sform:errors path = "ssNumber" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "email">Email Address</sform:label></td>
					<td><sform:input path = "email"/></td>
					<td><sform:errors path = "email" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
			<h3><a href="getQuote">Back</a><br/></h3>
			<span style="color:green">${filledStatHome}</span>
		</sform:form>
	</div>
</body>
</html>
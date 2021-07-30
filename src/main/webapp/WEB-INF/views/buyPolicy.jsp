<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page isELIgnored = "false" %>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Buy Policy</title>
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
		<h2>Buy Policy Details</h2>
		<sform:form method = "post" action ="addPolicy" modelAttribute="userPolicyCommand">
			<table border="1px">
				<tr>
					<td><sform:label path = "effectiveDate">Policy Effective Date(in dd/mm/yyyy)</sform:label></td>
					<td><sform:input path = "effectiveDate"/></td>
					<td><sform:errors path = "effectiveDate" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "endDate">Policy End Date(in dd/mm/yyyy)</sform:label></td>
					<td><sform:input path = "endDate"/></td>
					<td><sform:errors path = "endDate" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
			<h3><a href="getStarted">Back</a><br/></h3>
			<span style="color:red">${errorFilledStatPolicy}</span>
			<span style="color:green">${filledStatPolicy}</span>
		</sform:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="sform" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content = "text/html; charset=ISO-8859-1">
<title>Property Details</title>
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
		<sform:form method = "post" action ="addUserProperty" modelAttribute="userPropertyCommand">
			<table border="1px">
				<tr>
					<td><sform:label path = "marketValue">What is the market value of your home?(in $)</sform:label></td>
					<td><sform:input path = "marketValue"/></td>
					<td><sform:errors path = "marketValue" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "builtYear">What year was your home originally built?(in yyyy)</sform:label></td>
					<td><sform:input path = "builtYear"/></td>
					<td><sform:errors path = "builtYear" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "sqFoot">Square footage(in sq. foot)</sform:label></td>
					<td><sform:input path = "sqFoot"/></td>
					<td><sform:errors path = "sqFoot" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "dwellingStyle">Dwelling style</sform:label></td>
					<td><sform:select path = "dwellingStyle">
						<option value = "story_1">1 story</option>
						<option value = "story_1.5">1.5 story</option>
						<option value = "story_2">2 story</option>
						<option value = "story_2.5">2.5 story</option>
						<option value = "story_3">3 story</option>
					</sform:select></td>
					<td><sform:errors path = "dwellingStyle" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "roofMaterial">Roof material</sform:label></td>
					<td><sform:select path = "roofMaterial">
						<option value = "Concrete">Concrete</option>
						<option value = "Clay">Clay</option>
						<option value = "Rubber">Rubber</option>
						<option value = "Steel">Steel</option>
						<option value = "Tin">Tin</option>
						<option value = "Wood">Wood</option>
					</sform:select></td>
					<td><sform:errors path = "roofMaterial" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "garageType">Type of Garage</sform:label></td>
					<td><sform:select path = "garageType">
						<option value = "Attached">Attached</option>
						<option value = "Detached">Detached</option>
						<option value = "Built-in">Built-in</option>
						<option value = "None">None</option>
					</sform:select></td>
					<td><sform:errors path = "garageType" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "fullBath">Number of full baths</sform:label></td>
					<td><sform:select path = "fullBath">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">more</option>
					</sform:select></td>
					<td><sform:errors path = "fullBath" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "halfBath">Number half baths</sform:label></td>
					<td><sform:select path = "halfBath">
						<option value = "1">1</option>
						<option value = "2">2</option>
						<option value = "3">3</option>
						<option value = "4">more</option>
					</sform:select></td>
					<td><sform:errors path = "halfBath" cssClass="error"/></td>
				</tr>
				<tr>
					<td><sform:label path = "swimmingPool">Does your home have a swimming pool?</sform:label></td>
					<td><sform:select path = "swimmingPool">
						<option value = "No">No</option>
						<option value = "Yes">Yes</option>
					</sform:select></td>
					<td><sform:errors path = "swimmingPool" cssClass="error"/></td>
				</tr>
				<tr>
					<td><input type="submit"/></td>
				</tr>
			</table>
			<h3><a href="getQuote">Back</a><br/></h3>
			<span style="color:green">${filledStatProp}</span>
		</sform:form>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Policy Terms</title>
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
		<h2>New Policy Terms</h2>
		<form action ="editTerms" method= "post">
			<input type="text" name = "newterms" size="50"/>
			<input type="submit" value="OK"/>
		</form>
		<br/>
		<br/>
		<h3><a href="viewPolicy">Back</a><br/></h3>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>update page</title>
<link href="/student_management/resources/css/addpage.css"
	rel="stylesheet"></link>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Kdam+Thmor+Pro&display=swap"
	rel="stylesheet">
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Poppins&display=swap"
	rel="stylesheet">
</head>
<body>
	<div class="container">
		<form:form action="updateprocess?userid=${userid}" method="POST"
			modelAttribute="studentinfo">
			<label for="name" class="label label1">name</label>
			<form:input path="studentname" id="name" class="inputs" />
			<br />
			<label for="mobile" class="label label2">mobile</label>
			<form:input path="studentmobile" id="mobile" class="inputs" />
			<br />
			<label for="country" class="label">country</label>
			<form:input path="studentcountry" id="country" class="inputs" />
			<br />
			<input value="submit" type="submit" class="btn">
		</form:form>
	</div>
</body>
</html>
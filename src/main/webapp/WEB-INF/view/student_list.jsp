<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>holla</title>
<link href="/student_management/resources/css/tablepage.css"
	rel="stylesheet"></link>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Chivo+Mono&family=Roboto+Condensed&family=Rubik&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&family=Poppins&family=Roboto:wght@300&display=swap"
	rel="stylesheet">
</head>
<body>
	<br />
	<div>
		<a href="/student_management/addstudent" id="add_btn" class="links">add</a>
		<table class="container">
			<tr>
				<th class="left_corner_head table_head">Id</th>
				<th class="table_head">Name</th>
				<th class="table_head">mobile</th>
				<th class="right_corner_head table_head">Country</th>
			</tr>
			<c:forEach var="student" items="${students}">
				<tr>
					<td class="table_data">${student.getId()}</td>
					<td class="table_data">${student.getName()}</td>
					<td class="table_data">${student.getMoblie()}</td>
					<td class="table_data">${student.getCountry()}</td>
					<td id="update_btn"><a
						href="/student_management/updatestudent?userid=${student.getId()}"
						class="links">update</a></td>
					<td id="delete_btn"><a
						href="/student_management/deletestudent?userid=${student.getId()}"
						class="links"
						onclick="if(!confirm('do you want to delete the student data?')) return false">delete</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
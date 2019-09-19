<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Add Student</title>
</head>
<body>

	<div id="header">
		<h2>Avensys Training Program</h2>
	</div>
	<div id="container">
		<h3>Update Student</h3>
		<form action="StudentControllerServlet" method="GET">
			<input type="hidden" name="command" value="update">
			<input type="hidden" name="id" value="${ student.getId() }">
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName" value="${ student.getFirstName() }"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName" value="${ student.getLastName() }"></td>
				</tr>
				<tr>
					<td>Email</td>
					<td><input type="email" name="email" value="${ student.getEmail() }"></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></td>
				</tr>
			</table>
		</form>
	</div>
	<div style="clear: both;"></div>
	<p><a href="StudentControllerServlet">Back to student list</a></p>

</body>
</html>
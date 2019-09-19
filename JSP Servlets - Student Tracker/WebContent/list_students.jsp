<%@ page import="java.util.*, com.avensys.studentracker.*"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<div id="container">
		<div class="row">
	
	
		<div id="">
			<h2>Avensys Training Program</h2>
		</div>
		<div id="">
			<div id="">
				<input type="button" value="Add Student" class="add-student-button"
					onclick="window.location.href='add_student_form.jsp'; return false;">
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>Email</th>
						<th colspan="2">Options</th>
					</tr>
					<c:forEach var="student" items="${ STUDENT_LIST }">

						<c:url var="updateLink" value="StudentControllerServlet">
							<c:param name="command" value="updateDetails" />
							<c:param name="id" value="${ student.getId() }" />
						</c:url>
						
						<c:url var="deleteLink" value="StudentControllerServlet">
							<c:param name="command" value="delete" />
							<c:param name="id" value="${ student.getId() }" />
						</c:url>

						<tr>
							<td>${ student.getFirstName() }</td>
							<td>${ student.getLastName() }</td>
							<td>${ student.getEmail() }</td>
							<td><a href="${ updateLink }">Update</a> 
								<!--
								<form action="StudentControllerServlet" method="GET">
									<input type="hidden" name="command" value="updateDetails">
									<input type="hidden" name="id" value="${ student.getId() }">
									<input type="submit" value="Update">
								</form>
								 -->
							</td>
							<td><a href="${ deleteLink }">Delete</a> 
								<!-- 
								<form action="StudentControllerServlet" method="GET">
									<input type="hidden" name="command" value="delete">
									<input type="hidden" name="id" value="${ student.getId() }">
									<input type="submit" value="Delete" onclick="if(confirm('Delete ${ student.getFirstName() } ${ student.getLastName() }?')){return true;} else {return false;}">
								</form>
								 -->
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>

</body>
</html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<!-- Add customer button -->
			<input type="button" value="Add customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button">
			<!-- Insert customer table -->
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<!-- Loop each data -->
				<c:forEach var="customerDetails" items="${ customers }">
					<!-- Construct update link -->
					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${ customerDetails.id }"></c:param>
					</c:url>

					<!-- Construct delete link -->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${ customerDetails.id }"></c:param>
					</c:url>

					<tr>
						<td>${ customerDetails.firstName }</td>
						<td>${ customerDetails.lastName }</td>
						<td>${ customerDetails.email }</td>
						<td><a href="${ updateLink }">Update</a> | <a
							href="${ deleteLink }"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false;">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>


</body>
</html>
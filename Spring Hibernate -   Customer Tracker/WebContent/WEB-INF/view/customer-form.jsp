<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Management</h2>
		</div>
	</div>

	<div id="container">
		<h3>Add/Update Customer</h3>

		<form:form action="saveCustomer" modelAttribute="customer"
			method="POST">

			<!-- Hidden form with customer id -->
			<form:hidden path="id"></form:hidden>

			<table>
				<tr>
					<td><label>First name:</label></td>
					<td><form:input path="firstName"></form:input></td>
				</tr>
				<tr>
					<td><label>Last name:</label></td>
					<td><form:input path="lastName"></form:input></td>
				</tr>
				<tr>
					<td><label>Email:</label></td>
					<td><form:input path="email"></form:input></td>
				</tr>
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"></td>
				</tr>
			</table>
		</form:form>

		<div style="clear: both"></div>

		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back
				to customer list</a>
		</p>
	</div>

</body>
</html>
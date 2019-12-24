<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>   
<html>
<head>
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

button {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
	color: white;
	background: maroon;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>

</head>
<body>
	<h2>Students details</h2>
	<table border="1">
		<thead>
			<tr>
				<th>std id</th>
				<th>first name</th>
				<th>last name</th>
				<th>mobile number</th>
				<th>user name</th>
				<th>department</th>
				<th>email</th>
				<th>delete</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${data}" var="std">
				<tr>
					<%-- <td><a href="/InstitueAndStudent/admin/updateUserPage?userId=${std.getUserId()}"><c:out value="${std.getUserId()}" /></a></td> --%>
					<td><c:out value="${std.getUserId()}" /></td>
					<td><c:out value="${std.getFirstName()}" /></td>
					<td><c:out value="${std.getLastName()}" /></td>
					<td><c:out value="${std.getMobileNo()}" /></td>
					<td><c:out value="${std.getUserName()}" /></td>
					<td><c:out value="${std.getDepartment()}" /></td>
					<td><c:out value="${std.getEmail()}" /></td>
					<!-- button as a link  -->
					<td><button
							onclick="window.location.href='/InstitueAndStudent/admin/deleteUser?userId=${std.getUserId()}&adminId=${adminId }'"
							value="delete">delete</button></td>
				</tr>
			</c:forEach>

		</tbody>
	</table>

</body>
</html>
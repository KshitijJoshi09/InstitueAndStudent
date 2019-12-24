<html>
<head>

</head>

<body>

	<h2>Add User</h2>

	<form action="/InstitueAndStudent/addUser" method="post">
		<table>
			<tr>
				<td><input type="text" name="adminId" value="${adminId } "
					hidden=""></td>
			</tr>
			<tr>
				<!-- column one  -->
				<td>first Name :</td>
				<!-- column two -->
				<td><input type="text" name="firstName"></td>
				<td><p style="color: red;">${ firstName }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>last Name :</td>
				<!-- column two -->
				<td><input type="text" name="lastName"></td>
				<td><p style="color: red;">${ lastName }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>email :</td>
				<!-- column two -->
				<td><input type="text" name="email"></td>
				<td><p style="color: red;">${ email }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>age :</td>
				<!-- column two -->
				<td><input type="number" name="age" value="0"></td>
				<td><p style="color: red;">${ age }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>User Name :</td>
				<!-- column two -->
				<td><input type="text" name="userName"></td>
				<td><p style="color: red;">${ userName }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>password :</td>
				<!-- column two -->
				<td><input type="text" name="password"></td>
				<td><p style="color: red;">${ password }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>mobile No :</td>
				<!-- column two -->
				<td><input type="text" name="mobileNo"></td>
				<td><p style="color: red;">${ mobileNo }</p></td>
			</tr>

			<%-- <tr>
				<!-- column one  -->
				<td>role :</td>
				<!-- column two -->
				<td><input type="text" name="role"></td>
				<td><p style="color : red ;">${ role }</p></td>
			</tr> --%>

			<tr>
				<td>deptartment :</td>
				<td><input type="radio" name="department" value="development">
					dev <input type="radio" name="department" value="testing">
					testing</td>
				<td><p style="color: red;">${ department }</p></td>
			</tr>


			<tr>
				<td>street :</td>
				<td><input type="text" name="address.street"></td>
				<td><p style="color: red;">${ address.street }</p></td>
			</tr>

			<tr>
				<td>city :</td>
				<td><input type="text" name="address.city"></td>
				<td><p style="color: red;">${ address.city }</p></td>
			</tr>

			<tr>
				<td>state :</td>
				<td><input type="text" name="address.state"></td>
				<td><p style="color: red;">${ address.state }</p></td>
			</tr>

			<tr>
				<td>pin code :</td>
				<td><input type="text" name="address.pinCode"></td>
				<td><p style="color: red;">${ address.pinCode }</p></td>
			</tr>

			<tr>
				<td><input type="submit" value="click me"></td>
			</tr>

		</table>

	</form>
</body>
</html>


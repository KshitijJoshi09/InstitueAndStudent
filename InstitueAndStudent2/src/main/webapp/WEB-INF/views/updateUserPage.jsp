<html>
<body>

	<h2>Update User</h2>

	<form action="updateUserDetails" method="post">
		<table>
			<%-- 	<tr>
				<td>${ error }</td>
			</tr> --%>
			<tr>
				<!-- column one  -->
				<td>first Name :</td>
				<!-- column two -->
				<td><input type="text" name="firstName"
					value="${ user.firstName}"></td>
				<td><p style="color: red;">${ firstName }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>last Name :</td>
				<!-- column two -->
				<td><input type="text" name="lastName" value="${ user.lastName}"></td>
				<td><p style="color: red;">${ lastName }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>email :</td>
				<!-- column two -->
				<td><input type="text" name="email" value="${ user.email}"></td>
				<td><p style="color: red;">${ email }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>age :</td>
				<!-- column two -->
				<td><input type="number" name="age" value="${ user.age}"></td>
				<td><p style="color: red;">${ age }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>User Name :</td>
				<!-- column two -->
				<td><input type="text" name="userName" value="${ user.userName}" readonly="readonly"
					></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>password :</td>
				<!-- column two -->
				<td><input type="text" name="password" value="${ user.password}"></td>
				<td><p style="color: red;">${ password }</p></td>
			</tr>

			<tr>
				<!-- column one  -->
				<td>mobile No :</td>
				<!-- column two -->
				<td><input type="text" name="mobileNo" value="${ user.mobileNo}"></td>
				<td><p style="color: red;">${ mobileNo }</p></td>
			</tr>

		<%-- 	<tr>
				<!-- column one  -->
				<td>role :</td>
				<!-- column two -->
				<td><input type="text" name="role" value=${ user.role}
					readonly="readonly"></td>
				<td><p style="color: red;">${ role }</p></td>
			</tr> --%>

			<tr>
				<td>deptartment :</td>
				<td><input type="radio" name="department" value="development">
					dev <input type="radio" name="department" value="testing">
					testing</td>
				<td><p style="color: red;">${ department }</p></td>

				<%-- <td><input type="radio" name="department" value="development"
					<c:if test="${user.department=='development'}">checked</c:if>>
					development <input type="radio" name="department" value="testing"
					<c:if test="${user.department=='testing'}">checked</c:if>>
					testing</td>
			</tr> --%>


			<tr>
				<td>street :</td>
				<td><input type="text" name="address.street" value="${ user.address.street}"></td>
				<td><p style="color: red;">${ address.street }</p></td>
			</tr>

			<tr>
				<td>city :</td>
				<td><input type="text" name="address.city" value="${ user.address.city}"></td>
				<td><p style="color: red;">${ address.city }</p></td>
			</tr>

			<tr>
				<td>state :</td>
				<td><input type="text" name="address.state" value="${ user.address.state}"></td>
				<td><p style="color: red;">${ address.state }</p></td>
			</tr>

			<tr>
				<td>pin code :</td>
				<td><input type="text" name="address.pinCode" value="${ user.address.pinCode}"></td>
				<td><p style="color: red;">${ address.pinCode }</p></td>
			</tr>

			<tr>
				<td><input type="submit" value="click me"></td>
			</tr>

		</table>

	</form>
</body>
</html>

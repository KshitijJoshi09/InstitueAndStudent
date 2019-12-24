<html>
<body>
	<h2>Sign In</h2>

	<form action="loginInUser" method="post">
		<table>
			
			<tr>
				<td>UserName/email/mobileNo</td>
				<td><input type="text" name="userId"></td>
				<td><span style="color:red;"> ${loginId }</span></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password"></td>
				<td><span style="color:red;"> ${password }</span></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Log In"></td>
			</tr>


		</table>


	</form>


</body>
</html>

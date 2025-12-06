<!doctype html>
<html>
	<head>
		<title>SpringMVC</title>
	</head>
	<body>
		<blockquote>
			<h2>Example of Spring MVC</h2>
			<hr>
				<a href="${pageContext.request.contextPath}/">Home</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/addStudent">AddStudent</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/viewStudent">ViewStudent</a>				
			<hr>
			<p>
				<h2>View Student</h2>
				<table border="1" cellspacing="0" cellPadding="8">
					<tr>
						<th>S.No</th>
						<th>Name</th>
						<th>Email</th>
						<th>Password</th>
						<th>Address</th>
						<th colspan="2">Action</th>
					</tr>
				</table>
			</p>
		</blockquote>
	</body>
</html>
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
				<h2>Add Student</h2>
				<form action="">
					<input
						type="text"
						placeholder="Enter Username"
						name="username"
						id="username"
					> <br>
					<input
						type="text"
						placeholder="Enter Username"
						name="username"
						id="username"
					> <br>
					<input
						type="text"
						placeholder="Enter Username"
						name="username"
						id="username"
					> <br>
					<input
						type="text"
						placeholder="Enter Username"
						name="username"
						id="username"
					> <br>
					<input
						type="submit"
						value="Add Student"
					> <br>
					<input
						type="reset"
						value="Reset Student"
					>
					
				</form>
			</p>
		</blockquote>
	</body>
</html>
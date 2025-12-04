<!Doctype html>
<html>
	<head>
		<title>SpringMVC</title>
	</head>
	<body>
		<blockquote>
			<hr>
			<a href="${pageContext.request.contextPath}/">Home</a>	|
			<a href="about">About</a> 
			<hr>
			<h2>Home Page</h2>
			<p>
				Lorem Ipsum is a type of dummy text commonly used in the printing and typesetting industry. It has been the industry's standard since the 1500s, when an unknown printer scrambled a galley of type to create a type specimen book. Essentially, Lorem Ipsum is a sequence of Latin words that do not form coherent sentences, making it useful for filling spaces in design layouts where actual text will eventually be placed. It serves as a placeholder in graphic design, publishing, and web development, allowing designers to focus on layout and visual elements without being distracted by meaningful content.
			</p>
		</blockquote>
	</body>
</html>
<!--
option 1 : request.getContextPath() inside expression tag 
option 2 : ./ 
option 3 : ${pageContext.request.contextPath} 
  -->
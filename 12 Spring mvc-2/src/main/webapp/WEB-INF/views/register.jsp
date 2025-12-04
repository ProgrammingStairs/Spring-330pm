<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Spring Example</title>
		<script>
			function submitData(event){
				event.preventDefault();
				var username = document.getElementById("username").value;
				var email = document.getElementById("email").value;
				var password = document.getElementById("password").value;
				var genderObj = document.querySelector('input[name="gender"]:checked');
				var gender = genderObj ? genderObj.value : "";
				var hobbiesObj = document.querySelectorAll('input[name="hobbies"]:checked');
				var hobbies = hobbiesObj ? [...hobbiesObj].map(hobby=>hobby.value).join(" , ") : "";
				var subject = document.getElementById("subject").value;
				
				var obj = {username,email,password,gender,hobbies,subject};
				//console.log("obj : ",obj);
				//console.log("-----------> ",JSON.stringify(obj));
				fetch("<%=request.getContextPath()%>/register",{
					method:'POST',
					headers : {
						'content-type':'application/json'
					},
					body:JSON.stringify(obj)
				}).then(response=>response.json())
					.then(data => {
						console.log("Received data : ",data.field);
						
						// clear all fields
						var fields = ["username","email","password","gender","hobbies","subject"];
						fields.forEach(f=>{
							document.getElementById("err_"+f).innerHTML = "";							
						})

						// show message on specific field
						if(data.field){
							document.getElementById("err_"+data.field).innerHTML = data.message;							
						}
						
						
						if(data.status==200){
							alert(data.message);
							window.location.href="<%=request.getContextPath()%>/login";							
						}
					})
				.catch((error)=>{
					console.log("Error : "+error);
				});

			}
		</script>
	</head>
	<body>
		<blockquote>
			<h2>Example of Spring MVC</h2>
			<hr>
				<a href="${pageContext.request.contextPath}/">Home</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/register">Register</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
				<a href="${pageContext.request.contextPath}/student/">StudentPortal</a>
			<hr>			
			<h2>Register Page</h2>
			<form:form modelAttribute="student">
				<form:input path="username" id="username" placeholder="Enter Username"/> 
				<span id="err_username" class="error"></span><br>
				
				<form:input path="email" id="email" placeholder="Enter Email"/> 
				<span id="err_email" class="error"></span><br>
				
				<form:input path="password" id="password" placeholder="Enter Password"/> 
				<span id="err_password" class="error"></span><br>
				
				<form:radiobutton path="gender" id="male" value="male"/>Male 
				<form:radiobutton path="gender" id="female" value="female" />Female 
				<span id="err_gender" class="error"></span><br>

				<form:checkbox path="hobbies" id="cricket" value="cricket" /> Cricket
				<form:checkbox path="hobbies" id="football" value="football" /> Football
				<span id="err_hobbies" class="error"></span><br>
				
				<form:select path="subject" id="subject">
					<form:option value="">Select Subject</form:option>
					<form:option value="C Language">C Language</form:option>
					<form:option value="C++ Language">C++ Language</form:option>
					<form:option value="C# Language">C# Language</form:option>
					<form:option value="Java Language">Java Language</form:option>
					<form:option value=".Net Language">.Net Language</form:option>
				</form:select>
				<span id="err_subject" class="error"></span><br>
				
				<br><br>
<!--  				
				<form:button onclick="submitData(event)" type="submit" value="Register">Register</form:button>
				<form:button type="reset">Reset</form:button>
-->
<!-- reason 1 -->
 <button type="button" onclick="submitData(event)">Register</button>
    <input type="reset" value="Reset">

			</form:form>
		</blockquote>
	</body>
</html>
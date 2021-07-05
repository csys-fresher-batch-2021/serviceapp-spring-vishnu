<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Log-in</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1>Login</h1>

		<form onsubmit="userLogin()" method="post">
			<label for="username">Email:</label> <input type="email" name="email"
				id="email" placeholder="Enter your email" autofocus required> <br>
			<label for="password">Password:</label> <input type="password"
				name="password" id="password" placeholder="Password" required> <br>
			<button type="submit">LOG IN</button>
		</form>
		<br><br>
		<h5>Do not have an Axles Account? <a href="userRegistration.jsp">Register</a> Now!</h5>
	</main>
	
	<script>
		function userLogin(){
			event.preventDefault();
			let userName = document.querySelector("#email").value;
			let password = document.querySelector("#password").value;
			localStorage.setItem("role","USER");
			let user={
					"email":userName,
					"password":password
			}
			let url = "/UserLoginServlet";
			content = "";
			axios.post(url, user).then(res=>{
				let data = res.data;
				console.log(data);
				alert(data.infoMessage);
				window.location.href="quickBook.jsp";
				
			}).catch(err=>{
				let data = err.response.data;
				content += data.errorMessage;
				alert(data.errorMessage);
			});
		}
	
	</script>
	
</body>
</html>
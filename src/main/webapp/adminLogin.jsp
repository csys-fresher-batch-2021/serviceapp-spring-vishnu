<!DOCTYPE>
<html lang="en">
<head>
<title>Car Service App</title>

</head>

<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h1 class="text-center">Admin</h1>
		<div>
			<form onsubmit="adminLogin()" method="post">
				<label for="username">Admin:</label> <input type="text"
					name="userName" id="userName" placeholder="Enter your email"
					autofocus required> <br> <label for="password">Password:</label>
				<input type="password" name="password" id="password"
					placeholder="Password" required> <br>
				<button type="submit">LOG IN</button>

				<p>
					<em>Admin: admin123@gmail.com<br>Password: admin1234
					</em>
				</p>
			</form>
		</div>
	</main>

		<script>
			function adminLogin(){
				event.preventDefault();
				let user = document.querySelector("#userName").value;
				let password = document.querySelector("#password").value;
				localStorage.setItem("role","ADMIN");
				let admin = {
						"email" : user,
						"password":password						
				}
				let url = "AdminLogin";
				content = "";
				axios.post(url, admin).then(res=>{
					let data = res.data;
					alert(data.infoMessage);
					window.location.href="addNewDetails.jsp";
				}).catch(err=>{
					let data = err.response.data;
					content += data.erorMessage;
					alert(data.errorMessage);
				});
			}
		</script>

</body>
</html>

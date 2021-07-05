
<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="ISO-8859-1">
<title>Register Now!</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Registration</h3>
		
		<p id="message"></p>
		
		<form onsubmit="addUser()" method="post">

			<label for="firstname">FirstName:</label> <input type="text"
				name="firstname" id="firstname" placeholder="firstName" autofocus
				required> <br> <label for="lastname">LastName:</label>
			<input type="text" name="lastname" id="lastname"
				placeholder="lastName" required> <br> <label
				for="contact">Contact Number:</label> <input type="tel"
				name="contact" id="contact" placeholder="9999999999" required>
			<br> <label for="email">Email:</label> <input type="email"
				name="email" id="email" placeholder="demoperson@example.com"
				required> <br> <label for="password">Password:</label>
			<input type="password" name="password" id="password"
				placeholder="Min 9 letters required" required> <br>
			<button type="submit">Register</button>
		</form>
	</main>
	<script>
		function addUser(){
			event.preventDefault();
			let firstName = document.querySelector("#firstname").value;
			let lastName = document.querySelector("#lastname").value;
			let contact = document.querySelector("#contact").value;
			let email = document.querySelector("#email").value;
			let password = document.querySelector("#password").value;
			let user = {
					"firstName":firstName,
					 "lastName":lastName,
					  "contact":contact,
					    "email":email,
				     "password":password
			}
			let url = "RegistrationServlet";
			content = "";
			axios.post(url, user).then(res=>{
				let data = res.data;
				content+=data.infoMessage;
				console.log(data);
				document.querySelector("#message").innerHTML = content;
				
			}).catch(err=>{
				let data = err.response.data;
				content+=data.errorMessage;
				console.log(data);
				document.querySelector("#message").innerHTML = content;
			})
		}
		
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>service centers</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Select your service center</h3>
		<form action="BillingPageAction" method="post">
			
		
			<div>
				<label for="username"> User Name:</label> 
				<input type="text" name="contact" value="" readonly> 
				
				<label for="contact">Contact: </label>
				<input type="text" name="contact" value="" readonly>
				
				<label for="carmodel">Your Car: </label>
				<input type="text" name="carmodel" value="" readonly>
				
				 <br>
				 
				<label for="selectedservice">Service type: </label>
				<input type="text" name="selectedservice" value="" readonly>
				
				<label for="registrationnumber">Registration Number: </label>
				<input type="text" name="registrationnumber" value="" readonly>
			</div>
			
			
			<table class="table table-striped">
				<caption>List Of Service Centers</caption>
				<thead class="thead-dark">
					<tr>
						<th scope="col">S.no</th>
						<th scope="col">Name</th>
						<th scope="col">Location</th>
						<th scope="col"></th>

					</tr>
				</thead>
				<tbody id="serviceCenter">
				
				</tbody>
			</table>
			<div>

			</div>
		</form>
	</main>
	<script>
		
	</script>
	
</body>
</html>
<!DOCTYPE>
<html lang="en">
<head>
<title>Car Services App</title>
</head>
<body class="text-center">
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>ADD TO DATABASE HERE</h3>

		<form onsubmit="addServices()" method="post">

			<label for="add Service">Add Services</label> <input type="text"
				name="services" id="services" placeholder="Enter New Service here"
				required> <input type="number" name="servicecharge"
				id="serviceCharge" placeholder="Enter the service charge" min=0
				max=100000 required>
			<button type="submit">Add Service</button>

		</form>
		<br> <br>

		<form onsubmit="addCar()" method="post">

			<label for="carname">Add New Car</label> <input type="text"
				name="carname" id="carName" placeholder="Enter New Car here" required>
			<button type="submit">Add Car</button>

		</form>
		<br> <br>

		<form onsubmit="addServiceCenter()" method="post">
			<label for="servicecenter">Add New Service Center</label> <input
				type="text" name="servicecenter" id="servicecenter" required> <label
				for="location">Enter center location</label> <input type="text"
				name="location" id = "location" required>
			<button type="submit">Add Station</button>
		</form>

	</main>
	<script>
		function addServices(){
			event.preventDefault();
			let service = document.querySelector("#services").value;
			let serviceCharge = document.querySelector("#serviceCharge").value;
			let services = {
						"service" : service,
						"serviceCharge" : serviceCharge
			}
			console.log(services);
			let url = "AddService";
			content = "";
			axios.post(url, services).then(res=>{
				let data = res.data;
				console.log(data);
				alert(data.infoMessage);
				window.location.href="addNewDetails.jsp";
			}).catch(err=>{
				let data = err.response.data;
				content += data.errorMessage;
				alert(data.errorMessage);
				window.location.href="addNewDetails.jsp";
			})
			
		}
		
		function addServiceCenter(){
			event.preventDefault();
			let center = document.querySelector("#servicecenter").value;
			let location = document.querySelector("#location").value;
			let serviceCenter = {
					"centerName" : center,
					"location" : location
			}
			console.log(serviceCenter);
			let url = "AddServiceCenter";
			content = "";
			axios.post(url, serviceCenter).then(res=>{
				let data = res.data;
				console.log(data);
				alert(data.infoMessage);
				window.location.href="addNewDetails.jsp";
			}).catch(err=>{
				let data = err.response.data;
				content += data.errorMessage;
				alert(data.errorMessage);
				window.location.href="addNewDetails.jsp";
				
			})
		};
		
		function addCar(){
			event.preventDefault();
			let car = document.querySelector("#carName").value;
			let carObj = {
					"carName":car
			}
			
			let url = "AddCar";
			content = "";
			axios.post(url, carObj).then(res=>{
				let data = res.data;
				console.log(data);
				alert(data.infoMessage);
				window.location.href="addNewDetails.jsp";
			}).catch(err=>{
				let data = err.response.data;
				content += data.errorMessage;
				alert(data.errorMessage);
				window.location.href="addNewDetails.jsp";
			})
			
		};
		
	</script>
</body>
</html>

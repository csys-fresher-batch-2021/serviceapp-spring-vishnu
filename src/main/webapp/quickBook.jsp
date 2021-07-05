<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Book now</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Quick Book</h3>
		<form onsubmit="getSelectedValues()" method="post">


			<label>Select your car:</label> <select name="cars" id="selectCar"
				required>
				<option value="">Not Selected</option>


			</select> <br> <label>Select your service:</label> <select
				name="services" id="selectService" required>
				<option value="">Not Selected</option>

			</select> <br> <label>Enter vehicle Registration number:</label> <input
				type="text" name="regno" id="regNo" placeholder="TN-03-AP-3333"
				required> <br>
			<button type="submit">Book Now</button>

		</form>
	</main>
	<script>
	function getCarList(){
		let url = "ListCars";
		fetch(url).then(res=>res.json()).then(res=>{
			let cars = res;
			console.log(cars);
			 for(let car of cars ){
				 let content = 
				$('#selectCar').append("<option id="+car.carId+" value='"+car.carName+"'>"+car.carName+"</option>");	
			}		
		})
		
		
	}
	
	function getServiceList(){
		let url = "ListServices";
		fetch(url).then(res=>res.json()).then(res=>{
			let services = res;
			console.log(services);
			for(let service of services ){
				$('#selectService').append("<option id="+service.id+" value='"+service.service+"'>"+service.service+"</option>");
			}			
		})		
	}
		
	function getSelectedValues(){
		event.preventDefault();
		let userCar =  document.querySelector("#selectCar").value;
		let userService = document.querySelector("#selectService").value;
		let registerNumber = document.querySelector("#regNo").value;
		
		let userData = {
				"userCar":userCar,
				"userService":userService,
				"registrationNumber":registerNumber
		}
		let url = "QuickBookAction";
		content = "";
		axios.post(url, userData).then(res=>{
			let data = res.data;
			window.location.href="serviceCenters.jsp";			
		}).catch(err=>{
			let data = err.response.data;
			content += data.errorMessage;
			alert(data.errorMessage);
			window.location.href="quickBook.jsp";
		});
	}
	getCarList();
	getServiceList();
	
</script>
</body>
</html>
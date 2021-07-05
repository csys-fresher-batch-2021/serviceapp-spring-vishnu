<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Cars</title>
</head>
<body class="text-center">

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>List of Cars</h3>
		<table id = "carTableId" class="table table-striped">
			<caption>Available cars</caption>
			<thead>
				<tr>
					<th scope="col">S.NO</th>
					<th scope="col">CARS</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody id="cars">

			</tbody>
		</table>
	</main>
	<script>
	$(document).ready(function(){
		let url = "ListCars";
		fetch(url).then(res=>res.json()).then(res=>{
			let cardata = res;
			console.log(cardata);
			let content="";
			let i=0;
			for(let car of cardata){
				content += "<tr><td>"+ ++i +
				"</td><td>"+car.carName+"</td>"
				+"<td><button class = 'btn btn-danger' onclick=\"removeCar("+car.carId+ ")\">Remove</button</td></tr>"
			}
			$('#carTableId tbody').append(content);
			$('#carTableId').dataTable();
		})
	
	});
	
	function removeCar(id){
		event.preventDefault();
		const queryParams = "?id="+id;
		let url = "RemoveCar"+queryParams;
		let content = "";
		fetch(url).then(res=>res.json()).then(res=>{
			let data = res;
			console.log(data);
			content+=data.infoMessage;
			alert(content);
			window.location.href="carsTable.jsp";					
		}).catch(err=>{
			let data = err.response;
			console.log(data);
			content+=data.errorMessage;
			alert(content);
		});
		
	}
	
		
	</script>

</body>
</html>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Car Service</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<h3 class="text-center">List of Services</h3>



		<table id="tableId" class="table table-striped">
			<caption>Available Services</caption>
			<thead>
				<tr>
					<th scope="col">S.no</th>
					<th scope="col">Services</th>
					<th scope="col">Charge(in Rs)</th>
					<th scope="col"></th>
				</tr>
			</thead>
			<tbody>

			</tbody>
		</table>

		<script>
		$(document).ready(function () {
	   
				let url = "ListServices";
				fetch(url).then(res=>res.json()).then(res=>{
					let services = res;
					console.log(services);
					let content="";
					let i=0;
					let role = '<%=session.getAttribute("Role")%>';
					for(let serviceItem of services){
						if(role=="ADMIN"){
						content += "<tr><td>"+ ++i +
						"</td><td>"+serviceItem.service+"</td><td>"
						+serviceItem.serviceCharge+
						"</td><td><button class = 'btn btn-danger' onclick=\"removeService("+serviceItem.id+ ")\">Remove</button</td></tr></tr>"
						}
						else if(role=="USER"){
							content += "<tr><td>"+ ++i +
							"</td><td>"+serviceItem.service+"</td><td>"
							+serviceItem.serviceCharge+
							"</td><td><button class = 'btn btn-primary' onclick=\"bookService("+serviceItem.id+ ")\">Book</button</td></tr></tr>"
														
						}					
						else{
							content += "<tr><td>"+ ++i +
							"</td><td>"+serviceItem.service+"</td><td>"
							+serviceItem.serviceCharge+
							"</td><td><button class = 'btn btn-primary'>Book</button</td></tr></tr>"							
						}					
					}
					$('#tableId tbody').append(content);
	        		$('#tableId').dataTable();
				})
		 });
			
			function removeService(id){
				event.preventDefault();
				const queryParams = "?id="+id;
				let url = "RemoveService"+queryParams;
				let content = "";
				fetch(url).then(res=>res.json()).then(res=>{
					let data = res;
					console.log(data);
					content+=data.infoMessage;
					alert(content);
					window.location.href="services.jsp";					
				}).catch(err=>{
					let data = err.response;
					console.log(data);
					content+=data.errorMessage;
					alert(content);
				});
				
			}
			
			//getAllServices();
						
		</script>

	</main>
</body>

</html>

<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/fontawesome.min.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- JS -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>

<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>

<script
	src="https://cdn.datatables.net/1.10.4/js/jquery.dataTables.min.js"></script>
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.10.4/css/jquery.dataTables.min.css">
<script
	src="http://ajax.aspnetcdn.com/ajax/jquery.templates/beta1/jquery.tmpl.min.js"
	type="text/javascript"></script>

<%
String Role = (String) session.getAttribute("Role");
%>

<header>
	<nav class="navbar navbar-expand-sm navbar-dark bg-dark">
		<a class="navbar-brand" href="index.jsp">AXLES</a>
		<button class="navbar-toggler d-lg-none" type="button"
			data-toggle="collapse" data-target="#collapsibleNavId"
			aria-controls="collapsibleNavId" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="collapsibleNavId">
			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<%
				if (Role == "USER") {
				%>
				<li class="nav-item active"><a class="nav-link"
					href="quickBook.jsp">Home </a></li>
				<%
				}
				%>

				<li class="nav-item"><a class="nav-link" href="services.jsp">Services</a>
				</li>
			</ul>
			<%
			if (Role == null) {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="dropdownId"
					data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">LOGIN</a>
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item" href="adminLogin.jsp">ADMIN</a> <a
							class="dropdown-item" href="userLogin.jsp">USER</a>
					</div></li>
				<li class="nav-item"><a class="nav-link"
					href="userRegistration.jsp">Register</a></li>
			</ul>
			<%
			}
			if (Role == "ADMIN") {
			%>

			<ul class="navbar-nav mr-auto mt-2 mt-lg-0">
				<li class="nav-item"><a class="nav-link" href="carsTable.jsp">Cars</a>
				</li>
				<li class="nav-item"><a class="nav-link"
					href="addNewDetails.jsp">Add new Detail</a></li>
			</ul>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">
				<li class="nav-item active"><a class="nav-link"
					href="AdminLogout">Logout</a></li>
			</ul>

			<%
			}
			if (Role == "USER") {
			%>
			<ul class="navbar-nav ml-auto mt-2 mt-lg-0">

				<li class="nav-item dropdown">
					<div class="dropdown-menu" aria-labelledby="dropdownId">
						<a class="dropdown-item" href=#></a> <a class="dropdown-item"
							href="#"> </a> <a class="dropdown-item" href="#"> </a>
					</div>
				</li>

				<li class="nav-item active"><a class="nav-link"
					href="UserLogout">Logout</a></li>

			</ul>

			<%
			}
			%>

		</div>
	</nav>
</header>






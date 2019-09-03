<%@page import="models.Vehicle"%>
<%@page import="java.util.ArrayList"%>

<html>
<head>

	<meta charset="UTF-8">
	<title>Vehicle DB</title>
	<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="css/site.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
	<h1><img alt="" src="images/vLogo.png"></h1>
	<c:choose>
		<%--If the session loggedin is true then show update, delete, sold and new vehicle buttons--%>
		<c:when test="${loggedin == true}">
				<form class="form-inline" method="POST" action="./searchVehicle" style="margin-left:2%; float:left;">
				    <input class="form-control mr-sm-2" name="value" type="search" min="1" placeholder="Search" aria-label="Search" required>
				    <select class="form-control mr-sm-2" name="type">
					  <option value="vehicle_id">ID</option>
					  <option value="make">Make</option>
					  <option value="year">Year</option>
					  <option value="price">Price</option> 
					</select>
				    <button class="btn btn-dark" type="submit">Search</button>
				    <a href="./logout" class="btn btn-dark">Logout</a>
				    <a href="./addVehicle" class="btn btn-success">+ New Vehicle</a>
				    
		  		</form>
		  		<form method="POST" action="./getApi" style="float:left;">
				   	<button type="submit" class="btn btn-info">API Key</button>
				   	<input type="hidden" value="${username}" name="username">
				   	<input type="hidden" value="${password}" name="password">
				</form>
				<table class="table table-sm">
					<thead class="thead-dark">
						<tr>
							<th> Vehicle ID</th>
							<th> Make</th>
							<th> Model</th>
							<th> Year</th>	
							<th> Price</th>
							<th> License Number</th>
							<th> Colour</th>
							<th> Number Of Doors</th>
							<th> Transmission</th>
							<th> Mileage</th>
							<th> Fuel Type</th>
							<th> Engine Size</th>
							<th> Body Style</th>
							<th> Condition</th>
							<th> Notes</th>
							<th> Sold</th>
							<th> Edit</th>
						</tr>
					</thead>
					<c:forEach items="${allVehicles}" var="v">
						<tr id="${v.getVehicle_id()}">
							<td>${v.getVehicle_id()}</td>
							<td>${v.getMake()}</td>
							<td>${v.getModel()}</td>
							<td>${v.getYear()}</td>
							<td>${v.getPrice()}</td>
							<td>${v.getLicense_number()}</td>
							<td>${v.getColour()}</td>
							<td>${v.getNumber_doors()}</td>
							<td>${v.getTransmission()}</td>
							<td>${v.getMileage()}</td>
							<td>${v.getFuel_type()}</td>
							<td>${v.getEngine_size()}</td>
							<td>${v.getBody_style()}</td>
							<td>${v.getCondition()}</td>
							<td>${v.getNotes()}</td>
							<td>${v.isSold()}</td>
							<c:set var="sold" value="${v.isSold()}"/>
							<td>
							<div class="editVehicle">
								<a href="./updateVehicle?vehicle_id=${v.getVehicle_id()}" class="btn btn-warning">Update</a>
								<form method="POST" action="./deleteVehicle" >
									<button type="submit" class="btn btn-danger" value="${v.getVehicle_id()}" name="vehicle_id" id="delete" onClick="showAlert(event)">Delete</button>
								</form>
								<%--If sold is false show the sold button--%>
								<c:if test="${sold eq false}">
									<form method="POST" action="./soldVehicle" >
										<button class="btn btn-primary" value="${v.getVehicle_id()}" name="vehicle_id" id="sold${v.getVehicle_id()}" style="width:80px;margin-top: -16px;">Sold</button>
									</form>
								</c:if>
								<%--If sold is true show the unsold button--%>
								<c:if test="${sold eq true}"> 
									<form method="POST" action="./unsoldVehicle" >
										<button class="btn btn-primary" value="${v.getVehicle_id()}" name="vehicle_id" id="unsold${v.getVehicle_id()}" style="width:80px;margin-top: -16px;">Unsold</button>
									</form>
								</c:if>
							</div>
							</td>
						</tr>
						<%--Set the table row of the unsold button clicked to the class click style--%>
						<script>
						$(document).ready(function(){
							$('#unsold' + ${v.getVehicle_id()}).closest('tr').addClass('click');
						});
						</script>
					</c:forEach>
				</table>
			<br />
	</c:when>
	<c:otherwise>
		<div class="container">
				<form class="form-inline" method="POST" action="./searchVehicle">
				    <input class="form-control mr-sm-2" name="value" type="search" min="1" placeholder="Search" aria-label="Search" required>
				    <select class="form-control mr-sm-2" name="type">
					  <option value="vehicle_id">ID</option>
					  <option value="make">Make</option>
					  <option value="year">Year</option>
					  <option value="price">Price</option>
					</select>
				    <button class="btn btn-dark" type="submit">Search</button>
				    <a href="./login" class="btn btn-dark">Login</a>
				    <a href="./addUser" class="btn btn-dark">Sign Up</a>
		  		</form>
				<table class="table table-sm">
					<thead class="thead-dark">
						<tr>
							<th> Vehicle ID</th>
							<th> Make</th>
							<th> Model</th>
							<th> Year</th>
							<th> Price</th>
							<th> License Number</th>
							<th> Colour</th>
							<th> Number Of Doors</th>
							<th> Transmission</th>
							<th> Mileage</th>
							<th> Fuel Type</th>
							<th> Engine Size</th>
							<th> Body Style</th>
							<th> Condition</th>
							<th> Notes</th>
						</tr>
					</thead>
					<c:forEach items="${allVehicles}" var="v">
						<tr>
							<td>${v.getVehicle_id()}</td>
							<td>${v.getMake()}</td>
							<td>${v.getModel()}</td>
							<td>${v.getYear()}</td>
							<td>${v.getPrice()}</td>
							<td>${v.getLicense_number()}</td>
							<td>${v.getColour()}</td>
							<td>${v.getNumber_doors()}</td>
							<td>${v.getTransmission()}</td>
							<td>${v.getMileage()}</td>
							<td>${v.getFuel_type()}</td>
							<td>${v.getEngine_size()}</td>
							<td>${v.getBody_style()}</td>
							<td>${v.getCondition()}</td>
							<td>${v.getNotes()}</td>
						</tr>
					</c:forEach>
				</table>
				</div>
		<br />
	</c:otherwise>
	</c:choose>
	<%--Show an alart before deleting the vehicle--%>
	<script>
	function showAlert(e) {
	    var txt;
	    var r = confirm("Are you sure you want to delete vehicle?");
	    if (r == true) {
	        txt = "You pressed OK!";
	        return true;
	    } else {
	        txt = "You pressed Cancel!";
	        e.preventDefault();
	        return false;
	    }
	}
	</script>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>


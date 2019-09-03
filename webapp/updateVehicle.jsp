<%@page import="models.Vehicle"%>
<%@page import="java.util.ArrayList"%>

<!DOCTYPE html>
<html>
<head>
	<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
	<c:set value="${Vehicles}" var="v" />
	<title>Update Vehicle</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="css/site.css">
</head>
<body>
	<h1>Update Vehicle</h1>
	<div class="container">
		<a href="./home" class="btn btn-dark">Home</a>
		<form method="POST" action="./updateVehicle" class="form-group"> 
			Make: 
			<input type="text" name="make" class="form-control" id="exampleFormControlInput1" value="${v.getMake()}"required> 
			Model: 
			<input type="text" name="model" class="form-control" id="exampleFormControlInput1" value="${v.getModel()}" required>
			Year: 
			<input type="text" name="year" class="form-control" id="exampleFormControlInput1" value="${v.getYear()}" required>
			Price: 
			<input type="text" name="price" class="form-control" id="exampleFormControlInput1" value="${v.getPrice()}" required>
			License Number e.g AB12ABC: 
			<input type="text" name="license_number" class="form-control" pattern="[A-Z][A-Z0-9][0-9][0-9][A-Z][A-Z][A-Z]" id="exampleFormControlInput1" value="${v.getLicense_number()}" required>
			Colour: 
			<input type="text" name="colour" class="form-control" id="exampleFormControlInput1" value="${v.getColour()}" required>
			Number Of Doors: 
			<input type="text" name="number_doors" class="form-control" id="exampleFormControlInput1" value="${v.getNumber_doors()}" required>
			Transmission: 
			<input type="text" name="transmission" class="form-control" id="exampleFormControlInput1" value="${v.getTransmission()}" required>
			Mileage: 
			<input type="text" name="mileage" class="form-control" id="exampleFormControlInput1" value="${v.getMileage()}" required>
			Fuel Type: 
			<input type="text" name="fuel_type" class="form-control" id="exampleFormControlInput1" value="${v.getFuel_type()}" required>
			Engine Size: 
			<input type="text" name="engine_size" class="form-control" id="exampleFormControlInput1" value="${v.getEngine_size()}" required>
			Body Style: 
			<input type="text" name="body_style" class="form-control" id="exampleFormControlInput1" value="${v.getBody_style()}" required>
			Condition: 
			<input type="text" name="condition" class="form-control" id="exampleFormControlInput1" value="${v.getCondition()}" required>
			Notes: 
			<input type="text" name="notes" class="form-control" id="exampleFormControlInput1" value="${v.getNotes()}" required>
			<br>
			<button type="submit" value="${v.getVehicle_id()}" name="vehicle_id" class="btn btn-dark">Save</button>
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>


</html>
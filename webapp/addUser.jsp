<!DOCTYPE html>
<html>
<head>
	<title>Add New Vehicle</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
	<link rel="stylesheet" href="css/site.css">
</head>
<body>
	<h1>Sign Up</h1>
	<div class="container">
		<a href="./home" class="btn btn-dark">Home</a>
		<form method="POST" action="./addUser" class="form-group">
			Firstname: 
			<input type="text" name="firstname" class="form-control" id="exampleFormControlInput1" required> 
			Lastname:
			<input type="text" name="lastname" class="form-control" id="exampleFormControlInput1" required> 
			Username:
			<input type="text" name="username" class="form-control" id="exampleFormControlInput1" required> 
			Password: 
			<input type="text" name="password" class="form-control" id="exampleFormControlInput1" required>
			Confirm Password: 
			<input type="text" name="conPassword" class="form-control" id="exampleFormControlInput1" required>  
			<br>
			<input type="submit" class="btn btn-dark">
		</form>
	</div>
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</body>
</html>
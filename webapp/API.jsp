<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Vehicle DB</title>
	<meta <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<link rel="stylesheet" href="css/site.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

</head>
<body>
	<h1><img alt="" src="images/vLogo.png"></h1>
	
	<div class="API">
		<h3>Hi ${api.getFirstname()}</h3>
		<h3>Your API Key: </h3><h3 style="color: blue">${api.getApi()}</h3>
		<a href="./home" class="btn btn-dark">Home</a>
	</div>

</body>
</html>
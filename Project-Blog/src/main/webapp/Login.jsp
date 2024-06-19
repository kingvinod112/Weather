<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded">
	
	<h2>Login</h2>
	<form action="Login" method="post">
	<label class="text-${cl}">${log}</label>
	<input type="email"  class="form-control" name="email" placeholder="Email" Required><br>
	<input type="password"  class="form-control" name="pass" placeholder="Password" Required>
	<a href="Forgot">Forgot password ?</a><br><br>
	<input type="submit" value="submit"  class="btn btn-primary" />
	<a class="text-decoration-none text-white btn btn-success" href="/">Back to Home</a>
	<a class="text-decoration-none text-white btn btn-success" href="Register">Register</a>

	

	
	</form>
</section>
</body>
</html>
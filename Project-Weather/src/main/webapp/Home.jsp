<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Weather API</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<section class="border border-secondary p-4 w-50 mx-auto my-5 bg-dark shadow rounded">
	
			<h2 class="text-center text-white">Weather Report</h2>
			<form action="Weather" method="Get">
				<input type="search" role="search"  class="form-control" name="city" placeholder="Enter Your Location" Required><br>	
				<div class="w-50 mx-auto">
				
					<input type="submit" value="submit"  class="btn btn-outline-success ms-5 me-3" />
					<a class=" text-decoration-none  btn btn-outline-info " href="Home.jsp">Refresh</a>	
					
				</div>	
			</form>
	</section>
	<section ${cl}="border border-secondary p-4 w-50 mx-auto my-5  shadow rounded">
		<h2 class="text-center ">${l1}</h2>
		
		<h4 class="text-center ">${l2}</h4>
		<h4 class="text-center ">${l3}</h4>
		<h4 class="text-center ">${l4}</h4>
		<h4 class="text-center ">${l5}</h4>
		<h4 class="text-center ">${l6}</h4>
		
	</section>

</body>
</html>
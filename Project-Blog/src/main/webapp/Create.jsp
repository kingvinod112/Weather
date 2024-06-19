<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Blog</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded">
	
	<h2>New Blog</h2>
	<form action="Create" method="post">
		<input type="text"  class="form-control" name="title" placeholder="Blog Title" Required><br>
		<textarea rows="" cols="" class="form-control" name="content" placeholder="Enter Content Here.." Required></textarea><br>
		<input type="${upd}"  class="form-control" name="aname" value="${aname}" Required><br>
		
		<input type="submit" value="submit"  class="btn btn-primary" />
	
	<a class=" text-decoration-none text-white btn btn-success" href="Blogs">Back to Blogs</a>	
	</form>
</section>
</body>
</html>
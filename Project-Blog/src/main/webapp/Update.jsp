<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Blog</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
	<section class="border border-secondary p-4 w-50 mx-auto my-5 shadow rounded">
	
	<h2>Update Blog</h2> 
	<form action="Edit" method="post">
		<input type="hidden" name="id"  value="${uid}"><br>
		<input type="text"  class="form-control" name="title" value="${utitle}" placeholder="Blog Title" Required><br>
		<input type="text"  class="form-control" name="cont" value="${ucont}" placeholder="Blog Content" Required><br>
		<input type="${upd}"  class="form-control" name="aname" value="${uname}" placeholder="Author Name" Required><br>
		<input type="submit" value="submit"  class="btn btn-primary" />
	<a class=" text-decoration-none text-white btn btn-success" href="MyBlog">Back</a>
		
	</form>
</section>
</body>
</html>
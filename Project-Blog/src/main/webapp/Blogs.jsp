<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <title>My Blog</title>
    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    <title>Home</title>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }
        nav{
            background-color: rgb(30, 53, 72);
        }
       

        main {
            padding: 20px;
        }

        article {
            background-color: #fff;
            padding: 20px;
            margin-bottom: 20px;
        }

        article h2 {
            color: #333;
        }

        article time {
            color: #666;
        }

        footer {
            background-color: #333;
            color: #fff;
            text-align: center;
            padding: 10px 0;
            position: fixed;
            width: 100%;
            bottom: 0;
        }
        details{
            margin-bottom: 10px;
        }
        summary{
            cursor:pointer;
            font-weight: bold;
        }
        details [open] summary{
            color: blue;
        }
        
        .del{
       
        position: absolute;
        
        right: 122px;
       	
        }
        .ed{
       
        position: absolute;
        
        right: 180px;
       	
        }
        
    </style>
</head>
<body>
    <nav class="  d-flex sticky-top">
        <a href="#" class=" m-0" ><img src="https://patiyer.com/wp-content/uploads/2021/07/Blog-speech-bubbles.png" alt="" style="height:60px; width:100; margin-left:20px;"></a>

        <div class="d-flex m-2 me-5">
            <a href="/" class="btn btn-outline-info m-2 me-2 ms-3" >Home</a>
            <a href="Blogs" class="btn btn-warning  mt-2 mb-2" >Blogs</a>
            <a href="Create" class="btn btn-success m-2 ms-3" >Create Blog</a>
            <a href="MyBlog" class="btn btn-success m-2" >My Blog</a>
            
            <form class="d-flex m-2 ms-5 me-5" action="Search" method="Post" role="search">
                <input class="form-control w-70" type="search" name="srch" placeholder="Search Blog Title" aria-label="Search">
                <button class="btn btn-primary me-5" type="submit">Search</button>

            </form>
        </div>
        
        <div class="m-2 ms-5">
            <a href="Logout" class="btn btn-${colr} m-2 ms-5" >${hlo}</a>
        </div>
    </nav>
	
		<h2 class="text-primary mt-4 mb-4 ms-5">${username} !</h2>  
		<h4 class="text-center text-${mc}" >${nblg}</h4>
		<h1 class=" text-${myc} text-center">${myblg}</h1>
    
    <main>
    <c:forEach items="${records}" var="blog">
        <article>
            <h2>${blog.title}<a class="del" href="Delete?id=${blog.id}">${del}</a> <a class="ed" href="Edit?id=${blog.id}&title=${blog.title}&cont=${blog.content}&aname=${blog.aname}">${edt}</a></h2>
            <details>
            <p>${blog.content}</p>
            </details>
            <p>Author: ${blog.aname}</p>
        </article>
	</c:forEach>
	
        
    </main>

    <footer>
        <p>&copy; 2024 My Blog. All rights reserved.</p>
    </footer>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

	<title>Home</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>    <title>Home</title>
    <Style>
        
       
        body{
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            
        }
        nav{
            background-color: rgb(30, 53, 72);
        }
        .pcon{
            margin:10px 80px 80px 80px;
        }

		a{
		text-decoration: none;
		}
       
        
    </Style>
</head>
<body>
    <nav class="  d-flex sticky-top">
        <a href="#" class=" m-0" ><img src="https://patiyer.com/wp-content/uploads/2021/07/Blog-speech-bubbles.png" alt="" style="height:60px; width:100; margin-left:20px;"></a>
		<a href="Blogs" class="btn btn-warning mt-2 mb-3 ms-5 " >Blogs</a>
        <div class="mx-auto ">
            <a href="#0" class="btn btn-outline-success m-2" >Science & Technologies</a>
            <a href="#1" class="btn btn-outline-success m-2" >Nature</a>
            <a href="#2" class="btn btn-outline-success m-2" >Animals</a>
            <a href="#3" class="btn btn-outline-success m-2" >Food</a>
        </div>
        <div class="me-5  ms-2">
            <a href="Logout" class="btn btn-${colr} m-2" >${hlo} </a>
        </div>
    </nav>

 
        <h2 class="text-primary mt-4 mb-4 ms-5">${username} !</h2>
    

    <a href="Blogs" class="text-black">
    <div class="pcon">
    <h1 class="text-center" id="0">Science & Technologies</h1> 
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/Nature/T1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/T2.jpg" class="d-block w-100" alt="Image">
          </div>
          <div class="carousel-item">
            <img src="/Nature/T3.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div></a>
    

	<a href="Blogs" class="text-black">
    <div class="pcon">
    <h1 class="text-center" id="1">Nature</h1>
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/Nature/N1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/N2.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/N3.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div></a>
    
    <a href="Blogs" class="text-black">
    <div class="pcon">
    <h1 class="text-center" id="2">Animals</h1>
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/Nature/A1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/A2.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/A3.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div></a>
   
   <a href="Blogs" class="text-black">
    <div class="pcon">
    <h1 class="text-center" id="3">Food</h1>
    <div id="carouselExampleAutoplaying" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-inner">
          <div class="carousel-item active">
            <img src="/Nature/F1.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/F2.jpg" class="d-block w-100" alt="...">
          </div>
          <div class="carousel-item">
            <img src="/Nature/F3.jpg" class="d-block w-100" alt="...">
          </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="visually-hidden">Next</span>
        </button>
      </div>
    </div></a>


</body>
</html>
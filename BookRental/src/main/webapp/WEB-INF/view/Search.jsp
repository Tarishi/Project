<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1"> -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>
<script src=" <c:url value="/resources/js/bootstrap.min.js"/>"></script>

<!--     links for data tables starts here -->
<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<!-- <link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css"> -->

<script type="text/javascript" language="javascript"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>
<script type="text/javascript" charset="utf-8">
       $(document).ready(function() {
    	   activetab();
              $('#example').dataTable( {
            language: {
                searchPlaceholder: "Search within table "
            }
        } );
       });

</script>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href=" <c:url value="/resources/css/small-business.css" />"
	rel="stylesheet">
<link href="<c:url value="webapp/resources/css/small-business.css"/>"
	rel="stylesheet">
</head>
<body>
<body>

<div class="container">
   
   		<header>
   		
   		<div class="row">
					<div class="col-lg-12">
   <nav class="navbar navbar-default navbar-inverse" role="navigation">
								
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
					<ul class="nav navbar-nav">
					<li class="active">
							<a href="#"><h4>Book At Your Step</h4></a>
						</li>
					
					<li class="active">
							<a href="loginform.htm"><h4>Home</h4></a>
						</li>
						
						<li class="active">
							<a href="#"><h4>About Us</h4></a>
						</li>
						<li class="active">
							<a href="#"><h4>Contact Us</h4></a>
						</li>
						
					</ul>
					
				</div>
			</nav>
			</div>
			</div>
   </header>
     

		<div class="col-md-12 column">
			<nav class="navbar navbar-default " role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					<form class="navbar-form navbar-left" role="search"
						action="nonesearch.htm" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="searchTitle" placeholder="search By Title"/>
							<input type="text" class="form-control" name="searchAuthor" placeholder="search By Author"/>
							<input type="text" class="form-control" name="searchCategory" placeholder="search By Category"/>
						</div>
						<button type="submit" class="btn btn-default" >Search</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li>NEW USER? <a href="register.htm">REGISTER</a>
						</li>

					</ul>
				</div>

			</nav>
		</div>



	</div>
	<!-- /.container -->
	<!--  </nav> -->

	<!-- Page Content -->
	<div class="container">

		<!-- Heading Row -->
		<div class="row">
			<div class="col-md-12">
				
				
			<!-- /.col-md-8 -->


<!-- Subscribe Here to Read Books  <a href="register.htm">REGISTER</a>
<br></br>
Already a member  <a href="loginform.htm">login</a> -->
<br></br>
	<form action="search.htm" method="post">
	<div id="notfound" style="color:red">
					 ${show}
					</div>
		<c:if test="${not empty searchbook}">
						
						
						 <table id="example" class="table table-bordered">
								<thead>
							<tr style="background-color: lightsteelblue;">

								<th>Book Title</th>
								<th>Book Author</th>
								<th>Book Publisher</th>
								<th>Book Availability</th>
								<th>Book Category</th>
								<th>Book Description</th>
								<th>Book Image</th>
							</tr>
							</thead>
							<tbody>
							<c:forEach items="${list}" var="book" varStatus="book1">
							
							
								<tr class="info">
									<td>${book.bookTitle}</td>
									<td>${book.bookAuthor}</td>
									<td>${book.bookPublisher}</td>
									<td><c:forEach var="available" items="${available}" varStatus="check2">
												<c:if test="${book1.index ==check2.index }">
													<c:if test="${available =='In Stock'}" >
													<div style="color: green">
													    ${available}
													    </div>
													</c:if>
													<c:if test="${available=='Out Of Stock'}">
													<div style="color: red">
														${available}
														</div>
													</c:if>

												</c:if>
											</c:forEach></td>
									<td>${book.bookCategory}</td>
									<td>${book.bookDescription}</td>
									<td><img alt=""
											src="<c:url value="/resources/images/${book.bookImage}"/>"
											width="75" height="75" /></td>
													
								  
								
								</tr>
							</c:forEach>
							</tbody>
						</table>

					</c:if>
	</form>
	
	</div>
			</div>
			</div>
</body>
</html>
</body>
</html>
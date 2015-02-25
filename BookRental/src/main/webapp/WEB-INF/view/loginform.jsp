<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html lang="en">

<head>


<!-- validation of login -->
<style>
.error {
	color: #ff0000;
	font-style: italic;
}
</style>
<!-- <style>
	.panel-group{
		position: absolute;
		width: 328px;
		z-index: 10;
	}
	.thumbnail{
		padding-bottom:52px;
	}
</style> -->
<script src="<c:url value="//code.jquery.com/jquery-1.9.1.js"/>"></script>
<script
	src="<c:url value="//ajax.aspnetcdn.com/ajax/jquery.validate/1.9/jquery.validate.min.js"/>"></script>
<script>
  
  // When the browser is ready...
  $(function() {
  
    // Setup form validation on the #register-form element
    $("#login").validate({
    
        // Specify the validation rules
        rules: {
            userName: "required",
            
            userPassword: {
                required: true,
               
            },
            
     
        },
        
        // Specify the validation error messages
        messages: {
            userName: "Please enter your first name",
            
            userPassword: {
                required: "Please provide a password",
                minlength: "Your password must be at least 5 characters long"
            },
            
       
        },
        
        submitHandler: function(form) {
            form.submit();
        }
    });

  });
  
  </script>
<!-- /validation -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>BOOK RENTAL</title>

<!-- Bootstrap Core CSS -->
<%-- <c:url value="/resources/css/bootstrap.min.css"/> --%>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href=" <c:url value="/resources/css/small-business.css" />"
	rel="stylesheet">
<link href="<c:url value="webapp/resources/css/small-business.css"/>"
	rel="stylesheet">

</head>

<body>

   


	<!-- Navigation -->
	<!-- <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation"> -->
	<div class="container">
   
   		<header>
   		
   		<div class="row">
					<div class="col-lg-12">
   <nav class="navbar navbar-default navbar-inverse" role="navigation">
			<!-- 	<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Book At Your Step</a>
				</div> -->
				
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1" style="background-color: black">
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
			<nav class="navbar navbar-default " role="navigation" >
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1" style="background-color:lightslategrey; width: 1138px;
margin-left: -17px;">
					<form class="navbar-form navbar-left" role="search" style="padding-top:19px;"
						action="nonesearch.htm" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="searchTitle" placeholder="search By Title" style="background-color: aliceblue;"/>
							<input type="text" class="form-control" name="searchAuthor" placeholder="search By Author" style="background-color: aliceblue"/>
							<input type="text" class="form-control" name="searchCategory" placeholder="search By Category" style="background-color: aliceblue"/>
						</div>
						<button type="submit" class="btn btn-default" style="
    background-color: lightsteelblue;
    color: black;
    font-weight: 500;"
						>Search</button>
					</form>
					<ul class="nav navbar-nav navbar-right">
						<li style="color:black"><br>NEW USER? <a href="register.htm" style="color:black">REGISTER</a>
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
			<div class="col-md-8">
				<div class="carousel slide" id="carousel-927073">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-927073"></li>
						<li data-slide-to="1" data-target="#carousel-927073"></li>
						<li data-slide-to="2" data-target="#carousel-927073"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" class="img-responsive img-rounded"
								src="resources/images/images (4).jpg"
								style="height: 249px; width: 586x;" />
							<div class="carousel-caption">
								<h4>
									<!-- First Thumbnail label -->
								</h4>
								<p></p>
							</div>
						</div>
						<div class="item">
							<img alt="" class="img-responsive img-rounded"
								src="resources/images/elibrary.jpg"
								style="height: 249px; width: 586x;" />
							<div class="carousel-caption">
								<h4>
									<!-- Second Thumbnail label -->
								</h4>
								<p></p>
							</div>
						</div>
						<div class="item">
							<img alt="" class="img-responsive img-rounded"
								src="resources/images/img_e-library.jpg"
								style="height: 249px; width: 586x;" />
							<div class="carousel-caption">
								<h4>
									<!-- 	Third Thumbnail label -->
								</h4>
								<p></p>
							</div>
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-927073"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-927073"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
			<!-- /.col-md-8 -->


		<%-- 	<form:form action="loginform.htm"  method="POST"
				id="login"> --%>
<form action="<c:url value='j_spring_security_check' />" method="post">
				<table cellspacing="0">
					<tr>

						<th style="width: 276px; height: 46px">LOGIN:</th>
						<td style="width: 339px;"></td>
					</tr>

					<tr>

						<th style="width: 276px; height: 79px"><label>User Name:</label></th>
						<td style="width: 339px;"><input type="text" name="j_username"
								size="20" maxlength="15" required="true" class="form-control" style=" width: 175px;"/></td>
					</tr>
					<tr>
						<th style="height: 71px;"><label>Password:</label></th>
						<td style="width: 463px;"><input type="password" name="j_password"
								size="20" showPassword="true" required="true" class="form-control" style=" width: 175px;"/></td>
					</tr>

					<tr>

						<td colspan="2" class="error" style="height: 34px;"><c:out
								value="${loginError}" /></td>
					</tr>


					<tr>
						<th style="height: 49px;"></th>
						<td style="height: 30px;"><input name="commit" type="submit" class="btn btn-default" style="background-color: lightsteelblue; font-weight: bold;font-family: initial;font-size: 14px;"
							value="LOGIN " />  &nbsp &nbsp   <a href="forgotPassword.htm">Forgot Password?</a></td>
							
					</tr>


				</table>

			</form>

			<!-- /.row -->

			<hr>

			<!-- Call to Action Well -->
			<div class="row">
				<div class="col-lg-12">
					<!-- <div class="well text-center" style="background-color: lightslategrey; color:black"><h4>New Arrivals Here</h4></div> -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->

			<!-- Content Row -->
			 <div class="well" style="background-color: rgb(227, 235, 247);">
                   
                     
                   <div class="row">
                  <div class=" text-center" style="background-color:  rgb(227, 235, 247); color:black"><h4>New Arrivals Here</h4></div>
                   <c:forEach var="v" items="${list}" begin="0" end="5">
				<div class="col-md-4" style="width:247px height:325px;">
				
					<div class="thumbnail" style="background-color: aliceblue; padding-bottom:52px;">
					
						<img alt="image" src="<c:url value="/resources/images/${v.bookImage}"/>" style="width:150px; height:180px;"/>
									 
						<div class="caption" >
							<h5 style="font-weight: 600;">
								${v.bookTitle}
							</h5>
							
							
								<div class="panel-group" id="panel-277316${v.ISBN}" style="position: absolute;
		width: 328px;
		z-index: 10;">
				
				<div class="panel panel-default">
					<div class="panel-heading" style="background-color: lightsteelblue;">
						<a class="panel-title collapsed" data-toggle="collapse" data-parent="#panel-277316${v.ISBN}" href="#panel-element-954643${v.ISBN}" >Details</a>
					</div>
					<div id="panel-element-954643${v.ISBN}" class="panel-collapse collapse">
						<div class="panel-body">
							Name: ${v.bookTitle}<br>
							Category: ${v.bookCategory}<br>
							Author: ${v.bookAuthor}<br>
							Publisher: ${v.bookPublisher}<br>
						</div>
					</div>
				</div>
			</div>
							
						</div>
					</div>
				</div>
				
				</c:forEach>
			</div>
                   
              </div>     
			
			<!-- /.row -->

			<!-- Footer -->
			<footer>
				<div class="row">
					<div class="col-lg-12">
						<p>Copyright &copy; Book At Your Step</p>
					</div>
				</div>
			</footer>

		</div>
		<!-- /.container -->

		<!-- jQuery Version 1.11.0 -->
		<%-- <c:url value="/resources/js/jquery-1.11.0.js" /> --%>
		<script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>

		<!-- Bootstrap Core JavaScript -->
		<%--   <c:url value="/resources/js/bootstrap.min.js" /> --%>
		<script src=" <c:url value="/resources/js/bootstrap.min.js"/>"></script>
		<script>
    $('.carousel').carousel({
        interval: 2000 //changes the speed
    })
    </script>
</body>

</html>







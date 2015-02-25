<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Book at your step</title>

<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<%-- 	<script src="<c:url value="/resources/js/jquery-ui-1.10.4.js"/>"></script> --%>
<script src=" <c:url value="/resources/js/scriptsource.js"/>"></script>
<%--   <script src=" <c:url value="/resources/js/autocomplete-0.3.0.js"/>"></script> --%>
<%--    <script src=" <c:url value="/resources/js/dataTables.jqueryui.js"/>"></script> --%>
<!-- Bootstrap Core JavaScript -->
<%-- 	  <c:url value="/resources/js/bootstrap.min.js" /> --%>
<script src=" <c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" language="javascript"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
	<link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
</head>
<body>


  <div class="container" align="center">
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
		<!-- Heading Row -->
		<div class="row" align="center">
			<div class="col-md-12" align="center">
	
	<img alt="" class="img-responsive img-rounded" src="resources/images/images (7).jpg"	style="height: 200px; width: 1200px;"/>
	
			<form role="form" action="forgotPassword.htm" method=Post>
				<div class="form-group" align="center">
					 <br><br><br><br><br><br><label for="userName">Enter User Name:</label><input type="text" required="true" class="form-control" style=" width: 175px;" align="center" name="userName" id="userName" />
					 <br>
				
				<br>  <button type="submit" class="btn btn-default" align="center">Submit</button>  &nbsp &nbsp &nbsp
				<a href="loginform.htm"> <button type="button" class="btn btn-default">Cancel</button></a>
				</div>
				<br>
				${res}
			</form>
			</div>
			</div>
			</div>
</body>
</html>
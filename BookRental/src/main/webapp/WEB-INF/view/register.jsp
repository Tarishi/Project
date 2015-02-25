<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglibprefix ="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<title>Insert title here</title>

<script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script>

	<!-- Bootstrap Core JavaScript -->
	<%--   <c:url value="/resources/js/bootstrap.min.js" /> --%>
	<script src=" <c:url value="/resources/js/bootstrap.min.js"/>"></script>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href=" <c:url value="/resources/css/small-business.css" />"
	rel="stylesheet">
<link href="<c:url value="webapp/resources/css/small-business.css"/>"
	rel="stylesheet">



<!-- jQuery Form Validation code -->
<script>
  function hideDiv() {
      document.getElementById("plan").style.display = 'none';   
      
    }
  $(document).ready(function(){
  
  $('.btnSubscription').click(function() {
			var getId = $(this).attr('value');
			$('#planid').val(getId);
		})
  
  $("#plan_id").click(function(){
   document.getElementById("plan").style.display = 'block';    
  });
});
   
  function userIdAvailable(){
	    var checkname=$('#userName').val();
	    
	    console.log("check" +checkname);
	    if(checkname!=""){
	           
	    $("#user").show();
	    $.ajax({
	           type: "POST",
	           url: "${pageContext.request.contextPath}/checkavailability.htm",
	           data: {
	                 username : checkname
	           },
	           cache: false,
	           success: function(response){
	           var result=(response);
	           if(result=="true"){
	           document.getElementById("user").style.color="green";
	           $("#user").html('<span/>Username Avaliable !');
	           document.getElementById("submit").disabled=false;
	           }
	           else
	    
	           {
	           document.getElementById("user").style.color="red";
	           $("#user").html('<span class="glyphicon glyphicon-remove-sign" /> This Username is Already Taken');
	           document.getElementById("submit").disabled=true;
	           }
	           },
	           error : function(error){
	                 alert(error);
	           },
	           fail : function(){
	                 alert("fail");
	           }
	           
	           });
	           }else{
	           $("#user").html('');
	           }
	           
	           };



  
  </script>
 <style>
label{
 margin-right: 25px;
 } 

</style>
</head>
<body onload="hideDiv()">
<div class="container">
   
   		<header>
   		
   		<div class="row">
					<div class="col-lg-12">
   <nav class="navbar navbar-default navbar-inverse" role="navigation">
			<!-- 	<div class="navbar-header">
					 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="icon-bar"></span><span class="icon-bar"></span><span class="icon-bar"></span></button> <a class="navbar-brand" href="#">Book At Your Step</a>
				</div> -->
				
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
<div class="container">

		<!-- Heading Row -->
		<div class="row">
			<div class="col-md-12">
      <img alt="" class="img-responsive img-rounded" src="resources/images/images (7).jpg"	style="height: 200px; width: 1200px;"/>
      <br>
 	<h3>Register </h3>

	<sf:form action="register.htm" method="post" id="register" role="form"
		modelAttribute="RegisterForm">
		<div class="form-group">
<div class="col-md-6">
		<fieldset>
			<table cellspacing="0">
				<tr >
					<th><sf:label path="userName" id="username"> UserName: </sf:label></th>
					<td ><input type="text" id="userName" name="userName" required="true" class="form-control"  style=" width: 225px;" onblur="userIdAvailable()"> <span id="user"></span></td>
				</tr>
				<tr>
			<td><br></td>
				</tr>
				<tr>
					<th><sf:label path="firstName" id="firstname"> FirstName: </sf:label></th>
					<td><input type="text" id="firstName" name="firstName" required="true" class="form-control" style=" width: 225px;"/></td>
				</tr>
				<tr>
			<td><br></td>
				</tr>
				
				<tr>
					<th><sf:label path="lastName" id="lastname">LastName:</sf:label></th>
					<td> <input type="text" id="lastName" name="lastName" required="true"  class="form-control" style=" width: 225px;"/></td>
				</tr>
				<tr>
			<td><br></td>
				</tr>
				<tr>
					<th><sf:label path="userPassword" id="password">Password:</sf:label></th>
					<td> <input type="password" id="userPassword" name="userPassword" required="true"  class="form-control" style=" width: 225px;"/></td>
				</tr>
				<tr>
			<td><br></td>
				</tr>
				<tr>
					<th><sf:label path="email" id="email">Email Address:</sf:label></th>
					<td> <input type="email" id="email" 
								name="email" required="true"  class="form-control" style=" width: 225px;"/></td>
				</tr>
<tr>
			<td><br></td>
				</tr>
				<tr>
					<th><sf:label path="contact">Contact:</sf:label></th>
					<td><input type="number" id="contact" 
								name="contact" required="true"  class="form-control" style=" width: 225px;"/></td>
				</tr>
				<tr>
			<td><br></td>
				</tr>
				<tr>
					<th><sf:label path="address">Address:</sf:label></th>
					<td> <input type="text" id="address" 
								name="address" required="true"  class="form-control" style=" width: 225px;"/></td>
				</tr>
<tr>
			<td><br></td>
				</tr>
				<tr><th><sf:label path="planid" >Plan:</sf:label></th>
				<td><input name="commit" type="button" class="btn btn-info"  required="true" 
						value="Select Subscription Plan" id="plan_id" style="width: 225px;"/>
					
					<td style="width: 247px;"> <input type="text" id="planid" 
								name="planid" required="true"  readonly="true" class="form-control" style=" width: 225px; display: none;"/></td>
								
					
				</tr>
<tr>
			<td><br></td>
				</tr>
				<tr>
					<th></th>
					<td><input name="commit" type="submit" class="btn btn-success" required="true"  value="register" /> </sf:form>

</td>
</tr>
</table>
</fieldset>

</div>
	<div id="plan" class="col-md-6">
							<table class="table table-bordered">
								<tr class="danger">
									<th></th>
									<th>Plan Name</th>
									<th>Plan Id</th>
									<th>Amount</th>
									<th>Duration</th>
									<th>Max_books</th>
								</tr>
								<c:forEach items="${plan}" var="plan">
									<tr class="info">
										<td><input type="radio" name="planRadio" id="radio_value" required="true" 
											class="btnSubscription" value=${plan.planId}></td>
										<td>${plan.planName}</td>
										<td>${plan.planId}</td>
										<td>${plan.amount}</td>
										<td>${plan.duration}</td>
										<td>${plan.maxBooks}</td>

									</tr>
								</c:forEach>
							</table>
						</div>
					
						
						</div>
						</div>
						
						
						
						
						</div>
</body>
</html>
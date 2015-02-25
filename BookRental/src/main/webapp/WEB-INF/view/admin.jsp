<!DOCTYPE html>
<%
Integer userid=(Integer)session.getAttribute("uid");
if(userid== null)
{
	response.sendRedirect("loginform.htm");
}
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>BOOK RENTAL</title>
  <script src=" <c:url value="/resources/js/scriptsource.js"/>"></script>
  
  
<!-- <script type="text/javascript">
  function preventBack() { window.history.forward(); }
  setTimeout("preventBack()", 0);
  window.onunload = function() { null };
</script> -->
 
<script language="JavaScript" type="text/javascript">
  javascript: window.history.forward(1);
</script>

<!-- Bootstrap Core CSS -->
<%-- <c:url value="/resources/css/bootstrap.min.css"/> --%>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href=" <c:url value="/resources/css/small-business.css" />"
	rel="stylesheet">
<link href="<c:url value="webapp/resources/css/small-business.css"/>"
	rel="stylesheet">

<!-- <link rel="stylesheet" type="text/css"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.3/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.css"> -->

<script type="text/javascript" language="javascript"
	src="http://code.jquery.com/jquery-1.10.2.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" language="javascript"
	src="http://cdn.datatables.net/plug-ins/725b2a2115b/integration/bootstrap/3/dataTables.bootstrap.js"></script>


</head>

<body onload="activetab()">

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
							<a href="#"><h4>Home</h4></a>
						</li>
					
						<li class="active">
							<a href="#"><h4>About Us</h4></a>
						</li>
						<li class="active">
							<a href="#"><h4>Contact Us</h4></a>
						</li>
						
					</ul>
					<ul class="nav navbar-nav navbar-right">
						<li class="active">
							<a href="#"><h4>Hi <%=session.getAttribute("uname")%></h4></a>
						</li>
						<li class="active">
							
							 <a href="<c:url value="j_spring_security_logout" />"><h4>Logout</h4></a>
						</li>
					</ul>
				</div>
			</nav>
			</div>
			</div>
   </header>


		<!-- Heading Row -->
		<div class="row">
			<div class="col-md-15">
	<img alt="" class="img-responsive img-rounded" src="resources/images/images (7).jpg"	style="height: 200px; width: 1200px;"/>


	<div class="tabbable" id="tabs-319498">
		<ul class="nav nav-tabs" style="background-color:lightblue;  ">
			<li  id="add"><a href="#panel-117854"
				data-toggle="tab" style="color:black; ">Add Book</a></li>
			<li id="delete"><a href="#panel-445699" data-toggle="tab" style="color:black; ">Delete/Update
					Book</a></li>
			<li id="plan"><a href="#panel-445611" data-toggle="tab" style="color:black; ">ADD/Update Plan </a></li>	
						
			<li id="view"><a href="#panel-445690" data-toggle="tab" style="color:black; ">View Active Users
					</a></li>	
			<li id="view"><a href="#panel-445691" data-toggle="tab"  onClick="ajaxDeliveryRequests();" style="color:black; "><span class="badge badge-important pull-right" style="background-color:rgb(221, 95, 95);"> ${Dsize} </span>  Pending Delivery Requests
					</a></li>	
			<li id="view"><a href="#panel-445692" data-toggle="tab" onClick="ajaxReturnRequests()" style="color:black; "><span class="badge badge-important pull-right" style="background-color:rgb(221, 95, 95);"> ${Rsize} </span> Pending Return Requests
					</a></li>						
			<li id="pdf"><a href="#panel-445610" data-toggle="tab" onClick="ajaxReports()" style="color:black; ">Reports</a></li>	
			
		</ul>
		</div>
	</div>
	</div>
		
		
		<!--------------------------------------------------ADD  START---------------------------------------------------------------------------------->
			
		<div class="tab-content">
		<!-- Heading Row -->
		
			
			<div class="tab-pane active" id="panel-117854">
			
				<p>
				<form action="savebook.htm" method="post" enctype="multipart/form-data" modelAttribute="command" >


					<centre>

					<dl>
						<dt>
							<label for="title">Title:</label>
						</dt>
						<dd>
							<input type="text" id="bookTitle" required="true" class="form-control" style=" width: 175px;" align="center"
								name="bookTitle" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="description">Description:</label>
						</dt>
						<dd>
							<input type="text" id="bookDescription" required="true" class="form-control" style=" width: 175px;" align="center"
								name="bookDescription" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="author">Author:</label>
						</dt>
						<dd>
							<input type="text" id="bookAuthor" required="true" class="form-control" style=" width: 175px;" align="center"
								name="bookAuthor" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="publisher">Publisher</label>
						</dt>
						<dd>
							<input type="text" id="bookPublisher" required="true" class="form-control" style=" width: 175px;" align="center"
								name="bookPublisher" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="category">Category</label>
						</dt>
						<dd>
							<select size="1" name="bookCategory" id="bookCategory" class="form-control" style=" width: 175px;" align="center"
								required="true">
								<option>Select</option>
								<option value="technical">education</option>
								<option value="technical">fiction</option>
								<option value="managemnt">general</option>
								<option value="technical">management</option>
								<option value="technical">technical</option>


							</select>
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="noOfCopies">No. Of Copies</label>
						</dt>
						<dd>
							<input type="number" min="0" id="noOfCopies" required="true" class="form-control" style=" width: 175px;" align="center"
								name="noOfCopies" />
						</dd>
					</dl>
					<dl>
						<dt>
							<label for="file">Image: </label>
						</dt>
						<dd>
							<input type="file" id="file" required="true" class="form-control" style=" width: 175px;" align="center"
								name="file" />
						</dd>
					</dl>
					<div id="submit_buttons">
					<button type="submit"  class="btn btn-success">Submit</button>                  
					&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
					<button type="reset"  class="btn btn-info">Reset</button>
						
					</div>
					</centre>
				</form>
				
				</p>
			</div>
			
			
<!--------------------------------------------------ADD  END---------------------------------------------------------------------------------->	

<!--------------------------------------------------DELETE/UPDATE START---------------------------------------------------------------------------------->

			<div class="tab-pane " id="panel-445699">

				<p>
				<form class="navbar-form navbar-left" role="search"
					action="adminsearch.htm" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="searchBook" />
					</div>
					<button type="submit" class="btn btn-info" id="search" name="b1">Search</button>

					<br> </br>
					<c:if test="${not empty delete1}">
					<script>
                               function activetab() {	
								
										$("#panel-117854").removeClass("active"); // this deactivates the home tab
										$("#panel-445699").addClass("active");
										$("#add").removeClass("active"); // this deactivates the home tab
										$("#delete").addClass("active");
									       

								}
							
						</script>
						</c:if>
						<div id="notfound" style="color:red">
					 ${show}
					</div>
					<c:if test="${not empty searchbook}">
					
						<!-- <script>
                               function activetab() {	
								
										$("#panel-117854").removeClass("active"); // this deactivates the home tab
										$("#panel-445699").addClass("active");
										$("#add").removeClass("active"); // this deactivates the home tab
										$("#delete").addClass("active");
									       

								}
							
						</script> -->
						<table class="table table-bordered">
							<tr style="background-color: lightsteelblue;">
								
								<th>Book Title</th>
								<th>Book Author</th>
								<th>Book Publisher</th>
								<th>Book Category</th>
								<th>Book Availability</th>
								<th>Book Description</th>
								<th>Book Image</th>
								<th>Update</th>
								<th>Order</th>
							</tr>

							<c:forEach items="${list}" var="book" varStatus="book1">
								<tr class="info">
									
									
									<td>${book.bookTitle}</td>
									<td>${book.bookAuthor}</td>
									<td>${book.bookPublisher}</td>
									<td>${book.bookCategory}</td>
									<td><c:forEach var="available" items="${available}" varStatus="check2">
												<c:if test="${book1.index ==check2.index }">
													<c:if test="${available =='In Stock'}" >
													<div style="color: green">
													    ${available}
													    </div>
													</c:if>
													<c:if test="${available=='Out Of Stock'}">
													<div style="color:red">
														${available}
														</div>
													</c:if>

												</c:if>
											</c:forEach></td>
									<td>${book.bookDescription}</td>
									<td><img alt="" src="<c:url value="/resources/images/${book.bookImage}"/>" width="75" height="75"/>
									<td><button type="button" id="${book.ISBN}" onClick="ajaxEdit(${book.ISBN})" class="btn btn-success" >Update Book</button></td>	
									<td align="center"><button type="button" id="del${book.ISBN}" onClick="ajaxDelete(${book.ISBN})" class="btn btn-danger">Delete Book</button></td>

								</tr>
							</c:forEach>

						</table>

					</c:if>
                     
  										</form>
  										

					<%-- <form action="delete.htm" method=post>  --%>

					<%-- <button type="button" class="btn btn-default" id="del${book.ISBN}"
						onClick="ajaxDelete(${book.ISBN})" name="b1">Delete</button> --%>
					<%-- </form> --%>

				
				<div id="stage" class="col-sm-3 col-md-2 sidebar">
				
				
			   </div>
			</p>
		</div>
		
		<!--------------------------------------------------DELETE/UPDATE END---------------------------------------------------------------------------------->
		
		<!--------------------------------------------------VIEW USER START---------------------------------------------------------------------------------->
		<div class="tab-pane " id="panel-445690">

				<p>
				
				<form class="navbar-form navbar-left" role="search"
					action="usersearch.htm" method="post">
					<div class="form-group">
						<input type="text" class="form-control" name="searchuser" placeholder="search by user name"/>
						<input type="text" class="form-control" name="searchplan" placeholder="search by plan name"/>
					</div>
					<button type="submit" class="btn btn-success" id="search" name="b1" >Search</button>
					<button type="button" class="btn btn-info" id="search1" name="b" onClick="ajaxViewAll();">View All</button>
					<br></br>
					<div id="stage1" >
				
				
			        </div>
			   
					<c:if test="${not empty delete}">
					<script>
                               function activetab() {	
								
										$("#panel-117854").removeClass("active"); // this deactivates the home tab
										$("#panel-445690").addClass("active");
										$("#add").removeClass("active"); // this deactivates the home tab
										$("#view").addClass("active");
									       

								}
							
						</script>
						</c:if>
					<c:if test="${(not empty searchuser)}">
					
						<table class="table table-bordered">
							<tr style="background-color: lightsteelblue;">
								
								<!-- <th>User ID</th> -->
								<th>User Name</th>
								<th>Email Id</th>
								<th>Contact No.</th>
								<th>Plan Name</th>
								<!-- <th>Plan ID</th> -->
								<th>Plan Start Date</th>
								<th>Plan End Date</th>
							</tr>

							<c:forEach items="${list}" var="user">
								<tr class="info">
									
									<%-- <td>${user.id}</td> --%>
									<td>${user.user.userName}</td>
									<td>${user.user.email}</td>
									<td>${user.user.contact}</td>
									<td>${user.plan.planName}</td>
									<%-- <td>${user.plan_id}</td> --%>
									<td>${user.startDate}</td>
									<td>${user.endDate}</td>
								</tr>
							</c:forEach>

						</table>

					</c:if>
				</form>
				<br></br>
				
				</p>
		 </div>
		<!--------------------------------------------------VIEW USER END---------------------------------------------------------------------------------->
		
		<!--------------------------------------------------AddPlan Start---------------------------------------------------------------------------------->
		<div class="tab-pane " id="panel-445611">

				<p>
						
				${msg}
				<form action="admin_addSubscriptionXML1.htm" method="post"
					enctype="multipart/form-data">
					<table>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
													
						</tr>

						<tr>
							<td>Choose File :</td>
							<td><input type="file" name="file" class="form-control" required="true"/></td>
						</tr>
						<tr>
							<td>&nbsp;</td>
							<td>&nbsp;</td>
							</tr>
						<tr>
							<td></td>
							<td><input type="submit" value="Add or Update" name="button" class="btn btn-success "/></td>
							
						</tr>
					</table>
				</form>
			
			<c:if test="${!empty plansList}">
					<table id="example" class="table table-striped" cellspacing="0"
						width="100% 
			cellspacing="0">
						<caption>
							<h2>Subscriptions Plans</h2>
						</caption>
						<thead>
							<tr style="background-color: lightsteelblue;">



								<th>PlanName</th>
								<th>Maximum Books</th>
								<th>Amount</th>
								<th>Duration</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach items="${plansList}" var="plans">
								<tr class="info">

									<td><c:out value="${plans.planName}" /></td>
									<td><c:out value="${plans.maxBooks}" /></td>
									<td><c:out value="${plans.amount}" /></td>
									<td><c:out value="${plans.duration}" /></td>
							   
							   </tr>

							</c:forEach>
						</tbody>
					</table>
				</c:if>
		
	
	
				</p>
		</div>		
		
		<!--------------------------------------------------AddPlan END---------------------------------------------------------------------------------->
		
		<!--------------------------------------------------delivery requests Start---------------------------------------------------------------------------------->
		<div class="tab-pane " id="panel-445691">

		<p>
			<div id="deliveryRequest">
			
			</div>
		
		</p>
		</div>
		<!--------------------------------------------------delivery requests  END---------------------------------------------------------------------------------->
		
		<!--------------------------------------------------return requests Start---------------------------------------------------------------------------------->
		<div class="tab-pane " id="panel-445692">

		<p>
			<div id="returnRequest">
			
			</div>
		
		</p>
		</div>
		<!--------------------------------------------------return requests  END---------------------------------------------------------------------------------->
		
		<!--------------------------------------------------reports Start---------------------------------------------------------------------------------->
		<div class="tab-pane " id="panel-445610">

		<p>
			<div id="reports">
			
			</div>
		
		</p>
		</div>
		<!--------------------------------------------------reports  END---------------------------------------------------------------------------------->
	
	
	
	</div>
	
	</div>
	
	<!-- /.col-md-4 -->

	<!-- /.row -->

	<!-- Footer -->
	<footer>
		<div class="row">
			<div class="col-lg-12">
				<p></p>
			</div>
		</div>
	</footer>

	</div>
	<!-- /.container -->

	<!-- jQuery Version 1.11.0 -->
	<%-- <c:url value="/resources/js/jquery-1.11.0.js" /> --%>
	<%-- <script src="<c:url value="/resources/js/jquery-1.11.0.js"/>"></script> --%>

	<!-- Bootstrap Core JavaScript -->
	<%--   <c:url value="/resources/js/bootstrap.min.js" /> --%>
	<script src=" <c:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>

</html>



<!DOCTYPE html>
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


<script src="<c:url value="/resources/js/jquery-1.10.2.js"/>"></script>
<%-- 	<script src="<c:url value="/resources/js/jquery-ui-1.10.4.js"/>"></script> --%>
<script src=" <c:url value="/resources/js/scriptsource.js"/>"></script>
<%--   <script src=" <c:url value="/resources/js/autocomplete-0.3.0.js"/>"></script> --%>
<%--    <script src=" <c:url value="/resources/js/dataTables.jqueryui.js"/>"></script> --%>
<!-- Bootstrap Core JavaScript -->
<%-- 	  <c:url value="/resources/js/bootstrap.min.js" /> --%>
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




<script language="JavaScript" type="text/javascript">
  javascript: window.history.forward(1);
</script>


<script type="text/javascript">
/* $(document).ready(function() {
	activetab();
}); */



	function hideMsg()
	{
		
		 document.getElementById("message").style.display = 'none'; 
		 document.getElementById("notfound").style.display = 'none';   
	}

	function showmsg()
	{
	
		 document.getElementById("notfound").style.display = 'block';   
	}
	
     function autocomplete1(term) {
    	
    	
    	var term = "term="+term;
    	 
            $.ajax({
                    url :"${pageContext.request.contextPath}/autocomplete.htm",
                    type : "GET",
                   
                    data : term,        
                    dataType : "json",
                    success : function(data) {
                    	  
                    	 $( "#searchTitle" ).autocomplete({
                    		
                    	      source: data,
                    	      selectFirst: true,
                    	      autoFocus: true,
                    	      delay:0,
                    	      minChars:1
                    	    });
                    }
            });
    	  

}; 



</script>

<!-- Bootstrap Core CSS -->
<%-- <c:url value="/resources/css/bootstrap.min.css"/> --%>
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel="stylesheet">

<!-- Custom CSS -->
<link href=" <c:url value="/resources/css/small-business.css" />"
	rel="stylesheet">

<link href=" <c:url value="/resources/css/jquery-ui-1.10.4.css" />"
	rel="stylesheet">
<link href="<c:url value="webapp/resources/css/small-business.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="webapp/resources/css/autocomplete-0.3.0.css"/>"
	rel="stylesheet">
<link
	href="<c:url value="webapp/resources/css/adataTables.jqueryui.css"/>"
	rel="stylesheet">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<script type="text/javascript">
function fade(){
$("#save").fadeOut(7000);
$("#message").fadeOut(7000);
}

</script>
</head>

<body onload="ajaxRecommend(<%=session.getAttribute("uid")%>); ">


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
			<div class="col-md-12">

				<img alt="" class="img-responsive img-rounded"
					src="resources/images/images (7).jpg"
					style="height: 200px; width: 1200px;" />

				<div class="tabbable" id="tabs-284163">
					<ul class="nav nav-tabs" style="background-color:lightblue;  ">
						
						<li id="home"  ><a href="#panel-673236" data-toggle="tab" style="color:black; "
							>Home</a>
						</li>
						<li id="books"><a href="#panel-383067"
							data-toggle="tab" onclick="hideMsg();" style="color:black; ">Books</a></li>
						<li><a href="#panel-673230" data-toggle="tab"
							onclick="ajaxViewShelf(<%=session.getAttribute("uid")%>);" style="color:black; ">Virtual
								Shelf</a></li>
						<li><a href="#panel-673231" data-toggle="tab" style="color:black; ">History</a></li>
						<li><a href="#panel-673232" data-toggle="tab"
							onclick="ajaxBooksHeld(<%=session.getAttribute("uid")%>);" style="color:black; ">Books
								Held</a></li>
						<li><a href="#panel-673235" data-toggle="tab"
							onclick="ajaxBooksRequested(<%=session.getAttribute("uid")%>);" style="color:black; ">Books
								Requested</a></li>
						<li id="profile1"><a href="#panel-673233" data-toggle="tab"
							onclick="ajaxViewProfile(<%=session.getAttribute("uid")%>);" style="color:black; ">My
								Profile</a></li>
						<li id="enroll"><a href="#panel-673234" data-toggle="tab"
							onclick="ajaxNewPlan(<%=session.getAttribute("uid")%>);" style="color:black; ">Enroll
								to New Plan</a></li>
						<li></li>
					</ul>

				</div>
			</div>
		</div>
		<!-----------------------------------------------------------------------------search start----------------------------------------------------------->
		<div class="tab-content">
		<div id="message" style="color: red"></div>
			<div class="tab-pane " id="panel-383067">
				<p>
					<!-- <div style="margin: 0px auto 0px auto; width: 1000px; border: 1px solid Gray"> -->
				<form class="navbar-form navbar-left" role="search"
					action="search.htm" method="post">
					<div class="form-group">


						<div class="ui-widget">
							<input type="text" class="form-control" name="searchTitle"
								id="searchTitle" placeholder="search By Title"
								onkeyup="autocomplete1(this.value)" /> <input type="text"
								class="form-control" name="searchAuthor" id="searchAuthor"
								placeholder="search By Author" /> <input type="text"
								class="form-control" name="searchCategory" id="searchCategory"
								name="searchCategory" placeholder="search By Category" />

						</div>
					</div>
					<button type="submit" class="btn btn-success" onclick="showmsg()">Search</button>
					<br> </br>
					<div id=message style="color: red">
					<script type="text/javascript">
					fade()
					</script></div>
					<div id="notfound" style="color:red">
					 ${show}
					</div>
					<br> </br>
					<%-- <form action="search.htm" method="post"> --%>
					<c:if test="${not empty active}">
						<script>
                               function activetab() {	
								
										$("#panel-673236").removeClass("active"); // this deactivates the home tab
										$("#panel-673233").addClass("active");
										$("#home").removeClass("active"); // this deactivates the home tab
										$("#profile1").addClass("active");
										ajaxViewProfile(<%=session.getAttribute("uid")%>);

								}
							
						</script>
					</c:if>
					
					<c:if test="${not empty searchbook}">
						<script>
						
                               function activetab() {	
								
										$("#panel-673236").removeClass("active"); // this deactivates the home tab
										$("#panel-383067").addClass("active");
										$("#home").removeClass("active"); // this deactivates the home tab
										$("#books").addClass("active");
										

								}
                               
						</script>
					</c:if>
					
					<c:if test="${not empty res}">
						<script>
                               function activetab() {	
								
										$("#panel-673236").removeClass("active"); // this deactivates the home tab
										$("#panel-673234").addClass("active");
										$("#home").removeClass("active"); // this deactivates the home tab
										$("#enroll").addClass("active");
										ajaxNewPlan(<%=session.getAttribute("uid")%>);
									
								}
							
						</script>
					
					</c:if>
					
					
					<c:if test="${not empty searchbook}">


						<div id="bookList">

                         <table id="example" class="table table-bordered" >
								<thead>
								<tr style="background-color: lightsteelblue;">

									<th>Book Title</th>
									<th>Book Author</th>
									<th>Book Publisher</th>
									<th>Book Category</th>
									<th>Book Availability</th>
									<th>Book Description</th>
									<th>Book Image</th>
									<th>Add To Shelf</th>
									<th>Order</th>
								</tr>
								</thead>
								<tbody>

								<c:forEach var="book" items="${list}" varStatus="book1">


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
													<div style="color: red">
														${available}
														</div>
													</c:if>

												</c:if>
											</c:forEach></td>
										<td>${book.bookDescription}</td>
										<td><img alt=""
											src="<c:url value="/resources/images/${book.bookImage}"/>"
											width="75" height="75" /></td>

										<td align="center"><c:forEach var="check" items="${check}" varStatus="check1">
												<c:if test="${book1.index ==check1.index }">
													<c:if test="${check =='active'}">
														<button type="button" class="btn btn-success"
															disabled="disabled" name="add" id="add${book.ISBN}"
															onclick="ajaxShelf(${book.ISBN},<%=session.getAttribute("uid") %>);">Already
															in Shelf</button>
													</c:if>
													<c:if test="${check=='inactive'}">
														<button type="button" class="btn btn-success" name="add"
															id="add${book.ISBN}"
															onclick="ajaxShelf(${book.ISBN},<%=session.getAttribute("uid") %>);">Add
															Book To Shelf</button>
													</c:if>

												</c:if>
											</c:forEach></td>


										
											<td align="center"><c:forEach var="order" items="${ordered}" varStatus="ordered">
												<c:if test="${book1.index ==ordered.index }">
													<c:if test="${order =='ordered'}">
														<a id="order1${book.ISBN}"
											href="#modal-container-${book.ISBN}" role="button"
											class="btn btn-info" disabled="disabled" data-toggle="modal"
											onclick="check(${book.ISBN})">Ordered</a>
													</c:if>
													<c:if test="${order=='order'}">
														<a id="order1${book.ISBN}"
											href="#modal-container-${book.ISBN}" role="button"
											class="btn btn-info"  data-toggle="modal"
											onclick="check(${book.ISBN})">Order Book</a>
													</c:if>

												</c:if>
											</c:forEach>
											<div class="modal fade" id="modal-container-${book.ISBN}"
												role="dialog" aria-labelledby="myModalLabel"
												aria-hidden="true">
												<div class="modal-dialog">
													<div class="modal-content">
														<div class="modal-header">
															<button type="button" class="close" data-dismiss="modal"
																aria-hidden="true">×</button>
															<h4 class="modal-title" id="myModalLabel">Confirm
																Address</h4>
														</div>
														<div class="modal-body">
															<c:forEach items="${user}" var="user">
																<dl>
																	<dt></dt>
																	<dd>
																		<input type="text" id="address" name="address"
																			value="${user.address}" />
																	</dd>
																</dl>
																
																</c:forEach>
															</div>
														<div class="modal-footer">
															<button type="button" class="btn btn-primary"
																data-dismiss="modal">Cancel</button>
															<button type="button" class="btn btn-success"
																id="order${book.ISBN}" onclick="ajaxOrderBook(${book.ISBN}, $('#address').val(),<%=session.getAttribute("uid")%>);"
																data-dismiss="modal">Order Book</button>
														
															
														</div>
													</div>

												</div>

											</div></td>
								

								</tr>
								</c:forEach>
</tbody>
							</table>
						</div>
					</c:if>
			</div>
			</p>
			</form>

			<!-----------------------------------------------------------------------------search end----------------------------------------------------------->

			<!-----------------------------------------------------------------------------recommend start----------------------------------------------------------->
			<div class="tab-pane active" id="panel-673236">
				<p>
				
				
				<div id="recommendations">
				</div>
				</p>
			</div>
			<!-----------------------------------------------------------------------------recommend end------------------------------------------------------------->


			<!-----------------------------------------------------------------------------view start----------------------------------------------------------->
			<div class="tab-pane " id="panel-673230">
				<p>
				<div id="stage"></div>
				
				</p>
			</div>
			<!-----------------------------------------------------------------------------view end------------------------------------------------------------->
			<!-----------------------------------------------------------------------------history start----------------------------------------------------------->
			<div class="tab-pane " id="panel-673231">
				<p>
				<div class="panel-group" id="panel-460525">
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: rgb(227, 235, 247);">
							<a class="panel-title collapsed" data-toggle="collapse"
								data-parent="#panel-460525" href="#panel-element-908158"
								onclick="ajaxHistory(<%=session.getAttribute("uid")%>);">Book
								History</a>
						</div>
						<div id="panel-element-908158" class="panel-collapse collapse">
							<div class="panel-body">
								<div id="history"></div>

							</div>
						</div>
					</div>
					<div class="panel panel-default">
						<div class="panel-heading" style="background-color: rgb(227, 235, 247);">
							<a class="panel-title collapsed" data-toggle="collapse"
								data-parent="#panel-460525" href="#panel-element-887634"
								onclick="ajaxViewPlan(<%=session.getAttribute("uid")%>);">Subscription
								History</a>
						</div>
						<div id="panel-element-887634" class="panel-collapse collapse">
							<div class="panel-body">
								<div id="plan"></div>
							</div>
						</div>
					</div>
				</div>
				</p>
			</div>
			<!-----------------------------------------------------------------------------history end----------------------------------------------------------->
			<!-----------------------------------------------------------------------------profile start----------------------------------------------------------->
			<div class="tab-pane " id="panel-673233">
				<p>
				<c:if test="${not empty saved}">
					<div id="save" style="color:green">changes saved</div>
					<script type="text/javascript">
					fade()
					</script>
					</c:if>
				
				<div id="profile"></div>
				
				</p>
			</div>
			<!-----------------------------------------------------------------------------profile end----------------------------------------------------------->

			<!-----------------------------------------------------------------------------Books held start----------------------------------------------------------->
			<div class="tab-pane " id="panel-673232">
				<p>
				<div id="showbooks"></div>

				</p>
			</div>

			<!-----------------------------------------------------------------------------Books held end----------------------------------------------------------->

			<!-----------------------------------------------------------------------------EnrollNewPlan start----------------------------------------------------------->
			<div class="tab-pane " id="panel-673234">
				<p>
				<c:if test="${not empty res}">
					<c:if test="${res =='subscribed to new plan' }">	
					 	<div id="save" style="color:green">${res }</div>
					</c:if>
					<c:if test="${res =='Previous plan is active' }">	
						<div id="save" style="color:red">You cannot subscribe to new plan. You are already subscribed</div>
						<script type="text/javascript">
					fade()
					</script>
					</c:if>
					
				</c:if>
					
					
					<div id="newplan"></div>
				</p>
			</div>
			<!-----------------------------------------------------------------------------EnrollNewPlan end------------------------------------------------------------->
			<!-----------------------------------------------------------------------------BooksRequested Start------------------------------------------------------------->
			<div class="tab-pane " id="panel-673235">
				<p>
				<div id="booksrequested"></div>
				</p>
			</div>
			<!-----------------------------------------------------------------------------BooksRequested end------------------------------------------------------------->

		</div>
	</div>
	</div>


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
	
	<script type="text/javascript">
	// For demo to fit into DataTables site builder...
	$('#example')
		.removeClass( 'display' )
		.addClass('table table-hover table-bordered');
</script>


</body>

</html>


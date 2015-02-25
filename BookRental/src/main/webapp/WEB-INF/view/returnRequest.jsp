<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

function ajaxCloseRequest(bookid,userid){
	
	
	var bookId = "bookId="+bookid;
	var userId="userId="+userid
		   $.ajax({
			    url : "${pageContext.request.contextPath}/CloseReturn.htm",
			    type: "GET",
			    cache:false,
			    data : bookId+"&"+userId,
	
	 success: function(response)
			    {
			    	
			    	var str=response;
			    	var id = 'closeReturn'+bookid;
			    	var x=document.getElementById(id);
			    	
			    	x.className ="btn btn-defaultClose disabled";
			    	x.disabled=true;
			    	if(str=="Closed")
		    		{
			    	x.innerHTML=response;
			    		}
			    	else
			    		$("#message").html(response); 

 		       
			    },
			
		   error: function(response)
		    {
		 		alert("Failure");
		 		alert("Cannot fulfill the request");
		 		var id = 'exception';
		 		var x=document.getElementById(id);
		 		x.innerHTML=response;
		    }
});
}  

</script>
</head>
<body>
<table class="table table-bordered">
				<tr style="background-color: lightsteelblue;">
					<th>User Id</th>
					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book Publisher</th>
					<th>Book Category</th>
					<th>Book Description</th>
					<th>Request Date</th>
					<th>Delivery Date</th>
					<th>Return Request Date</th>
					<th>Book Image</th>
					<th>Action</th>
				</tr>

				<c:forEach items="${list}" var="book">
					<tr class="info">
						<td>${book.userName}</td>
						<td>${book.book.bookdto.bookTitle}</td>
						<td>${book.book.bookdto.bookAuthor}</td>
						<td>${book.book.bookdto.bookPublisher}</td>
						<td>${book.book.bookdto.bookCategory}</td>
						<td>${book.book.bookdto.bookDescription}</td>
						<td>${book.deliveryrequestDate}</td>
						<td>${book.deliveryDate}</td>
						<td>${book.returnRequestDate}</td>
						<td><img alt="" src="<c:url value="/resources/images/${book.book.bookdto.bookImage}"/>" width="75" height="75"/></td>
						
						
									
						<td align="center"><button
									type="button" class="btn btn-default" id="closeReturn${book.book.bookdto.ISBN}" onclick="ajaxCloseRequest(${book.book.bookdto.ISBN},${book.userId});">Close Request</button></td>			
						
						
					
					</tr>
				</c:forEach>

			</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>
function ajaxCancelRequest(bookid,userid){
	
	
	var bookId = "bookId="+bookid;
	var userId="userId="+userid
		   $.ajax({
			    url : "${pageContext.request.contextPath}/cancelRequest.htm",
	
			    type: "GET",
			    cache:false,
			    data : bookId+"&"+userId,
	
	 success: function(response)
			    {
			    	
			    	var id = 'cancel'+bookid;
			    	var x=document.getElementById(id);
			    	x.className ="btn btn-defaultCancel disabled";
			    	x.disabled=true;
			    	x.innerHTML=response;
			    	$("#cancelmsg").html(response);		
 		       
			    },
			
		   error: function ()
		    {
		 		alert("Failure");
		    }
});
}


</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<div id=cancelmsg style="color: red"></div>
<br>
<table id="searchTable" class="table table-bordered" >
<thead>
				<tr style="background-color: lightsteelblue;">

					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book Publisher</th>
					<th>Book Category</th>
					<th>Book Description</th>
					<th>Request Date</th>
					<th>Book Image</th>
					<th>Cancel request</th>
				</tr>
</thead>
<tbody>
				<c:forEach items="${list}" var="book">
					<tr class="info">
						<td>${book.book.bookdto.bookTitle}</td>
						<td>${book.book.bookdto.bookAuthor}</td>
						<td>${book.book.bookdto.bookPublisher}</td>
						<td>${book.book.bookdto.bookCategory}</td>
						<td>${book.book.bookdto.bookDescription}</td>
						<td>${book.deliveryrequestDate}</td>
						<td><img alt="" src="<c:url value="/resources/images/${book.book.bookdto.bookImage}"/>" width="75" height="75"/></td>
						
						
									
						<td align="center"><button
									type="button" class="btn btn-info" id="cancel${book.book.bookdto.ISBN}" onclick="ajaxCancelRequest(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Cancel</button></td>			
						
						
						
					
					</tr>
				</c:forEach>
</tbody>
			</table>

		

</body>
</html>
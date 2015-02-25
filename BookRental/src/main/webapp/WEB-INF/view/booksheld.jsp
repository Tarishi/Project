<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function ajaxReturn(bookid,userid){
	

	var bookId = "bookId="+bookid;
	var userId="userId="+userid
		   $.ajax({
			    url : "${pageContext.request.contextPath}/returnbook.htm",
	
			    type: "GET",
			    cache:false,
			    async:true,
			    data : bookId+"&"+userId,
	
	 success: function(response)
			    {
			    	
			    	var id = 'return'+bookid;
			    	var id1='cancel'+bookid;
			    	var x=document.getElementById(id);
			    	var y=document.getElementById(id1);
			    	
			    	x.disabled=true;
			    	document.getElementById(id1).disabled=false;
			    	$("#returnmsg").html(response);

 		       
			    },
			
		   error: function ()
		    {
		 		alert("Failure");
		    }
});
}

function ajaxCancel(bookid,userid){
	
	var bookId = "bookId="+bookid;
	var userId="userId="+userid
		   $.ajax({
			    url : "${pageContext.request.contextPath}/cancelbook.htm",
	
			    type: "GET",
			    cache:false,
			    async:true,
			    data : bookId+"&"+userId,
	
	 success: function(response)
			    {
			    	
			    	var id = 'cancel'+bookid;
			    	var id1='return'+bookid;
			    	var x=document.getElementById(id);
			    	var y=document.getElementById(id1);
			    	
			    	document.getElementById(id1).disabled=false;
			    	x.disabled=true;
			    	$("#returnmsg").html(response);			    	       
			    },
			
		   error: function ()
		    {
		 		alert("Failure");
		    }
});
}


</script>
</head>
<body>
	<div id=returnmsg style="color: red"></div>
	<br>
			<table class="table table-bordered">
				<tr style="background-color: lightsteelblue;">

					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book Publisher</th>
					<th>Book Category</th>
					<th>Book Description</th>
					<th>Request Date</th>
					<th>Delivery Date</th>
					<th>Book Image</th>
					<th>Return</th>
					<th>Cancel</th>
				</tr>

				<c:forEach items="${list}" var="book">
					<tr class="info">
						<td>${book.book.bookdto.bookTitle}</td>
						<td>${book.book.bookdto.bookAuthor}</td>
						<td>${book.book.bookdto.bookPublisher}</td>
						<td>${book.book.bookdto.bookCategory}</td>
						<td>${book.book.bookdto.bookDescription}</td>
						<td>${book.deliveryrequestDate}</td>
						<td>${book.deliveryDate}</td>
						<td><img alt="" src="<c:url value="/resources/images/${book.book.bookdto.bookImage}"/>" width="75" height="75"/></td>
						
						<c:if test="${book.returnType =='pending'}">			
						<td align="center"><button
									type="button" class="btn btn-success" disabled="disabled" id="return${book.book.bookdto.ISBN}" onclick="ajaxReturn(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Return Book</button></td>
									
						<td align="center"><button
									type="button" class="btn btn-danger" id="cancel${book.book.bookdto.ISBN}" onclick="ajaxCancel(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Cancel</button></td>			
						</c:if>
						
						<c:if test="${book.returnType =='none' }">			
						<td align="center"><button
									type="button" class="btn btn-success"  id="return${book.book.bookdto.ISBN}" onclick="ajaxReturn(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Return Book</button></a></td>
						<td align="center"><button
									type="button" class="btn btn-danger" disabled="disabled" id="cancel${book.book.bookdto.ISBN}" onclick="ajaxCancel(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Cancel</button></td>	
						
						</c:if>
						
						<c:if test="${book.returnType =='cancelled' }">			
						<td align="center"><button
									type="button" class="btn btn-success"  id="return${book.book.bookdto.ISBN}" onclick="ajaxReturn(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Return Book</button></a></td>
						<td align="center"><button
									type="button" class="btn btn-danger" disabled="disabled" id="cancel${book.book.bookdto.ISBN}" onclick="ajaxCancel(${book.book.bookdto.ISBN},<%=session.getAttribute("uid") %>);">Cancel</button></td>	
					
						</c:if>
						
						
					
					</tr>
				</c:forEach>

			</table>

		
</body>
</html>
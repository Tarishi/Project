<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table id="historytable" class="table table-bordered">
<thead>
				<tr style="background-color: lightsteelblue;">

					<th>Book Title</th>
					<th>Book Author</th>
					<th>Book Publisher</th>
					<th>Book Category</th>
					<th>Book Description</th>
					<th>Request Date</th>
					<th>Delivery Date</th>
					<th>Return Request Date</th>
					<th>Return Date</th>
					<th>Book Image</th>
				</tr>
</thead>
<tbody>
				<c:forEach items="${history}" var="book">
					<tr class="info">
						<td>${book.book.bookdto.bookTitle}</td>
						<td>${book.book.bookdto.bookAuthor}</td>
						<td>${book.book.bookdto.bookPublisher}</td>
						<td>${book.book.bookdto.bookCategory}</td>
						<td>${book.book.bookdto.bookDescription}</td>
						<td>${book.deliveryrequestDate}</td>
						<td>${book.deliveryDate}</td>
						<td>${book.returnRequestDate}</td>
						<td>${book.returnDate}</td>
						<td><img alt="" src="<c:url value="/resources/images/${book.book.bookdto.bookImage}"/>" width="75" height="75"/></td>
						
									
						
						
						
					
					</tr>
				</c:forEach>
</tbody>
			</table>


</body>
</html>
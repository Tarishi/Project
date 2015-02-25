<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>

<c:if test="${not empty latest}">
				<div align="center">
				 <h3> New Arrivals</h3>
				</div>
				</c:if>
<c:if test="${not empty recommends}">
				<div align="center">
				 <h3> Recommendations</h3>
				</div>
				</c:if>
	<table class="table table-bordered" >
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

		<c:forEach items="${list}" var="book" varStatus="book1" begin="0" end="5">


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

				<div class="modal fade" id="modal-container-${book.ISBN}" role="dialog"
					aria-labelledby="myModalLabel" aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal"
									aria-hidden="true">×</button>
								<h4 class="modal-title" id="myModalLabel">Confirm Address</h4>
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
									id="order${book.ISBN}"
									onclick="ajaxOrderBook(${book.ISBN}, $('#address').val(),<%=session.getAttribute("uid")%>);" data-dismiss="modal">Order
									Book</button>
							</div>
						</div>

					</div>
						
				</div>
		

		</c:forEach>

	</table>

</body>
</html>
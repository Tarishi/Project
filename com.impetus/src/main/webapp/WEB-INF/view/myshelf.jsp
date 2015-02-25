
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src=" <c:url value="/resources/js/scriptsource.js"/>"></script>
<table id="shelf" class="table table-bordered">
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
		<c:forEach items="${list}" var="list" varStatus="book1">
			<tr class="info">


				<td>${list.book.bookTitle}</td>
				<td>${list.book.bookAuthor}</td>
				<td>${list.book.bookPublisher}</td>
				<td>${list.book.bookCategory}</td>
				<script>
				    var a=${list.book.noOfCopies};
				    var b=${list.book.booksOrdered};
				    var c =a-b;
				    
				</script>
				<td>
							<c:if test="${list.book.noOfCopies-list.book.booksOrdered>0}" >
								<div style="color: green">
								    In Stock
									    </div>
										</c:if>
											<c:if test="${list.book.noOfCopies-list.book.booksOrdered<=0}">
												<div style="color: red">
													Out Of Stock
												</div>
											</c:if></td>
				<%-- <td>${list.book.noOfCopies}</td> --%>
				<td>${list.book.bookDescription}</td>
				<td><img alt=""
					src="<c:url value="/resources/images/${list.book.bookImage}"/>"
					width="75" height="75" /></td>

				<td><button type="button" id="remove${list.book.ISBN}"
						onclick="ajaxRemove(${list.book.ISBN},<%=session.getAttribute("uid") %>);return false;"
						class="btn btn-success">Remove From Shelf</button></td>

				<%-- <td align="center"><a id="order1${list.book.ISBN}"
					href="#modal-container-${list.book.ISBN}" role="button" class="btn btn-info"
					data-toggle="modal">Order Book</a></td> --%>
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

				<div class="modal fade" id="modal-container-${list.book.ISBN}" role="dialog"
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
									id="order${list.book.ISBN}"
									onclick="ajaxOrderBook(${list.book.ISBN}, $('#address').val(),<%=session.getAttribute("uid")%>);" data-dismiss="modal">Order
									Book</button>
							</div>
						</div>

					</div>
						
				</div>

			</tr>
		</c:forEach>
	</tbody>

</table>
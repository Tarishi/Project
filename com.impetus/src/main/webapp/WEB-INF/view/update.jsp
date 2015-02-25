<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function call()
{
alert("book updated");
}
</script>

</head>
<body>
<form method="post" name="addbook" id="addbook" action="updatebook.htm" >

      <c:forEach items="${book}" var="book">

                    <dl>
						<dt>
						</dt>
						<dd>
							<input type="hidden" id="ISBN" name="ISBN" value="${book[0].ISBN}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Title:</label>
						</dt>
						<dd>
							<input type="text" id="bookTitle" name="bookTitle" value="${book[0].bookTitle}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Description:</label>
						</dt>
						<dd>
							<input type="text" id="bookDescription" 
								name="bookDescription" value="${book[0].bookDescription}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Author:</label>
						</dt>
						<dd>
							<input type="text" id="bookAuthor" 
								name="bookAuthor" value="${book[0].bookAuthor}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Publisher</label>
						</dt>
						<dd>
							<input type="text" id="bookPublisher" 
								name="bookPublisher" value="${book[0].bookPublisher}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Category</label>
						</dt>
						<dd>
							<select size="1" name="bookCategory" id="bookCategory" class="form-control" style=" width: 175px;">
								
								<option>${book[0].bookCategory}</option>
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
							<label>No. Of Copies</label>
						</dt>
						<dd>
							<input type="text" id="noOfCopies" 
								name="noOfCopies" value="${book[0].noOfCopies}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label>No. Of Books ORDERED</label>
						</dt>
						<dd>
							<input type="text" id="booksOrdered" 
								name="booksOrdered" value="${book[0].booksOrdered}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					
					<%-- <dl>
						<dt>
							<label >Image: </label>
						</dt>
						
						<dd>
							    <img src="<c:out value="${book[0].bookImage}"/>" style="height: 50px; width: 50px;"/>
								<input type="file" id="bookImage" 
								name="bookImage" value="${book[0].bookImage}"/>
						</dd>
					</dl> --%>
					<%-- <img src="<c:out value="${book[0].bookImage}"/>" style="height: 50px; width: 50px;"/> --%>
					<div id="submit_buttons">
						
						<button type="submit" onclick="call()" class="btn btn-success">Submit</button>
					</div>
		</c:forEach>			
				</form>
</body>
</html>
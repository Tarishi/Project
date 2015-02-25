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

    <form method="post"  action="updateuser.htm" ModelAttribute="user">
	 
      <c:forEach items="${user}" var="user">

                    <dl>
						<dt>
						</dt>
						<dd>
							<input type="hidden" id="id" name="id" value="${user.user.id}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >User Name:</label>
						</dt>
						<dd>
							<input type="text" id="userName" name="userName" value="${user.user.userName}" readonly="true" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Email Id:</label>
						</dt>
						<dd>
							<input type="text" id="email" 
								name="email" value="${user.user.email}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Contact No.:</label>
						</dt>
						<dd>
							<input type="text" id="contact" 
								name="contact" value="${user.user.contact}" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label >Plan Name</label>
						</dt>
						<dd>
							<input type="text" id="planName" 
								name="planName" value="${user.plan.planName}" readonly="true" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					
						<dt>
							<label>Plan Start Date</label>
						</dt>
						<dd>
							<input type="text" id="startDate" 
								name="startDate" value="${user.startDate}" readonly="true" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label>Plan End Date</label>
						</dt>
						<dd>
							<input type="text" id="endDate" 
								name="endDate" value="${user.endDate}" readonly="true" class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					<dl>
						<dt>
							<label>Address</label>
						</dt>
						<dd>
							<input type="text" id="address" 
								name="address" value="${user.user.address}"  class="form-control" style=" width: 175px;"/>
						</dd>
					</dl>
					
					<div id="submit_buttons">
						
						<button type="submit" class="btn btn-success" onclick="show()">Save changes</button>
					</div>
		</c:forEach>			
				</form>
</body>
</html>
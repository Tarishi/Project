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
<c:if test="${(not empty searchall)}">
					
						<table id="viewtable" class="table table-bordered">
						<thead>
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
</thead>
<tbody>
							<c:forEach items="${user}" var="user">
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
</tbody>
						</table>

					</c:if>
</body>
</html>
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
<table class="table table-bordered">
								<tr style="background-color: lightsteelblue;">
									
									<th>Plan Name</th>
								<!-- 	<th>Plan Id</th> -->
									<th>Amount</th>
									<th>Duration</th>
									<th>Max books</th>
									<th>Start Date</th>
									<th>End Date</th>
									<th>Status</th>
								</tr>
								<c:forEach items="${plan}" var="plan">
									<tr class="info">
										<td>${plan.plan.planName}</td>
										<%-- <td>${plan.plan.plan_id}</td> --%>
										<td>${plan.plan.amount}</td>
										<td>${plan.plan.duration}</td>
										<td>${plan.plan.maxBooks}</td>
										<td>${plan.startDate}</td>
										<td>${plan.endDate}</td>
										<td><c:if test="${plan.status =='true' }"><div style=color:green>Active</div></c:if>
										<c:if test="${plan.status =='false' }"><div style=color:red>In Active</div></c:if></td>

									</tr>
								</c:forEach>
							</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script>

	

$('.btnSubscription').click(function() {
	var getId = $(this).attr('value');
	$('#plan_id').val(getId);
})

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="enrollnewplan.htm" method="post" >

<table class="table table-bordered">
								<tr style="background-color: lightsteelblue;">
									<th></th>
									<th>Plan Name</th>
									<th>Amount</th>
									<th>Duration</th>
									<th>Max_books</th>
								</tr>
								<c:forEach items="${enroll}" var="plan">
									<tr class="info">
										<td><input type="radio" name="planRadio" id="radio_value"
											class="btnSubscription" value=${plan.planId} required="true"></td>
										<td>${plan.planName}</td>
										<td>${plan.amount}</td>
										<td>${plan.duration}</td>
										<td>${plan.maxBooks}</td>

									</tr>
								</c:forEach>
							</table>
							<input id="plan_id" name="plan_id" size="30" type="text" 
								 required="true"  readonly="true" class="form-control" style=" width: 175px;  display: none;" />
							<button  type="submit" class="btn btn-success">Enroll</button>
							</form>
</body>
</html>
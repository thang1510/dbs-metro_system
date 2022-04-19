<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center">Payment Reservation Complex</h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Payment ID</th>
		<th>Reservation ID</th>
		<th>Ticket ID</th>
	</tr>
<c:forEach items="${PaymentReservationList}" var="PaymentReservationList">
	<tr>
		<td>${PaymentReservationList.payment_id}</td>
		<td>${PaymentReservationList.reservation_id}</td>
		<td>${PaymentReservationList.ticket_id}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
code {
  font-family: Consolas,"courier new";
  color: crimson;
  background-color: #f1f1f1;
  padding: 2px;
  font-size: 105%;
  display: block;
  white-space: pre-wrap
}
</style>
</head>
<body>
	<h3 align="center">Payment Reservation - Complex Query</h3>
	<code> 
		SELECT payment.payment_id, payment.reservation_id, reservation.ticket_id 
		FROM dbs_metro_system.payment 
		JOIN dbs_metro_system.reservation 
		WHERE EXISTS 
		( 
			SELECT payment_id 
			FROM payment 
		) 
		AND payment.amount > 50000;
	</code>
	<h3 align="center">Query Result</h3>
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

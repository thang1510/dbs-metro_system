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
	<h3 align="center">Payment - Aggregate Query</h3>
	<code> 
		SELECT * FROM dbs_metro_system.payment 
		WHERE amount < 
		( 
			SELECT AVG(amount) 
			FROM dbs_metro_system.payment 
		) 
		AND payment_date >= '2022-01-04 14:21:00';
	</code>
	<h3 align="center">Query Result</h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Payment ID</th>
		<th>Reservation ID</th>
		<th>Payment Date</th>
		<th>Amount</th>
	</tr>
<c:forEach items="${PaymentList}" var="payment">
	<tr>
		<td>${payment.payment_id}</td>
		<td>${payment.reservation_id}</td>
		<td>${payment.payment_date}</td>
		<td>${payment.amount}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

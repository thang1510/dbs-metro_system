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
	<h3 align="center">Passenger - Complex Query</h3>
	<code> 
		SELECT passenger.passenger_id, fullname, amount 
		FROM dbs_metro_system.passenger 
		INNER JOIN dbs_metro_system.reservation 
		INNER JOIN dbs_metro_system.payment 
		WHERE passenger.passenger_id = reservation.passenger_id 
			  AND payment.reservation_id = reservation.reservation_id 
			  AND amount > 
			  ( 
			  	SELECT AVG(amount) 
			  	FROM dbs_metro_system.payment 
			  ) 
	    	AND year(passenger.join_date) > 2020;
	</code>
	<h3 align="center">Query Result</h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Passenger ID</th>
		<th>Full Name</th>
		<th>Amount</th>
	</tr>
<c:forEach items="${PassengerComplex}" var="PassengerComplex">
	<tr>
		<td>${PassengerComplex.passenger_id}</td>
		<td>${PassengerComplex.fullname}</td>
		<td>${PassengerComplex.amount}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

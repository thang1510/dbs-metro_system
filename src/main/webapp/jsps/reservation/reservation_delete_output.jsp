<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Reservation</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <h1>Delete Reservation</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/ReservationServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
	<input type="hidden" name="reservation_id" value="${reservation.reservation_id }"/>
		
	Reservation ID: <input type="text" name="reservation_id" value="${reservation.reservation_id }" disabled/>
	<br/>
	Passenger ID: <input type="text" name="passenger_id" value="${reservation.passenger_id }" disabled/>
	<br/>
	Ticket ID: <input type="text" name="ticket_id" value="${reservation.ticket_id }" disabled/>
	<br/>
	Reservation status: <input type="text" name="reservation_status" value="${reservation.reservation_status }" disabled/>
	<br/>
	Reservation date: <input type="text" name="reservation_date" value="${reservation.reservation_date }" disabled/>
	<br/>
	
	<input type="submit" value="Delete Reservation"/>
</form>

</body>
</html>

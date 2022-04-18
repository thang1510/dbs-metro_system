<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Reservation</title>
    
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
  <h1>Update Reservation</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
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
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/ReservationServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="reservation_id" value="${reservation.reservation_id }"/>
	
	Passenger ID: <input type="text" name="passenger_id" value="${form.passenger_id }" />
	<br/>
	Ticket ID: <input type="text" name="ticket_id" value="${form.ticket_id }" />
	<br/>
	Reservation status: <input type="text" name="reservation_status" value="${form.reservation_status }" />
	<br/>
	Reservation date: <input type="text" name="reservation_date" value="${form.reservation_date }" />
	<br/>
	
	<input type="submit" value="Update Reservation"/>
</form>

</body>
</html>

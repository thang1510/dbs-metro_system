<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Reservation Create</title>
    
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
  <h1>Create Reservation</h1>
<form action="<c:url value='/ReservationServletCreate'/>" method="post">
	Reservation ID: <input type="text" name="reservation_id" value="${form.reservation_id }"/>
	<span style="color: red; font-weight: 900">${errors.reservation_id }</span>
	<br/>
	Passenger ID: <input type="text" name="passenger_id" value="${form.passenger_id }"/>
	<span style="color: red; font-weight: 900">${errors.passenger_id }</span>
	<br/>
	Ticket ID: <input type="text" name="ticket_id" value="${form.ticket_id }"/>
	<span style="color: red; font-weight: 900">${errors.ticket_id }</span>
	<br/>
	Reservation status: <input type="text" name="reservation_status" value="${form.reservation_status }"/>
	<span style="color: red; font-weight: 900">${errors.reservation_status }</span>
	<br/>
	Reservation date: <input type="text" name="reservation_date" value="${form.reservation_date }"/>
	<span style="color: red; font-weight: 900">${errors.reservation_date }</span>
	<br/>
	<input type="submit" value="Create Reservation"/>
</form>
  </body>
</html>

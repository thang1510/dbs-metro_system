<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Ticket</title>
    
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
  <h1>Update Ticket</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Ticket ID: <input type="text" name="ticket_id" value="${ticket.ticket_id }" disabled/>
	<br/>
	Train ID: <input type="text" name="train_id" value="${ticket.train_id }" disabled/>
	<br/>	
	Station Depart：<input type="text" name="station_depart" value="${ticket.station_depart }" disabled/>
	<br/>
	Station Arrive：<input type="text" name="station_arrive" value="${ticket.station_arrive }" disabled/>
	<br/>
	Time Depart：<input type="text" name="time_depart" value="${ticket.time_depart }" disabled/>
	<br/>
	Time Arrive：<input type="text" name="time_arrive" value="${ticket.time_arrive }" disabled/>
	<br/>
</form>

<h1>Update the values below</h1>
<form action="<c:url value='/TicketServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="ticket_id" value="${ticket.ticket_id }"/>
	
	Train ID: <input type="text" name="train_id" value="${form.train_id }" />
	<br/>	
	Station Depart：<input type="text" name="station_depart" value="${form.station_depart }" />
	<br/>
	Station Arrive：<input type="text" name="station_arrive" value="${form.station_arrive }" />
	<br/>
	Time Depart：<input type="text" name="time_depart" value="${form.time_depart }" />
	<br/>
	Time Arrive：<input type="text" name="time_arrive" value="${form.time_arrive }" />
	<br/>
	<input type="submit" value="Update Ticket"/>
</form>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Entity</title>
    
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
  <h1>Delete Entity</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/TicketServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="username" value="${Ticket.username }"/>
	Ticket ID: <input type="text" name="ticket_id" value="${Ticket.username }" disabled/>
	<br/>
	Train ID: <input type="text" name="train_id" value="${Ticket.username }" disabled/>
	<br/>	
	Station Depart：<input type="text" name="station_depart" value="${Ticket.password }" disabled/>
	<br/>
	Station Depart：<input type="text" name="station_arrive" value="${Ticket.password }" disabled/>
	<br/>
	Time Depart：<input type="text" name="time_depart" value="${Ticket.password }" disabled/>
	<br/>
	Time Arrive：<input type="text" name="time_depart" value="${Ticket.password }" disabled/>
	<br/>
	
	<input type="submit" value="Delete Ticket"/>
	
</form>

</body>
</html>

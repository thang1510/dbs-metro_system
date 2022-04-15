<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Ticket Create</title>
    
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
  <h1>Create Ticket</h1>
<form action="<c:url value='/TicketServletCreate'/>" method="post">
	Ticket ID: <input type="text" name="ticket_id" value="${form.ticket_id }"/>
	<span style="color: red; font-weight: 900">${errors.ticket_id }</span>
	<br/>
	Train ID: <input type="text" name="train_id" value="${form.train_id }"/>
	<span style="color: red; font-weight: 900">${errors.train_id }</span>
	<br/>
	Station Depart：<input type="text" name="station_depart" value="${form.station_depart }"/>
	<span style="color: red; font-weight: 900">${errors.station_depart }</span>
	<br/>
	Station Arrive：<input type="text" name="station_arrive" value="${form.station_arrive }"/>
	<span style="color: red; font-weight: 900">${errors.station_arrive }</span>
	<br/>
	Time Depart：<input type="text" name="time_depart" value="${form.time_depart }"/>
	<span style="color: red; font-weight: 900">${errors.time_depart }</span>
	<br/>
	Time Arrive：<input type="text" name="time_arrive" value="${form.time_arrive }"/>
	<span style="color: red; font-weight: 900">${errors.time_arrive }</span>
	<br/>
	<input type="submit" value="Create Ticket"/>
</form>
  </body>
</html>

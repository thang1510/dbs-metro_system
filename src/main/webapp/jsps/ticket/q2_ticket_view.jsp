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
	<h3 align="center"> Ticket - Simple Query</h3>
	<code> 
		SELECT * FROM dbs_metro_system.ticket 
		WHERE time_depart >= '2022-01-03 13:23:00' 
		      AND time_arrive <= '2022-01-05 19:00:00' 
		ORDER BY station_depart DESC;
	</code>
	<h3 align="center">Query Result</h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Ticket ID</th>
		<th>Train ID</th>
		<th>Station Depart</th>
		<th>Station Arrive</th>
		<th>Time Depart</th>
		<th>Time Arrive</th>
	</tr>
<c:forEach items="${TicketList}" var="ticket">
	<tr>
		<td>${ticket.ticket_id}</td>
		<td>${ticket.train_id}</td>
		<td>${ticket.station_depart}</td>
		<td>${ticket.station_arrive}</td>
		<td>${ticket.time_depart}</td>
		<td>${ticket.time_arrive}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

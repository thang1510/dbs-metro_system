<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Ticket </h3>
	<table border="1" width="70%" align="center">
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
		<td>${book.ticket_id}</td>
		<td>${book.train_id}</td>
		<td>${book.station_depart}</td>
		<td>${book.station_arrive}</td>
		<td>${book.time_depart}</td>
		<td>${book.time_arrive}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

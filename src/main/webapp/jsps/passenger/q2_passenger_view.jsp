<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
	<h3 align="center"> Passenger </h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Passenger ID</th>
		<th>Full Name</th>
		<th>Address</th>
		<th>Join Date</th>
	</tr>
<c:forEach items="${PassengerList}" var="PassengerList">
	<tr>
		<td>${PassengerList.passenger_id}</td>
		<td>${PassengerList.fullname}</td>
		<td>${PassengerList.address}</td>
		<td>${PassengerList.join_date}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

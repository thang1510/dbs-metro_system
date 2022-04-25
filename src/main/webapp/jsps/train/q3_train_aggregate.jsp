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
	<h3 align="center">Train - Aggregate Query</h3>
	<code> 
		SELECT * FROM dbs_metro_system.train 
		WHERE seat_number < 
			(
				SELECT AVG(seat_number) 
				FROM dbs_metro_system.train
			) 
		AND LENGTH(train_name) > 3;
	</code>
	<h3 align="center">Query Result</h3>
	<table border="1" width="100%" align="center">
	<tr>
		<th>Train ID</th>
		<th>Seat Number</th>
		<th>Train Name</th>
		<th>Train Status</th>
	</tr>
<c:forEach items="${TrainList}" var="TrainList">
	<tr>
		<td>${TrainList.train_id}</td>
		<td>${TrainList.seat_number}</td>
		<td>${TrainList.train_name}</td>
		<td>${TrainList.train_status}</td>
	</tr>
</c:forEach>
</table>
</body>
</html>

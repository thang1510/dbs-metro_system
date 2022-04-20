<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
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
    <h1>List of Queries</h1>
    <br>
    <a href="<c:url value='/findAll'/>" target="body">Please list all the user in the table</a>&nbsp;&nbsp;
 	<br />
 	
 	<h2>Simple Queries</h2>
 	<a href="<c:url value='/findTicket'/>" target="body">Please list all ticket having Time Depart >= '2022-01-03 13:23:00', and Time Arrive <= '2022-01-05 19:00:00' </a>&nbsp;&nbsp;
    <br />
    <a href="<c:url value='/findPassenger'/>" target="body">Please list all Passenger such that </a>&nbsp;&nbsp;
 	<br />
    
    <h2>Aggregate Queries</h2>
    <a href="<c:url value='/findPayment'/>" target="body">Please list all payment - the Amount is less than the average amount and Payment Date after '2022-01-04 14:21:00'</a>&nbsp;&nbsp;
    <br />
    <a href="<c:url value='/findTrain'/>" target="body">Please list all train such that </a>&nbsp;&nbsp;
    <br />
    <h2>Complex Queries</h2>
    <a href="<c:url value='/findPaymentReservation'/>" target="body">Please list all payment and reservation such that -  </a>&nbsp;&nbsp;
    
  </body>
</html>

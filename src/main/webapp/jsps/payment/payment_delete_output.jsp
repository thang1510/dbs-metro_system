<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Delete Payment</title>
    
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
  <h1>Delete Payment</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form action="<c:url value='/Entity1ServletDelete'/>" method="post">
	<input type="hidden" name="method" value="delete"/>
		<input type="hidden" name="username" value="${entity1.username }"/>
		Payment ID: <input type="text" name="payment_id" value="${payment.username }" disabled/>
		<br/>
		Reservation ID: <input type="text" name="reservation_id" value="${payment.username }" disabled/>
		<br/>
		Payment date: <input type="text" name="payment_date" value="${payment.username }" disabled/>
		<br/>
		Amount: <input type="text" name="amount" value="${payment.username }" disabled/>
	<br/>
	<input type="submit" value="Delete Payment"/>
</form>

</body>
</html>

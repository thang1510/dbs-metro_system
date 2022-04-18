<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Update Payment</title>
    
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
  <h1>Update Payment</h1>
	<p style="color: red; font-weight: 900">${msg }</p>
	<form>
		Payment ID: <input type="text" name="payment_id" value="${payment.payment_id }" disabled/>
		<br/>
		Reservation ID: <input type="text" name="reservation_id" value="${payment.reservation_id }" disabled/>
		<br/>
		Payment date: <input type="text" name="payment_date" value="${payment.payment_date }" disabled/>
		<br/>
		Amount: <input type="text" name="amount" value="${payment.amount }" disabled/>
		<br/>
</form>
<h1>Update the values below</h1>
<form action="<c:url value='/PaymentServletUpdate'/>" method="post">
	<input type="hidden" name="method" value="update"/>
	<input type="hidden" name="payment_id" value="${payment.payment_id }"/>
	
	Reservation ID: <input type="text" name="reservation_id" value="${form.reservation_id }" />
	<br/>
	Payment date: <input type="text" name="payment_date" value="${form.payment_date }" />
	<br/>
	Amount: <input type="text" name="amount" value="${form.amount }" />
	<br/>
		
	<input type="submit" value="Update Payment"/>
</form>

</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Payment Create</title>
    
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
  <h1>Payment Create</h1>
<form action="<c:url value='/PaymentServletCreate'/>" method="post">
	Payment ID: <input type="text" name="payment_id" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Reservation ID: <input type="text" name="reservation_id" value="${form.username }"/>
	<span style="color: red; font-weight: 900">${errors.username }</span>
	<br/>
	Password：<input type="text" name="password" value="${form.password }"/>
	<span style="color: red; font-weight: 900">${errors.password }</span>
	<br/>
	Email	：<input type="text" name="email" value="${form.email }"/>
	<span style="color: red; font-weight: 900">${errors.email }</span>
	<br/>
	<input type="submit" value="Create Payment"/>
</form>
  </body>
</html>

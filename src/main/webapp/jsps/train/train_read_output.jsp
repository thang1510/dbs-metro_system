<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Read Train Output</title>
    
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
  <h1>Read Train Output</h1>
<p style="color: red; font-weight: 900">${msg }</p>
<form>
	Train ID: <input type="text" name="train_id" value="${train.train_id }" disabled/>
	<br/>
	Seat number: <input type="text" name="seat_number" value="${train.seat_number }" disabled/>
	<br/>
	Train name: <input type="text" name="train_name" value="${train.train_name }" disabled/>
	<br/>
	Train status: <input type="text" name="train_status" value="${train.train_status }" disabled/>
	<br/>
</form>

<button onclick="window.location.href='<c:url value='/jsps/main.jsp'/>'">Continue</button>
</body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Train Create</title>
    
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
  <h1>Create Train</h1>
<form action="<c:url value='/TrainServletCreate'/>" method="post">
	Train ID: <input type="text" name="train_id" value="${form.train_id }"/>
	<span style="color: red; font-weight: 900">${errors.train_id }</span>
	<br/>
	Seat number: <input type="text" name="seat_number" value="${form.seat_number }"/>
	<span style="color: red; font-weight: 900">${errors.seat_number }</span>
	<br/>
	Train name: <input type="text" name="train_name" value="${form.train_name }"/>
	<span style="color: red; font-weight: 900">${errors.train_name }</span>
	<br/>
	Train status: <input type="text" name="train_status" value="${form.train_status }"/>
	<span style="color: red; font-weight: 900">${errors.train_status }</span>
	<br/>
	<input type="submit" value="Create Train"/>
</form>
  </body>
</html>

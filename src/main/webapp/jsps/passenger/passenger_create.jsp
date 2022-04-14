<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>Create Passenger</title>
    
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
  <h1>Create Passenger</h1>
<form action="<c:url value='/PassengerServletCreate'/>" method="post">

	Passenger ID: <input type="text" name="passenger_id" value="${form.passenger_id }"/>
	<span style="color: red; font-weight: 900">${errors.passenger_id }</span>
	<br/>
	Full Name：<input type="text" name="fullname" value="${form.fullname }"/>
	<span style="color: red; font-weight: 900">${errors.fullname }</span>
	<br/>
	Address：<input type="text" name="address" value="${form.address }"/>
	<span style="color: red; font-weight: 900">${errors.address }</span>
	<br/>
	Join date：<input type="text" name="join_date" value="${form.join_date }"/>
	<span style="color: red; font-weight: 900">${errors.join_date }</span>
	<br/>
	
	<input type="submit" value="Create Passenger"/>
</form>
  </body>
</html>

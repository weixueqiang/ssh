<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="base" value="${pageContext.request.contextPath}"></c:set>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>??</title>
</head>
<body>
	<center>
		<h2 style="color: #ff261a;">this is my test page!</h2>
	</center>
	<form action="${base}/date">
		<input type="text" name="date" /> <input type="submit" value="提交" />
	</form>
</body>
</html>
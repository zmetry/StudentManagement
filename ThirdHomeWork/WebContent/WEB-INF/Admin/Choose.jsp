<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h4>请选择您的操作</h4>
	
	<form action="AdminTransit" method="post">
		
	<select name = "text">
  		<option value = "add">增</option>
  		<option value = "delete">删</option>
  		<option value = "modify">改</option>
  		<option value = "search">查</option>
	</select>
		
		<input type="submit" value="确定">
	
	</form>

</body>
</html>
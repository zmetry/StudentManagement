<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h3>请输入学号</h3>

	<form action = "AdminOp" method = "post">
		
		学号	    ：<input type = "text" name = "StuNum"><br/>
		<input type = "submit" value = "删除" >
		<input type = "hidden" name = "StuName" value=""> <br/>
		<input type = "hidden" name = "TelNum" value=""><br/>
		<input type = "hidden" name = "StuQQ" value=""><br/>
		<input type = "hidden" name = "StuMail" value=""><br/>
				<input type="hidden" name = "mode" value="delete">
			
	</form>

</body>
</html>
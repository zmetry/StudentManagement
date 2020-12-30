<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action = "AdminOp" method = "post">
		
		学号	    ：<input type = "text" name = "StuNum"><br/>
		姓名	    ：<input type = "text" name = "StuName" > <br/>
		电话号码：<input type = "text" name = "TelNum"><br/>
		QQ	    ：<input type = "text" name = "StuQQ"><br/>
		邮箱   	    ：<input type = "text" name = "StuMail"><br/>
				<input type="hidden" name = "mode" value="add">
			<input type = "submit" value = "插入" >
	</form>
	

</body>
</html>
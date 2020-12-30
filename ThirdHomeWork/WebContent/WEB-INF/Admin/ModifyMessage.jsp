<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		boolean flag = (boolean)request.getAttribute("flag");
		
		if(flag == true){
			
			String str = (String)request.getAttribute("before");
			
			%>
			
			<h3>请输入要更改的信息</h3>
			
				<form action = "AdminOp" method = "post">
		
			学号	    ：<input type = "text" name = "StuNum"><br/>
			姓名	    ：<input type = "text" name = "StuName" > <br/>
			电话号码：<input type = "text" name = "TelNum"><br/>
			QQ	    ：<input type = "text" name = "StuQQ"><br/>
			邮箱   	    ：<input type = "text" name = "StuMail"><br/>
					<input type = "hidden" name = "before" value = <%=str%>>
				<input type="hidden" name = "mode" value="modify">
			<input type = "submit" value = "更改" >
		</form>
				
			<% 
			
		}else{
			
			%>
			
				<h3>请输入要更改的学生的学号</h3>
				<form action = "ModifyTools" method = "post">
					学号	    ：<input type = "text" name = "StuNum"><br/>
					<input type = "submit" value="提交">	
				</form>
			<%
			
		}
		
	%>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import = "java.util.*,user.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Page</title>
</head>
<body>

	<%!
		public static final int PAGESIZE = 5;
		int curPage;
		int pageCount = 0;
		Student stu = new Student();
		List<Student> StuList = new ArrayList<Student>();
	%>

	<%
		StuList.clear();
		Object obj = request.getAttribute("stulist");
		//检查是不是ArrayList
		if(obj instanceof ArrayList<?>){
			//取出ArrayList
			ArrayList< ? > al = (ArrayList< ? >) obj;
			if (al.size() > 0) {
		    	// 一个个转换过来.
		    	for (int i = 0; i < al.size(); i++) {
		      	// 还得判断是不是String
		      	Object o = al.get(i);
		      	if(o instanceof Student ){
		    	 	 StuList.add((Student)o);//timeSpent是前面自己定义的ArrayList
		      		}
		   	 }
			}
		}
		System.out.println(StuList.size());
		curPage = (int)request.getAttribute("curPage");
		
		stu.setMail((String)request.getAttribute("Mail"));
		stu.setName((String)request.getAttribute("StuName"));
		stu.setQQNum((String)request.getAttribute("QQNum"));
		stu.setStuNum((String)request.getAttribute("StuNum"));
		stu.setTelNum((String)request.getAttribute("TelNum"));
		
		pageCount = (StuList.size()%PAGESIZE==0)?(StuList.size()/PAGESIZE):(StuList.size()/PAGESIZE+1); 	
		
	%>
	
	<table border="1">
	<tr>
	<td>学号</td>
	<td>姓名</td>
	<td>电话号码</td>
	<td>QQ</td>
	<td>邮箱</td>
	</tr>
	
	<%
		for(int i = (curPage - 1) * PAGESIZE;i < ((curPage*PAGESIZE>StuList.size())?StuList.size():curPage * PAGESIZE);i++){
			
			Student s = StuList.get(i);
			
			%><tr><td><%
			out.print(s.getStuNum());
			
			%></td><td><%
			out.print(s.getName());
			
			%></td><td><%
			out.print(s.getTelNum());
			
			%></td><td><%
			out.print(s.getQQNum());
			
			%></td><td><%
			out.print(s.getMail());
			
			%></td></tr><%
			
		}
	%>
	
	<div>
	<form action="HomeWorkS" method = "post" style="display: inline">
		<input type = "hidden" name = "StuName" value = <%=stu.getName()%>>
		<input type = "hidden" name = "StuNum" value = <%=stu.getStuNum()%>>
		<input type = "hidden" name = "TelNum" value = <%=stu.getTelNum()%>>
		<input type = "hidden" name = "StuQQ" value = <%=stu.getQQNum()%>>
		<input type = "hidden" name = "StuMail" value = <%=stu.getMail()%>>
		<input type = "hidden" name = "curPage" value = <%=1%>>
			<input type = "submit" value = "首页" >
	</form>
	
	<form action="HomeWorkS" method = "post" style="display: inline">
		<input type = "hidden" name = "StuName" value = <%=stu.getName()%>>
		<input type = "hidden" name = "StuNum" value = <%=stu.getStuNum()%>>
		<input type = "hidden" name = "TelNum" value = <%=stu.getTelNum()%>>
		<input type = "hidden" name = "StuQQ" value = <%=stu.getQQNum()%>>
		<input type = "hidden" name = "StuMail" value = <%=stu.getMail()%>>
		<input type = "hidden" name = "curPage" value = <%=curPage>1?curPage-1:curPage%>>
			<input type = "submit" value = "上一页" >
	</form>
	
	<form action="HomeWorkS" method = "post" style="display: inline">
		<input type = "hidden" name = "StuName" value = <%=stu.getName()%>>
		<input type = "hidden" name = "StuNum" value = <%=stu.getStuNum()%>>
		<input type = "hidden" name = "TelNum" value = <%=stu.getTelNum()%>>
		<input type = "hidden" name = "StuQQ" value = <%=stu.getQQNum()%>>
		<input type = "hidden" name = "StuMail" value = <%=stu.getMail()%>>
		<input type = "hidden" name = "curPage" value = <%=curPage<pageCount?curPage+1:curPage%>>
			<input type = "submit" value = "下一页" >
	</form>
	
	<form action="HomeWorkS" method = "post" style="display: inline">
		<input type = "hidden" name = "StuName" value = <%=stu.getName()%>>
		<input type = "hidden" name = "StuNum" value = <%=stu.getStuNum()%>>
		<input type = "hidden" name = "TelNum" value = <%=stu.getTelNum()%>>
		<input type = "hidden" name = "StuQQ" value = <%=stu.getQQNum()%>>
		<input type = "hidden" name = "StuMail" value = <%=stu.getMail()%>>
		<input type = "hidden" name = "curPage" value = <%=pageCount%>>
			<input type = "submit" value = "尾页" >
	</form>
	
	第<%=curPage%>页/共<%=pageCount%>页  
	
	</div>
	

</body>
</html>
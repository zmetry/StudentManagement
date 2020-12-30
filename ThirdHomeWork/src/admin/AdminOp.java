//package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

import user.*;

/**
 * Servlet implementation class AdminOp
 */
@WebServlet("/AdminOp")
public class AdminOp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Session session = (Session) request.getSession(true);
		
		String choose = request.getParameter("mode");
		String strtemp;
		Student stu = new Student();
		SQLOperator sqlo = new SQLOperator();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setHeader("Content-type","text/html;charset=utf-8");
		
		if(request.getParameter("StuName") != "" && request.getParameter("StuName") != null){
			String str = request.getParameter("StuName");
			str = str.trim();
			stu.setName(str);
		}else{
			stu.setName("");
		}
		
		
		if(request.getParameter("StuQQ") != "" && request.getParameter("StuQQ") != null){
			stu.setQQNum(request.getParameter("StuQQ").trim());
		}else{
			stu.setQQNum("");
		}
		
		if(request.getParameter("StuNum") != "" && request.getParameter("StuNum") != null){
			stu.setStuNum(request.getParameter("StuNum").trim());
		}else{
			stu.setStuNum("");
		}
		
		if(request.getParameter("StuMail") != "" && request.getParameter("StuMail") != null){
			stu.setMail(request.getParameter("StuMail").trim());
		}else{
			stu.setMail("");
		}
		
		if(request.getParameter("TelNum") != "" && request.getParameter("TelNum") != null){
			stu.setTelNum(request.getParameter("TelNum").trim());
		}else{
			stu.setTelNum("");
		}
		
		
		switch(choose) {
		case "add":
			sqlo.AddMessage(stu);
			request.getRequestDispatcher("WEB-INF/Admin/successful.jsp").forward(request, response);
			break;
		case "delete":
			sqlo.DeleteMessage(stu.getStuNum());
			request.getRequestDispatcher("WEB-INF/Admin/successful.jsp").forward(request, response);
			break;
		case "modify":
			sqlo.DeleteMessage(request.getParameter("before"));
			sqlo.AddMessage(stu);
			request.getRequestDispatcher("WEB-INF/Admin/successful.jsp").forward(request, response);
			break;
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

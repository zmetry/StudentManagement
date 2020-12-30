package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.*;
import java.util.*;

/**
 * Servlet implementation class ModifyTools
 */
@WebServlet("/ModifyTools")
public class ModifyTools extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str = request.getParameter("StuNum");
		SQLOperator sqo = new SQLOperator();
		String temp = str;
		boolean flag = false;
		List<Student> stulist = sqo.GetSQLMessage("StuNum = '" + str + "';");
		if(stulist.isEmpty()) {
			
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("WEB-INF/Admin/ModifyMessage.jsp").forward(request, response);
			
		}else {
			flag = true;
			request.setAttribute("flag", flag);
			request.setAttribute("before", temp);
			request.getRequestDispatcher("WEB-INF/Admin/ModifyMessage.jsp").forward(request, response);	
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

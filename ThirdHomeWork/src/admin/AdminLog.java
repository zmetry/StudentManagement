package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.*;

/**
 * Servlet implementation class AdminWork
 */
@WebServlet("/AdminLog")
public class AdminLog extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean result = false;
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		SQLOperator sqlo = new SQLOperator();
		result = sqlo.Log(username, password);
		
		if(result == false) {
			
			request.getRequestDispatcher("WEB-INF/Admin/logfail.jsp").forward(request, response);
			
		}
		else {
			
			request.getRequestDispatcher("WEB-INF/Admin/Choose.jsp").forward(request, response);
			
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

package admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminOp
 */
@WebServlet("/AdminTransit")
public class AdminTransit extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String str = request.getParameter("text");
		boolean flag = false;
		
		switch(str) {
		case "add":
			request.getRequestDispatcher("WEB-INF/Admin/AddMessage.jsp").forward(request, response);
			break;
		case "delete":
			request.getRequestDispatcher("WEB-INF/Admin/DeleteMessage.jsp").forward(request, response);
			break;
		case "modify":
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("WEB-INF/Admin/ModifyMessage.jsp").forward(request, response);
			break;
		case "search":
			request.getRequestDispatcher("NormalStart.jsp").forward(request, response);
			break;
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

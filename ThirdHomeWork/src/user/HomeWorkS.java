package user;

import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.*;

/**
 * Servlet implementation class HomeWorkS
 */
@WebServlet("/HomeWorkS")
public class HomeWorkS extends HttpServlet{   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("UTF-8");
		Student stu = new Student();
		SQLOperator sqlo = new SQLOperator();
		boolean Result = false;
		List<Student> StuList = null;
		int curPage;
		
		int count = 0;
		String strtemp;
		
		if(request.getParameter("curPage") != null){
			curPage = Integer.parseInt(request.getParameter("curPage").trim());  
		}else {
			curPage = 1;
		}
		
		if(request.getParameter("StuName") != "" && request.getParameter("StuName") != null){
			String str = request.getParameter("StuName");
			str = str.trim();
			strtemp = new String(str.getBytes(stu.getEncoding(str)),"ISO-8859-1");
			str = new String(str.getBytes(stu.getEncoding(str)),"UTF-8");
			stu.setName(str);
			count++;
		}else{
			stu.setName("");
		}
		
		if(request.getParameter("StuQQ") != "" && request.getParameter("StuQQ") != null){
			stu.setQQNum(request.getParameter("StuQQ").trim());
			count++;
		}else{
			stu.setQQNum("");
		}
		
		if(request.getParameter("StuNum") != "" && request.getParameter("StuNum") != null){
			stu.setStuNum(request.getParameter("StuNum").trim());
			count++;
		}else{
			stu.setStuNum("");
		}
		
		if(request.getParameter("StuMail") != "" && request.getParameter("StuMail") != null){
			stu.setMail(request.getParameter("StuMail").trim());
			count++;
		}else{
			stu.setMail("");
		}
		
		if(request.getParameter("TelNum") != "" && request.getParameter("TelNum") != null){
			stu.setTelNum(request.getParameter("TelNum").trim());
			count++;
		}else{
			stu.setTelNum("");
		}
		
		
		if(count == 1) {
				if(stu.getName() != null && stu.getName() != "") {
					String temp = "StuName like " + "'" + stu.getName() + "%';";
					StuList = sqlo.GetSQLMessage(temp);
					if(StuList != null) {
						Result = true;
					}
				}else {
					if(stu.getStuNum() != null && stu.getStuNum() != "") {
						String temp = "StuNum = " + "'" + stu.getStuNum() + "';";
						StuList = sqlo.GetSQLMessage(temp);
						if(StuList != null) {
							Result = true;
						}
					}else {
						if(stu.getMail() != null && stu.getMail() != "") {
							String temp = "Mail = " + "'" + stu.getMail() + "';";
							StuList = sqlo.GetSQLMessage(temp);
							if(StuList != null) {
								Result = true;
							}
						}else {
							if(stu.getTelNum() != null && stu.getTelNum() != "") {
								String temp = "TelNum = " + "'" + stu.getTelNum() + "';";
								StuList = sqlo.GetSQLMessage(temp);
								if(StuList != null) {
									Result = true;
								}
							}else {
									if(stu.getQQNum() != null && stu.getQQNum() != "") {
										String temp = "QQNum = " + "'" + stu.getQQNum() + "';";
										StuList = sqlo.GetSQLMessage(temp);
										if(StuList != null) {
											Result = true;
										}
									}
								}
							}
					}
				}
		}
		
		if(count > 1) {
			String temp = "";
			int i = 0;
			if(stu.getName() != null && stu.getName() != "") {
				if(i == 0) {
					temp += "StuName like " + "'" + stu.getName() +"%'";
					i++;
				}
			}
			
			if(stu.getMail() != null & stu.getMail() != "") {
				if(i == 0) {
					temp += "Mail = " + "'" + stu.getMail() + "'";
					i++;
				}else {
					temp += " and Mail = " + "'" + stu.getMail() + "'";
				}
				if(i == count) {
					temp += ";";
				}
				
			}
			
			if(stu.getQQNum() != null & stu.getQQNum() != "") {
				if(i == 0) {
					temp += "QQNum = " + "'" + stu.getQQNum() + "'";
					i++;
				}else {
					temp += " and QQNum = " + "'" + stu.getQQNum() + "'";
				}
				if(i == count) {
					temp += ";";
				}	
			}
			
			if(stu.getTelNum() != null & stu.getTelNum() != "") {
				if(i == 0) {
					temp += "TelNum = " + "'" + stu.getTelNum() + "'";
					i++;
				}else {
					temp += " and TelNum = " + "'" + stu.getTelNum() + "'";
				}
				if(i == count) {
					temp += ";";
				}	
			}
			
			if(stu.getStuNum() != null & stu.getStuNum() != "") {
				if(i == 0) {
					temp += "StuNum = " + "'" + stu.getStuNum() + "'";
					i++;
				}else {
					temp += " and StuNum = " + "'" + stu.getStuNum() + "'";
				}
				if(i == count) {
					temp += ";";
				}	
			}
			
			StuList = sqlo.GetSQLMessage(temp);
			if(StuList != null) {
				Result = true;
			}
		}
		
		if(Result == false) {
			request.getRequestDispatcher("WEB-INF/contact/searchfail.jsp").forward(request, response);
		}else {
			
			request.setAttribute("stulist", StuList);
			request.setAttribute("curPage", curPage);
			
			request.setAttribute("StuName", stu.getName());
			request.setAttribute("StuNum", stu.getStuNum());
			request.setAttribute("Mail", stu.getMail());
			request.setAttribute("QQNum", stu.getQQNum());
			request.setAttribute("TelNum", stu.getTelNum());
			
			request.getRequestDispatcher("WEB-INF/contact/Show.jsp").forward(request, response);
		}
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
		
	}

}

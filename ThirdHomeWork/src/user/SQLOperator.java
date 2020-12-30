package user;

import java.util.*;

import user.Student;

import java.sql.*;

public class SQLOperator {
	
	public List<Student> GetSQLMessage(String txt){
		
		List<Student> stulist = new ArrayList<Student>();
		
		Connection conn = null;//数据库连接对象
		PreparedStatement pstmt = null;//SQL语句对象，用来执行SQL语句
		ResultSet rs = null;//结果集对象，执行查询SQL语句会返回结果集
		
		String sqltxt = "select * from message where " + txt;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
                        //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"
					+ "?serverTimezone=UTC", 
					"root", "root");
			
			pstmt = conn.prepareStatement(sqltxt);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Student stu = new Student();
				stu.setName(rs.getString("StuName"));
				stu.setMail(rs.getString("Mail"));
				stu.setQQNum(rs.getString("QQNum"));
				stu.setStuNum(rs.getString("StuNum"));
				stu.setTelNum(rs.getString("TelNum"));
				stulist.add(stu);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return stulist;
	}
	
	public boolean Log(String username,String password) {
		
		boolean result = false;
		Connection conn = null;//数据库连接对象
		PreparedStatement pstmt = null;//SQL语句对象，用来执行SQL语句
		ResultSet rs = null;//结果集对象，执行查询SQL语句会返回结果集
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
                        //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"
					+ "?serverTimezone=UTC", 
					"root", "root");
			
			pstmt = conn.prepareStatement("select * from admin where username = ? and password = ?");
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				result = true;
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs != null) {
				rs.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public void AddMessage(Student stu) {
		
		Connection conn = null;//数据库连接对象
		PreparedStatement pstmt = null;//SQL语句对象，用来执行SQL语句
		ResultSet rs = null;//结果集对象，执行查询SQL语句会返回结果集

		
		String str = "insert into message(StuName,StuNum,TelNum,QQNum,Mail) values (?,?,?,?,?)";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
                        //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"
					+ "?serverTimezone=UTC&characterEncoding=UTF-8&userUnicode=true", 
					"root", "root");
			
			pstmt = conn.prepareStatement(str);
			pstmt.setString(2, stu.getStuNum());
			pstmt.setString(1, stu.getName());
			pstmt.setString(3, stu.getTelNum());
			pstmt.setString(4, stu.getQQNum());
			pstmt.setString(5, stu.getMail());
			
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public boolean DeleteMessage(String str) {
		
		Connection conn = null;//数据库连接对象
		PreparedStatement pstmt = null;//SQL语句对象，用来执行SQL语句
		ResultSet rs = null;//结果集对象，执行查询SQL语句会返回结果集
		boolean flag = false;
		
		String sqlstr = "delete from message where StuNum = ?;";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
                        //添加一个println，如果加载驱动异常，检查是否添加驱动，或者添加驱动字符串是否错误
			e.printStackTrace();
		}
		
		try {
			
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student"
					+ "?serverTimezone=UTC&characterEncoding=UTF-8&userUnicode=true", 
					"root", "root");
			
			pstmt = conn.prepareStatement(sqlstr);
			pstmt.setString(1, str);
			pstmt.execute();
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		try {
			if(pstmt != null) {
				pstmt.close();
			}
			if(conn != null) {
				conn.close();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		return flag;
		
	}
	
	
	
}

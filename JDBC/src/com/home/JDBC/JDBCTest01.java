package com.home.JDBC;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.Statement;

/*
 * 		JDBC program six Trilgy
 * 			1.register driver 
 * 				 1.1 get driver object
 * 				 1.2 register driver
 * 			2.get database connection
 * 			3.get database operation
 * 			4.implement SQL Language
 * 			5.handle select result
 * 			6.close resource
 */

public class JDBCTest01 {

	public static void main(String[] args)  {
		//1. register driver 
		Driver driver=null;
		ResultSet rs=null;
		Connection conn =null;
		Statement stmt=null;
		try {
			//1.1 get register driver object
			driver = new com.mysql.jdbc.Driver();
			
			//1.2 register driver
			DriverManager.registerDriver(driver);
			
			//2.get database connection
			String url="jdbc:mysql://localhost:3306/home";
			String user="root";
			String password="xavierli";
			conn = DriverManager.getConnection(url, user, password);
			
			//3.get database operation object
			stmt = conn.createStatement();
			
			
			//4.implement SQL language
					
					//4.1 DQL Language  
					String sql="select * from student";
					rs = stmt.executeQuery(sql);
					System.out.println(rs);
					//5. handle select result
					while(rs.next()) {
						String sno = rs.getString("sno");
						String sname = rs.getString("sname");
						int sage = rs.getInt("sage");
						System.out.println(sno+" "+sname+" "+sage);
					}
					//4.2 DML Language
					/*String sql_ins="insert into student(sno,sname,sage) values('1','xavier','20')";
					int count=	stmt.executeUpdate(sql_ins);
					System.out.println(count);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//6. close resource
		finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(stmt!=null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}

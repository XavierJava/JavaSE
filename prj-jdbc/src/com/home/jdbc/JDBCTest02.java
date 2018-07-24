package com.home.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest02 {

	public static void main(String[] args) {
		Connection conn=null;
		Statement  stmt=null;
		ResultSet  rs=null;
		try {
			// 1.register driver
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 2.get database connection
			String url="jdbc:mysql://localhost:3306/home";
			String user="root";
			String password="xavierli";
			conn=DriverManager.getConnection(url, user, password);
			// 3.get database operation
			stmt=conn.createStatement();
			String sql="select * from student";
			// 4.implement SQL language
			rs=stmt.executeQuery(sql);
			while(rs.next()) {
				String sno = rs.getString("sno");
				String sname = rs.getString("sname");
				int sage = rs.getInt("sage");
				System.out.println(sno+" "+sname+" "+" "+sage);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
				try {
					if(rs!=null) {
					rs.close();
					}
					if(stmt!=null) {
						stmt.close();
					}
					if(conn!=null) {
						conn.close();
					}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
			
	}



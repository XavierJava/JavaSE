package com.home.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCTest04 {

	public static void main(String[] args)  {
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/home";
			String user="root";
			String password="xavierli";
			conn=DriverManager.getConnection(url, user, password);
			// close auto commit , turn on Transaction
			conn.setAutoCommit(false);
			//Transation only have relationship with DML Language
			String sql_del="delete from student where sno =?";
			// SQL prepare Compile
			ps=conn.prepareStatement(sql_del);
			ps.setString(1, "1");
			int count = ps.executeUpdate();
			System.out.println(count);
			// commit transaction
			conn.commit();
		} catch (Exception e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}finally {
			
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps!=null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(conn!=null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}

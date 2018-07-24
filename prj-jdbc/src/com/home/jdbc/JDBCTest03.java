package com.home.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTest03 {

	public static void main(String[] args) {
		// 1. get information from database properties file
		// read config file by fileReader
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		try {
			FileReader fileReader = new FileReader("config/db.config.properties");
	    //create attribute object
			Properties pro = new Properties();
		// produce a map set by attribute object's load method let config information load to Memory
			pro.load(fileReader);
		// close stream
			fileReader.close();
			String driver = pro.getProperty("driver");
			String url = pro.getProperty("url");
			String user = pro.getProperty("user");
			String password = pro.getProperty("password");
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url, user, password);
				stmt =conn.createStatement();
				String sql_ins="insert into student(sno,sname,sage) values ('2','rachard','25')";
				int count = stmt.executeUpdate(sql_ins);
				System.out.println(count);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
				try {
					if(conn!=null) {
					conn.close();
					}
					
					if(stmt!=null) {
						stmt.close();
					}
					
					if(rs!=null) {
						rs.close();
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		
		
		
	}

}

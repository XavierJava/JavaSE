package com.home.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get "multipart" request 's request content
		ServletInputStream is = request.getInputStream();
		
		// use standard inputStream'data write into standard outputStream 
		PrintWriter out = response.getWriter();
		int len =-1;
		byte[] buffer =new byte[1024];
		while((len=is.read(buffer))!=-1) {
			String str = new String(buffer,0,len);
			out.print(str);
		}
		// close inputStream
		 is.close();
	}
	
}

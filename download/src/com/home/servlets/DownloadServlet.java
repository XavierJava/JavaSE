package com.home.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jni.OS;


public class DownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName ="教程.pdf";
		byte[] bytes = fileName.getBytes("UTF-8");
		fileName=new String(bytes,"ISO8859-1");
		
		//update response's head attribute "content-disposition" value is "attachment"
		response.setHeader("content-disposition", "attachment;fileName="+fileName);
		
		String path="/resources/1.pdf";
		InputStream is = this.getServletContext().getResourceAsStream(path);
		//achieve
		ServletOutputStream out = response.getOutputStream();
		int len=-1;
		byte[] buffer=new byte[1024];
		while((len=is.read(buffer))!=-1) {
				out.write(buffer, 0, len);
		}
		
		
		//close stream
		out.close();
		is.close();
	}

}

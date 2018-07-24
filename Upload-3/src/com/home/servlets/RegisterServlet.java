package com.home.servlets;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class RegisterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// 1. judge this request is a multipart request 
		
	 if(!ServletFileUpload.isMultipartContent(request)) {
		 throw new  RuntimeException("Current request does not support file upload!");
	 }
	 try {
		 // create a factory for disk-based file items
		 DiskFileItemFactory factory = new DiskFileItemFactory();
		
	   //set use this temporary file's boundary value(边界值)  if more than this value
	   // otherwise ,this upload file will write into memory
		 
		 //set the boundary value is 1M
		factory.setSizeThreshold(1024*1024*1); 
		//create temporary file
		String rePath=this.getServletContext().getRealPath("/repository");
		File repository=new File(rePath);
		factory.setRepository(repository);
		 
		 
		 // create a new file upload core handler
		 ServletFileUpload upload = new ServletFileUpload(factory);
		 
		 //set every item's head character Encoding,this can solve file's name Chinese garbled
		 upload.setHeaderEncoding("UTF-8");
		 
		 // set single file's size
		 upload.setFileSizeMax(1024*1024*2);
		 
		 // set one request upload files'size     use upload multiple files
		 upload.setSizeMax(1024*1024*5);
		 
		 // Parse(解析) the request,get all items
		List<FileItem> items = upload.parseRequest(request);
		 // Traversing "items"
		for(FileItem item :items) {
			 if (item.isFormField()) {	   //standard form item
			      String fieldName = item.getFieldName();
			      String fieldValue = item.getString("UTF-8");
			      System.out.println(fieldName+" "+fieldValue);
			    } else {					//fileupload form item
			    	String fileName = item.getName(); //get upload File's name
			    	fileName=System.currentTimeMillis()+fileName;
			    	int uploadFileIndex = fileName.lastIndexOf("\\");
			    	fileName=fileName.substring(uploadFileIndex+1, fileName.length());
			    	System.out.println(fileName);
			    	//get inputStream ,in this stream have the uploadfile content
			    	InputStream is = item.getInputStream();
			    	
			    	//get file save in the server's path
			    	String path = this.getServletContext().getRealPath("/images");
			    	
			    	//create target file
					File descFile = new File(path,fileName);
			    	FileOutputStream os = new FileOutputStream(descFile);
			    	
			    	// Write data from InputStream to the OutputStream
			    	int len =-1;
			    	byte[] buffer=new byte[1024];
			    	while((len=is.read(buffer))!=-1) {
			    		os.write(buffer, 0, len);
			    	}
			    	//close stream
			    	os.close();
			    	is.close();
			    	
			    	//delete temp file
			    	item.delete();
			    }

		}
	} catch (FileUploadException e) {
		e.printStackTrace();
	}
	}
	
		
	}
	


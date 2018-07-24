<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
The file upload requirements for the form:
	1.the form submit's method must be "POTS"
	2.in this form should design this submit request is "multipart",the way is
	add "enctype" attribute for the <form/> label
	3.this form should have "file" element
 -->
<form action="${pageContext.request.contextPath}/registerServlet" method="POST" enctype="multipart/form-data">
name：<input type="text" name="name"> <br><br>
age：&nbsp;<input type="text" name="age"> <br><br>
photo：<input type="file" name="phote"> <br><br>
<input type="Submit" value="Register">
</form>


</body>
</html>
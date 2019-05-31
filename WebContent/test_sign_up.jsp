<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="User_controller" method="post">
		<input type="hidden" name="action" value="insert">
			ID <input type="text" name="id"/><br>
			PW <input type="password" name="pw" /><br>
			NAME <input type="text" name="name" /><br>
			EMAIL <input type="email" name="email" /><br>
			TEL <input type="tel" name="tel" /><br>
			<input type="submit" value="SIGN UP" />			
		</form>	
	</div>
</body>
</html>
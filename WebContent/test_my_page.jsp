<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<jsp:useBean id="user" scope="request" class="com.q0429.model.User" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<div align="center">	
		
			ID : <%=user.getId()%><br>
			PW : <%=user.getPw()%><br>
			NAME : <%=user.getName()%><br>
			EMAIL : <%=user.getEmail()%><br>
			TEL : <%=user.getTel()%>
		
	</div>
</body>
</html>
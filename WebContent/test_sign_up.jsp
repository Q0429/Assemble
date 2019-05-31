<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<jsp:useBean id="user" class="com.q0429.model.User" scope="request"></jsp:useBean>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function double_chk() {
		
	}
</script>
</head>
<body>

	<div align="center">		
		<form name ="form" action="User_controller" method="post">
			<input type="hidden" name="action" value="insert"> 
			ID <input type="text" name="id" value="<%=user.getId()%>" /> 
			<input type="button" onclick="double_chk()" value="중복 체크" /><br>
			PW <input type="password" name="pw" value="<%=user.getPw()%>" /><br>
			NAME <input type="text" name="name" value="<%=user.getName()%>" /><br>
			EMAIL <input type="email" name="email" value="<%=user.getEmail()%>" /><br>
			TEL <input type="tel" name="tel" value="<%=user.getTel()%>" /><br>
			<input type="submit" value="SIGN UP" />
		</form>
	</div>
</body>
</html>
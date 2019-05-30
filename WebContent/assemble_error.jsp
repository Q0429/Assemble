<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="inner">
		<header class="major">
			<h2>에러 발생</h2>
		</header>
		<p>
			주소록 처리중에 에러가 발생 했습니다.<br> 관리자에게 문의해주세요.<br> <br>
			<%=exception%>
		</p>
	</div>
</body>
</html>
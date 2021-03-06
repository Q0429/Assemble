<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<jsp:useBean id="user" class="com.q0429.model.User" scope="request"></jsp:useBean>
<!DOCTYPE HTML>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>
<head>
<title>Assemble</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="assets/css/noscript.css" />
</noscript>
</head>
<body class="is-preload">

	<!-- Wrapper -->
	<div id="wrapper">

		<jsp:include page="header.jsp"></jsp:include>

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>SIGN UP</h1>
					</header>
				</div>
			</section>

		</div>

		<!-- Contact -->
		<section id="contact">
			<div class="inner">

				<form method="post" action="User_controller">
					<input type=hidden name="action" value="insert">
					<div class="fields">
						<div class="field">
							<label for="name">ID</label>
							 <input type="text" name="id" id="name" value="<%=user.getId()%>"/>
							 <!-- <input type="button" onclick="double_chk()" value="중복 체크" /> -->
						</div>
						<div class="field">
							<label for="name">PW</label> <input type="password" name="pw"
								id="name" value="<%=user.getPw()%>" />
						</div>
						<div class="field">
							<label for="name">NAME</label> <input type="text" name="name"
								id="name" value="<%=user.getName()%>" />
						</div>
						<div class="field">
							<label for="name">EMAIL</label> <input type="email" name="email"
								id="name" value="<%=user.getEmail()%>" />
						</div>
						<div class="field">
							<label for="name">TEL</label> <input type="tel" name="tel"
								id="name" value="<%=user.getTel()%>" />
						</div>
					</div>
					<ul class="actions">
						<li><input type="submit" value="SIGN UP" class="primary" /></li>
						<li><input type="button" onClick="location.href='index.jsp'"
							value="BACK" /></li>
					</ul>
				</form>


			</div>
		</section>

		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
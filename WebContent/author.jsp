<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8" errorPage="assemble_error.jsp" %>
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

		<!-- Banner -->
		<!-- Note: The "styleN" class below should match that of the header element. -->
		<section id="banner" class="style2">
			<div class="inner">
				<span class="image"> <img src="images/pic07.jpg" alt="" />
				</span>
				<header class="major">
					<h1>만든 사람 소개</h1>
				</header>
			</div>
		</section>

		<!-- Main -->
		<div id="main">
			<!-- Contact -->
			<section id="contact">
				<div class="inner">
					<section class="">
						<section>
							<div class="contact-method">
								<span class="icon alt fa-id-card"></span>
								<h3>이형규</h3>
								<span>컴퓨터공학전공<br /> 27세<br /> 백수
								</span>
							</div>
						</section>
						<section>
							<div class="contact-method">
								<span class="icon alt fa-envelope"></span>
								<h3>Email</h3>
								<a href="#">belathne0429@gmail.com</a>
							</div>
						</section>
						<section>
							<div class="contact-method">
								<span class="icon alt fa-phone"></span>
								<h3>Phone</h3>
								<span>(010) 2937-6242</span>
							</div>
						</section>

					</section>
				</div>
			</section>
		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
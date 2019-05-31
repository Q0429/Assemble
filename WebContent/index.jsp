<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
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
		<section id="banner" class="major">
			<div class="inner">
				<header class="major">
					<h1>
						<%
							String now_user;
							now_user = (String) session.getAttribute("sign_in_user");
							if (now_user == null) {
								now_user = "";
							} else {
								now_user += "님 ";
							}							
						%>
						<%=now_user%>어서오세요.
					</h1>
				</header>
				<div class="content">
					<ul class="actions">
						<li><a href="#one" class="button next scrolly">Get
								Started</a></li>
					</ul>
				</div>
			</div>
		</section>

		<!-- Main -->
		<div id="main">

			<!-- One -->
			<section id="one" class="tiles">
				<article>
					<span class="image"> <img src="images/pic01.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<a href="addrbook_form.jsp" class="link"> 프로젝트 등록</a>
						</h3>
					</header>
				</article>
				<article>
					<span class="image"> <img src="images/pic02.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<a href="addrbook_control.jsp?action=list" class="link"> 프로젝트
								참가 </a>
						</h3>
					</header>
				</article>
				<article>
					<span class="image"> <img src="images/pic03.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<a href="addrbook_control.jsp?action=edit_list" class="link">
								프로젝트 조회 </a>
						</h3>
					</header>
				</article>
				<article>
					<span class="image"> <img src="images/pic04.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<a href="author.jsp" class="link"> 제작자 </a>
						</h3>
					</header>
				</article>
			</section>


		</div>
		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
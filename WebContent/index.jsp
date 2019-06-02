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
							boolean is_user = false;
							String now_user;
							now_user = (String) session.getAttribute("sign_in_user");
							if (now_user == null) {
						%>
						어서오세요.
						<%
							} else {
								is_user = true;
						%>
						<%=now_user + "님 "%>어서오세요.
						<%
							}
						%>

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
							<%
								if (is_user) {
							%>
							<a href="create_pj.jsp"
								class="link"> 프로젝트 생성 </a>
							<%
								} else {
							%>
							<a href="sign_in.jsp" class="link"> 프로젝트 생성 </a>
							<%
								}
							%>
						</h3>
					</header>
				</article>
				<article>
					<span class="image"> <img src="images/pic02.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<a href="Link_controller?action=list_null" class="link"> 프로젝트 참가 </a>
						</h3>
					</header>
				</article>
				<article>
					<span class="image"> <img src="images/pic03.jpg" alt="" />
					</span>
					<header class="major">
						<h3>
							<%
								if (is_user) {
							%>
							<a href="User_controller?action=my_info&id=<%=now_user%>"
								class="link"> 프로젝트 관리 </a>
							<%
								} else {
							%>
							<a href="sign_in.jsp" class="link"> 프로젝트 관리 </a>
							<%
								}
							%>
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
	</div>
</body>
</html>
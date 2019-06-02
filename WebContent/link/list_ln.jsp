<%@page import="java.util.ArrayList"%>
<%@page import="com.q0429.model.Project"%>
<%@page import="com.q0429.model.Link"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
	<jsp:useBean id="datas" scope="request" class="java.util.ArrayList" />
	<jsp:useBean id="datas_pj" scope="request" class="java.util.ArrayList"></jsp:useBean>
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

		<jsp:include page="/header.jsp"></jsp:include>

		

		<!-- Main -->
		<div id="main" class="alt">

			<!-- One -->
			<section id="one">
				<div class="inner">
					<header class="major">
						<h1>LIST</h1>
					</header>

					<!-- Content -->


					<hr class="major" />

					<!-- Elements -->

					<div class="col-6 col-12-medium">
						<!-- Table -->
						<div class="table-wrapper">
							<table class="alt">
								<thead>
									<tr>
										<th>이름</th>
										<th>OWNER</th>
										<th>DEADLINE</th>
										<th>REQUEST</th>
									</tr>
								</thead>
								<tbody>
									<%
										int idx = 1;
										for (int i = 0; i < datas.size(); i++) {
											Link ln = (Link)datas.get(i);
											Project pj = (Project)datas_pj.get(i);
									%>
									<tr>
										<td><%=idx%></td>
										<td><%=pj.getName()%></td>
										<td><%=pj.getOwner()%></td>
										<td><%=pj.getDeadline()%></td>
										<td><%=ln.getRequire()%></td>
									</tr>
									<%
										idx++;
										}
									%>

								</tbody>
							</table>
						</div>
					</div>

		<jsp:include page="/footer.jsp"></jsp:include>
</body>
</html>
<%@page import="com.q0429.model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.q0429.model.Project"%>
<%@page import="com.q0429.model.Link"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<jsp:useBean id="user_info" scope="request" class="com.q0429.model.User" />
<jsp:useBean id="datas_pj" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="datas_ln" scope="request" class="java.util.ArrayList" />
<jsp:useBean id="datas_pj_name" scope="request"
	class="java.util.ArrayList" />
<%
	System.out.println("페이지 전달 아이디 : " + user_info.getId());
%>
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
						<h1>INFO</h1>
					</header>

					<!-- Content -->


					<hr class="major" />

					<!-- Elements -->

					<div class="col-6 col-12-medium">
						<!-- Table -->
						<div class="table-wrapper">
							<h1>유저 정보</h1>
							<table class="alt">
								<thead>
									<tr>
										<th>이름</th>
										<th>EMAIL</th>
										<th>TEL</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<%
											User now_user = (User) user_info;
										%>
										<td><%=now_user.getName()%></td>
										<td><%=now_user.getEmail()%></td>
										<td><%=now_user.getTel()%></td>
									</tr>
								</tbody>
							</table>
							<h1>나의 프로젝트</h1>
							<table class="alt">
								<thead>
									<tr>
										<th>No.</th>
										<th>NAME</th>
										<th>DEADLINE</th>
									</tr>
								</thead>
								<tbody>
									<%
										int idx = 1;
										for (Project pj : (ArrayList<Project>) datas_pj) {
									%>
									<tr>
										<td><%=idx%></td>
										<td><%=pj.getName()%></td>
										<td><%=pj.getDeadline()%></td>
										<td><input type="button"
											onclick="location.href='Project_controller?action=get_pj&pj_num=<%=pj.getPj_num()%>'"
											class="button small fit" value="조회"></td>
									</tr>
									<%
										idx++;
										}
									%>

								</tbody>
							</table>

							<h1>참가중인 프로젝트</h1>
							<table class="alt">
								<thead>
									<tr>
										<th>No.</th>
										<th>이름</th>
										<th>REQUIRE</th>
									</tr>
								</thead>
								<tbody>
									<%
										idx = 1;
										for (int i = 0; i < datas_ln.size(); i++) {
											Link ln = (Link) datas_ln.get(i);
											String pj_name = (String) datas_pj_name.get(i);
									%>
									<tr>
										<td><%=idx%></td>
										<td><%=pj_name%></td>
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

					<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
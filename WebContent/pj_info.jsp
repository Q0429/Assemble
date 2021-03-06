<%@page import="java.util.ArrayList"%>
<%@page import="com.q0429.model.Link"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>
<jsp:useBean id="pj" scope="request" class="com.q0429.model.Project" />
<jsp:useBean id="datas_ln" scope="request" class="java.util.ArrayList" />
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
						<h1>프로젝트 상세 정보</h1>
					</header>

					<!-- Content -->
					<div class="fields">
						<div class="field">
							<label for="name">이름</label> <input type="text" name="name"
								id="name" value="<%=pj.getName()%>" readonly="readonly" />
						</div>
						<div class="field">
							<label for="name">DEADLINE</label> <input type="text"
								name="deadline" id="name" value="<%=pj.getDeadline()%>"
								readonly="readonly" />
						</div>
						<div class="field">
							<label for="name">DETAIL</label>
							<textarea rows="8" cols="40" name="detail" maxlength="50"
								readonly="readonly"><%=pj.getDetail()%></textarea>
						</div>
					</div>

				</div>
				<input type="button"
					onClick="location.href='create_ln.jsp?pj_num=<%=pj.getPj_num()%>'"
					value="모집" />
				<div>
				<h1>참여자들</h1>
							<table class="alt">
								<thead>
									<tr>
										<th>No.</th>
										<th>이름</th>
										<th>REQUIRE</th>
										<th>참가자</th>
									</tr>
								</thead>
								<tbody>
									<%
										int idx = 1;
										for (Link ln : (ArrayList<Link>) datas_ln) {				
											
									%>
									<tr>
										<td><%=idx%></td>
										<td><%=pj.getName()%></td>
										<td><%=ln.getRequire()%></td>
										<%if(ln.getId() != null) {%>
										<th><%=ln.getId() %></th>
										<%} else { %>
										<th>미정</th>
										<%} %>
									</tr>
									<%
										idx++;
										}
									%>

								</tbody>
							</table>
				
				</div>
			</section>
		</div>

		<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>
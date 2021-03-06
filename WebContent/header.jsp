<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" errorPage="assemble_error.jsp"%>

<!-- Header -->
<header id="header" class="alt">
	<a href="index.jsp" class="logo"><strong>Assemble</strong> <span>by
			이형규</span></a>
	<nav>
		<ul class="actions">
			<%
				String sign_in_user = (String) session.getAttribute("sign_in_user");
				System.out.println("세션 전달 확인 " + sign_in_user);
				if (sign_in_user == null) {
			%>
			<li><input type="button" value="SIGN UP"
				onclick="location.href='User_controller?action=sign_up'" /></li>
			<li><input type="button" value="SIGN IN" class="primary"
				onClick="location.href='sign_in.jsp'" /></li>
			<%
				} else {
			%>
				<li><a href="User_controller?action=my_info&id=<%=sign_in_user%>"><%=sign_in_user+"님"%></a></li>
				<li><input type="button" value="SIGN OUT"
				onclick="location.href='User_controller?action=sign_out'" /></li>
			<%
			}
			%>

		</ul>
		<a href="#menu">Menu</a>
	</nav>
</header>

<!-- Menu -->
<nav id="menu">
	<ul class="links">
		<li><a href="index.jsp">Home</a></li>
		<%if(sign_in_user != null){ %>
		<li><a href="create_pj.jsp">프로젝트 생성</a></li>
		<%}%>
		<li><a href="Link_controller?action=list_null">프로젝트 참가</a></li>
		<%if(sign_in_user != null){ %>
		<li><a href="User_controller?action=my_info&id=<%=sign_in_user%>">프로젝트 관리</a></li>
		<%}%>
	</ul>
	<ul class="actions stacked">
		<li><a href="#" class="button primary fit">RETURN</a></li>
	</ul>
</nav>
package com.q0429.command.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jdt.internal.compiler.parser.TerminalTokens;

import com.q0429.command.Command;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;

public class Delete_User implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		User_DAO dao = new User_DAO();
		User target_user = new User_DAO().get_user(request.getParameter("id"));		
		response.setContentType("text/html; charset=UTF-8"); 
		
		if(target_user.getPw().equals(request.getParameter("pw")))
			dao.delete_User(request.getParameter("id"));
		else {
			PrintWriter out;
			try {
				out = response.getWriter();
				out.println("<script>alert('비밀번호가 틀렸습니다.!!');history.go(-1);</script>");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("화면 출력 오류");
			}
			
		}
	}

}

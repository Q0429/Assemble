package com.q0429.command.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.q0429.command.Command;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;

public class Delete_User implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		User_DAO dao = new User_DAO();
		User target_user = new User_DAO().get_user(request.getParameter("id"));		
		
		if(target_user.getPw().equals(request.getParameter("pw"))) {
			dao.delete_User(request.getParameter("id"));
			return true;
		}else {
			return false;
		}
		
	}

}

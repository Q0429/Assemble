package com.q0429.command.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;

public class Get_User implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User_DAO dao = new User_DAO();
		User user = new User_DAO().get_user(request.getParameter("id"));		
		response.setContentType("text/html; charset=UTF-8"); 
		System.out.println(request.getParameter("pw"));
		if(user.getPw().equals(request.getParameter("pw"))) {			
			request.setAttribute("user", user);
			return true;
		}
		else {			
			return false;			
		}		
		
	}

}

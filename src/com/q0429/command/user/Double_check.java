package com.q0429.command.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;

public class Double_check implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User_DAO dao = new User_DAO();
		User chk_user = new User();
		
		chk_user.setId(request.getParameter("id"));
		chk_user.setPw(request.getParameter("pw"));
		chk_user.setName(request.getParameter("name"));
		chk_user.setEmail(request.getParameter("email"));
		chk_user.setTel(request.getParameter("tel"));
		request.setAttribute("user", chk_user);
		
		if(dao.double_check(request.getParameter("id"))) {
			return false;
		}		
		return true;
	}
	
}

package com.q0429.command.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.model.User;

public class Sign_up_User implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setId("");
		user.setPw("");
		user.setName("");
		user.setEmail("");
		user.setTel("");
		request.setAttribute("user", user);
		
		return true;
	}

}

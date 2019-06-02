package com.q0429.command.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Project_DAO;
import com.q0429.model.Project;

public class Get_pj implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Project pj = new Project();
		Project_DAO dao = new Project_DAO();
		int get_pj = Integer.parseInt(request.getParameter("pj_num"));
		pj = dao.get_Pj(get_pj);
		request.setAttribute("pj", pj);
		return false;
	}

}

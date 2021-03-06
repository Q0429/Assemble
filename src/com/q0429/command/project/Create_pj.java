package com.q0429.command.project;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Project_DAO;
import com.q0429.model.Project;

public class Create_pj implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Project pj = new Project();
		Project_DAO dao = new Project_DAO();
		
		pj.setName(request.getParameter("name"));
		pj.setDeadline(request.getParameter("deadline"));
		pj.setDetail(request.getParameter("detail"));
		pj.setOwner(request.getParameter("owner"));
		
		dao.insert_Pj(pj);
		return true;
	}

}

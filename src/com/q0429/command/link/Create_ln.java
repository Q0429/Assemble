package com.q0429.command.link;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Link_DAO;
import com.q0429.model.Link;

public class Create_ln implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Link ln = new Link();
		Link_DAO dao = new Link_DAO();
		ln.setPj_num(Integer.parseInt(request.getParameter("pj_num")));
		ln.setRequire(request.getParameter("require"));
		dao.insert_Ln(ln);		
		return true;
	}

}

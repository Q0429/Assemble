package com.q0429.command.project;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Link_DAO;
import com.q0429.dao.Project_DAO;
import com.q0429.model.Link;
import com.q0429.model.Project;

public class Get_pj implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		Project pj = new Project();
		Project_DAO dao = new Project_DAO();
		Link_DAO dao_ln = new Link_DAO();
		ArrayList<Link> datas_ln = new ArrayList<Link>();
		int get_pj = Integer.parseInt(request.getParameter("pj_num"));
		pj = dao.get_Pj(get_pj);
		datas_ln = dao_ln.get_Ln_Pj(get_pj);
		request.setAttribute("pj", pj);
		request.setAttribute("datas_ln", datas_ln);
		return false;
	}

}

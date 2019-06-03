package com.q0429.command.link;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Link_DAO;
import com.q0429.dao.Project_DAO;
import com.q0429.model.Link;
import com.q0429.model.Project;

public class List_null implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		ArrayList<Link> datas = new ArrayList<Link>();
		ArrayList<Project> datas_pj = new ArrayList<Project>();
		Link_DAO dao = new Link_DAO();
		datas = dao.get_Ln_Null();
		for(Link ln : datas) {
			Project_DAO p_dao = new Project_DAO();
			datas_pj.add(p_dao.get_Pj(ln.getPj_num()));			
		}
		request.setAttribute("datas", datas);
		request.setAttribute("datas_pj", datas_pj);
		return false;
	}

}

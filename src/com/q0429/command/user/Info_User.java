package com.q0429.command.user;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Link_DAO;
import com.q0429.dao.Project_DAO;
import com.q0429.dao.User_DAO;
import com.q0429.model.Link;
import com.q0429.model.Project;
import com.q0429.model.User;

public class Info_User implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("커맨드 실행");
		
		String now_user = request.getParameter("id");
		User_DAO us_dao = new User_DAO();
		User nu = us_dao.get_user(now_user);
		System.out.println("가져올 유저 정보 : " + nu.getId());
		ArrayList<Project> datas_pj = new ArrayList<Project>();
		ArrayList<Link> datas_ln = new ArrayList<Link>();
		ArrayList<String> datas_pj_name = new ArrayList<String>();
		Project_DAO pj_dao = new Project_DAO();
		Link_DAO ln_dao = new Link_DAO();
		
		datas_pj = pj_dao.get_my_Pj(nu.getId());
		System.out.println("프로젝트 호출 종료");
		datas_ln = ln_dao.get_Ln_User(nu.getId());
		System.out.println("링크 호출 종료");
		for(Link ln : datas_ln) {
			Project_DAO dao = new Project_DAO();
			Project pj = dao.get_Pj(ln.getPj_num());
			datas_pj_name.add(pj.getName());
		}
		
		request.setAttribute("user_info", nu);
		request.setAttribute("datas_pj", datas_pj);
		request.setAttribute("datas_ln", datas_ln);
		request.setAttribute("datas_pj_name", datas_pj_name);
		return true;
	}

}

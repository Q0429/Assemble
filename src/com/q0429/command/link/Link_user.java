package com.q0429.command.link;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.dao.Link_DAO;
import com.q0429.model.Link;

public class Link_user implements Command {

	@Override
	public boolean execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		System.out.println("유저 연결 커맨드 실행");
	
		Link_DAO dao = new Link_DAO();
		Link ln = dao.get_Ln(Integer.parseInt(request.getParameter("ln_num")));
		ln.setId(request.getParameter("id"));
		
		System.out.println("--------------------------");
		System.out.println(ln.getLink_num());
		System.out.println(ln.getPj_num());
		System.out.println(ln.getRequire());
		System.out.println(ln.getId());
		System.out.println("--------------------------");
		
		Link_DAO dao_ln = new Link_DAO();
		dao_ln.join_user(ln);
		return false;
	}

}

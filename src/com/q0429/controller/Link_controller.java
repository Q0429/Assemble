package com.q0429.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.q0429.command.Command;
import com.q0429.command.link.*;


/**
 * Servlet implementation class Link_controller
 */
@WebServlet("/Link_controller")
public class Link_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Link_controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Command command = null;
		String viewPage = null;
		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		
		String action = request.getParameter("action");
		
		if(action.equals("create_ln")) {
			command = new Create_ln();
			if(command.execute(request, response)) {				
				viewPage = "Project_controller?action=get_pj&pj_num=" + request.getParameter("pj_num");
			} else {
				throw new ServletException("링크 생성 오류");
			} 
		} else if(action.equals("list_null")) {
			command = new List_null();
			command.execute(request, response);
			viewPage = "list_ln.jsp";			
		} else if(action.equals("link_user")) {
			System.out.println("링크연결할 id : " + request.getParameter("id"));
			command = new Link_user();
			command.execute(request, response);
			viewPage = "User_controller?action=my_info&id=" + request.getParameter("id");
		} 
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

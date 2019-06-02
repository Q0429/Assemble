package com.q0429.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.command.project.*;

/**
 * Servlet implementation class Project_controller
 */
@WebServlet("/project_controller")
public class Project_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Project_controller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Command command = null;
		String viewPage = null;

		request.setCharacterEncoding("UTF-8");

		String action = request.getParameter("action");

		if(action.equals("create_pj")) {
			command = new Create_pj();
			if(command.execute(request, response)) {
				viewPage = "";
			} else {
				throw new ServletException("프로젝트 생성 오류");
			}
		} else if(action.equals("list")) {
			command = new List_pj();
			command.execute(request, response);
			viewPage = "list_pj.jsp";
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

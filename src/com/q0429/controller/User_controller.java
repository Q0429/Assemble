package com.q0429.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.command.Command;
import com.q0429.command.user.*;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;


@WebServlet("/User_controller")
public class User_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public User_controller() {
		// TODO Auto-generated constructor stub   
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Command command = null;
		String viewPage = null;

		request.setCharacterEncoding("UTF-8");		

		String action = request.getParameter("action");

		if(action.equals("insert")){ // 가입
			command = new Insert_User();
			command.execute(request, response);
			viewPage = "index.html";
			//test
				viewPage = "test_my_page.jsp";
		} else if(action.equals("modify")) { // 변경
			command = new Get_User();
			command.execute(request, response);
			viewPage = "my_page.jsp";
		} else if(action.equals("update")) { // 변경 실행
			command = new Update_User();
			command.execute(request, response);
			viewPage = "index.html";
		} else if(action.equals("delete")) { // 탈퇴
			command = new Delete_User();
			command.execute(request, response);
			viewPage = "index.html";
		} else if(action.equals("get_user")) { //로그인
			command = new Get_User();
			command.execute(request, response);
			viewPage = "index.html";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

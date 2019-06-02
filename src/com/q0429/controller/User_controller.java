package com.q0429.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.q0429.command.Command;
import com.q0429.command.user.*;
import com.q0429.dao.User_DAO;
import com.q0429.model.User;


@WebServlet("/user_controller")
public class User_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;



	public User_controller() {
		// TODO Auto-generated constructor stub   
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		Command command = null;
		String viewPage = null;
		HttpSession session = request.getSession();

		request.setCharacterEncoding("UTF-8");		

		String action = request.getParameter("action");

		if(action.equals("insert")){ // 가입
			command = new Insert_User();
			if(command.execute(request, response)){
				viewPage = "user/sign_in.jsp";				
			} else {
				throw new ServletException("가입에 실패했습니다");
//				viewPage = "error/sign_up_error.jsp";		
			}			
		} else if(action.equals("sign_up")) {
			command = new Sign_up_User();
			command.execute(request, response);
			viewPage = "user/sign_up.jsp";			
		} else if(action.equals("double_check")) {
			command = new Double_check();
			if(command.execute(request, response)){
				viewPage = "user/sign_up.jsp";
				//test
				viewPage = "test_sign_up.jsp";
			} else {
				viewPage = "error/double_error.jsp";		
			}			
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
			if(command.execute(request, response))
				viewPage = "index.html";
			else {				
				viewPage = "my_page.jsp";
			}
		} else if(action.equals("sign_in")) { //로그인
			command = new Get_User();
			if(command.execute(request, response)) {
				System.out.println(request.getParameter("id"));
				session.setAttribute("sign_in_user", request.getParameter("id"));
				System.out.println("세션 입력 확인" + session.getAttribute("sign_in_user"));
				viewPage = "index.jsp";
			} else {
				viewPage = "error/login_error.jsp";			
			}
		} else if(action.equals("sign_out")) {
			session.invalidate();
			viewPage = "index.jsp";
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

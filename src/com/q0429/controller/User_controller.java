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


@WebServlet("/User_controller")
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
				viewPage = "sign_in.jsp";				
			} else {
				PrintWriter out = response.getWriter();
				out.println("<script>alert('가입실패!!');history.go(-1);</script>");
				viewPage = "error/sign_up_error.jsp";		
			}			
		} else if(action.equals("sign_up")) {
			command = new Sign_up_User();
			command.execute(request, response);
			viewPage = "sign_up.jsp";			
		} else if(action.equals("double_check")) {
			command = new Double_check();
			if(command.execute(request, response)){
				viewPage = "sign_up.jsp";
				//test
				viewPage = "test_sign_up.jsp";
			} else {
				throw new ServletException("중복된 아이디입니다.");		
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
				session.setAttribute("sign_in_user", request.getParameter("id"));				
				viewPage = "index.jsp";
			} else {
				throw new ServletException("로그인에 실패했습니다");	
			}
		} else if(action.equals("my_info")) {
			System.out.println("정보 가져오기 시작 : " + request.getParameter("id"));
			command = new Info_User();
			command.execute(request, response);
			viewPage = "my_info.jsp";
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

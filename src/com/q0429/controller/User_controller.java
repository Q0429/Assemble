package com.q0429.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.q0429.dao.User_DAO;
import com.q0429.model.User;


@WebServlet("/User_controller")
public class User_controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private User user;
	private User_DAO dao;
	private PrintWriter out;

 
    public User_controller() {
        // TODO Auto-generated constructor stub   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 	user = new User();
    	dao = new User_DAO();
		request.setCharacterEncoding("UTF-8");		
		out = response.getWriter();
		String action = request.getParameter("action");
		
		if(action.equals("insert")){
			user.setId(request.getParameter("id"));
			user.setPw(request.getParameter("pw"));
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setTel(request.getParameter("tel"));
			
			dao.insert_User(user);
			
		} else if(action.equals("update")) {
			user.setId(request.getParameter("id"));
			user.setPw(request.getParameter("pw"));
			user.setName(request.getParameter("name"));
			user.setEmail(request.getParameter("email"));
			user.setTel(request.getParameter("tel"));
			
			dao.update_User(user);
			
		} else if(action.equals("delete")) {
			dao.delete_User(request.getParameter("id"));
			
		} else if(action.equals("get_user")) {
			dao.get_user(request.getParameter("id"));
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

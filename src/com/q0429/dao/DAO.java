package com.q0429.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DAO {
	DataSource dataSource;
	Connection con = null;
	PreparedStatement pstm = null;
	
	public DAO() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource)context.lookup("java:comp/env/jdbc/Oracle");
			System.out.println("드라이버 연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("드라이버 연결 실패");
		}
		
		try {
			con = dataSource.getConnection();
			System.out.println("DB연결 성공");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("DB연결 실패");
		}
	}
	
	void disconnect() {
		if(pstm != null) {
			try {
				pstm.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} 
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

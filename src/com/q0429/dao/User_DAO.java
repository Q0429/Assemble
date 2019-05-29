package com.q0429.dao;

import com.q0429.model.User;

public class User_DAO extends DAO {
	
	public User_DAO() { // DAO 객체 생성과 동시에 DB연결
		super();
	}
	
	public boolean insert_User(User user) {
		
		String sql = "INSERT INTO users(id, pw, name, email, tel) VALUES (?, ?, ?, ?, ?)";
		
		try {
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, user.getId());
			pstm.setString(2, user.getPw());
			pstm.setString(3, user.getName());
			pstm.setString(4, user.getEmail());
			pstm.setString(5, user.getTel());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("유저 생성 오류");
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean update_User(User user) {
		
		String sql = "UPDATE users SET pw=?, name=?, email=?, tel=? WHERE id=?";
		
		try {
			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, user.getPw());
			pstm.setString(2, user.getName());
			pstm.setString(3, user.getEmail());
			pstm.setString(4, user.getTel());
			pstm.setString(5, user.getId());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("유저 갱신 오류");
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean delete_User(String user_id) {
		
		String sql = "DELETE FROM users WHERE " + user_id;
		
		try {
			
			pstm = con.prepareStatement(sql);
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("유저 삭제 오류");
			return false;
		} finally {
			// TODO: handle finally clause
			disconnect();
		}
		
		return true;
	}
}

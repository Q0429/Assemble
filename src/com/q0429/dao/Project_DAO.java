package com.q0429.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import com.q0429.model.Project;

public class Project_DAO extends DAO{
	
	public Project_DAO() {
		super();
	}
	
	public boolean insert_Pj(Project pj) {		
		String sql = "INSERT INTO project(pj_num, name, deadline, detail, owner) VALUES (PN_SEQ.NEXTVAL, ?, ?, ?, ?)";
		
		try {			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pj.getName());
			pstm.setString(2, pj.getDeadline());
			pstm.setString(3, pj.getDetail());
			pstm.setString(4, pj.getOwner());
			
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("프로젝트 생성 오류");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean update_Pj(Project pj) {		
		String sql = "UPDATE project SET name=?, deadline=?, detail=? WHERE pj_num=?";
		
		try {			
			pstm = con.prepareStatement(sql);
			
			pstm.setString(1, pj.getName());
			pstm.setString(2, pj.getDeadline());
			pstm.setString(3, pj.getDetail());
			pstm.setInt(4, pj.getPj_num());
			
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("프로젝트 갱신 오류");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean delete_Pj(int pj_num) {		
		String sql = "DELETE FROM project WHERE pj_num=" + pj_num;
		
		try {			
			pstm = con.prepareStatement(sql);
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("프로젝트 삭제 오류");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public Project get_Pj(int pj_num) {		
		String sql = "SELECT * FROM project WHERE pj_num=" + pj_num;
		Project pj = new Project();
		
		try {			
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			rs.next();			
			pj.setPj_num(rs.getInt("pj_num"));
			pj.setName(rs.getString("name"));
			pj.setDeadline(rs.getString("deadline"));
			pj.setDetail(rs.getString("detail"));
			pj.setOwner(rs.getString("owner"));
			rs.close();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("프로젝트 호출 오류");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return pj;
	}
	
	public ArrayList<Project> get_my_Pj(String user){		
		ArrayList<Project> datas = new ArrayList<Project>();
		String sql = "SELECT * FROM project WHERE owner=" + user;
		
		try {			
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while (rs.next()) {
				Project pj = new Project();
				
				pj.setPj_num(rs.getInt("pj_num"));
				pj.setName(rs.getString("name"));
				pj.setDeadline(rs.getString("deadline"));
				pj.setDetail(rs.getString("detail"));
				pj.setOwner(rs.getString("owner"));
				
				datas.add(pj);
			}
			
			rs.close();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("유저의 프로젝트 호출 오류");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return datas;
	}
}

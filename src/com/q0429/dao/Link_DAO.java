package com.q0429.dao;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;

import com.q0429.model.Link;

public class Link_DAO extends DAO{
	
	public Link_DAO() {
		super();
	}
	
	public boolean insert_Ln(Link ln) {		
		String sql = "INSERT INTO link(link_num, pj_num, require) VALUES(LN_SEQ.NEXTVAL, ?, ?)";
		
		try {			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, ln.getPj_num());
			pstm.setString(2, ln.getRequire());	
			
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("링크 생성 오류");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}

	
	public boolean join_user(Link ln) {		
		String sql = "UPDATE link SET id=? WHERE link_num=?";
		
		try {			
			pstm = con.prepareStatement(sql);			
			
			pstm.setString(1, ln.getId());
			pstm.setInt(2, ln.getLink_num());
			
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("사용자 링크 연결 오류");
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean fire_user(Link ln) {
		String sql = "UPDATE link SET id=? WHERE link_num=?";
		
		try {			
			pstm = con.prepareStatement(sql);			
			
			pstm.setNull(1, Types.VARCHAR);
			pstm.setInt(2, ln.getLink_num());
			
			pstm.executeUpdate();			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("유저 null 변경 오류");
			e.printStackTrace();
			return false;
		}finally {
			disconnect();
		}
		
		return true;
	}
	
	public boolean delete_Ln(int ln_num) {
		String sql = "DELETE FROM link WHERE link_num=" + ln_num;
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("링크 삭제 오류");
			e.printStackTrace();
			return false;
		} finally {
			disconnect();
		}
		
		return true;
	}
	
	public Link get_Ln(int ln_num) {
		String sql = "SELECT * FROM link WHERE link_num=?";
		Link ln = new Link();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, ln_num);
			ResultSet rs = pstm.executeQuery();
			
			rs.next();
			ln.setLink_num(rs.getInt("link_num"));
			ln.setPj_num(rs.getInt("pj_num"));
			ln.setRequire(rs.getString("require"));
			ln.setId(rs.getString("id"));
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("링크 호출 오류");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return ln;
	}
	
	public ArrayList<Link> get_Ln_User(String id) {
		String sql = "SELECT * FROM link WHERE id=?";
		ArrayList<Link> datas = new ArrayList<Link>();
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, id);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Link ln = new Link();
				
				ln.setLink_num(rs.getInt("link_num"));
				ln.setPj_num(rs.getInt("pj_num"));
				ln.setRequire(rs.getString("require"));
				ln.setId(rs.getString("id"));
				
				datas.add(ln);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id로 link호출 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return datas;
	}
	
	public ArrayList<Link> get_Ln_Pj(int pj_num) {
		String sql = "SELECT * FROM link WHERE pj_num=" + pj_num;
		ArrayList<Link> datas = new ArrayList<Link>();
		
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Link ln = new Link();
				
				ln.setLink_num(rs.getInt("link_num"));
				ln.setPj_num(rs.getInt("pj_num"));
				ln.setRequire(rs.getString("require"));
				ln.setId(rs.getString("id"));
				
				datas.add(ln);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Pj로 link호출 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return datas;
	}
	
	public ArrayList<Link> get_Ln_Null() {
		String sql = "SELECT * FROM link WHERE id IS NULL";
		ArrayList<Link> datas = new ArrayList<Link>();
		
		try {
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()) {
				Link ln = new Link();
				
				ln.setLink_num(rs.getInt("link_num"));
				ln.setPj_num(rs.getInt("pj_num"));
				ln.setRequire(rs.getString("require"));
				ln.setId(rs.getString("id"));
				
				datas.add(ln);
			}
			
			rs.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id가 null인 link호출 실패");
			e.printStackTrace();
		} finally {
			disconnect();
		}
		
		return datas;
	}
}

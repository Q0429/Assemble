package com.q0429.dao;

import com.q0429.model.Link;

public class Link_DAO extends DAO{
	
	public Link_DAO() {
		super();
	}
	
	public boolean insert_Ln(Link ln) {
		
		String sql = "INSERT INTO link(link_num, pj_num, require, id) VALUES(LN_SEQ.NEXTVAL, ?, ?, ?)";
		
		try {
			
			pstm = con.prepareStatement(sql);
			
			pstm.setInt(1, ln.getPj_num());
			pstm.setString(2, ln.getRequire());
			pstm.setString(3, ln.getId());
			
			pstm.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("링크 생성 오류");
			return false;
		} finally {
			disconnect();
		}
		return true;
	}
}

package com.goray.s4;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.goray.util.DBConnector;

public class MemberDAO {

	public MemberDTO login(MemberDTO mdto){
		Connection con = DBConnector.getConnect();
		String sql = "select * from member where id=? and pw=?";
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement(sql);
			st.setString(1, mdto.getId());
			st.setString(2, mdto.getPw());
			rs = st.executeQuery();
			if(rs.next()){
				mdto.setName(rs.getString("name"));
			}else{
				mdto = null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mdto = null;
		} finally {
			DBConnector.disconnect(rs, st, con);
		} return mdto;
	}
	
	

	
}

package member.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import event.db.EventBean;

public class MemDAO {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public MemDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}	
	
	
	public List<MemberBean> getMemList () {
		List<MemberBean> memlist = new ArrayList<MemberBean>();
		try {
			con = ds.getConnection();
			String sql = "select * from member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setMem_id(rs.getString(1));
				member.setMem_pass(rs.getString(2));
				member.setMem_name(rs.getString(3));
				member.setMem_jumin(rs.getString(4));
				member.setMem_phone(rs.getString(5));
				member.setMem_email(rs.getString(6));
				System.out.println("회원 전체 조회 rs.next() 성공!");
				memlist.add(member);
			}
			System.out.println("-----------------------------------------");
			return memlist;
			
		}catch(Exception e) {
			System.out.println("event_select() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
}

package admin.db;

import java.sql.*;

import javax.sql.DataSource;

public class AdminDAO {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;

	public int isId(String id, String pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select ADMIN_ID,ADMIN_PASS from admin";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println("---> rs.next있음");
				if(rs.getString(2).equals(pass)) {
					result = 1; // 아이디와 비밀번호 일치하는 경우
				} else {
					result = 0; // 비밀번호가 일치하지 않는 경우
				}
			} else {
				result = -1; // 아이디가 존재하지 않는 경우
			}
		} catch(Exception e) {
			System.out.println("에러!!!!!" + e.getMessage());
		} finally {
			if(rs!=null) {try{rs.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return result;
	}
	
}

package map.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class MapDAO {
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public MapDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = 
	  	 (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}	
	
	//검색 결과 갯수 구하기
	public int getListCount() {
		int x= 0;
		try{
			con=ds.getConnection();
			pstmt=con.prepareStatement(
					"select count(*) from store");
			rs = pstmt.executeQuery();
			
			if(rs.next()){
				x=rs.getInt(1);
			}
		}catch(Exception ex){
			System.out.println("getListCount() 에러: " + ex);			
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}
			                catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return x;
	}
	
	public JSONArray getList(String store_name) {
		JSONArray array = new JSONArray();
		try {
			con = ds.getConnection();
			
			String sql="select store_name, store_location, store_tel from store ";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			while(rs.next()) {
				JSONObject object = new JSONObject();
				object.put("store_name",rs.getString(1));
				object.put("store_location",rs.getString(2));
				object.put("store_tel",rs.getString(3));
				array.add(object);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex) {}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex) {}
			if(con!=null) try{con.close();}catch(SQLException ex) {}
		}
		return array;
	}

}

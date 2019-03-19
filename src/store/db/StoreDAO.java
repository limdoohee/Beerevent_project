package store.db;

import java.sql.*;
import java.text.ParseException;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import event.db.EventBean;
import seller.db.SellerBean;




public class StoreDAO {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public StoreDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}	
	
	public String getStoreName(int store_no) {
		String store_name="";
		try {
			con = ds.getConnection();
			String sql = "select store_name from store where store_no =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				store_name=rs.getString(1);
				System.out.println("이벤트 상세보기 rs.next() 성공!");
				System.out.println("-----------------------------------------");
			}
			return store_name;
		}catch(Exception e) {
			System.out.println("event_select() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}
	
	public String getStoreSeller(int store_no) {
		String seller_id="";
		try {
			con = ds.getConnection();
			String sql = "select seller_id from STORE where store_no=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				seller_id=rs.getString(1);
			}
			return seller_id;
		}catch(Exception e) {
			System.out.println("getStoreSeller() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}
	
	//마이페이지 - 이벤트별로 해당하는 가게 정보를 뽑아오기 위해 가게번호, 가게이름 뽑아오기
	public List<StoreBean> getStoreName() {
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		try {
			con = ds.getConnection();
			String sql = "select store_no, store_name " + 
						 "from store " + 
						  "where store_no in (select store_no " + 
						   "					from event)";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StoreBean store = new StoreBean();
				store.setStore_no(rs.getInt(1));
				store.setStore_name(rs.getString(2));
				;
				System.out.println("store_no : "+store.getStore_no()+" / store_name : "+store.getStore_name());
				System.out.println("-----------------------------------------");
				storelist.add(store);
			}
			return storelist;
		}catch(Exception e) {
			System.out.println("getStoreName() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}
	
	
	//가게 정보 보기
	public StoreBean getStore(int store_no) {
		StoreBean store = new StoreBean();
		try {
			con = ds.getConnection();
			String sql = "select * from store where store_no =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, store_no);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				store.setStore_no(rs.getInt(1));
				store.setStore_register_no(rs.getString(2));
				store.setStore_name(rs.getString(3));
				store.setStore_location(rs.getString(4));
				store.setStore_menu(rs.getString(5));
				store.setStore_dayofweek(rs.getString(6));
				store.setStore_tel(rs.getString(7));
				store.setStore_file(rs.getString(8));
				store.setSeller_id(rs.getString(9));
				System.out.println("가게 정보 보기 rs.next() 성공!");
				System.out.println("-----------------------------------------");
			}
			return store;
		}catch(Exception e) {
			System.out.println("getStore() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}

	//판매자 아이디에 해당하는 가게 리스트 뽑아오기
	public List<StoreBean> getStoreList(String seller_id) {
		
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		
		try {
			con = ds.getConnection();
			String sql = "select * from store where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StoreBean store = new StoreBean();
				store.setStore_no(rs.getInt(1));
				store.setStore_register_no(rs.getString(2));
				store.setStore_name(rs.getString(3));
				store.setStore_location(rs.getString(4));
				store.setStore_menu(rs.getString(5));
				store.setStore_dayofweek(rs.getString(6));
				store.setStore_tel(rs.getString(7));
				store.setStore_file(rs.getString(8));
				store.setSeller_id(rs.getString(9));
				storelist.add(store);
				System.out.println("판매자->가게 상세보기 rs.next() 성공!");
			}
			System.out.println("-----------------------------------------");
			return storelist;
		}catch(Exception e) {
			System.out.println("getStoreList() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}

	public int registerStore(StoreBean s) {
		
		//store_no에 들어갈 pk값 구하기
		int store_no = get_maxPK() + 1;
		try {
			
			
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("insert into store values(?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, store_no);
			pstmt.setString(2, s.getStore_register_no());
			pstmt.setString(3, s.getStore_name());
			pstmt.setString(4, s.getStore_location());
			pstmt.setString(5, s.getStore_menu());
			pstmt.setString(6, s.getStore_dayofweek());
			pstmt.setString(7, s.getStore_tel());
			pstmt.setString(8, s.getStore_file());
			pstmt.setString(9, s.getSeller_id());
			result = pstmt.executeUpdate();
		
		// primary key 제약 조건 위반했을 경우 발생하는 에러
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("가게 PK 중복 에러입니다.");
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(con != null) {
				try {
					con.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
		return result;
	}
	
	public int get_maxPK () {
		int pk_no=1;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select MAX(store_no) from store");
			rs = pstmt.executeQuery();
			if(rs.next())
				pk_no = rs.getInt(1);
		}catch(Exception e) {
			System.out.println("get_maxPK() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return pk_no;
	}
}

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
			System.out.println("DB ���� ���� : " + ex);
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
				System.out.println("�̺�Ʈ �󼼺��� rs.next() ����!");
				System.out.println("-----------------------------------------");
			}
			return store_name;
		}catch(Exception e) {
			System.out.println("event_select() ���� : "+e);
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
			System.out.println("getStoreSeller() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}
	
	//���������� - �̺�Ʈ���� �ش��ϴ� ���� ������ �̾ƿ��� ���� ���Թ�ȣ, �����̸� �̾ƿ���
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
			System.out.println("getStoreName() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}
	
	
	//���� ���� ����
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
				System.out.println("���� ���� ���� rs.next() ����!");
				System.out.println("-----------------------------------------");
			}
			return store;
		}catch(Exception e) {
			System.out.println("getStore() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return null;
	}

	//�Ǹ��� ���̵� �ش��ϴ� ���� ����Ʈ �̾ƿ���
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
				System.out.println("�Ǹ���->���� �󼼺��� rs.next() ����!");
			}
			System.out.println("-----------------------------------------");
			return storelist;
		}catch(Exception e) {
			System.out.println("getStoreList() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}

	public int registerStore(StoreBean s) {
		
		//store_no�� �� pk�� ���ϱ�
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
		
		// primary key ���� ���� �������� ��� �߻��ϴ� ����
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("���� PK �ߺ� �����Դϴ�.");
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
			System.out.println("get_maxPK() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return pk_no;
	}
}

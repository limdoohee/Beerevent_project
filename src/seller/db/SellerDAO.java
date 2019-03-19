package seller.db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.naming.*;
import javax.sql.DataSource;

import member.db.MemberBean;


public class SellerDAO {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public SellerDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}	
	
	public List<SellerBean> getSellList () {
		List<SellerBean> sellerlist = new ArrayList<SellerBean>();
		try {
			con = ds.getConnection();
			String sql = "select * from seller where seller_id != 'admin'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SellerBean seller = new SellerBean();
				seller.setSeller_id(rs.getString(1));
				seller.setSeller_pass(rs.getString(2));
				seller.setSeller_name(rs.getString(3));
				seller.setSeller_jumin(rs.getString(4));
				seller.setSeller_phone(rs.getString(5));
				seller.setSeller_email(rs.getString(6));
				seller.setSeller_bs_no(rs.getString(7));
				System.out.println("�Ǹ��� ��ü ��ȸ rs.next() ����!");
				sellerlist.add(seller);
			}
			System.out.println("-----------------------------------------");
			return sellerlist;
			
		}catch(Exception e) {
			System.out.println("event_select() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
	
	
	public List<SellertempBean> getStempList () {
		List<SellertempBean> stempList = new ArrayList<SellertempBean>();
		try {
			con = ds.getConnection();
			String sql = "select * from seller_temp";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				SellertempBean stemp = new SellertempBean();
				stemp.setStemp_id(rs.getString(1));
				stemp.setStemp_pass(rs.getString(2));
				stemp.setStemp_name(rs.getString(3));
				stemp.setStemp_jumin(rs.getString(4));
				stemp.setStemp_phone(rs.getString(5));
				stemp.setStemp_email(rs.getString(6));
				stemp.setStemp_bs_no(rs.getString(7));
				System.out.println("���δ���� ��ü ��ȸ rs.next() ����!");
				stempList.add(stemp);
			}
			System.out.println("-----------------------------------------");
			return stempList;
			
		}catch(Exception e) {
			System.out.println("getStempList() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}

	public SellerBean seller_select(String seller_id) {
		
		SellerBean seller = null;
		
		try {
			con = ds.getConnection();
			String sql = "select * from seller where seller_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				seller = new SellerBean();
				seller.setSeller_id(rs.getString(1));
				seller.setSeller_pass(rs.getString(2));
				seller.setSeller_name(rs.getString(3));
				seller.setSeller_jumin(rs.getString(4));
				seller.setSeller_phone(rs.getString(5));
				seller.setSeller_email(rs.getString(6));
				seller.setSeller_bs_no(rs.getString(7));
				System.out.println("�Ǹ��� �󼼺��� rs.next() ����!");
				System.out.println("-----------------------------------------");
			}
			return seller;
		}catch(Exception e) {
			System.out.println("event_select() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}
	
	
	// �Ǹ��� ���������� - ������������ �� �̾ƿ� ��������
	public SellerBean getSeller (String seller_id) {
		SellerBean seller = new SellerBean();
		try {
			con = ds.getConnection();
			String sql = "select * from seller where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				seller.setSeller_id(rs.getString(1));
				seller.setSeller_pass(rs.getString(2));
				seller.setSeller_name(rs.getString(3));
				seller.setSeller_jumin(rs.getString(4));
				seller.setSeller_phone(rs.getString(5));
				seller.setSeller_email(rs.getString(6));
				seller.setSeller_bs_no(rs.getString(7));
				System.out.println("�Ǹ��� �������� rs.next() ����!");
			}
			System.out.println("-----------------------------------------");
			return seller;
			
		}catch(Exception e) {
			System.out.println("getMember() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
	
	//���������� - �Ǹ��� ���� ����
	public int updateSeller(SellerBean seller){
		try {
			con = ds.getConnection();
			
			String sql = "update seller set "
						+ "seller_pass=?,"
						+ "seller_phone=?,"
						+ "seller_email=? "
						+ "where "
						+ "seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller.getSeller_pass());
			pstmt.setString(2, seller.getSeller_phone());
			pstmt.setString(3, seller.getSeller_email());
			pstmt.setString(4, seller.getSeller_id());
			
			result = pstmt.executeUpdate();
			
			System.out.println("--> �Ǹ��� �������� ���� ����!");
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			if(rs!=null) {try{rs.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return result;
	}

	public SellerBean getStemp(String stemp_id) {
		SellerBean seller = new SellerBean();
		try {
			con = ds.getConnection();
			String sql = "select * from seller_temp where stemp_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, stemp_id);
			rs = pstmt.executeQuery();
			
			//seller_temp���� �̾ƿ� ���� �ٷ� seller��ü�� �ִ´�.
			if(rs.next()) {
				seller.setSeller_id(rs.getString(1));
				seller.setSeller_pass(rs.getString(2));
				seller.setSeller_name(rs.getString(3));
				seller.setSeller_jumin(rs.getString(4));
				seller.setSeller_phone(rs.getString(5));
				seller.setSeller_email(rs.getString(6));
				seller.setSeller_bs_no(rs.getString(7));
				System.out.println("���δ���� -> �Ǹ��� ��ü�� �ֱ� ����!");
			}
			System.out.println("-----------------------------------------");
			return seller;
		}catch(Exception e) {
			System.out.println("getStemp() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return seller;
	}

	public void insertStemp_to_Seller(SellerBean seller) {
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement("insert into seller values(?,?,?,?,?,?,?)");
			pstmt.setString(1, seller.getSeller_id());
			pstmt.setString(2, seller.getSeller_pass());
			pstmt.setString(3, seller.getSeller_name());
			pstmt.setString(4, seller.getSeller_jumin());
			pstmt.setString(5, seller.getSeller_phone());
			pstmt.setString(6, seller.getSeller_email());
			pstmt.setString(7, seller.getSeller_bs_no());
			result = pstmt.executeUpdate();
			
			if (result == 1 ) {
				System.out.println("���� ó�� ��, stemp->seller�� ������ ���� ����!");
			} else {
				System.out.println("���� ó�� ��, stemp->seller�� ������ ���� ����");
			}
		}catch(Exception e) {
			System.out.println("insertStemp_to_Seller() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}

	public void deleteStemp(String stemp_id) {
		try {
			
			con = ds.getConnection();
			pstmt = con.prepareStatement("delete from seller_temp where stemp_id=?");
			pstmt.setString(1, stemp_id);
			result = pstmt.executeUpdate();
			
			if (result == 1 ) {
				System.out.println("���� ó�� ��, stemp ������ ���� ����!");
			} else {
				System.out.println("���� ó�� ��, stemp ������ ���� ����");
			}
		}catch(Exception e) {
			System.out.println("deleteStemp() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}

	public void deleteSeller(String seller_id) {
		try {
			con = ds.getConnection();
			String sql = "delete payment " + 
						"where EDATE_UNIQUE_NO in " + 
						"(select EDATE_UNIQUE_NO from eventdate where event_no in " + 
						"(select event_no from EVENT where store_no in " + 
						"(select store_no from store where seller_id=?)))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, payment ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, payment ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete eventdate where event_no in " + 
				"(select event_no from EVENT where store_no in " + 
				"(select store_no from store where seller_id=?))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, eventdate ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, eventdate ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete board where event_no in " + 
				"(select event_no from EVENT where store_no in " + 
				"(select store_no from store where seller_id=?))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, board ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, board ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete eventdate where event_no in " + 
				"(select event_no from EVENT where store_no in " + 
				"(select store_no from store where seller_id=?))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, eventdate ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, eventdate ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			
			con = ds.getConnection();
			sql ="delete bookmark where event_no in " + 
				"(select event_no from EVENT where store_no in " + 
				"(select store_no from store where seller_id=?))";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, bookmark ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, bookmark ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			
			con = ds.getConnection();
			sql ="delete EVENT where store_no in " + 
				"(select store_no from store where seller_id=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, EVENT ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, EVENT ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete store where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, store ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, store ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete seller where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("�Ǹ��� ���� ��, seller ������ ���� ����!");
			} else {
				System.out.println("�Ǹ��� ���� ��, seller ������ ���� ����");
			}
			pstmt.close();
			con.close();
			
			
			System.out.println("�Ǹ��� Ż��.");
			System.out.println("------------------------------------------------");
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			if(rs!=null) {try{rs.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}
	
	
}
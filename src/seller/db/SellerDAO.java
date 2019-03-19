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
			System.out.println("DB 연결 실패 : " + ex);
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
				System.out.println("판매자 전체 조회 rs.next() 성공!");
				sellerlist.add(seller);
			}
			System.out.println("-----------------------------------------");
			return sellerlist;
			
		}catch(Exception e) {
			System.out.println("event_select() 에러 : "+e);
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
				System.out.println("승인대기자 전체 조회 rs.next() 성공!");
				stempList.add(stemp);
			}
			System.out.println("-----------------------------------------");
			return stempList;
			
		}catch(Exception e) {
			System.out.println("getStempList() 에러 : "+e);
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
				System.out.println("판매자 상세보기 rs.next() 성공!");
				System.out.println("-----------------------------------------");
			}
			return seller;
		}catch(Exception e) {
			System.out.println("event_select() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}
	
	
	// 판매자 마이페이지 - 개인정보수정 시 뽑아올 개인정보
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
				System.out.println("판매자 개인정보 rs.next() 성공!");
			}
			System.out.println("-----------------------------------------");
			return seller;
			
		}catch(Exception e) {
			System.out.println("getMember() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
	
	//마이페이지 - 판매자 정보 수정
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
			
			System.out.println("--> 판매자 개인정보 수정 성공!");
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
			
			//seller_temp에서 뽑아온 값을 바로 seller객체에 넣는다.
			if(rs.next()) {
				seller.setSeller_id(rs.getString(1));
				seller.setSeller_pass(rs.getString(2));
				seller.setSeller_name(rs.getString(3));
				seller.setSeller_jumin(rs.getString(4));
				seller.setSeller_phone(rs.getString(5));
				seller.setSeller_email(rs.getString(6));
				seller.setSeller_bs_no(rs.getString(7));
				System.out.println("승인대기자 -> 판매자 객체에 넣기 성공!");
			}
			System.out.println("-----------------------------------------");
			return seller;
		}catch(Exception e) {
			System.out.println("getStemp() 에러 : "+e);
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
				System.out.println("승인 처리 시, stemp->seller로 데이터 삽입 성공!");
			} else {
				System.out.println("승인 처리 시, stemp->seller로 데이터 삽입 실패");
			}
		}catch(Exception e) {
			System.out.println("insertStemp_to_Seller() 에러 : "+e);
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
				System.out.println("승인 처리 시, stemp 데이터 삭제 성공!");
			} else {
				System.out.println("승인 처리 시, stemp 데이터 삭제 실패");
			}
		}catch(Exception e) {
			System.out.println("deleteStemp() 에러 : "+e);
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
				System.out.println("판매자 삭제 시, payment 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, payment 데이터 삭제 실패");
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
				System.out.println("판매자 삭제 시, eventdate 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, eventdate 데이터 삭제 실패");
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
				System.out.println("판매자 삭제 시, board 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, board 데이터 삭제 실패");
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
				System.out.println("판매자 삭제 시, eventdate 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, eventdate 데이터 삭제 실패");
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
				System.out.println("판매자 삭제 시, bookmark 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, bookmark 데이터 삭제 실패");
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
				System.out.println("판매자 삭제 시, EVENT 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, EVENT 데이터 삭제 실패");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete store where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("판매자 삭제 시, store 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, store 데이터 삭제 실패");
			}
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql ="delete seller where seller_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			result = pstmt.executeUpdate();
			if (result == 1 ) {
				System.out.println("판매자 삭제 시, seller 데이터 삭제 성공!");
			} else {
				System.out.println("판매자 삭제 시, seller 데이터 삭제 실패");
			}
			pstmt.close();
			con.close();
			
			
			System.out.println("판매자 탈퇴.");
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
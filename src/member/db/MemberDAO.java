package member.db;

import java.sql.*;
import java.util.*;

import javax.naming.*;
import javax.sql.DataSource;

import event.db.EventBean;
import seller.db.SellerBean;

public class MemberDAO {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public MemberDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB ���� ���� : " + ex);
			return;
		}
	}	

	// �Ϲ�ȸ�� �α���
	public int member_login(String mem_id, String mem_pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select mem_id, mem_pass from member  where mem_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,mem_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(2).equals(mem_pass)) {
					result = 1;	//���̵�� ��й�ȣ ��ġ�ϴ� ���
				} else {
					result = 0;	//��й�ȣ�� ��ġ���� �ʴ� ���
				}
			} else {
				result=-1; //���̵� ������������
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		} //finally
		return result;
	}
	
	
	// �Ǹ���ȸ�� �α���
	public int seller_login(String seller_id, String seller_pass) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			String sql = "select seller_id, seller_pass from seller  where seller_id = ? ";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,seller_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				if(rs.getString(2).equals(seller_pass)) {
					result = 1;	//���̵�� ��й�ȣ ��ġ�ϴ� ���
				} else {
					result = 0;	//��й�ȣ�� ��ġ���� �ʴ� ���
				}
			} else {
				result=-1; //���̵� ������������
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
			if(con!=null) {
				try {
					con.close();
				} catch(SQLException ex) {
					ex.printStackTrace();
				}
			}
		} //finally
		return result;
	}
	
	// �Ϲ�ȸ������
	public int insert_member(MemberBean m) {
		try {
			con = ds.getConnection();
			System.out.println("getConnection");
			
			pstmt = con.prepareStatement("insert into member values(?,?,?,?,?,?)");
			pstmt.setString(1, m.getMem_id());
			pstmt.setString(2, m.getMem_pass());
			pstmt.setString(3, m.getMem_name());
			pstmt.setString(4, m.getMem_jumin());
			pstmt.setString(5, m.getMem_phone());
			pstmt.setString(6, m.getMem_email());
			result = pstmt.executeUpdate();
		
		// primary key ���� ���� �������� ��� �߻��ϴ� ����
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("ȸ�� ���̵� �ߺ� �����Դϴ�.");
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

	// �Ǹ���ȸ������
		public int insert_seller(SellerBean s) {
			try {
				con = ds.getConnection();
				System.out.println("getConnection");
				
				pstmt = con.prepareStatement("insert into seller_temp values(?,?,?,?,?,?,?) ");
				pstmt.setString(1, s.getSeller_id());
				pstmt.setString(2, s.getSeller_pass());
				pstmt.setString(3, s.getSeller_name());
				pstmt.setString(4, s.getSeller_jumin());
				pstmt.setString(5, s.getSeller_phone());
				pstmt.setString(6, s.getSeller_email());
				pstmt.setString(7, s.getSeller_bs_no());
				result = pstmt.executeUpdate();
			
			// primary key ���� ���� �������� ��� �߻��ϴ� ����
			} catch(java.sql.SQLIntegrityConstraintViolationException e) {
				result = -1;
				System.out.println("�Ǹ���ȸ�� ���̵� �ߺ� �����Դϴ�.");
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

	// ������ - ȸ�� ��ü ��ȸ
	public List<MemberBean> getMemList () {
		List<MemberBean> memlist = new ArrayList<MemberBean>();
		try {
			con = ds.getConnection();
			String sql = "select * from member where mem_id != 'admin'";
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
				System.out.println("ȸ�� ��ü ��ȸ rs.next() ����!");
				memlist.add(member);
			}
			System.out.println("-----------------------------------------");
			return memlist;
			
		}catch(Exception e) {
			System.out.println("event_select() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
	
	// �Ϲ�ȸ�� ���������� - ������������ �� �̾ƿ� ��������
	public MemberBean getMember (String mem_id) {
		MemberBean member = new MemberBean();
		try {
			con = ds.getConnection();
			String sql = "select * from member where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member.setMem_id(rs.getString(1));
				member.setMem_pass(rs.getString(2));
				member.setMem_name(rs.getString(3));
				member.setMem_jumin(rs.getString(4));
				member.setMem_phone(rs.getString(5));
				member.setMem_email(rs.getString(6));
				System.out.println("ȸ�� �������� rs.next() ����!");
			}
			System.out.println("-----------------------------------------");
			return member;
			
		}catch(Exception e) {
			System.out.println("getMember() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
		
	}
	
	//���������� - ȸ�� ���� ����
	public int updateMember(MemberBean member){
		try {
			con = ds.getConnection();
			
			String sql = "update member set "
						+ "mem_pass=?,"
						+ "mem_phone=?,"
						+ "mem_email=? "
						+ "where "
						+ "mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getMem_pass());
			pstmt.setString(2, member.getMem_phone());
			pstmt.setString(3,member.getMem_email());
			pstmt.setString(4, member.getMem_id());
			
			result = pstmt.executeUpdate();
			
			System.out.println("--> ȸ�� �������� ���� ����!");
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
	
	// ���������� - ȸ�� Ż��
	public int deleteMember(String id) {
		try {
			con = ds.getConnection();
			String sql = "delete bookmark where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql = "delete payment where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql = "delete reply where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql = "delete board where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			pstmt.close();
			con.close();
			
			con = ds.getConnection();
			sql = "delete from member where mem_id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();
			
			System.out.println("ȸ�� Ż��.");
			System.out.println("------------------------------------------------");
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

	public void addBookmark(String mem_id, int event_no) {
		
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("insert into bookmark values(?,?)");
			pstmt.setInt(1, event_no);
			pstmt.setString(2, mem_id);
			result = pstmt.executeUpdate();
		
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			if(rs!=null) {try{rs.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}

	public void insert_payment(PaymentBean payment) {
		int pay_no = get_maxPK("payment")+1;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("insert into payment values(?,sysdate,?,?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, pay_no);
			pstmt.setInt(2, payment.getPay_price());
			pstmt.setInt(3, payment.getPay_yesorno());
			pstmt.setString(4, payment.getPay_card_name());
			pstmt.setString(5, payment.getPay_card_no());
			pstmt.setString(6, payment.getPay_card_cvc());
			pstmt.setString(7, payment.getPay_account_no());
			pstmt.setString(8, payment.getPay_account_pass());
			pstmt.setString(9, payment.getPay_deposit_name());
			pstmt.setInt(10, payment.getEdate_unique_no());
			pstmt.setInt(11, payment.getEvent_no());
			pstmt.setString(12, payment.getMem_id());
			result = pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			result = -1;
			e.printStackTrace();
		} finally {
			if(rs!=null) {try{rs.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}
	
	
	
	public int get_maxPK (String table) {
		int pk_no=1;
		try {
			con = ds.getConnection();
			
			if(table.equals("payment"))
				pstmt = con.prepareStatement("select MAX(pay_no) from payment");
			
			rs = pstmt.executeQuery();
			if(rs.next())
				pk_no = rs.getInt(1);
			else
				pk_no = 1;
		}catch(Exception e) {
			System.out.println("get_maxPK() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return pk_no;
	}

	public List<PaymentBean> getPaymentList(String mem_id) {
		
		List<PaymentBean> paymentlist = new ArrayList<PaymentBean>();
		
		try {
			con = ds.getConnection();
			String sql = "select * from payment where mem_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PaymentBean pay = new PaymentBean();
				pay.setPay_no(rs.getInt(1));
				pay.setPay_date(rs.getDate(2));
				pay.setPay_price(rs.getInt(3));
				pay.setPay_yesorno(rs.getInt(4));
				pay.setPay_card_name(rs.getString(5));
				pay.setPay_card_no(rs.getString(6));
				pay.setPay_card_cvc(rs.getString(7));
				pay.setPay_account_no(rs.getString(8));
				pay.setPay_account_pass(rs.getString(9));
				pay.setPay_deposit_name(rs.getString(10));
				pay.setEdate_unique_no(rs.getInt(11));
				pay.setEvent_no(rs.getInt(12));
				pay.setMem_id(rs.getString(13));
				paymentlist.add(pay);
				System.out.println("���� �ֹ��� ���� rs.next() ����!");
			}
			System.out.println("-----------------------------------------");
			return paymentlist;
			
		}catch(Exception e) {
			System.out.println("getPaymentList() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}
	
	
public List<EventBean> getPaymentEventList(String mem_id) {
		
	List<EventBean> eventlist = new ArrayList<EventBean>();
		
		try {
			con = ds.getConnection();
			String sql = "select event_no,event_name,event_file "
						+ "from event "
						+ "where event_no in (select event_no from payment where mem_id=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				event.setEvent_file(rs.getString(3));
				eventlist.add(event);
				System.out.println("���� �ֹ��� ���� - �̺�Ʈ�̸�/���� rs.next() ����!");
			}
			System.out.println("-----------------------------------------");
			return eventlist;
			
		}catch(Exception e) {
			System.out.println("getPaymentEventList() ���� : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}
	
	
	public boolean BookmarkDelete(int event_no) {
		String sql="DELETE FROM bookmark WHERE event_no=?";
		int result = 0;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, event_no);
			result=pstmt.executeUpdate();
				if(result==0) return false;
			return true;
		}catch(SQLException e) {
			System.out.println("BookmarkDelete() error: " + e);
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	
	public boolean deleteAll() {
		int result=0;
		String sql="DELETE FROM bookmark";
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement(sql);
			result=pstmt.executeUpdate();
			if(result==0) return false;
			return true;
		}catch(SQLException e) {
			System.out.println("deleteAll() error: " + e);
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
}

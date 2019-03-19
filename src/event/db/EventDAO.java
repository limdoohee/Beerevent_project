package event.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.naming.*;
import javax.sql.*;

import member.db.MemberBean;
import store.db.StoreBean;



public class EventDAO {
	
	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	int result;
	
	public EventDAO() {
		try{
			Context init = new InitialContext();
	  	    ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception ex){
			System.out.println("DB 연결 실패 : " + ex);
			return;
		}
	}	
	
	//index에서 검색했을 때 event 리스트를 뽑아올 메소드
	public List<EventBean> getEventList(String spot, String fromDate, String toDate, String eventType){
		//Event를 담을 리스트 객체 생성
		List<EventBean> eventlist=new ArrayList<EventBean>();

		System.out.println("fromDate : "+fromDate);
		System.out.println("toDate : "+toDate);
		System.out.println("spot의 값 : "+spot);
		System.out.println("이벤트타입 : "+eventType);
		System.out.println("-----------------------------------------");
		
		//이벤트 사진,이름,일자,유형,가격
		//★ 일단 위치에 대해서는 검색하지 않음.
		
		String event_list_sql =
				"select distinct e.event_no, e.event_file, e.event_name, e.event_categ, e.event_price, d.min " + 
				"from event e, (select event_no, min(edate_date) min " + 
				"				from eventdate " + 
				"				group by eventdate.event_no) d  " + 
				"where e.event_no = d.event_no " + 
				"and to_char(d.min, 'yyyy/MM/dd') between ? and ? " + 
				"and e.event_categ=? " +
				"and e.event_spot=? " +
				"order by d.min";
		try{
			con = ds.getConnection();
			
			//위치선택 안했을 시
			if(spot.equals("") || spot.equals(null)) {
				event_list_sql =
						"select distinct e.event_no, e.event_file, e.event_name, e.event_categ, e.event_price, d.min " + 
								"from event e, (select event_no, min(edate_date) min " + 
								"				from eventdate " + 
								"				group by eventdate.event_no) d  " + 
								"where e.event_no = d.event_no " + 
								"and to_char(d.min, 'yyyy/MM/dd') between ? and ? " + 
								"and e.event_categ=? " +
								"order by d.min";
				
				pstmt = con.prepareStatement(event_list_sql);
				
				pstmt.setString(1, fromDate);
				pstmt.setString(2, toDate);
				pstmt.setString(3, eventType);
				rs = pstmt.executeQuery();
			} else { //위치선택 했을 시
				pstmt = con.prepareStatement(event_list_sql);
				
				pstmt.setString(1, fromDate);
				pstmt.setString(2, toDate);
				pstmt.setString(3, eventType);
				pstmt.setString(4, spot);
				rs = pstmt.executeQuery();
			}
			//DB에서 가져온 데이터를 VO객체에 담습니다.
			
			System.out.println(event_list_sql);
			System.out.println("-----------------------------------------");
			while(rs.next()){
				System.out.println("이벤트 목록 rs.next() 성공!");
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_file(rs.getString(2));
				event.setEvent_name(rs.getString(3));
				//event.setEdate_date(rs.getDate(4));;
				event.setEvent_categ(rs.getString(4));
				event.setEvent_price(rs.getInt(5));
				eventlist.add(event); //값을 담은 객체를 리스트에 저장합니다.
			}
			System.out.println("eventlist.size() : "+eventlist.size());
			System.out.println("-----------------------------------------");
			return eventlist; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
		}catch(Exception ex){
			System.out.println("getEventList() 에러 : " + ex);
			System.out.println("-----------------------------------------");
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	//마이페이지 - 전체 이벤트 출력
	public List<EventBean> getEventList() {
		//Event를 담을 리스트 객체 생성
		List<EventBean> eventlist=new ArrayList<EventBean>();
		try{
			con = ds.getConnection();
			String sql = "select * from event";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println("마이페이지 - 이벤트 전체 목록 rs.next() 성공!");
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				event.setEvent_categ(rs.getString(3));
				event.setEvent_price(rs.getInt(4));
				event.setEvent_time(rs.getString(5));
				event.setEvent_location(rs.getString(6));
				event.setEvent_spot(rs.getString(7));
				event.setEvent_file(rs.getString(8));
				event.setEvent_description(rs.getString(9));
				event.setStore_no(rs.getInt(10));
				System.out.println("event_no : "+event.getEvent_no()+" / event_name : "+event.getEvent_name());
				System.out.println("-----------------------------------------");
				eventlist.add(event);
			}
			System.out.println("eventlist.size() : "+eventlist.size());
			System.out.println("-----------------------------------------");
			return eventlist; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
		}catch(Exception ex){
			System.out.println("getEventList() 에러 : " + ex);
			System.out.println("-----------------------------------------");
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	public List<EventBean> getEventList(String seller_id) {
		//Event를 담을 리스트 객체 생성
		List<EventBean> eventlist=new ArrayList<EventBean>();
		try{
			con = ds.getConnection();
			String sql = "select * from event " + 
						 "where store_no in(select store_no " + 
						 "					from store where seller_id=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, seller_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				System.out.println("판매자 - 이벤트 전체 목록 rs.next() 성공!");
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				event.setEvent_categ(rs.getString(3));
				event.setEvent_price(rs.getInt(4));
				event.setEvent_time(rs.getString(5));
				event.setEvent_location(rs.getString(6));
				event.setEvent_spot(rs.getString(7));
				event.setEvent_file(rs.getString(8));
				event.setEvent_description(rs.getString(9));
				event.setStore_no(rs.getInt(10));
				System.out.println("-----------------------------------------");
				eventlist.add(event);
			}
			System.out.println("eventlist.size() : "+eventlist.size());
			System.out.println("-----------------------------------------");
			return eventlist; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
		}catch(Exception ex){
			System.out.println("getEventList() 에러 : " + ex);
			System.out.println("-----------------------------------------");
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	
	//index에서 검색했을 때 event 리스트에 해당하는 날짜 뽑아올 메소드
	public List<EventBean> getEventDate(String spot, String fromDate, String toDate, String eventType)
			throws ParseException {
		//Event를 담을 리스트 객체 생성
		List<EventBean> eventlist=new ArrayList<EventBean>();

		System.out.println("fromDate : "+fromDate);
		System.out.println("toDate : "+toDate);
		System.out.println("spot의 값 : "+spot);
		System.out.println("이벤트타입 : "+eventType);
		System.out.println("-----------------------------------------");
		
		//이벤트 사진,이름,일자,유형,가격
		//★ 일단 위치에 대해서는 검색하지 않음.
		
		String event_list_sql =
				"select distinct e.event_no, d.edate_date " + 
				"from event e, eventdate d " + 
				"where e.event_no = d.event_no " + 
				"and to_char(d.edate_date, 'yyyy/MM/dd') between ? and ? " + 
				"and event_categ=? " + 
				"and event_spot=?";
		try{
			con = ds.getConnection();
			
			//위치선택 안했을 시
			if(spot.equals("") || spot.equals(null)) {
				event_list_sql =
						"select distinct e.event_no, d.edate_date " + 
						"from event e, eventdate d " + 
						"where e.event_no = d.event_no " + 
						"and to_char(d.edate_date, 'yyyy/MM/dd') between ? and ? " + 
						"and event_categ=?";
				
				pstmt = con.prepareStatement(event_list_sql);
				
				pstmt.setString(1, fromDate);
				pstmt.setString(2, toDate);
				pstmt.setString(3, eventType);
				rs = pstmt.executeQuery();
			} else { //위치선택 했을 시
				pstmt = con.prepareStatement(event_list_sql);
				
				pstmt.setString(1, fromDate);
				pstmt.setString(2, toDate);
				pstmt.setString(3, eventType);
				pstmt.setString(4, spot);
				rs = pstmt.executeQuery();
			}
			//DB에서 가져온 데이터를 VO객체에 담습니다.
			
			System.out.println(event_list_sql);
			System.out.println("-----------------------------------------");
			while(rs.next()){
				System.out.println("이벤트 날짜 rs.next() 성공!");
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEdate_date(rs.getDate(2));
				eventlist.add(event); //값을 담은 객체를 리스트에 저장합니다.
			}
			System.out.println("eventdate.size() : "+eventlist.size());
			System.out.println("-----------------------------------------");
			return eventlist; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
		}catch(Exception ex){
			System.out.println("getEventDate() 에러 : " + ex);
			System.out.println("-----------------------------------------");
		}finally{
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		
		return null;
	}
	
	
	//index에서 검색했을 때 event 리스트에 해당하는 날짜 뽑아올 메소드
		public List<EventBean> getEventDate(int event_no)
				throws ParseException {
			//Event를 담을 리스트 객체 생성
			List<EventBean> eventlist=new ArrayList<EventBean>();

			System.out.println("이벤트 상세보기(날짜) - 이벤트 번호  : "+event_no);
			System.out.println("-----------------------------------------");
			
			//이벤트 사진,이름,일자,유형,가격
			//★ 일단 위치에 대해서는 검색하지 않음.
			
			String event_date_sql =
					"select * from eventdate where event_no=? ";
			try{
				con = ds.getConnection();
				
				pstmt = con.prepareStatement(event_date_sql);
				
				pstmt.setInt(1, event_no);
				rs = pstmt.executeQuery();
				
				//DB에서 가져온 데이터를 객체에 담습니다.
				while(rs.next()){
					System.out.println("이벤트 날짜 rs.next() 성공!");
					EventBean event = new EventBean();
					event.setEdate_unique_no(rs.getInt(1));
					event.setEdate_date(rs.getDate(2));
					event.setEdate_num_of_pp(rs.getInt(3));
					event.setEvent_no(rs.getInt(4));
					eventlist.add(event); //값을 담은 객체를 리스트에 저장합니다.
				}
				System.out.println("eventdate.size() : "+eventlist.size());
				System.out.println("-----------------------------------------");
				return eventlist; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
			}catch(Exception ex){
				System.out.println("getEventDate() 에러 : " + ex);
				System.out.println("-----------------------------------------");
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			
			return null;
		}
		
		public String getSelectedEventDate(int edate_unique_no)  {

			String edate_date = "";
			try{
				con = ds.getConnection();
				
				pstmt = con.prepareStatement("select edate_date from eventdate where edate_unique_no=?");
				
				pstmt.setInt(1, edate_unique_no);
				rs = pstmt.executeQuery();
				
				if(rs.next())
					edate_date = rs.getString(1);
				return edate_date; //값을 담은 객체를 저장한 리스트를 호출한 곳으로 가져갑니다.
			}catch(Exception ex){
				System.out.println("getSelectedEventDate() 에러 : " + ex);
				System.out.println("-----------------------------------------");
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
				if(con!=null) try{con.close();}catch(SQLException ex){}
			}
			
			return null;
		}
	
		
		
	//선택된 이벤트 PK값을 받아 해당 PK번호에 해당하는 이벤트 결과 리턴
	public EventBean event_select(int event_no) {
		
		EventBean event = null;
		
		try {
			con = ds.getConnection();
			String sql = "select * from event where event_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, event_no);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				event.setEvent_categ(rs.getString(3));
				event.setEvent_price(rs.getInt(4));
				event.setEvent_time(rs.getString(5));
				event.setEvent_location(rs.getString(6));
				event.setEvent_spot(rs.getString(7));
				event.setEvent_file(rs.getString(8));
				event.setEvent_description(rs.getString(9));
				event.setStore_no(rs.getInt(10));
				System.out.println("이벤트 상세보기 rs.next() 성공!");
				System.out.println("-----------------------------------------");
			}
			return event;
		}catch(Exception e) {
			System.out.println("event_select() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}
	
	//찜목록 뽑아오기 위해~
	public List<EventBean> getEvent_for_Bookmark(String mem_id) {
		List<EventBean> elist = new ArrayList<EventBean>();
		EventBean event = new EventBean();
		try {
			con = ds.getConnection();
			String sql = "select * from event where event_no in " + 
					"(select event_no from bookmark where mem_id=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				event.setEvent_categ(rs.getString(3));
				event.setEvent_price(rs.getInt(4));
				event.setEvent_time(rs.getString(5));
				event.setEvent_location(rs.getString(6));
				event.setEvent_spot(rs.getString(7));
				event.setEvent_file(rs.getString(8));
				event.setEvent_description(rs.getString(9));
				event.setStore_no(rs.getInt(10));
				elist.add(event);
				System.out.println("찜목록 뽑아오기 rs.next() 성공!");
			}
			System.out.println("-----------------------------------------");
			return elist;
		}catch(Exception e) {
			System.out.println("getEvent_for_Bookmark() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return null;
	}

	public int registerEvent(EventBean event) {
		
		//store_no에 들어갈 pk값 구하기
		int event_no = get_maxPK("event") + 1;
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("insert into event values(?,?,?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, event_no);
			pstmt.setString(2, event.getEvent_name());
			pstmt.setString(3, event.getEvent_categ());
			pstmt.setInt(4, event.getEvent_price());
			pstmt.setString(5, event.getEvent_time());
			pstmt.setString(6, event.getEvent_location());
			pstmt.setString(7, event.getEvent_spot());
			pstmt.setString(8, event.getEvent_file());
			pstmt.setString(9, event.getEvent_description());
			pstmt.setInt(10, event.getStore_no());
			result = pstmt.executeUpdate();
		
		// primary key 제약 조건 위반했을 경우 발생하는 에러
		} catch(java.sql.SQLIntegrityConstraintViolationException e) {
			result = -1;
			System.out.println("이벤트 PK 중복 에러입니다.");
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
	
	public int get_maxPK (String table) {
		int pk_no=1;
		try {
			con = ds.getConnection();
			
			if(table.equals("event"))
				pstmt = con.prepareStatement("select MAX(event_no) from event");
			else if(table.equals("eventdate"))
				pstmt = con.prepareStatement("select MAX(edate_unique_no) from eventdate");
			
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

	public String getEventName(int event_no) {
		String event_name="";
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement("select event_name from event where event_no=?");
			pstmt.setInt(1, event_no);
			rs = pstmt.executeQuery();
			if(rs.next())
				event_name = rs.getString(1);
			return event_name;
		}catch(Exception e) {
			System.out.println("getEventName() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
		return event_name;
	}
	
	
	// 날짜에 인원 추가
	public void updatenumofpp(int edate_unique_no) {
		try {
			con = ds.getConnection();
			
			pstmt = con.prepareStatement("update eventdate set edate_num_of_pp=edate_num_of_pp+1 where edate_unique_no=?");
			pstmt.setInt(1, edate_unique_no);
			result = pstmt.executeUpdate();
		}
		catch(Exception e) {
			System.out.println("updatenumofpp() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		
	}
	
	
	//이벤트날짜 테이블에 등록
	public void insertEventdate(EventBean eventdate) {
		int pk = get_maxPK("eventdate")+1;
		try {
			con = ds.getConnection();

			java.sql.Date date = new java.sql.Date(eventdate.getEdate_date().getTime());
			
			pstmt = con.prepareStatement("insert into eventdate values(?,?,?,?)");
			pstmt.setInt(1, pk);
			pstmt.setDate(2,date);
			pstmt.setInt(3, 0);
			pstmt.setInt(4, eventdate.getEvent_no());
			pstmt.executeUpdate();
		} catch(Exception e) {
			System.out.println("updatenumofpp() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
	}

	public List<MemberBean> getEventOrderList(int edate_unique_no) {
		List<MemberBean> memberlist = new ArrayList<MemberBean>();
		try {
			con = ds.getConnection();
			String sql = "select mem_id, mem_name, mem_phone, mem_email " + 
							"from member " + 
							"where mem_id in (select mem_id " + 
							"from payment " + 
							"where edate_unique_no=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, edate_unique_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				MemberBean member = new MemberBean();
				member.setMem_id(rs.getString(1));
				member.setMem_name(rs.getString(2));
				member.setMem_phone(rs.getString(3));
				member.setMem_email(rs.getString(4));
				memberlist.add(member);
			}
			
			return memberlist;
			
		}catch(Exception e) {
			System.out.println("updatenumofpp() 에러 : "+e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) {try{pstmt.close();}catch(SQLException ex){ex.printStackTrace();}}
			if(con!=null) {try{con.close();}catch(SQLException ex){ex.printStackTrace();}}
		}
		return memberlist;
	}
}

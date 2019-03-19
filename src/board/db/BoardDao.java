package board.db;

import java.sql.*;
import java.util.*;
import javax.naming.*;
import javax.sql.*;

import event.db.EventBean;

public class BoardDao {

	DataSource ds;
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	public BoardDao() {
		try {
			Context init = new InitialContext();
			ds=
		(DataSource)init.lookup("java:comp/env/jdbc/OracleDB");
		}catch(Exception e) {
			System.out.println("DB connecting failure: " + e);
			return;
		}
	}
	
	public boolean boardInsert(BoardBean board_bean) {
		int no= 0;
		String sql="";
		int result=0;
		try {
			con = ds.getConnection();
			String sql_maxno = "SELECT MAX(board_no) FROM board";
			pstmt=con.prepareStatement(sql_maxno);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(rs.getInt(1));
				no = rs.getInt(1)+1;
			}
			
			sql="INSERT INTO board "
			+ "(board_no, board_title, board_content, board_file, board_date, board_readcount, mem_id, event_no) "	//Mem_id(), Event_no() 異붽� �븷 寃�
			+ " VALUES(?, ?, ?, ?, sysdate, ?,?,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			System.out.println(no);
			pstmt.setString(2, board_bean.getBoard_title());
			pstmt.setString(3, board_bean.getBoard_content());
			pstmt.setString(4, board_bean.getBoard_file());
			pstmt.setInt(5, board_bean.getBoard_readcount());
			pstmt.setString(6, board_bean.getMem_id());
			pstmt.setInt(7, board_bean.getEvent_no());	
					
			result = pstmt.executeUpdate();
			if (result ==0)
				return false;
			return true;					
		}catch(Exception e) {
			System.out.println("board_insert() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return false;
	}
	
	public int getListCount() {
		int x = 0;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement("SELECT COUNT(*) FROM board");
			rs = pstmt.executeQuery(); //executeQuery(): select
			
			if(rs.next()) {
				x=rs.getInt(1);
			}else {
				x=1;
			}
		}catch(Exception e) {
			System.out.println("getListCount() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return x;
	}

	public List<BoardBean> getBoardList(int page, int limit){
		String board_list_sql=
				"SELECT * FROM (SELECT rownum rnum, board_no, board_title, board_content, board_file, board_date, board_readcount, mem_id, event_no, event_name "
				+ "FROM (SELECT board_no, board_title, board_content, board_file, board_date, board_readcount, mem_id, board.event_no, event_name "
				+ "FROM  board, event WHERE board.event_no=event.event_no ORDER BY board_no DESC)) "
				+ "WHERE rnum>=? AND rnum<=?";
		
		List<BoardBean> list = new ArrayList<BoardBean>();
		int startrow=(page-1)*limit+1;
		int endrow=startrow + limit-1;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean board_bean = new BoardBean();
				board_bean.setBoard_no(rs.getInt("board_no"));
				board_bean.setBoard_title(rs.getString("board_title"));
				board_bean.setBoard_readcount(rs.getInt("board_readcount"));
				board_bean.setBoard_date(rs.getDate("board_date"));
				board_bean.setMem_id(rs.getString("mem_id"));
				board_bean.setEvent_no(rs.getInt("event_no"));
				board_bean.setEvent_name(rs.getString("event_name"));

				list.add(board_bean);				
			}
			return list;		
		}catch(Exception e) {
			System.out.println("getBoardList() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return null;
	}
	
	public List<BoardBean> getBoardList_event(int page, int limit, int event_no){
		String board_list_sql=
				"SELECT * FROM (SELECT rownum rnum, board_no, board_title, board_content, board_file, board_date, board_readcount, mem_id, event_no, event_name "
				+ "FROM (SELECT board_no, board_title, board_content, board_file, board_date, board_readcount, mem_id, board.event_no, event_name "
				+ "FROM  board, event WHERE board.event_no=event.event_no ORDER BY board_no DESC)) "
				+ "WHERE rnum>=? AND rnum<=? "
				+ "AND event_no=?";
		
		List<BoardBean> list = new ArrayList<BoardBean>();
		int startrow=(page-1)*limit+1;
		int endrow=startrow + limit-1;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(board_list_sql);
			pstmt.setInt(1, startrow);
			pstmt.setInt(2, endrow);
			pstmt.setInt(3, event_no);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean board_bean = new BoardBean();
				board_bean.setBoard_no(rs.getInt("board_no"));
				board_bean.setBoard_title(rs.getString("board_title"));
				board_bean.setBoard_readcount(rs.getInt("board_readcount"));
				board_bean.setBoard_date(rs.getDate("board_date"));
				board_bean.setMem_id(rs.getString("mem_id"));
				board_bean.setEvent_no(rs.getInt("event_no"));
				board_bean.setEvent_name(rs.getString("event_name"));

				list.add(board_bean);				
			}
			return list;		
		}catch(Exception e) {
			System.out.println("getBoardList() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return null;
	}
	
	public boolean boardModify(BoardBean board_bean) {
		String sql = "UPDATE board SET board_title = ?, board_content =? "
				+ "WHERE board_no=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board_bean.getBoard_title());
			pstmt.setString(2, board_bean.getBoard_content());
			pstmt.setInt(3, board_bean.getBoard_no());
			pstmt.executeQuery();
			return true;			
		}catch(SQLException e) {
			System.out.println("boardModify() error: " + e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	
	public void setReadCountUpdate(int no) {
		String sql = "UPDATE board SET board_readcount = board_readcount+1 WHERE board_no = ?";
		try{
			con = ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
		}catch(SQLException e) {
			System.out.println("setReadCountUpdate() error: " + e); 
		}finally {
			if(rs!=null) try{rs.close();} catch(SQLException e){}
			if(pstmt != null) try{pstmt.close();}catch(SQLException e){}
			if(con!=null) try {con.close();}catch(SQLException e) {}
		}
	}
	public BoardBean getDetail(int no) {
		BoardBean board_bean = null;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement("SELECT * FROM "
					+ "(SELECT board_no, board_title, board_content, board_file, board_date, "
					+ "board_readcount, mem_id, board.event_no, event_name "
					+ "FROM board,event WHERE board.event_no=event.event_no) "
					+ "WHERE board_no=?");
			pstmt.setInt(1, no);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				board_bean = new BoardBean();
				board_bean.setBoard_no(rs.getInt("board_no"));
				board_bean.setBoard_title(rs.getString("board_title"));
				board_bean.setBoard_content(rs.getString("board_content"));
				board_bean.setBoard_file(rs.getString("board_file"));
				board_bean.setBoard_date(rs.getDate("board_date"));
				board_bean.setBoard_readcount(rs.getInt("board_readcount"));
				board_bean.setMem_id(rs.getString("mem_id"));
				board_bean.setEvent_no(rs.getInt("event_no"));
				board_bean.setEvent_name(rs.getString("event_name"));
			}
			return board_bean;
		}catch(SQLException e) {
			System.out.println("getDetail() error: " + e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public boolean boardDelete(int no) {
		String sql="DELETE FROM board WHERE board_no=?";
		int result=0;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,no);
			result=pstmt.executeUpdate();
				if(result==0) return false;
			return true;		
		}catch(SQLException e) {
			System.out.println("boardDelete() error: " + e);
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	//added
	public boolean boardReplyDelete(int no) {
		String sql="DELETE FROM reply WHERE board_no=?";
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,no);
			pstmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("boardReplyDelete() error: " + e);
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}
	//
	public boolean replyInsert(ReplyBean reply_bean) {
		int no= 1;
		int result=0;
		try {
			con = ds.getConnection();
			String sql_maxno = "SELECT MAX(reply_no) FROM reply";
			pstmt=con.prepareStatement(sql_maxno);
			rs = pstmt.executeQuery();	
				if(rs.next()) {
					System.out.println(rs.getInt(1));
					no = rs.getInt(1)+1;
				}else {
					no=1;
				}
			
			String sql="INSERT INTO reply "
			+ "(board_no, reply_no, reply_content, reply_date, mem_id) "	//mem_id() 異붽� �븷 寃�
			+ "VALUES(?, ?, ?, sysdate,?)";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply_bean.getBoard_no());
			pstmt.setInt(2, no);
					System.out.println(no);
			pstmt.setString(3, reply_bean.getReply_content());
			pstmt.setString(4, reply_bean.getMem_id());
			result = pstmt.executeUpdate();
				if (result ==0) return false;
			return true;					
		}catch(Exception e) {
			System.out.println("replyInsert() ��?�윭: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return false;
	}
	
	public List<EventBean> getEventName() {
		
		List<EventBean> eventnamelist = new ArrayList<EventBean>();
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement("SELECT event_no,event_name FROM event");
			rs=pstmt.executeQuery();
			while(rs.next()) {
				System.out.println("---> rs.next entered");
				EventBean event = new EventBean();
				event.setEvent_no(rs.getInt(1));
				event.setEvent_name(rs.getString(2));
				eventnamelist.add(event);
			}
			return eventnamelist;
		}catch(SQLException e) {
			System.out.println("getEventName() error: " + e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return eventnamelist;
	}
	
	public List<ReplyBean> getReplyListBoard(int board_no){
		String sql="SELECT * FROM reply WHERE board_no=? ORDER BY reply_no DESC";
		List<ReplyBean> list = new ArrayList<ReplyBean>();
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_no);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ReplyBean reply_bean = new ReplyBean();
				reply_bean.setBoard_no(rs.getInt("board_no"));
				reply_bean.setReply_no(rs.getInt("reply_no"));
				reply_bean.setReply_content(rs.getString("reply_content"));
				reply_bean.setReply_date(rs.getDate("reply_date"));
				reply_bean.setMem_id(rs.getString("mem_id"));
				list.add(reply_bean);
			}
			return list;
		}catch(Exception e) {
			System.out.println("getReplyList() error: " + e);
		}finally {
			if(rs!=null) try{rs.close();}catch(SQLException ex){}
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return null;
	}
	
	public boolean replyDelete(int reply_no){
		String sql="DELETE FROM reply WHERE reply_no=?";
		int result=0;
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reply_no);
			result=pstmt.executeUpdate();
			if(result==0) return false;
			return true;
		}catch(SQLException e) {
			System.out.println("replyDelete() error: " + e);
		}finally {
			if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			if(con!=null) try{con.close();}catch(SQLException ex){}
		}
		return false;
	}	
	
	
	public int getMemberListCount(String mem_id) {
		int x = 0;
		try {
			con=ds.getConnection();
			pstmt=con.prepareStatement("SELECT COUNT(*) FROM board WHERE mem_id = ?");
			pstmt.setString(1, mem_id);
			rs = pstmt.executeQuery(); //executeQuery(): select
			
			if(rs.next()) {
				x=rs.getInt(1);
			}else {
				x=1;
			}
		}catch(Exception e) {
			System.out.println("getListCount() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return x;
	}
	
	
	public List<BoardBean> getMemberBoardList(String mem_id, int page, int limit){
		String sql=
		"SELECT * FROM "
		+ "(SELECT rownum rnum, board_no, board_title, board_content, board_file, "
		+ "board_date, board_readcount, mem_id, event_no, event_name FROM "
		+ "(SELECT board_no, board_title, board_content, board_file, board_date, "
		+ "board_readcount, mem_id, board.event_no, event_name FROM  board, event "
		+ "WHERE board.event_no = event.event_no ORDER BY board_no DESC) "
		+ "WHERE mem_id = ?) WHERE rnum >= ? AND rnum <=?";

		List<BoardBean> list = new ArrayList<BoardBean>();
		int startrow=(page-1)*limit+1;
		int endrow=startrow + limit-1;
		
		try {
			con=ds.getConnection();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, mem_id);
			pstmt.setInt(2, startrow);
			pstmt.setInt(3, endrow);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardBean board_bean = new BoardBean();
				board_bean.setBoard_no(rs.getInt("board_no"));
				board_bean.setBoard_title(rs.getString("board_title"));
				board_bean.setBoard_readcount(rs.getInt("board_readcount"));
				board_bean.setBoard_date(rs.getDate("board_date"));
				board_bean.setMem_id(rs.getString("mem_id"));
				board_bean.setEvent_no(rs.getInt("event_no"));
				board_bean.setEvent_name(rs.getString("event_name"));
				
				list.add(board_bean);				
			}
			return list;		
		}catch(Exception e) {
			System.out.println("getMemberBoardList() error: " + e);
		}finally {
			if(rs != null)
				try {rs.close();} catch(SQLException e) {}
			if(pstmt != null)
				try {pstmt.close();}catch(SQLException e) {}
			if(con != null)
				try {con.close();}catch(SQLException e) {}
		}
		return null;
	}
}


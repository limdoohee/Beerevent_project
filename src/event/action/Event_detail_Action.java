package event.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import board.db.*;
import event.db.*;
import store.db.*;

public class Event_detail_Action implements Action {
	public ActionForward execute
	(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		
		EventDAO eventdao = new EventDAO();
		EventBean event = eventdao.event_select(event_no);
		
		List<EventBean> eventdate = new ArrayList<EventBean>();
		eventdate = eventdao.getEventDate(event_no);	
		
		if(event == null ) {
			System.out.println("이벤트 상세보기 실패");
			System.out.println("-----------------------------------------");
			return null;
		}
		System.out.println("이벤트 상세보기 성공");
		System.out.println("-----------------------------------------");
		
		
		StoreDAO storedao = new StoreDAO();
		String store_name = storedao.getStoreName(event.getStore_no());
		
		if(store_name == null ) {
			System.out.println("이벤트 상세보기 - 가게 이름 추출 실패");
			System.out.println("-----------------------------------------");
			return null;
		}
		System.out.println("이벤트 상세보기 - 가게 이름 추출 성공");
		System.out.println("-----------------------------------------");

		
		// 이벤트에 해당하는 후기 불러오기
		BoardDao board_dao = new BoardDao();
		List<BoardBean> board_bean_list = new ArrayList<BoardBean>();
			
		int page=1;
		int limit=10;
		
			
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("page= " + page);
			
		HttpSession session = request.getSession();
		if(session.getAttribute("limit") != null) {
			limit = Integer.parseInt(session.getAttribute("limit").toString());
		}
		if(request.getParameter("limit") != null) {	
			limit = Integer.parseInt(request.getParameter("limit"));
			session.setAttribute("limit", limit);
			System.out.println("limit= " + limit);
		}
		
		int list_total_count = board_dao.getListCount();
		board_bean_list=board_dao.getBoardList_event(page,limit,event_no);
		

		int maxpage=(list_total_count + limit-1)/limit;
		System.out.println("list_total_count= " + maxpage);
		
		int startpage = ((page-1)/10)*10 +1;
		System.out.println("startpage= " + startpage);
		
		int endpage = startpage + 10 -1;
		System.out.println("endpage= " + endpage);
		
		if(endpage>maxpage) endpage=maxpage;
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("list_total_count", list_total_count);
		request.setAttribute("board_bean_list", board_bean_list);
		request.setAttribute("limit", limit);
		request.setAttribute("event", event);
		request.setAttribute("eventdate", eventdate);
		
		
		forward.setRedirect(false);
		
		if(request.getParameter("state") != null) {
			forward.setPath("6board/board_list2.jsp");
			System.out.println("Ajax working");
		}else
			forward.setPath("2event/event_detail.jsp?store_name="+store_name);

		return forward;
	}

}

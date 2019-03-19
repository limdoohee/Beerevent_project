package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.EventBean;
import event.db.EventDAO;
import store.db.StoreBean;
import store.db.StoreDAO;

public class Manager_Event_Detail_Action  implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	ActionForward forward = new ActionForward();
	request.setCharacterEncoding("utf-8");
	
	int event_no = Integer.parseInt(request.getParameter("event_no"));
	
	//선택된 이벤트 가져오기
	EventDAO eventdao = new EventDAO();
	EventBean event = eventdao.event_select(event_no);
	
	// 이벤트의 날짜 리스트 가져오기
	List<EventBean> eventdate = new ArrayList<EventBean>();
	eventdate = eventdao.getEventDate(event_no);
	
	// 이벤트를 진행하는 가게 이름 가져오기
	StoreDAO storedao = new StoreDAO();
	String store_name = storedao.getStoreName(event.getStore_no());
	System.out.println("store_name : "+store_name);
	
	//판매자 아이디 가져오기
	storedao = new StoreDAO();
	String seller_id = storedao.getStoreSeller(event.getStore_no());
	System.out.println("seller_id : "+seller_id);
	
	request.setAttribute("event", event);
	request.setAttribute("eventdate", eventdate);
	forward.setPath("3mypage_admin/admin_mypage_eventdetail.jsp?store_name="+store_name+"&seller_id="+seller_id);
	forward.setRedirect(false);
	
	
	return forward;
	}
}

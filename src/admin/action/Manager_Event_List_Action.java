package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.*;
import store.db.*;


public class Manager_Event_List_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		//이벤트 리스트 뽑아오기
		EventDAO eventdao = new EventDAO();
		List<EventBean> eventlist = new ArrayList<EventBean>();
		eventlist = eventdao.getEventList();
		
		//이벤트에 해당하는 가게 이름 뽑아오기?
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreName();
		
/*		//이벤트의 회차 개수 구해오기
		int event_count = eventdao.getEventCount();*/
		
		request.setAttribute("eventlist", eventlist);
		request.setAttribute("storelist", storelist);
		forward.setPath("3mypage_admin/admin_mypage_eventlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

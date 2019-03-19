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
		
		//�̺�Ʈ ����Ʈ �̾ƿ���
		EventDAO eventdao = new EventDAO();
		List<EventBean> eventlist = new ArrayList<EventBean>();
		eventlist = eventdao.getEventList();
		
		//�̺�Ʈ�� �ش��ϴ� ���� �̸� �̾ƿ���?
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreName();
		
/*		//�̺�Ʈ�� ȸ�� ���� ���ؿ���
		int event_count = eventdao.getEventCount();*/
		
		request.setAttribute("eventlist", eventlist);
		request.setAttribute("storelist", storelist);
		forward.setPath("3mypage_admin/admin_mypage_eventlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

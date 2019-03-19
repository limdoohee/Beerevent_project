package event.action;

import javax.servlet.http.*;

import event.db.*;


public class Event_modifyPage_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		
		EventDAO eventdao = new EventDAO();
		EventBean event = new EventBean();
		
		event = eventdao.event_select(event_no);
		
		if(event == null) {
			System.out.println("�̺�Ʈ ���� ����");
			return null;
		}
		System.out.println("�̺�Ʈ ���� ����");
		
		request.setAttribute("event", event);
		
		forward.setRedirect(false);
		forward.setPath("3mypage_admin/admin_mypage_eventmodify.jsp");
		return forward;
	}

}

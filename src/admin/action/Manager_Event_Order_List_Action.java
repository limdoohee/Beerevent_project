package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.EventDAO;
import member.db.MemberBean;

public class Manager_Event_Order_List_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		int edate_unique_no = Integer.parseInt(request.getParameter("edate_unique_no"));
		
		EventDAO eventdao = new EventDAO();
		List<MemberBean> memberlist = new ArrayList<MemberBean>();
		memberlist = eventdao.getEventOrderList(edate_unique_no);
		
		request.setAttribute("memberlist", memberlist);
		
		forward.setPath("3mypage_admin/event_order_list.jsp");
		return forward;
	}

}

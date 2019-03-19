package member.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import event.db.*;
import member.db.*;

public class Mem_bookmarkPage_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = session.getAttribute("id").toString();
		
		// �α����� ȸ���� ���� �������� (��³����� event�������̱� ������ eventDAO���� �޼ҵ� ����)
		EventDAO eventdao = new EventDAO();
		List<EventBean> elist = new ArrayList<EventBean>();
		elist = eventdao.getEvent_for_Bookmark(mem_id);
		
		request.setAttribute("elist", elist);
		forward.setPath("4mypage_member/member_mypage_wishlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

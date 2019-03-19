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
		
		// 로그인한 회원의 찜목록 가져오기 (출력내용은 event정보들이기 때문에 eventDAO에서 메소드 실행)
		EventDAO eventdao = new EventDAO();
		List<EventBean> elist = new ArrayList<EventBean>();
		elist = eventdao.getEvent_for_Bookmark(mem_id);
		
		request.setAttribute("elist", elist);
		forward.setPath("4mypage_member/member_mypage_wishlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

package member.action;

import javax.servlet.http.*;

import member.db.MemberDAO;

public class BookmarkDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		boolean result = false;
		
		MemberDAO member_dao = new MemberDAO();
		ActionForward action_forward = new ActionForward();
		
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		result = member_dao.BookmarkDelete(event_no);
		if(result==false) {
			System.out.println("bookmark deleting error");
			return null;
		}
		System.out.println("bookmark deleted");
		
		action_forward.setRedirect(false);
			action_forward.setPath("board/member_mypage_wishlist.jsp");
		return action_forward;
	}

}

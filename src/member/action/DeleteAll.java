package member.action;

import javax.servlet.http.*;
import member.db.MemberDAO;

public class DeleteAll implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		boolean result = false;
		MemberDAO member_dao = new MemberDAO();
		ActionForward action_forward = new ActionForward();
		result= member_dao.deleteAll();
		
		if(result==false) {
			System.out.println("DeleteAll falure");
			return null;
		}
		
		System.out.println("DeleteAll success");
		action_forward.setRedirect(false);
		action_forward.setPath("board/member_mypage_wishlist.jsp");
		
		return action_forward;
	}

}

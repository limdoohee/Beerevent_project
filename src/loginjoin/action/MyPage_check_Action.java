package loginjoin.action;

import javax.servlet.http.*;

public class MyPage_check_Action implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");

		HttpSession session = request.getSession();
		
		String id = (session.getAttribute("id")).toString();
		String login_type = (session.getAttribute("login_type").toString());
		
		System.out.println("[마이페이지 진입]");
		System.out.println("id : "+id);
		System.out.println("login_type : "+login_type);
		System.out.println("------------------------------------------------");
		
		forward.setRedirect(false);
		if(login_type.equals("admin")) {
			forward.setPath("3mypage_admin/admin_mypage.jsp");
		} else if(login_type.equals("member")) {
			forward.setPath("4mypage_member/member_mypage.jsp");
		} else if(login_type.equals("seller")) {
			forward.setPath("5mypage_seller/seller_mypage.jsp");
		}

		return forward;
	}

}

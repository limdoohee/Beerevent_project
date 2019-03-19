package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.MemberDAO;
import seller.db.SellerDAO;

public class Manager_seller_delete_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String seller_id = request.getParameter("seller_id");
		
		SellerDAO sellerdao = new SellerDAO();
		sellerdao.deleteSeller(seller_id);
		
		forward.setRedirect(false);
		if(request.getParameter("state")!=null) {
			forward.setPath("3mypage_admin/admin_mypage_memlist_ajax.jsp");
			System.out.println("Ajax working");
		}else {
			forward.setPath("3mypage_admin/admin_mypage_memlist.jsp");
		}
		return forward;
	}

}

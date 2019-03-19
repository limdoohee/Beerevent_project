package admin.action;

import java.util.*;

import javax.servlet.http.*;

import seller.db.*;

public class Manager_seller_temp_approval_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String stemp_id = request.getParameter("stemp_id");
		System.out.println("stemp_id = "+stemp_id);
		SellerDAO sellerdao = new SellerDAO();
		
		//����ó���� stemp ������ seller ��ü�� ��ƿ´�.
		SellerBean seller = new SellerBean();
		seller = sellerdao.getStemp(stemp_id);
		
		// ��ƿ� ��ü�� seller���̺� insert
		sellerdao.insertStemp_to_Seller(seller);
		
		//stemp�� �ش� ������ �����.
		sellerdao.deleteStemp(stemp_id);
		
		List<SellerBean> sellerlist = new ArrayList<SellerBean>();
		sellerlist = sellerdao.getSellList();
		
		request.setAttribute("sellerList", sellerlist);
		
		forward.setRedirect(false);
		if(request.getParameter("state")!=null) {
			forward.setPath("3mypage_admin/admin_mypage_sellerlist_ajax.jsp");
			System.out.println("Ajax working");
		}else {
			forward.setPath("3mypage_admin/admin_mypage_sellerlist.jsp");
		}
		
		return forward;
	}

}

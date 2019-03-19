package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import seller.db.*;


public class Manager_seller_List_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		SellerDAO selldao = new SellerDAO();

		List<SellerBean> sellerList = new ArrayList<SellerBean>();
		sellerList = selldao.getSellList();

		List<SellertempBean> stempList = new ArrayList<SellertempBean>();
		stempList = selldao.getStempList();
		
		request.setAttribute("sellerList", sellerList);
		request.setAttribute("stempList", stempList);
		forward.setPath("3mypage_admin/admin_mypage_sellerlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

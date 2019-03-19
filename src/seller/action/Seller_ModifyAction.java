package seller.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import seller.db.*;

public class Seller_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String seller_id = (String)session.getAttribute("id");
		System.out.println("¡Ú id = " + seller_id);
		SellerDAO sellerdao = new SellerDAO();
		SellerBean seller = new SellerBean();
		seller = sellerdao.getSeller(seller_id);
		
		forward.setPath("5mypage_seller/seller_mypage_modify.jsp");
		forward.setRedirect(false);
		request.setAttribute("selInfo", seller);
		return forward;
	}

}

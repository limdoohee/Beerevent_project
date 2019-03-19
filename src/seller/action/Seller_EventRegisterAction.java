package seller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import store.db.*;


public class Seller_EventRegisterAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreList(session.getAttribute("id").toString());
		
		request.setAttribute("storelist", storelist);
		forward.setPath("5mypage_seller/seller_event_register.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

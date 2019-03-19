package admin.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.*;
import seller.db.*;
import store.db.*;

public class Manager_seller_detail_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String seller_id = request.getParameter("seller_id");
		
		//상세보기 - 판매자 정보 뽑아오기
		SellerDAO sellerdao = new SellerDAO();
		SellerBean seller = sellerdao.seller_select(seller_id); 
		
		// 해당 판매자가 등록한 가게 뽑아오기
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreList(seller.getSeller_id());
		
		// 해당 판매자가 등록한 가게의 이벤트 뽑아오기
		/*EventDAO eventdao = new EventDAO();
		List<EventBean> eventdate = new ArrayList<EventBean>();
		eventdate = eventdao.event_select(seller.getSeller_id());*/
		
		request.setAttribute("seller",seller);
		request.setAttribute("storelist", storelist);
		
		forward.setPath("3mypage_admin/admin_mypage_sellerdetail.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

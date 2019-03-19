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
		
		//�󼼺��� - �Ǹ��� ���� �̾ƿ���
		SellerDAO sellerdao = new SellerDAO();
		SellerBean seller = sellerdao.seller_select(seller_id); 
		
		// �ش� �Ǹ��ڰ� ����� ���� �̾ƿ���
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreList(seller.getSeller_id());
		
		// �ش� �Ǹ��ڰ� ����� ������ �̺�Ʈ �̾ƿ���
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

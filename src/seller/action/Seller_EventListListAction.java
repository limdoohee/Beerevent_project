package seller.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import store.db.*;
import event.db.*;


public class Seller_EventListListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		StoreDAO storedao = new StoreDAO();
		List<StoreBean> storelist = new ArrayList<StoreBean>();
		storelist = storedao.getStoreList(session.getAttribute("id").toString());
		
		EventDAO eventdao = new EventDAO();
		List<EventBean> eventlist = new ArrayList<EventBean>();
		eventlist = eventdao.getEventList(session.getAttribute("id").toString());
		
		request.setAttribute("storelist", storelist);
		request.setAttribute("eventlist", eventlist);
		forward.setPath("5mypage_seller/seller_event_list.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

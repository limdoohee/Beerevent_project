package event.action;

import javax.servlet.http.*;
import store.db.*;

public class Event_Storeview_Action implements Action {

	@Override
	public ActionForward execute
	(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		request.setCharacterEncoding("utf-8");
		
		int store_no = Integer.parseInt(request.getParameter("store_no"));
		
		StoreDAO storedao = new StoreDAO();
		StoreBean store = storedao.getStore(store_no);
		
		if(store == null ) {
			System.out.println("가게 정보 보기 실패");
			System.out.println("-----------------------------------------");
			return null;
		}
		System.out.println("가게 정보 보기 성공");
		System.out.println("-----------------------------------------");
		
		
		ActionForward forward = new ActionForward();
		request.setAttribute("store", store);
		
		forward.setRedirect(false);
		forward.setPath("2event/event_to_store.jsp");
		return forward;
		
	}
}

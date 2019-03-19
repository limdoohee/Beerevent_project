package member.action;


import javax.servlet.http.*;

import event.db.*;


public class Mem_EventOrderPage_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		/*String mem_id = session.getAttribute("id").toString();*/
		
		//이벤트 번호, 이벤트 이름, 이벤트 날짜, 이벤트 가격
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		String event_spot = request.getParameter("event_spot");
		String event_categ = request.getParameter("event_categ");
		String event_name = request.getParameter("event_name");
		String event_file = request.getParameter("event_file");
		String event_description = request.getParameter("event_description");
		String event_price = request.getParameter("event_price");
		int edate_unique_no = Integer.parseInt(request.getParameter("e_date"));
		System.out.println(event_file);
		EventDAO edao = new EventDAO();
		String edate_date = edao.getSelectedEventDate(edate_unique_no);
		
		request.setAttribute("event_no", event_no);
		request.setAttribute("event_spot", event_spot);
		request.setAttribute("event_categ", event_categ);
		request.setAttribute("event_description", event_description);
		request.setAttribute("event_name", event_name);
		request.setAttribute("event_file", event_file);
		request.setAttribute("event_price", event_price);
		request.setAttribute("edate_unique_no", edate_unique_no);
		request.setAttribute("edate_date", edate_date);
		
		forward.setPath("7order/Mem_order.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

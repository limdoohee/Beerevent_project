package member.action;

import java.util.*;
import javax.servlet.http.*;

import event.db.EventBean;
import member.db.*;

public class Mem_myOrderList_Action implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		String mem_id = session.getAttribute("id").toString();
		
		MemberDAO memdao = new MemberDAO();
		
		List<PaymentBean> paymentlist = new ArrayList<PaymentBean>();
		paymentlist = memdao.getPaymentList(mem_id);
		
		List<EventBean> eventlist = new ArrayList<EventBean>();
		eventlist = memdao.getPaymentEventList(mem_id);
		
		request.setAttribute("paymentlist", paymentlist);
		request.setAttribute("eventlist", eventlist);
		
		forward.setPath("4mypage_member/member_mypage_order.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}

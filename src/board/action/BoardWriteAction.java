package board.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
import board.db.*;
import event.db.EventBean;
import member.db.MemberDAO;
import member.db.PaymentBean;

public class BoardWriteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardDao board_dao = new BoardDao();
		ActionForward action_forward = new ActionForward();
		
		HttpSession session = request.getSession();
		String login_id = session.getAttribute("id").toString();
		
		MemberDAO memdao = new MemberDAO();
		List<PaymentBean> paymentlist = new ArrayList<PaymentBean>();
		
		paymentlist = memdao.getPaymentList(login_id);
		
		
		List<EventBean> eventnamelist = new ArrayList<EventBean>();
		eventnamelist = board_dao.getEventName();
		
		if(eventnamelist == null) {
			System.out.println("event_no receiving failure");
			return null;
		}
		System.out.println("event_no received");
		
		request.setAttribute("paymentlist", paymentlist);
		request.setAttribute("eventnamelist", eventnamelist);
		action_forward.setRedirect(false);
		action_forward.setPath("6board/board_write.jsp");
		return action_forward;
	}

}

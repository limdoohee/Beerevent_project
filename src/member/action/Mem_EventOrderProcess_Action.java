package member.action;


import java.io.PrintWriter;

import javax.servlet.http.*;

import event.db.*;
import member.db.*;


public class Mem_EventOrderProcess_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		
		//fk값 가져오기
		String mem_id = session.getAttribute("id").toString();
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		int edate_unique_no = Integer.parseInt(request.getParameter("edate_unique_no"));
		//pk는 숫자계산해서 가져오고, 날짜는 sysdate
		int event_price = Integer.parseInt(request.getParameter("event_price"));
		
		String pay_card_name = request.getParameter("pay_card_name");
		String pay_card_no = request.getParameter("pay_card_no");
		String pay_card_cvc = request.getParameter("pay_card_cvc");
		String pay_account_no = request.getParameter("pay_account_no");
		String pay_account_pass = request.getParameter("pay_account_pass");
		String pay_deposit_name = request.getParameter("pay_deposit_name");
		
		int pay_yesorno = 1;
		
		if( !pay_deposit_name.equals("") && !pay_deposit_name.equals(null)) {
			pay_yesorno = 0;
		}
		
		PaymentBean payment = new PaymentBean();
		payment.setPay_price(event_price);
		payment.setPay_yesorno(pay_yesorno);
		payment.setPay_card_name(pay_card_name);
		payment.setPay_card_no(pay_card_no);
		payment.setPay_card_cvc(pay_card_cvc);
		payment.setPay_account_no(pay_account_no);
		payment.setPay_account_pass(pay_account_pass);
		payment.setPay_deposit_name(pay_deposit_name);
		payment.setEdate_unique_no(edate_unique_no);
		payment.setEvent_no(event_no);
		payment.setMem_id(mem_id);
		
		MemberDAO memdao = new MemberDAO();
		memdao.insert_payment(payment);
		
		// 등록하면서 해당 이벤트 정원에 +1
		EventDAO eventdao = new EventDAO();
		eventdao.updatenumofpp(payment.getEdate_unique_no());
		
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println(" alert('결제가 완료되었습니다.'); location.href='myOrderList.member'; ");
		out.println("</script>");
		
		return null;
	}

}

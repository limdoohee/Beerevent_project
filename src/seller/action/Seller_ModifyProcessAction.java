package seller.action;

import java.io.PrintWriter;

import javax.servlet.http.*;

import seller.db.*;


public class Seller_ModifyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String seller_id = session.getAttribute("id").toString();
		String seller_pass = request.getParameter("seller_pass");
		
		String seller_phone1 = request.getParameter("seller_phone1");
		String seller_phone2 = request.getParameter("seller_phone2");
		String seller_phone3 = request.getParameter("seller_phone3");
		String seller_phone=seller_phone1+"-"+seller_phone2+"-"+seller_phone3;
		
		String seller_email1 = request.getParameter("seller_email1");
		String seller_email2 = request.getParameter("seller_email2");
		String seller_email = seller_email1+"@"+seller_email2;
		
		SellerBean seller = new SellerBean();
		seller.setSeller_id(seller_id);;
		seller.setSeller_pass(seller_pass);;
		seller.setSeller_phone(seller_phone);;
		seller.setSeller_email(seller_email);;
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		SellerDAO sellerdao = new SellerDAO();
		int result= sellerdao.updateSeller(seller);
		
		out.println("<script>");
		if(result == 1) {
			out.println(" alert('정보가 수정되었습니다.'); location.href='sellerModify.seller'; ");
		} else if (result == -1) {
			out.println(" alert('데이터 수정 중 오류가 발생했습니다.'); history.back(); ");
		}
		out.println("</script>");
		
		
		return null;
	}

}

package loginjoin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.MemberDAO;
import seller.db.SellerBean;

public class Join_Seller_ProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String seller_id = request.getParameter("seller_id");
		String seller_pass = request.getParameter("seller_pass");
		String seller_name = request.getParameter("seller_name");
		String seller_jumin = (request.getParameter("seller_jumin1")+"-"+request.getParameter("seller_jumin2"));
		String seller_phone = (request.getParameter("seller_phone1")+"-"+
													request.getParameter("seller_phone2")+"-"+
													request.getParameter("seller_phone3"));
		String seller_email = (request.getParameter("seller_email")+"@"+request.getParameter("seller_domain"));
		String seller_bs_no = (request.getParameter("bsno1")+"-"+request.getParameter("bsno2")+"-"+request.getParameter("bsno3"));
		
		SellerBean s = new SellerBean();
		s.setSeller_id(seller_id);
		s.setSeller_pass(seller_pass);
		s.setSeller_name(seller_name);
		s.setSeller_jumin(seller_jumin);
		s.setSeller_phone(seller_phone);
		s.setSeller_email(seller_email);
		s.setSeller_bs_no(seller_bs_no);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO mdao = new MemberDAO();
		int isid = mdao.seller_login(seller_id,seller_pass);
		
		if(isid!=-1) {
			out.println("<script>");
			out.println("alert('등록된 아이디가 있습니다.');");
			out.println("history.back()");
			out.println("</script>");
			} else {
			System.out.println(seller_id);
			System.out.println(seller_pass);
			System.out.println(seller_name);
			System.out.println(seller_jumin);
			System.out.println(seller_phone);
			System.out.println(seller_email);
			System.out.println(seller_bs_no);
			int result = mdao.insert_seller(s);
			out.println("<script>");
			if(result == 1) {
			out.println("alert('회원가입을 축하합니다')");
			out.println("location.href='./login.net';");
			} else if (result == -1) {
			out.println("alert('데이터 삽입 중 오류가 발생했습니다');");
			out.println("history.back()");	// 비밀번호를 제외한 다른 데이터 유지
									// location.href ="" 새로고침되어 전부 삭제
			}
			out.println("</script>");
			}
			return null;
		}
	}

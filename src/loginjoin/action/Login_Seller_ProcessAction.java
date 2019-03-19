package loginjoin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberDAO;


public class Login_Seller_ProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		String seller_id = request.getParameter("id");
		String seller_pass = request.getParameter("pass");

		MemberDAO mdao = new MemberDAO();
		int result = mdao.seller_login(seller_id, seller_pass);
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result==1) {
			HttpSession session = request.getSession();
			// �α��� ����
			session.setAttribute("id", seller_id);
			if(seller_id.equals("admin")) {
				session.setAttribute("login_type", "admin");
			} else {
				session.setAttribute("login_type", "seller");
			}
			forward.setRedirect(false);
			forward.setPath("/search.event");
			return forward;
		} else {
			String message="";
			if(result==-1) 
				message = "���̵� ã�� ���߽��ϴ�.";
			else 
				message = "��й�ȣ�� ��ġ���� �ʽ��ϴ�.";
				
			out.println("<script>");
			out.println("alert('"+message+"');");
			out.println("location.href='login.net';");
			out.println("</script>");
			out.close();
			return null;
		}	//else
	}

}

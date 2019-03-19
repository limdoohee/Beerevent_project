package member.action;

import java.io.PrintWriter;

import javax.servlet.http.*;

import member.db.*;


public class Mem_ModifyProcessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		request.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mem_id ="";
		if (session.getAttribute("login_type").equals("member")) {
			mem_id = (String)session.getAttribute("id").toString();
		} else if (session.getAttribute("login_type").equals("admin")) {
			mem_id = request.getParameter("mem_id");
		}
		String mem_pass = request.getParameter("mem_pass");
		
		String mem_phone1 = request.getParameter("mem_phone1");
		String mem_phone2 = request.getParameter("mem_phone2");
		String mem_phone3 = request.getParameter("mem_phone3");
		String mem_phone=mem_phone1+"-"+mem_phone2+"-"+mem_phone3;
		
		String mem_email1 = request.getParameter("mem_email");
		String mem_domain = request.getParameter("mem_domain");
		String mem_email = mem_email1+"@"+mem_domain;
		
		MemberBean member = new MemberBean();
		member.setMem_id(mem_id);
		member.setMem_pass(mem_pass);
		member.setMem_phone(mem_phone);
		member.setMem_email(mem_email);
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO mdao = new MemberDAO();
		int result= mdao.updateMember(member);
		
			if(session.getAttribute("login_type").equals("member")) {
				out.println("<script>");
				if(result == 1) {
					out.println(" alert('정보가 수정되었습니다.'); location.href='mypageModify.member'; ");
				} else if (result == -1) {
					out.println(" alert('데이터 수정 중 오류가 발생했습니다.'); history.back(); ");
				}
				out.println("</script>");
			}
			else if (session.getAttribute("login_type").equals("admin")) {
				out.println("<script>");
				if(result == 1) {
					out.println(" alert('정보가 수정되었습니다.'); location.href='member.admin'; ");
				} else if (result == -1) {
					out.println(" alert('데이터 수정 중 오류가 발생했습니다.'); history.back(); ");
				}
				out.println("</script>");
			}
		
		
		return null;
	}

}

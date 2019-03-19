package loginjoin.action;

import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.*;


public class Join_Member_ProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request,
            											HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("mem_id");
		String mem_pass = request.getParameter("mem_id");
		String mem_name = request.getParameter("mem_name");
		String mem_jumin = (request.getParameter("mem_jumin1")+"-"+request.getParameter("mem_jumin2"));
		String mem_phone = (request.getParameter("mem_phone1")+"-"+
													request.getParameter("mem_phone2")+"-"+
													request.getParameter("mem_phone3"));
		String mem_email = (request.getParameter("mem_email")+"@"+request.getParameter("mem_domain"));
		
		MemberBean m = new MemberBean();
		m.setMem_id(mem_id);
		m.setMem_pass(mem_pass);
		m.setMem_name(mem_name);
		m.setMem_jumin(mem_jumin);
		m.setMem_phone(mem_phone);
		m.setMem_email(mem_email);
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MemberDAO mdao = new MemberDAO();
		int isid = mdao.member_login(mem_id,mem_pass);
		
		if(isid!=-1) {
			out.println("<script>");
			out.println("alert('등록된 아이디가 있습니다.');");
			out.println("history.back()");
			out.println("</script>");
		} else {
			int result = mdao.insert_member(m);
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

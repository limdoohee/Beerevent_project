package loginjoin.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.*;

public class Login_Member_ProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward=new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		String mem_id = request.getParameter("id");
		String mem_pass = request.getParameter("pass");

		MemberDAO mdao = new MemberDAO();
		int result = mdao.member_login(mem_id, mem_pass);
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		if(result==1) {
			HttpSession session = request.getSession();
			// 로그인 성공
			session.setAttribute("id", mem_id);
			if(mem_id.equals("admin")) {
				session.setAttribute("login_type", "admin");
			} else {
				session.setAttribute("login_type", "member");
			}
			forward.setRedirect(false);
			forward.setPath("/search.event");
			return forward;
		} else {
			String message="";
			if(result==-1) 
				message = "아이디를 찾지 못했습니다.";
			else 
				message = "비밀번호가 일치하지 않습니다.";
				
			out.println("<script>");
			out.println("alert('"+message+"');");
			out.println("location.href='login.net';");
			out.println("</script>");
			out.close();
			return null;
		}	//else
	}

}

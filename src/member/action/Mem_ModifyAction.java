package member.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.db.MemberBean;
import member.db.MemberDAO;

public class Mem_ModifyAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		String mem_id ="";
		if (session.getAttribute("login_type").equals("member")) {
			mem_id = (String)session.getAttribute("id");
		} else if (session.getAttribute("login_type").equals("admin")) {
			mem_id = request.getParameter("mem_id");
		}
		System.out.println("¡Ú id = " + mem_id);
		MemberDAO memberdao = new MemberDAO();
		MemberBean member = new MemberBean();
		member = memberdao.getMember(mem_id);
		
		forward.setPath("4mypage_member/member_mypage_modify.jsp");
		forward.setRedirect(false);
		request.setAttribute("meminfo", member);
		return forward;
	}

}

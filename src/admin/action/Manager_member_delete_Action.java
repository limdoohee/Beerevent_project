package admin.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.MemberDAO;

public class Manager_member_delete_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String mem_id = request.getParameter("mem_id");
		
		MemberDAO memdao = new MemberDAO();
		memdao.deleteMember(mem_id);
		
		forward.setRedirect(false);
		if(request.getParameter("state")!=null) {
			forward.setPath("3mypage_admin/admin_mypage_memlist_ajax2.jsp");
			System.out.println("Ajax working");
		}else {
			forward.setPath("3mypage_admin/admin_mypage_memlist.jsp");
		}
		return forward;
	}

}

package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.db.*;


public class Manager_mem_List_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		MemberDAO memdao = new MemberDAO();
		List<MemberBean> memlist = new ArrayList<MemberBean>();
		memlist = memdao.getMemList();
		
		request.setAttribute("memlist", memlist);
		forward.setPath("3mypage_admin/admin_mypage_memlist.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}

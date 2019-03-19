package member.action;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;

import member.db.*;

public class Mem_Addbookmark_Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		String mem_id = session.getAttribute("id").toString();
		int event_no = Integer.parseInt(request.getParameter("event_no"));
		System.out.println("event_no = "+event_no);
		
		// 로그인한 회원의 찜목록에 추가
		MemberDAO memdao = new MemberDAO();
		memdao.addBookmark(mem_id, event_no);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println(" alert('찜목록에 추가되었습니다. 찜 목록은 마이페이지에서 확인할 수 있습니다.'); ");
		out.println(" location.href='EventDetail.event?event_no="+event_no+"'; ");
		out.println("</script>");
		
		return null;
	}

}

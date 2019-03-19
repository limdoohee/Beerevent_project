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
		
		// �α����� ȸ���� ���Ͽ� �߰�
		MemberDAO memdao = new MemberDAO();
		memdao.addBookmark(mem_id, event_no);
		
		
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println("<script>");
		out.println(" alert('���Ͽ� �߰��Ǿ����ϴ�. �� ����� �������������� Ȯ���� �� �ֽ��ϴ�.'); ");
		out.println(" location.href='EventDetail.event?event_no="+event_no+"'; ");
		out.println("</script>");
		
		return null;
	}

}

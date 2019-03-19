//Ż��

package member.action;

import java.io.PrintWriter;
import javax.servlet.http.*;

import member.db.*;

public class Mem_DeleteAction implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request,
								 HttpServletResponse response) throws Exception {
		
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");

		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		
			MemberDAO mdao = new MemberDAO();
			int result = mdao.deleteMember(id);
			if(result == 1) {
				HttpSession session = request.getSession();
				session.invalidate();
				out.println("<script> alert('Ż��Ǿ����ϴ�.'); location.href='search.event'; </script>");
				out.close();
			} else if (result == -1) {
				out.println("<script> alert('Ż��ó�� �� ������ �߻��߽��ϴ�.'); history.back();</script> ");
			}
			
		return null;
	}
}
package board.action;

import javax.servlet.http.*;

public class LoginProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			ActionForward forward = new ActionForward();
			request.setCharacterEncoding("utf-8");
			
			String id = "mem1";
			String pass = "1";
			
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			session.setAttribute("login_type", "member");
			forward.setRedirect(false);
			forward.setPath("BoardList.board");
			
			return forward;			
		}
	}

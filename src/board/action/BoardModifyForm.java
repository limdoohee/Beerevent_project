package board.action;

import javax.servlet.http.*;
import board.db.*;

public class BoardModifyForm implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		ActionForward action_forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		BoardDao board_dao = new BoardDao();
		BoardBean board_bean = new BoardBean();
		
		int no = Integer.parseInt(request.getParameter("no"));
		board_bean = board_dao.getDetail(no);
		
		if(board_bean==null) {
			System.out.println("edited board view failure");
			return null;
		}
		System.out.println("edited board view success");
		
		request.setAttribute("board_bean", board_bean);
		action_forward.setRedirect(false);
		action_forward.setPath("6board/board_modify_form.jsp");
		return action_forward;
		
	}
}

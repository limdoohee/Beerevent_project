package board.action;
import javax.servlet.http.*;
import board.db.*;

public class ReplyDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception{
		request.setCharacterEncoding("utf-8");
		boolean result = false;
		
		BoardDao board_dao = new BoardDao();
		ActionForward action_forward = new ActionForward();

		
		int reply_no = Integer.parseInt(request.getParameter("reply_no"));
			/*System.out.println(request.getParameter("reply_no"));*/
		result = board_dao.replyDelete(reply_no);
		if(result==false) {
			System.out.println("reply deleting error");
			return null;
		}
		System.out.println("reply deleted");
		
		action_forward.setRedirect(false);
		if(request.getParameter("state")!=null) {
			action_forward.setPath("6board/board_detail_view2.jsp");
			System.out.println("Ajax working");
		}else {
			action_forward.setPath("6board/board_detail_view.jsp");
		}
		return action_forward;
	}
}

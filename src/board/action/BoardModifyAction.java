package board.action;
import javax.servlet.http.*;
import board.db.*;

public class BoardModifyAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		ActionForward action_forward = new ActionForward();
		boolean result = false;
		
		int no = Integer.parseInt(request.getParameter("no"));
			System.out.println(request.getParameter("no"));
		BoardDao board_dao = new BoardDao();
		BoardBean board_bean = new BoardBean();
		
		board_bean.setBoard_no(no);
		board_bean.setBoard_title(request.getParameter("board_title"));
		board_bean.setBoard_content(request.getParameter("board_content"));	
		result = board_dao.boardModify(board_bean);
		
		if(result == false) {
			System.out.println("board editing failure");
			return null;
		}
		
		System.out.println("board edited");
		
		action_forward.setRedirect(true);
		action_forward.setPath("./BoardDetailAction.board?no=" + board_bean.getBoard_no());
		return action_forward;
	}

}
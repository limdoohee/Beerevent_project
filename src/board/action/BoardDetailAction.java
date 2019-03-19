package board.action;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.*;
import board.db.*;

public class BoardDetailAction implements Action{

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardDao board_dao = new BoardDao();
		BoardBean board_bean = new BoardBean();
		List<ReplyBean> reply_bean_list = new ArrayList<ReplyBean>();
		
		request.setCharacterEncoding("utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		board_dao.setReadCountUpdate(no);	//�닔�젙 �썑 �떎�떆蹂닿린�븣�?�?
		board_bean=board_dao.getDetail(no);
		
		if(board_bean == null) {
			System.out.println("board detail view failure");
			return null;
		}
		System.out.println("board detail view success");
				
		request.setAttribute("board_bean",board_bean);
		
	
		reply_bean_list=board_dao.getReplyListBoard(no);
		
		request.setAttribute("reply_bean_list", reply_bean_list);
		
		ActionForward action_forward = new ActionForward();
		action_forward.setRedirect(false);
		action_forward.setPath("6board/board_detail_view.jsp");
		
		return action_forward;
	}
}

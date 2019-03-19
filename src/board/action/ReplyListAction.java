package board.action;
import java.util.*;
import javax.servlet.http.*;
import board.db.*;

public class ReplyListAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		BoardDao board_dao = new BoardDao();
		ReplyBean reply_bean = new ReplyBean();
		List<ReplyBean> reply_bean_list = new ArrayList<ReplyBean>();
		ActionForward action_forward = new ActionForward();
		boolean result = false;
		
			/*System.out.println("error check 12454: "+request.getParameter("board_no"));*/
		reply_bean.setBoard_no(Integer.parseInt(request.getParameter("board_no")));
		reply_bean.setReply_content(request.getParameter("reply_content"));
		reply_bean.setMem_id(request.getParameter("mem_id"));
			/*System.out.println("error check mem_id: "+request.getParameter("mem_id"));*/
		
		result = board_dao.replyInsert(reply_bean);
		
		if(result == false) {
			System.out.println("reply result false");
			return null;
		}
		
		System.out.println("reply added");
				
		
		reply_bean_list=board_dao.getReplyListBoard(Integer.parseInt(request.getParameter("board_no")));
		
		request.setAttribute("reply_bean_list", reply_bean_list);
		
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
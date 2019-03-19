package board.action;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import board.db.*;

public  class BoardAddAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao board_dao = new BoardDao();
		BoardBean board_bean = new BoardBean();
		ActionForward action_forward = new ActionForward();
		HttpSession session = request.getSession();
		System.out.println("BoardAddAction_id="+session.getAttribute("id"));
		
		String realFolder="";
		
		String saveFolder = "upload/board";
		
		int fileSize = 5*1024*1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		
		System.out.println("realFolder= " + realFolder);
		boolean result = false;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
			
			board_bean.setBoard_title(multi.getParameter("board_title"));
			board_bean.setBoard_content(multi.getParameter("board_content"));
			board_bean.setBoard_file(
					multi.getFilesystemName((String)multi.getFileNames().nextElement()));
				System.out.println("file name占�?占� 占쏙옙?占쎄쉐 揶쏉옙= " + multi.getFileNames().nextElement());
			
			board_bean.setBoard_readcount(0);
			board_bean.setMem_id((String)session.getAttribute("id"));
			board_bean.setEvent_no(Integer.parseInt(multi.getParameter("event_no")));			
			result = board_dao.boardInsert(board_bean);
			
			if(result == false) {
				System.out.println("board adding failure");
				return null;
			}
			System.out.println("board added");
			System.out.println(board_bean.getBoard_readcount());
			action_forward.setRedirect(true);
			action_forward.setPath("./BoardList.board");
			return action_forward;
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return null;
	}
}

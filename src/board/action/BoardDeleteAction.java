package board.action;
import java.io.PrintWriter;
import javax.servlet.http.*;
import board.db.*;

public class BoardDeleteAction implements Action{
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8");
		boolean result = false;
		
		int no = Integer.parseInt(request.getParameter("no"));
		BoardDao board_dao = new BoardDao();
		
		board_dao.boardReplyDelete(no);
		System.out.println("boardReply deleted");
		
		result = board_dao.boardDelete(no);
		if(result==false) {
			System.out.println("board deleting failure");
			return null;
		}
		System.out.println("board deleted");
		
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script>");
		out.println("alert('삭제되었습니다.')");
		out.println("location.href='BoardList.board'");
		out.println("</script>");
		out.close();
		return null;		
	}
}

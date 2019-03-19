package board.action;

import java.util.*;
import javax.servlet.http.*;
import board.db.*;

public class BoardListAction implements Action {

	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		BoardDao board_dao = new BoardDao();
		List<BoardBean> board_bean_list = new ArrayList<BoardBean>();
			
		int page=1;
		int limit=10;
		
			
		if(request.getParameter("page")!=null) {
			page=Integer.parseInt(request.getParameter("page"));
		}
		System.out.println("page= " + page);
			
		HttpSession session = request.getSession();
		if(session.getAttribute("limit") != null) {
			limit = Integer.parseInt(session.getAttribute("limit").toString());
		}
		if(request.getParameter("limit") != null) {	
			limit = Integer.parseInt(request.getParameter("limit"));
			session.setAttribute("limit", limit);
			System.out.println("limit= " + limit);
		}
		
		int list_total_count = board_dao.getListCount();
		board_bean_list=board_dao.getBoardList(page,limit);
		

		int maxpage=(list_total_count + limit-1)/limit;
		System.out.println("list_total_count= " + maxpage);
		
		int startpage = ((page-1)/10)*10 +1;
		System.out.println("startpage= " + startpage);
		
		int endpage = startpage + 10 -1;
		System.out.println("endpage= " + endpage);
		
		if(endpage>maxpage) endpage=maxpage;
		request.setAttribute("page", page);
		request.setAttribute("maxpage", maxpage);
		request.setAttribute("startpage", startpage);
		request.setAttribute("endpage", endpage);
		request.setAttribute("list_total_count", list_total_count);
		request.setAttribute("board_bean_list", board_bean_list);
		request.setAttribute("limit", limit);
		
		
		ActionForward action_forward = new ActionForward();
		action_forward.setRedirect(false);
		
		if(request.getParameter("state") != null) {
			action_forward.setPath("6board/board_list2.jsp");
			System.out.println("Ajax working");
		}else
			action_forward.setPath("6board/board_list.jsp");

		return action_forward;
	}	
	
	}

	

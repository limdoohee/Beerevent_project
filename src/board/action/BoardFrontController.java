package board.action;
import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("*.board")
public class BoardFrontController extends javax.servlet.http.HttpServlet{

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String RequestURI=request.getRequestURI();
		System.out.println("RequestURI= " + RequestURI);
		
		String contextPath=request.getContextPath();
		System.out.println("contextPath= " + contextPath);
		
		String command=RequestURI.substring(contextPath.length());
		System.out.println("command= " + command);
		
		HttpSession session = request.getSession();
		System.out.println("id="+session.getAttribute("id"));	
		System.out.println("login_type="+session.getAttribute("login_type"));	
		ActionForward action_forward=null;
		Action action=null;
		
				if(command.equals("/BoardList.board")) {
					action = new BoardListAction();
					try {
						action_forward = action.execute(request, response);				
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/BoardWrite.board")) {
					action = new BoardWriteAction();
					try {
						action_forward=action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				else if(command.equals("/BoardAddAction.board")) {
					action = new BoardAddAction();
					try {
						action_forward=action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/BoardDetailAction.board")) {
					action = new BoardDetailAction();
					try {
						action_forward=action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/BoardModifyAction.board")) {
					action=new BoardModifyAction();
					try {
						action_forward=action.execute(request,response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/BoardModifyForm.board")) {
					action = new BoardModifyForm();
					try {
						action_forward=action.execute(request, response);
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/BoardDeleteAction.board")) {
					action=new BoardDeleteAction();
					try {
						action_forward=action.execute(request, response);					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/ReplyList.board")) {
					action = new ReplyListAction();
					try {
						action_forward = action.execute(request, response);				
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/ReplyDeleteAction.board")) {
					action = new ReplyDeleteAction();
					try {
						action_forward=action.execute(request, response);					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else if(command.equals("/MemberBoardList.board")) {
					action = new MemberBoardListAction();
					try {
						action_forward=action.execute(request, response);					
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
				
				if(action_forward != null) {
					if(action_forward.isRedirect()) {
						response.sendRedirect(action_forward.getPath());
					}else {
						RequestDispatcher dispatcher = request.getRequestDispatcher(action_forward.getPath());
							dispatcher.forward(request, response);
					}
				}
				
	}
				
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			doProcess(request, response);
		}
	
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
			doProcess(request, response);
		}
}

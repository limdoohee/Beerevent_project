package member.action;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("*.member")
public class FrontController extends javax.servlet.http.HttpServlet {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doProcess(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		/*
		 	요청된 전체 URL중에서 포트 번호 다음 부터 마지막 문자열까지 반환됩니다.
		 	예) http://localhost:8088/JspProject/login.net 인 경우
		 		"/JspProject/login.net" 반환됩니다.
		 */
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println("RequestURI = "+RequestURI);
		System.out.println("contextPath = "+contextPath);
		System.out.println("command = "+command);
		System.out.println("------------------------------------------------");
		
		// 초기화
		ActionForward forward = null;
		Action action = null;
		
		
		// ???
		if(command.equals("/login.member")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("member/login.jsp");
		}
		// ???
		else if(command.equals("/join.member")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("member/join.jsp");
		}
		// ???
		else if(command.equals("/main.member")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("member/main.jsp");
		}
		// 일반회원 정보 수정 페이지로 이동
		else if(command.equals("/mypageModify.member")) {
			action = new Mem_ModifyAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}// 일반회원 정보 수정 프로세스
		} else if(command.equals("/Mem_ModifyProcess.member")) { 
			action = new Mem_ModifyProcessAction(); //수정하기버튼
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//일반회원 탈퇴
		else if(command.equals("/Mem_DeletProcess.member")) {
				action = new Mem_DeleteAction(); //탈퇴하기버튼
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		//마이페이지 - 찜목록 보기
		else if(command.equals("/bookmark.member")) {
			action = new Mem_bookmarkPage_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//마이페이지 - 내가 주문한 내역
		else if(command.equals("/myOrderList.member")) {
			action = new Mem_myOrderList_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//이벤트 상세보기 - 찜 버튼 눌렀을 때
		else if(command.equals("/addBookmark.member")) {
			action = new Mem_Addbookmark_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//결제 - 바로구매 눌렀을 때
		else if(command.equals("/eventOrder.member")) {
			action = new Mem_EventOrderPage_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//결제 - 결제 처리
		else if(command.equals("/orderProcess.member")) {
			action = new Mem_EventOrderProcess_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(command.equals("/DeleteAll.member")) {
			action = new DeleteAll();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/BookmarkDeleteAction.member")) {
			action = new BookmarkDeleteAction();
			try {
				forward = action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
			
			
		//경로지정 이동
		if(forward != null) {
			if(forward.isRedirect()) { //redirect값이 true일때 = 주소값 그대로 넘어갈 때
				response.sendRedirect(forward.getPath());
			}else { //dispatcher방식(?) = 요청주소에 결과값자체를 보내서 주소값은 요청주소 그대로
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
	}
	
	
	
	protected void doGet (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}
	protected void doPost (HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request,response);
	}
}

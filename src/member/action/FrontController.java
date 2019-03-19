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
		 	��û�� ��ü URL�߿��� ��Ʈ ��ȣ ���� ���� ������ ���ڿ����� ��ȯ�˴ϴ�.
		 	��) http://localhost:8088/JspProject/login.net �� ���
		 		"/JspProject/login.net" ��ȯ�˴ϴ�.
		 */
		String RequestURI = request.getRequestURI();
		String contextPath = request.getContextPath();
		String command = RequestURI.substring(contextPath.length());
		System.out.println("RequestURI = "+RequestURI);
		System.out.println("contextPath = "+contextPath);
		System.out.println("command = "+command);
		System.out.println("------------------------------------------------");
		
		// �ʱ�ȭ
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
		// �Ϲ�ȸ�� ���� ���� �������� �̵�
		else if(command.equals("/mypageModify.member")) {
			action = new Mem_ModifyAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}// �Ϲ�ȸ�� ���� ���� ���μ���
		} else if(command.equals("/Mem_ModifyProcess.member")) { 
			action = new Mem_ModifyProcessAction(); //�����ϱ��ư
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//�Ϲ�ȸ�� Ż��
		else if(command.equals("/Mem_DeletProcess.member")) {
				action = new Mem_DeleteAction(); //Ż���ϱ��ư
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		}
		//���������� - ���� ����
		else if(command.equals("/bookmark.member")) {
			action = new Mem_bookmarkPage_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//���������� - ���� �ֹ��� ����
		else if(command.equals("/myOrderList.member")) {
			action = new Mem_myOrderList_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//�̺�Ʈ �󼼺��� - �� ��ư ������ ��
		else if(command.equals("/addBookmark.member")) {
			action = new Mem_Addbookmark_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//���� - �ٷα��� ������ ��
		else if(command.equals("/eventOrder.member")) {
			action = new Mem_EventOrderPage_Action();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		//���� - ���� ó��
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
			
			
		//������� �̵�
		if(forward != null) {
			if(forward.isRedirect()) { //redirect���� true�϶� = �ּҰ� �״�� �Ѿ ��
				response.sendRedirect(forward.getPath());
			}else { //dispatcher���(?) = ��û�ּҿ� �������ü�� ������ �ּҰ��� ��û�ּ� �״��
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

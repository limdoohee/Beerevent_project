package loginjoin.action;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("*.net")
public class FrontController extends HttpServlet  {
	protected void doProcess(HttpServletRequest request,
            HttpServletResponse response) 
            		throws ServletException, IOException {
		String RequestURI=request.getRequestURI();
		System.out.println("RequestURI = " + RequestURI);
		String contextPath=request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		String command=RequestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		System.out.println("------------------------------------------------");
		
		
		ActionForward forward=null;
		Action action=null;
		
		 // �α��� �������� �̵�
		 if (command.equals("/login.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/login.jsp");
		}
		 // �Ϲ�ȸ�� �α���
		else if(command.equals("/login_member.net")) {
			action = new Login_Member_ProcessAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 // �Ǹ���ȸ�� �α���
		else if(command.equals("/login_seller.net")) {
			action = new Login_Seller_ProcessAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 // ȸ�����Լ���
		else if(command.equals("/join_select.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/join_select.jsp");
		}
		 // �Ϲ�ȸ�� ����
		else if(command.equals("/join_member.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/join_member.jsp");
		}else if(command.equals("/join_member_process.net")) {
			action = new Join_Member_ProcessAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 // �Ǹ���ȸ�� ����
		else if(command.equals("/join_seller.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/join_seller.jsp");
		} else if(command.equals("/join_seller_process.net")) {
			action = new Join_Seller_ProcessAction();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 // �α׾ƿ�
		else if(command.equals("/logout.net")) {
			action = new Logout_Action();
			try {
				forward=action.execute(request, response);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		 //������������ �̵� ��, ������/�Ϲ�ȸ��/�Ǹ���ȸ�� ����
		else if(command.equals("/mypagecheck.net")){
			action = new MyPage_check_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		 // sns
		else if(command.equals("/sns.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/sns.jsp");
		}
		 
		 // company
		else if(command.equals("/company.net")) {
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("1index/company.jsp");
		}
		
		if(forward != null){
		    if(forward.isRedirect()){ //�����̷�Ʈ �˴ϴ�.
		    	
			      response.sendRedirect(forward.getPath());
		    }else{//�������˴ϴ�.
		        	RequestDispatcher dispatcher=
				      request.getRequestDispatcher(forward.getPath());
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

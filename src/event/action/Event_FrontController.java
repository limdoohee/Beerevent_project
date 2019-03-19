package event.action;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import admin.action.Manager_Event_Detail_Action;



@WebServlet("*.event")
public class Event_FrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request,
            HttpServletResponse response) 
            		throws ServletException, IOException {
		
		String RequestURI=request.getRequestURI();
		HttpSession session = request.getSession();
		System.out.println("RequestURI = " + RequestURI);
		String contextPath=request.getContextPath();
		System.out.println("contextPath = " + contextPath);
		String command=RequestURI.substring(contextPath.length());
		System.out.println("command = " + command);
		System.out.println("------------------------------------------------");
		System.out.println("�α��� ���̵�  : "+session.getAttribute("id"));
		System.out.println("---> �α��� ����  : "+session.getAttribute("login_type"));
		System.out.println("------------------------------------------------");
		
		
		ActionForward forward=null;
		Action action=null;
		
		/*
		 
		 if(command.equals("/BoardList.bo")){
				action = new BoardListAction();//�������� ���� ��ĳ����
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		 }else if(command.equals("/BoardWrite.bo")){
			forward=new ActionForward();
			forward.setRedirect(false); //������ ������� �ּҰ� �ٲ��� �ʾƿ�
			forward.setPath("./board/qna_board_write.jsp");
		 }
		 
		 
		 */
		if(command.equals("/search.event")){
			forward=new ActionForward();
			forward.setRedirect(false); //������ ������� �ּҰ� �ٲ��� �ʾƿ�
			forward.setPath("./1index/search.jsp");
		} else if(command.equals("/searchResult.event")){
			action = new Event_searchResult_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/EventDetail.event")){
			action = new Event_detail_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/EventStoreView.event")){
			action = new Event_Storeview_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/EventModifyPage.event")){
			action = new Event_modifyPage_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
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
	
	
	
	protected void doGet (HttpServletRequest request, 
            HttpServletResponse response) 
            		throws ServletException, IOException {
		doProcess(request,response);
}  	

protected void doPost (HttpServletRequest request, 
             HttpServletResponse response) 
            		 throws ServletException, IOException {
	doProcess(request,response);
}	

}

package admin.action;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import event.action.*;



@WebServlet("*.admin")
public class Admin_FrontController extends HttpServlet {
	
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

/*		if(command.equals("/search.event")){
			forward=new ActionForward();
			forward.setRedirect(false); //������ ������� �ּҰ� �ٲ��� �ʾƿ�
			forward.setPath("./1index/search.jsp");
		} */
		
		if(command.equals("/member.admin")){
			action = new Manager_mem_List_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/seller.admin")){
			action = new Manager_seller_List_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/event.admin")){
			action = new Manager_Event_List_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/eventDetail.admin")){
			action = new Manager_Event_Detail_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/sellerDetail.admin")){
			action = new Manager_seller_detail_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/AddsellerFromStemp.admin")){
			action = new Manager_seller_temp_approval_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ���������� - �̺�Ʈ ����ȸ - �ֹ��ڸ���Ʈ
		else if(command.equals("/EventOrderList.admin")){
			action = new Manager_Event_Order_List_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ���������� - �Ϲ�ȸ�� ��ȸ - ȸ�� ����
		else if(command.equals("/memberDelete.admin")){
			action = new Manager_member_delete_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ���������� - �Ǹ��� ��ȸ - �Ǹ��� ����
		else if(command.equals("/sellerDelete.admin")){
			action = new Manager_seller_delete_Action();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// ����������- �Ǹ��� ��ȸ - ���δ���� �ź�
		else if(command.equals("/stempDelete.admin")){
			action = new Manager_stemp_delete_Action();//�������� ���� ��ĳ����
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

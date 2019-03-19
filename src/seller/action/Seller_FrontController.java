package seller.action;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;




@WebServlet("*.seller")
public class Seller_FrontController extends HttpServlet {
	
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
		
		// �Ǹ��� ���� ���� ����
		if(command.equals("/sellerModify.seller")){
			action = new Seller_ModifyAction();//�������� ���� ��ĳ����
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			} // �Ǹ��� ���� ���� ���� ���μ���
		} else if(command.equals("/sellerModifyProcess.seller")) { 
			action = new Seller_ModifyProcessAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// �Ǹ��� ���ü ���
		else if(command.equals("/storeRegister.seller")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./5mypage_seller/seller_store_register.jsp");
				// ���ü ��� ���μ���
		} else if(command.equals("/storeWriteProcess.seller")) { 
			action = new Seller_StoreRegisterAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// �Ǹ��� ���ü ��ȸ
		else if(command.equals("/storeList.seller")){
			action = new Seller_StoreListAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// �Ǹ��� �̺�Ʈ ���
		else if(command.equals("/eventRegister.seller")){
			action = new Seller_EventRegisterAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
				// �̺�Ʈ ��� ���μ���
		} else if(command.equals("/eventRegisterProcess.seller")) { 
			action = new Seller_EventRegisterProcessAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// �Ǹ��� �̺�Ʈ ��ȸ
		else if(command.equals("/eventList.seller")){
			action = new Seller_EventListListAction();
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

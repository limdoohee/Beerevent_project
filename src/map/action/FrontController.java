package map.action;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import map.action.Action;
import map.action.ActionForward;

@WebServlet("*.do")
public class FrontController extends javax.servlet.http.HttpServlet {
	protected void doProcess(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
		 String RequestURI=request.getRequestURI();
		 System.out.println("RequestURI = " + RequestURI);
		 
		 String contextPath=request.getContextPath();
		 System.out.println("contextPath = " + contextPath);
		 
		 String command=RequestURI.substring(contextPath.length());
		 System.out.println("command = " + command);
		 
		 ActionForward forward=null;
		 Action action=null;
		 
		if(command.equals("/store_map.do")){
			forward=new ActionForward();
			forward.setRedirect(false); //������ ������� �ּҰ� �ٲ��� �ʾƿ�
			forward.setPath("1index/map.jsp");
		 }
			 
		 if(command.equals("/store_map_list.do")){
				action = new map_list_action();//�������� ���� ��ĳ����
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		 }
		 
		 if(command.equals("/store_map_marker.do")){
				action = new map_marker_action();//�������� ���� ��ĳ����
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
	 
	 //doProcess(request,response)�޼��带 �����Ͽ� ��û�� GET����̵� 
	 //POST������� ���۵Ǿ� ���� ���� �޼��忡�� ��û�� ó���� �� �ֵ��� �Ͽ����ϴ�.
	protected void doGet(HttpServletRequest request, 
			             HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}  	
	
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) 
		throws ServletException, IOException {
		doProcess(request,response);
	}	  	 
}

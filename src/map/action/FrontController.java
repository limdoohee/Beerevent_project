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
			forward.setRedirect(false); //포워딩 방식으로 주소가 바뀌지 않아요
			forward.setPath("1index/map.jsp");
		 }
			 
		 if(command.equals("/store_map_list.do")){
				action = new map_list_action();//다형성에 의한 업캐스팅
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		 }
		 
		 if(command.equals("/store_map_marker.do")){
				action = new map_marker_action();//다형성에 의한 업캐스팅
				try{
					forward=action.execute(request, response); 
				}catch(Exception e){
					e.printStackTrace();
				}
		 }
		 
	 if(forward != null){
		    if(forward.isRedirect()){ //리다이렉트 됩니다.
			      response.sendRedirect(forward.getPath());
		    }else{//포워딩됩니다.
		        	RequestDispatcher dispatcher=
				      request.getRequestDispatcher(forward.getPath());
			        dispatcher.forward(request, response);
		    }
		}
	 }
	 
	 //doProcess(request,response)메서드를 구현하여 요청이 GET방식이든 
	 //POST방식으로 전송되어 오든 같은 메서드에서 요청을 처리할 수 있도록 하였습니다.
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

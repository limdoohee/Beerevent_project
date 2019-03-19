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
			forward.setRedirect(false); //포워딩 방식으로 주소가 바뀌지 않아요
			forward.setPath("./1index/search.jsp");
		} */
		
		if(command.equals("/member.admin")){
			action = new Manager_mem_List_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/seller.admin")){
			action = new Manager_seller_List_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/event.admin")){
			action = new Manager_Event_List_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/eventDetail.admin")){
			action = new Manager_Event_Detail_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/sellerDetail.admin")){
			action = new Manager_seller_detail_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		} else if(command.equals("/AddsellerFromStemp.admin")){
			action = new Manager_seller_temp_approval_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 마이페이지 - 이벤트 상세조회 - 주문자리스트
		else if(command.equals("/EventOrderList.admin")){
			action = new Manager_Event_Order_List_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 마이페이지 - 일반회원 조회 - 회원 삭제
		else if(command.equals("/memberDelete.admin")){
			action = new Manager_member_delete_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 마이페이지 - 판매자 조회 - 판매자 삭제
		else if(command.equals("/sellerDelete.admin")){
			action = new Manager_seller_delete_Action();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 마이페이지- 판매자 조회 - 승인대기자 거부
		else if(command.equals("/stempDelete.admin")){
			action = new Manager_stemp_delete_Action();//다형성에 의한 업캐스팅
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

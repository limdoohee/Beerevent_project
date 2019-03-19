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
			forward.setRedirect(false); //포워딩 방식으로 주소가 바뀌지 않아요
			forward.setPath("./1index/search.jsp");
		} */
		
		// 판매자 개인 정보 수정
		if(command.equals("/sellerModify.seller")){
			action = new Seller_ModifyAction();//다형성에 의한 업캐스팅
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			} // 판매자 개인 정보 수정 프로세스
		} else if(command.equals("/sellerModifyProcess.seller")) { 
			action = new Seller_ModifyProcessAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 판매자 사업체 등록
		else if(command.equals("/storeRegister.seller")){
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./5mypage_seller/seller_store_register.jsp");
				// 사업체 등록 프로세스
		} else if(command.equals("/storeWriteProcess.seller")) { 
			action = new Seller_StoreRegisterAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 판매자 사업체 조회
		else if(command.equals("/storeList.seller")){
			action = new Seller_StoreListAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 판매자 이벤트 등록
		else if(command.equals("/eventRegister.seller")){
			action = new Seller_EventRegisterAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
				// 이벤트 등록 프로세스
		} else if(command.equals("/eventRegisterProcess.seller")) { 
			action = new Seller_EventRegisterProcessAction();
			try{
				forward=action.execute(request, response); 
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		// 판매자 이벤트 조회
		else if(command.equals("/eventList.seller")){
			action = new Seller_EventListListAction();
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

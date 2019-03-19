
package seller.action;
import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import store.db.StoreBean;
import store.db.StoreDAO;

public class Seller_StoreRegisterAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		StoreDAO storedao = new StoreDAO();
		StoreBean store = new StoreBean();
		ActionForward action_forward = new ActionForward();
		HttpSession session = request.getSession();
		System.out.println("seller_id="+session.getAttribute("id"));
		
		String realFolder="";
		
		String saveFolder = "upload/store";
		
		int fileSize = 10*1024*1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		
		System.out.println("realFolder= " + realFolder);
		int result = -1;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
			
			store.setStore_register_no(multi.getParameter("s_register"));
			store.setStore_name(multi.getParameter("s_name"));
			store.setStore_location(multi.getParameter("s_location"));
			String s_menu1 = multi.getParameter("s_menu1");
			String s_money1 = multi.getParameter("s_money1");
			String s_menu2 = multi.getParameter("s_menu2");
			String s_money2 = multi.getParameter("s_money2");
			String s_menu3 = multi.getParameter("s_menu3");
			String s_money3 = multi.getParameter("s_money3");
			String store_menu = s_menu1 +"," + s_money1 +","
							  + s_menu2 +"," + s_money2 +","
							  + s_menu3 +"," + s_money3;
			System.out.println("[가게 등록] 가게 메뉴 : "+store_menu);
			store.setStore_menu(store_menu);
			String[] s_day_array = multi.getParameterValues("s_day");
			String store_dayofweek = "";
			for (int i=0 ; i<s_day_array.length ; i++) {
				if(i!=(s_day_array.length-1))
					store_dayofweek += s_day_array[i]+",";
				else 
					store_dayofweek += s_day_array[i];
			}
			System.out.println("[가게 등록] 휴점요일 : "+store_dayofweek);
			store.setStore_dayofweek(store_dayofweek);
			String s_phone1 = multi.getParameter("s_phone1");
			String s_phone2 = multi.getParameter("s_phone2");
			String s_phone3 = multi.getParameter("s_phone3");
			String store_tel = s_phone1+"-"+s_phone2+"-"+s_phone3;
			store.setStore_tel(store_tel);
			
			
			store.setStore_file(
					multi.getFilesystemName((String)multi.getFileNames().nextElement()));
				System.out.println( multi.getFileNames().nextElement());
			store.setSeller_id((String)session.getAttribute("id"));			
			result= storedao.registerStore(store);
			
			if(result == -1) {
				System.out.println("store adding failure");
				return null;
			}
			System.out.println("store added");
			
			action_forward.setRedirect(true);
			action_forward.setPath("./storeList.seller");
			return action_forward;
		}catch(Exception e) {
			e.printStackTrace();			
		}
		return null;
	}
}

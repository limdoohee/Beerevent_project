package seller.action;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.*;
import javax.servlet.http.*;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import event.db.EventBean;
import event.db.EventDAO;

public class Seller_EventRegisterProcessAction implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		EventDAO eventdao = new EventDAO();
		EventBean event = new EventBean();
		ActionForward action_forward = new ActionForward();
	
		String realFolder="";
		
		String saveFolder = "upload/event";
		
		int fileSize = 10*1024*1024;
		
		ServletContext sc = request.getServletContext();
		realFolder = sc.getRealPath(saveFolder);
		System.out.println("realFolder= " + realFolder);
		int result = -1;
		
		try {
			MultipartRequest multi = null;
			multi = new MultipartRequest(request, realFolder, fileSize, "utf-8", new DefaultFileRenamePolicy());
		
			
			event.setEvent_name(multi.getParameter("name"));
			event.setEvent_categ(multi.getParameter("categ"));
			System.out.println(Integer.parseInt(multi.getParameter("price")));
			event.setEvent_price(Integer.parseInt(multi.getParameter("price")));
			
			String time1 = multi.getParameter("time1");
			String time2 = multi.getParameter("time2");
			String event_time = time1 +"-"+time2;
			event.setEvent_time(event_time);
			event.setEvent_location(multi.getParameter("location"));
			event.setEvent_spot(multi.getParameter("spot"));
			event.setEvent_file(multi.getFilesystemName((String)multi.getFileNames().nextElement()));			
			event.setEvent_description(multi.getParameter("description"));
			event.setStore_no(Integer.parseInt(multi.getParameter("store_no")));
			
			result= eventdao.registerEvent(event);
			
			int event_no = eventdao.get_maxPK("event");
			
			String[] edate_date = multi.getParameterValues("edate_date");
			event.setEvent_no(event_no);
			for(int i=0 ; i < edate_date.length ; i++) {
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = format.parse(edate_date[i]);
				event.setEdate_date(date);
				eventdao.insertEventdate(event);
			}		
			
			if(result == -1) {
				System.out.println("event adding failure");
				return null;
			}
			System.out.println("event added");
			action_forward.setRedirect(true);
			action_forward.setPath("./eventList.seller");
			return action_forward;
			
		}catch(Exception e) {
			e.printStackTrace();			
		}		
			return null;
		}
}
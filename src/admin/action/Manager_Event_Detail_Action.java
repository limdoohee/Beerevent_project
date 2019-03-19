package admin.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.EventBean;
import event.db.EventDAO;
import store.db.StoreBean;
import store.db.StoreDAO;

public class Manager_Event_Detail_Action  implements Action {
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

	ActionForward forward = new ActionForward();
	request.setCharacterEncoding("utf-8");
	
	int event_no = Integer.parseInt(request.getParameter("event_no"));
	
	//���õ� �̺�Ʈ ��������
	EventDAO eventdao = new EventDAO();
	EventBean event = eventdao.event_select(event_no);
	
	// �̺�Ʈ�� ��¥ ����Ʈ ��������
	List<EventBean> eventdate = new ArrayList<EventBean>();
	eventdate = eventdao.getEventDate(event_no);
	
	// �̺�Ʈ�� �����ϴ� ���� �̸� ��������
	StoreDAO storedao = new StoreDAO();
	String store_name = storedao.getStoreName(event.getStore_no());
	System.out.println("store_name : "+store_name);
	
	//�Ǹ��� ���̵� ��������
	storedao = new StoreDAO();
	String seller_id = storedao.getStoreSeller(event.getStore_no());
	System.out.println("seller_id : "+seller_id);
	
	request.setAttribute("event", event);
	request.setAttribute("eventdate", eventdate);
	forward.setPath("3mypage_admin/admin_mypage_eventdetail.jsp?store_name="+store_name+"&seller_id="+seller_id);
	forward.setRedirect(false);
	
	
	return forward;
	}
}

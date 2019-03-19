package event.action;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import event.db.*;

public class Event_searchResult_Action implements Action {
	public ActionForward
	execute(HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		ActionForward forward = new ActionForward();
		request.setCharacterEncoding("utf-8");
		
		String spot = request.getParameter("spot");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String eventType = request.getParameter("eventType");
		
		EventDAO eventdao = new EventDAO();
		List<EventBean> eventlist = new ArrayList<EventBean>();
		List<EventBean> eventdate = new ArrayList<EventBean>();
		
		eventlist = eventdao.getEventList(spot,fromDate,toDate,eventType);
		eventdate = eventdao.getEventDate(spot,fromDate,toDate,eventType);
		
		//이벤트리스트 객체를'eventlist'로 request에 저장
		request.setAttribute("eventlist", eventlist);
		request.setAttribute("eventdate",eventdate);
		
		request.setAttribute("spot",spot);
		request.setAttribute("fromDate",fromDate);
		request.setAttribute("toDate",toDate);
		request.setAttribute("eventType",eventType);
		forward.setRedirect(false);
		forward.setPath("./2event/event_search_result.jsp");
		

		return forward;
	}

}

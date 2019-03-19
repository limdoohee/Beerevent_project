package map.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;

import map.db.MapBean;
import map.db.MapDAO;

public class map_marker_action implements Action {
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MapBean mapbean = new MapBean();
		request.setCharacterEncoding("utf-8");
		
		String store_name = request.getParameter("store_name");
		String store_location = request.getParameter("store_location");
		String store_tel = request.getParameter("store_tel");
		
		mapbean.setStore_name(store_name);
		mapbean.setStore_location(store_location);
		mapbean.setStore_tel(store_tel);
		
		MapDAO dao = new MapDAO();
		JSONArray array = dao.getList(store_name);
		response.setContentType("text/html; charset=utf-8"); 
		
		response.setHeader("cache-control", "no-cache,no-store");

		PrintWriter out = response.getWriter();
		out.print(array);
		return null;
	}
}

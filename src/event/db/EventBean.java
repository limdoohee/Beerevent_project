package event.db;

import java.util.Date;

public class EventBean {

	private int event_no;
	private String event_name ;
	private String event_categ ;
	private int event_price ;
	private String event_time ;
	private String event_location ;
	private String event_spot ;
	private String event_file ;
	private String event_description ;
	private int store_no ;
	
	private int edate_unique_no;
	private Date edate_date;
	private int edate_num_of_pp;
	
	
	public int getEvent_no() {
		return event_no;
	}
	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}
	public String getEvent_name() {
		return event_name;
	}
	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}
	public String getEvent_categ() {
		return event_categ;
	}
	public void setEvent_categ(String event_categ) {
		this.event_categ = event_categ;
	}
	public int getEvent_price() {
		return event_price;
	}
	public void setEvent_price(int event_price) {
		this.event_price = event_price;
	}
	public String getEvent_time() {
		return event_time;
	}
	public void setEvent_time(String event_time) {
		this.event_time = event_time;
	}
	public String getEvent_location() {
		return event_location;
	}
	public void setEvent_location(String event_location) {
		this.event_location = event_location;
	}
	public String getEvent_spot() {
		return event_spot;
	}
	public void setEvent_spot(String event_spot) {
		this.event_spot = event_spot;
	}
	public String getEvent_file() {
		return event_file;
	}
	public void setEvent_file(String event_file) {
		this.event_file = event_file;
	}
	public String getEvent_description() {
		return event_description;
	}
	public void setEvent_description(String event_description) {
		this.event_description = event_description;
	}
	public int getStore_no() {
		return store_no;
	}
	public void setStore_no(int store_no) {
		this.store_no = store_no;
	}
	public int getEdate_unique_no() {
		return edate_unique_no;
	}
	public void setEdate_unique_no(int edate_unique_no) {
		this.edate_unique_no = edate_unique_no;
	}
	public Date getEdate_date() {
		return edate_date;
	}
	public void setEdate_date(Date edate_date) {
		this.edate_date = edate_date;
	}
	public int getEdate_num_of_pp() {
		return edate_num_of_pp;
	}
	public void setEdate_num_of_pp(int edate_num_of_pp) {
		this.edate_num_of_pp = edate_num_of_pp;
	}
	
}

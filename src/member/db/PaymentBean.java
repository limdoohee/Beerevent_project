package member.db;

import java.util.Date;

public class PaymentBean {

	private int pay_no;
	private Date pay_date;
	private int pay_price;
	private int pay_yesorno;
	private String pay_card_name;
	private String pay_card_no;
	private String pay_card_cvc;
	private String pay_account_no;
	private String pay_account_pass;
	private String pay_deposit_name;
	private int edate_unique_no;
	private int event_no;
	private String mem_id;
	
	
	public int getPay_no() {
		return pay_no;
	}
	public void setPay_no(int pay_no) {
		this.pay_no = pay_no;
	}
	public Date getPay_date() {
		return pay_date;
	}
	public void setPay_date(Date pay_date) {
		this.pay_date = pay_date;
	}
	public int getPay_price() {
		return pay_price;
	}
	public void setPay_price(int pay_price) {
		this.pay_price = pay_price;
	}
	public int getPay_yesorno() {
		return pay_yesorno;
	}
	public void setPay_yesorno(int pay_yesorno) {
		this.pay_yesorno = pay_yesorno;
	}
	public String getPay_card_name() {
		return pay_card_name;
	}
	public void setPay_card_name(String pay_card_name) {
		this.pay_card_name = pay_card_name;
	}
	public String getPay_card_no() {
		return pay_card_no;
	}
	public void setPay_card_no(String pay_card_no) {
		this.pay_card_no = pay_card_no;
	}
	public String getPay_card_cvc() {
		return pay_card_cvc;
	}
	public void setPay_card_cvc(String pay_card_cvc) {
		this.pay_card_cvc = pay_card_cvc;
	}
	public String getPay_account_no() {
		return pay_account_no;
	}
	public void setPay_account_no(String pay_account_no) {
		this.pay_account_no = pay_account_no;
	}
	public String getPay_account_pass() {
		return pay_account_pass;
	}
	public void setPay_account_pass(String pay_account_pass) {
		this.pay_account_pass = pay_account_pass;
	}
	public String getPay_deposit_name() {
		return pay_deposit_name;
	}
	public void setPay_deposit_name(String pay_deposit_name) {
		this.pay_deposit_name = pay_deposit_name;
	}
	public int getEdate_unique_no() {
		return edate_unique_no;
	}
	public void setEdate_unique_no(int edate_unique_no) {
		this.edate_unique_no = edate_unique_no;
	}
	public int getEvent_no() {
		return event_no;
	}
	public void setEvent_no(int event_no) {
		this.event_no = event_no;
	}
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	
}

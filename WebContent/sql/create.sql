create table member (
mem_id 		varchar2(30) 	primary key,
mem_pass 	varchar2(20) 	not null,
mem_name 	varchar2(21) 	not null,
mem_jumin 	varchar2(8) 	not null,
mem_phone 	varchar2(20) 	not null,
mem_email 	varchar2(40) 	not null
);


create table seller (
seller_id 		varchar2(30) 	primary key,
seller_pass 	varchar2(20) 	not null,
seller_name 	varchar2(21) 	not null,
seller_jumin 	varchar2(8) 	not null,
seller_phone 	varchar2(20) 	not null,
seller_email 	varchar2(40) 	not null,
seller_bs_no 	varchar2(30)	not null
);


create table seller_temp (
stemp_id 		varchar2(30) 	primary key,
stemp_pass 		varchar2(20) 	not null,
stemp_name 		varchar2(21) 	not null,
stemp_jumin 	varchar2(8) 	not null,
stemp_phone 	varchar2(20) 	not null,
stemp_email 	varchar2(40) 	not null,
stemp_bs_no 	varchar2(30) 	not null
);


create table store (
store_no	 		number 	  	primary key,
store_register_no 	varchar2(30) 	not null,
store_name 			varchar2(30) 	not null,
store_location 		varchar2(100) 	not null,
store_menu 			varchar2(100) 	not null,
store_dayofweek 	varchar2(20) 	not null,
store_tel	 		varchar2(20) 	not null,
store_file 			varchar2(100),
seller_id 			varchar2(15) 	not null,
FOREIGN KEY (seller_id)
REFERENCES seller(seller_id) ON DELETE SET NULL
);


create table event (
event_no	 	number 	  	primary key,
event_name 	varchar2(30) 	not null,
event_categ 	varchar2(10) 	not null,
event_price 	number 	 	not null,
event_time 	varchar2(30) 	not null,
event_location 	varchar2(120) 	not null,
event_spot 	varchar2(10) 	not null,
event_file 	varchar2(100),
event_description 	varchar2(500) 	not null,
store_no	 	number 	 	not null,
FOREIGN KEY (store_no)
REFERENCES store(store_no) ON DELETE SET NULL
);


create table eventdate (
edate_unique_no 	number 	  	primary key,
edate_date 			date  		not null,
edate_num_of_pp 	number 		not null,
event_no 			number 	  	not null,
FOREIGN KEY (event_no)
 REFERENCES event(event_no) ON DELETE SET NULL
) ;


create table bookmark (
event_no 		number 	  	not null,
mem_id 		varchar2(15) 	not null,
FOREIGN KEY (event_no)
REFERENCES event(event_no) ON DELETE SET NULL,
FOREIGN KEY (mem_id)
REFERENCES member(mem_id) ON DELETE SET NULL
);


create table board (
board_no 		number	 	primary key,
board_title 	varchar2(500) 	not null,
board_content 	varchar2(4000),
board_file 	varchar2(500),
board_date 	date,
board_readcount	 number,
mem_id 		varchar2(15)	not null,
event_no	 	number		not null,
FOREIGN KEY (mem_id) REFERENCES member(mem_id) ON DELETE SET NULL,
FOREIGN KEY (event_no) REFERENCES event(event_no) ON DELETE SET NULL
);


create table reply (
reply_no 		number			primary key,
reply_content 	varchar2(500) 	not null,
reply_date		date,
board_no 		number	 		not null,
mem_id 			varchar2(15) 	not null,
FOREIGN KEY (board_no)
REFERENCES board(board_no) ON DELETE SET NULL,
FOREIGN KEY (mem_id)
REFERENCES member(mem_id) ON DELETE SET NULL
);




create table payment (
pay_no	 			number 	  	primary key,
pay_date 			date 	 	not null,
pay_price 			number 	  	not null,
pay_yesorno 		number 	  	not null,
pay_card_name 		varchar2(30),
pay_card_no 		varchar2(30),
pay_card_cvc 		varchar2(30),
pay_account_no 		varchar2(30),
pay_account_pass 	varchar2(30),
pay_deposit_name 	varchar2(30),
edate_unique_no 	number 		not null,
event_no 			number 		not null,
mem_id 			varchar2(15) 	not null,
FOREIGN KEY (edate_unique_no)
REFERENCES eventdate(edate_unique_no) ON DELETE SET NULL,
FOREIGN KEY (event_no)
REFERENCES event(event_no) ON DELETE SET NULL,
FOREIGN KEY (mem_id)
REFERENCES member(mem_id) ON DELETE SET NULL
);

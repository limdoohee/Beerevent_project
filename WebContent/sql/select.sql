select * from member;
select * from seller;
select * from seller_temp;
select * from store;
select * from event;
select * from bookmark;
select * from board;
select * from reply;
select * from eventdate;

select e.*, s.store_name



select store_no, store_name
from store
where store_no in (select store_no
					from event);
					
					select store_no
					from event
					
					
select seller_id from STORE where store_no=1;
					
					
select * from store;

select * from eventdate;

select event_no,min(edate_date)
from eventdate
group by event_no
order by min(edate_date);



select distinct e.event_no, e.event_file, e.event_name, e.event_categ, e.event_price, d.min
from event e, (select event_no, min(edate_date) min
				from eventdate
				group by eventdate.event_no) d 
where e.event_no = d.event_no
and to_char(d.min, 'yyyy/MM/dd') between '2018/12/01' and '2018/12/31'
and e.event_categ='¿Ã∫•∆Æ'
order by d.min;


select * from store where seller_id='sell1';


select * from event where event_no in 
(select event_no from bookmark where mem_id='mem1');


select max(store_no)
from store;


select * from event
where store_no in(select store_no
					from store where seller_id='sell1');
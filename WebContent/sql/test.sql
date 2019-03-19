select distinct e.event_no, e.event_file, e.event_name, d.edate_date, e.event_categ, e.event_price 
from event e, eventdate d
where e.event_no = d.event_no
and to_char(d.edate_date, 'yyyy/MM/dd') between '2018/12/01' and '2018/12/30'
and event_categ='클래스'
and event_spot='강남구';


select distinct e.event_no, e.event_file, e.event_name, e.event_categ, e.event_price 
from event e, eventdate d
where e.event_no = d.event_no
and to_char(d.edate_date, 'yyyy/MM/dd') between '2018/12/01' and '2018/12/30'
and event_categ='클래스'
and event_spot='강남구';


select ADMIN_ID,ADMIN_PASS from admin where admin_id = 'admin';
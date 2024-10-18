select * from notice;
select * from notice
where trunc(sysdate) between trunc(startdate) and trunc(enddate) ;
select * from notice
where trunc(sysdate) > trunc(enddate) ;
select * from notice
where trunc(sysdate) < trunc(startdate) ;
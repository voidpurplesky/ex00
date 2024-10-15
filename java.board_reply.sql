-- 1. 객체제거
drop table board_reply CASCADE CONSTRAINTS PURGE;
drop SEQUENCE board_reply_seq;

create table board_reply (
    rno number primary key,
    no number references board(no) not null,
    content VARCHAR2(600) not null,
    id varchar2(30) references member(id) not null,
    writeDate date default sysDate
);
create SEQUENCE board_reply_seq;
select max(no) from board;
insert into board_reply(rno, no, content, id) 
 values (board_reply_seq.nextval, 61, '질문있습니다.', 'id1');
 
insert into board_reply(rno, no, content, id) 
 values (board_reply_seq.nextval, 61, '질문있습니다.2', 'id1');
 
select * from member;
select * from board_reply;
update member set name = 'name1' where id = 'id1';
commit;
update board_reply set id = 'id2' where rno = 1;
select b.rno, b.no, b.content, b.id, b.writedate, m.name
  		from board_reply b, member m
        where m.id = b.id
        and b.no = 61
  		order by rno desc;
        
select count(no) from board_reply where no = 61 ;


select rno, no, content, id, writedate, name from ( select rownum rnum, rno, no, content, id, 
writedate, name from ( select b.rno, b.no, b.content, b.id, b.writedate, m.name from board_reply 
b, member m where m.id = b.id and b.no = 61 order by rno desc ) ) where rnum between 1 and 
10 ;
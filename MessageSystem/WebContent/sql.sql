1. ȸ�������� ������ ������ �� �ִ� 'web_member'���̺��� ����ÿ�.
   �÷��� : email / pw / tel / address


create table web_member(
	email varchar2(50) PRIMARY KEY,
	pw varchar2(20) not null,
	tel varchar2(20),
	address	varchar2(20)
)

CREATE SEQUENCE num START WITH 1 INCREMENT BY 1

create table web_message(
	num number,
	send_name varchar2(50),
	receive_email varchar2(100),
	content varchar2(200),
	day date
)

drop table web_user

insert into web_member values('admin','1q2w3e4r','010-1111-2222','���ֱ�����')

select * from web_member

insert into web_message values(num.nextval,'������','pbk','���ֱ�����',sysdate)

ALTER TABLE web_message MODIFY(content varchar2(2000))

ALTER TABLE web_member drop column admin

alter table web_member add admin number(2) default 2

select * from web_message

update web_member set admin=2

update web_member set admin=1 where email='admin'

update web_member set pw='1' where email='admin'
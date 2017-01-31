create user jathoo;
alter user jathoo superuser;
create user yathu with password 'password';
alter user yathu superuser;
drop database testdb;
create database testdb;
grant all privileges on database testdb to yathu;
grant all privileges on database testdb to yathu;




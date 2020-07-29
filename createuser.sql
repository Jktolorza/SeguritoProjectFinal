-- create new user
alter session set "_ORACLE_SCRIPT"=true;
CREATE USER seguritoprojectfinal IDENTIFIED BY seguritoprojectfinal;

-- grant priviledges
GRANT CONNECT, RESOURCE, DBA TO seguritoprojectfinal;


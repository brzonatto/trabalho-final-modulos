create user DB_POKEMON identified by oracle;
GRANT CONNECT TO DB_POKEMON;
GRANT CONNECT, RESOURCE, DBA TO DB_POKEMON;
GRANT CREATE SESSION TO DB_POKEMON;
GRANT DBA TO DB_POKEMON;
grant create view, create procedure, create sequence to DB_POKEMON;
GRANT UNLIMITED TABLESPACE TO DB_POKEMON;
GRANT CREATE MATERIALIZED VIEW TO DB_POKEMON;
GRANT CREATE TABLE TO DB_POKEMON;
GRANT GLOBAL QUERY REWRITE TO DB_POKEMON;
GRANT SELECT ANY TABLE TO DB_POKEMON;
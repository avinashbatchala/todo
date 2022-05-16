drop database tododb;
drop user todo;
create user todo with password 'password';
create database tododb with template=template0 owner=todo;
\connect tododb;
alter default privileges grant all on tables to todo;

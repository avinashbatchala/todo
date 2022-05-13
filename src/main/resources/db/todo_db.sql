drop database tododb;
drop user todo;
create user todo with password 'password';
create database tododb with template=template0 owner=todo;
\connect tododb;
alter default privileges grant all on tables to todo;
alter default privileges grant all on sequences to todo;

create table td_users(
    user_id integer primary key not null,
    first_name varchar(50) not null ,
    last_name varchar (50) not null,
    email varchar (50) not null,
    password text not null

);

create table td_tasks(
    task_id integer primary key not null,
    user_id integer not null,
    task_name varchar (20) not null,
    task_description text not null,
    task_status boolean not null
);

alter table td_users add constraint users_tasks_fk
foreign key (user_id) references td_users(user_id);

create sequence td_users_seq increment 1 start 1;
create sequence td_tasks_seq increment 1 start 1;
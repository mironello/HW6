create table worker
(
    id       bigint primary key,
    name     varchar(1000) not null check (LENGTH(name) >= 2 and LENGTH(name) <= 1000),
    birthday DATE check (extract(year from birthday) > 1900),
    level    varchar(10)   not null check (level in ('Trainee', 'Junior', 'Middle', 'Senior')),
    salary   int check (salary >= 100 and salary <= 100000)
);

create table client
(
    id   bigint primary key,
    name varchar(1000) not null check (LENGTH(name) >= 2 and LENGTH(name) <= 1000)
);

create table project
(
    id          bigint primary key,
    client_id   bigint references client (id),
    start_date  date,
    finish_date date
);

create table project_worker
(
    project_id bigint references project (id),
    worker_id  bigint references worker (id),
    primary key (project_id, worker_id)
);

create sequence worker_seq start 1;
create sequence client_seq start 1;
create sequence project_seq start 1;

alter table worker
    alter column id set default nextval('worker_seq');
alter table client
    alter column id set default nextval('client_seq');
alter table project
    alter column id set default nextval('project_seq');
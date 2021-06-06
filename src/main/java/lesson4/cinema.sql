/* DB init */

drop database if exists gb;
create database gb;

\c gb;

drop schema if exists cinema;
create schema cinema;

set search_path to cinema;

/* tables init */

drop table if exists movie cascade;
create table movie(
	id bigserial primary key,
	name varchar not null,
	duration int not null
);

drop table if exists movie_schedule cascade;
create table movie_schedule(
	id bigserial primary key,
	movie_id bigint not null references movie(id),
	start_date timestamp not null,
	price int not null
);

drop table if exists ticket cascade;
create table ticket(
	id bigserial primary key,
	movie_schedule_id bigint not null references movie_schedule(id)
);

/* data init */

insert into movie (name, duration) values
	('Тихое место-2', 97),
	('Круэлла', 134),
	('Форсаж-9', 145),
	('Кролик Питер-2', 93),
	('Гнев человеческий', 118)
;

insert into movie_schedule (movie_id, start_date, price) values
	(1, '07-06-2021 17:30:00', 400),
	(2, '07-06-2021 18:00:00', 800),
	(3, '08-06-2021 15:30:00', 600),
	(4, '08-06-2021 19:30:00', 500),
	(5, '09-06-2021 17:30:00', 350),
	(1, '09-06-2021 19:30:00', 199),
	(2, '10-06-2021 10:30:00', 1200),
	(3, '10-06-2021 17:30:00', 900),
	(4, '11-06-2021 11:30:00', 600),
	(5, '11-06-2021 13:00:00', 500),
	(5, '12-06-2021 10:00:00', 500),
	(5, '12-06-2021 12:30:00', 500),
	(5, '12-06-2021 14:30:00', 500),
	(5, '12-06-2021 17:00:00', 500)
;

insert into ticket (movie_schedule_id) values
	(1),
	(1),
	(1),
	(3),
	(7)
;
	
/* test data */

select * from movie;
select * from movie_schedule ms ;
select * from ticket;

/* Ошибки в расписании */

select 
	ms.id as movie_schedule_id, ms.movie_id, m.name, m.duration, ms.start_date,
	ms2.id as movie_schedule_id, ms2.movie_id, m2.name, m2.duration, ms2.start_date
from 
	movie_schedule ms
cross join
	movie_schedule ms2
inner join
	movie m on m.id = ms.movie_id
inner join
	movie m2 on m2.id = ms2.movie_id
where 
	ms.id != ms2.id and
	ms.start_date > ms2.start_date and
	ms.start_date < ms2.start_date + (m2.duration || ' minutes')::interval
order by 
	ms.start_date 
	
;

/* Перерыв более 30 минут */

select 
	ms.id, ms.start_date, (select name from movie where id = ms.movie_id), max(g.end_date) as prev_end_date, extract(epoch from (ms.start_date - max(g.end_date)))/60 as "interval"
from 
	movie_schedule ms
cross join
	(
		select 
			ms2.start_date + (m2.duration || ' minutes')::interval as end_date 
		from 
			movie_schedule ms2 
		inner join 
			movie m2 on m2.id = ms2.movie_id
	) as g 
inner join movie m
	on m.id = ms.movie_id 
where 
	ms.start_date > g.end_date and
	g.end_date::date = ms.start_date::date 
group by 
	ms.id
having 
	extract(epoch from (ms.start_date - max(g.end_date)))/60 > 30
order by 
	interval desc;
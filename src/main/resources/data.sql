insert into course(id, name, created_date, last_updated_date)
values(10001, "Learn Spring", current_timestamp(), current_timestamp());
insert into course(id, name, created_date, last_updated_date)
values(10002, "Learn Spring Boot", current_timestamp(), current_timestamp());
insert into course(id, name, created_date, last_updated_date)
values(10003, "Learn Spring JPA", current_timestamp(), current_timestamp());
insert into course(id, name, created_date, last_updated_date)
values(10004, "Learn Spring Security", current_timestamp(), current_timestamp());


insert into passport(id, number)
values(40001, "A123456");
insert into passport(id, number)
values(40002, "B123456");
insert into passport(id, number)
values(40003, "C123456");


insert into student(id, name, passport_id)
values(20001, "A", 40001);
insert into student(id, name, passport_id)
values(20002, "B", 40002);
insert into student(id, name, passport_id)
values(20003, "C", 40003);



insert into review(id, rating, description)
values(50001, "5", "Great course");
insert into review(id, rating, description)
values(50002, "4", "Wonderful course");
insert into review(id, rating, description)
values(50003, "5", "Awesome course");



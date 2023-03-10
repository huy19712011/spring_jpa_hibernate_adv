insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10001, "Learn Spring", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10002, "Learn Spring Boot", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10003, "Learn Spring JPA", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10004, "Learn Spring Security", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10011, "Dummy1", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10012, "Dummy2", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10013, "Dummy3", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10014, "Dummy4", current_timestamp(), current_timestamp(), false);
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10015, "Dummy5", current_timestamp(), current_timestamp(), false);
-- for testing countByName()
insert into course(id, name, created_date, last_updated_date, is_deleted)
values(10016, "Dummy5", current_timestamp(), current_timestamp(), false);


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



insert into review(id, rating, description, course_id)
values(50001, "FIVE", "Great course", 10001);
insert into review(id, rating, description, course_id)
values(50002, "FOUR", "Wonderful course", 10001);
insert into review(id, rating, description, course_id)
values(50003, "FIVE", "Awesome course", 10003);

insert into student_course (student_id, course_id)
values(20001, 10001);
insert into student_course (student_id, course_id)
values(20002, 10001);
insert into student_course (student_id, course_id)
values(20003, 10001);
insert into student_course (student_id, course_id)
values(20001, 10003);



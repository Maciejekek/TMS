insert into class_block(class_block_name)
values ('test');

insert into class_block(class_block_name)
values ('test');

insert into courses(name)
values ('java');

insert into participant_application(course_id, person_id)
VALUES (1, 1);

insert into notification(class_name, notification_date, description)
VALUES ('nameNotifi', '2019-02-01', 'des');

insert into person_account_data(login, password, auth_token, email, type, is_active)
VALUES ('login', 'password', 'token', 'email', 'type', true);

INSERT INTO persons(last_name, name)
VALUES ('Magda', 'Magda')


-- insert into class_block_classes_list(class_block_id,classes_list_id ) values (1,1);
--
-- insert into courses_class_block_list(courses_id, class_block_list_id) values (1, 1);

-- insert into classes(topic) values ('newTopic');
--
-- insert into persons(name,lastName) values ('name','lastName');
--


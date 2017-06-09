# DC schema

# --- !Ups
insert into users (id, name, email) values(1, 'Ane', 'ane@gmail.com');
insert into users (id, name, email) values(2, 'Beck', 'beck@yahoo.com');

insert into tasks(user_id, name, description) values(1, 'shopping', null);
insert into tasks(user_id, name, description) values(1, 'homework', 'I have homework to do until next Sunday.');

insert into tasks(user_id, name, description) values(2, 'clean my room', 'My mum schoold me if I negelect to do it..');

# --- !Downs
delete from tasks;
delete from users;

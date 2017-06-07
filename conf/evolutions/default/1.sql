# DC schema

# --- !Ups

create table users (
 id int NOT NULL AUTO_INCREMENT,
 name varchar(100) NOT NULL,
 email varchar(100) NOT NULL,
 PRIMARY KEY (id)
);

create table tasks (
 id int NOT NULL AUTO_INCREMENT,
 user_id int NOT NULL,
 name varchar(100) NOT NULL,
 description text,
 created_at datetime NOT NULL,
 CONSTRAINT tasks_fk_1 FOREIGN KEY (user_id) REFERENCES users(id),
 PRIMARY KEY (id)
);

# --- !Downs
drop table tasks;
drop table users;

-- learn.demo_user definition

-- Drop table

-- DROP TABLE learn.demo_user;

CREATE TABLE learn.demo_user (
	id varchar(32) NOT NULL,
	user_name varchar(20) NOT NULL,
	age int2 NULL,
	version_no int2 NOT NULL,
	create_time timestamp NOT NULL,
	create_by varchar(32) NOT NULL,
	update_time timestamp NOT NULL,
	update_by varchar(32) NOT NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

INSERT INTO learn.demo_user (id, user_name, age, version_no, create_time, create_by, update_time, update_by) VALUES('1', 'albert', NULL, 1, '2022-04-20 11:58:27.528', 'SYSTEM', '2022-04-20 11:58:27.528', 'SYSTEM');
INSERT INTO learn.demo_user (id, user_name, age, version_no, create_time, create_by, update_time, update_by) VALUES('2', 'ben', NULL, 1, '2022-04-20 11:58:27.528', 'SYSTEM', '2022-04-20 11:58:27.528', 'SYSTEM');

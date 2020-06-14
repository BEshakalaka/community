create table user
(
	id int(255) auto_increment primary key NOT NULL,
	account_id varchar(100),
	name varchar(50),
	token char(36),
	gmt_create bigint(255),
	gmt_modified bigint(255)
);
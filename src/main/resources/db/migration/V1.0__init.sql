create schema authentication;

CREATE TABLE authentication.user (
	vw_id VARCHAR(10) NOT NULL,
	password VARCHAR(255) NOT NULL,
	active BOOLEAN NOT NULL,
	access_token VARCHAR(255) DEFAULT NULL,
	PRIMARY KEY(vw_id)
);

create table authentication.role (
	id BIGSERIAL,
	name VARCHAR(255) NOT NULL,
	admin BOOLEAN NOT null,
	PRIMARY KEY(id)
);

create table authentication.user_role (
	vw_id VARCHAR(20) references authentication.user,
	role_id BIGINT references authentication.role
);

CREATE TABLE authentication.access (
	id BIGSERIAL,
	vw_id VARCHAR(20) NOT NULL,
	active BOOLEAN NOT NULL,
	date TIMESTAMP NOT NULL,
	success BOOLEAN NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE authentication.request (
	id BIGSERIAL,
	vw_id VARCHAR(20),
	access_token_used VARCHAR(255),
	active BOOLEAN,
	date TIMESTAMP,
	request_url VARCHAR(255),
	remote_address VARCHAR(20),
	server_message VARCHAR(255),
	type VARCHAR(255),
	success BOOLEAN,
	PRIMARY KEY(id)
);

insert into authentication.role values (1, 'administrator', true);
insert into authentication.role values (2, 'inspector', false);
insert into authentication.role values (3, 'consultant', false);

insert into authentication.user values ('123456789', '$2a$10$9GQAOiiinEdrI4dNYbYpku2fTstn2RKsLSjScdjav1aNZgRhZijDu', true, null);

insert into authentication.user_role values ('123456789', 1);
CREATE TABLE authentication.user (
	vw_id VARCHAR(20) NOT NULL,
	password VARCHAR(255) NOT NULL,
	active BOOLEAN NOT NULL,
	access_token VARCHAR(255) NOT NULL,
	PRIMARY KEY(vw_id)
);

create table authentication.role (
	id BIGSERIAL,
	name VARCHAR(255) NOT NULL,
	admin BOOLEAN NOT null,
	PRIMARY KEY(id)
)

create table authentication.user_role (
	vw_id VARCHAR(20) references authentication.user,
	role_id BIGINT references authentication.role
)


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
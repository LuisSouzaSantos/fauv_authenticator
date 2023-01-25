USE DATABASE

CREATE SCHEMA authentication;

CREATE TABLE authentication.user (
	vw_id VARCHAR(20) NOT NULL,
	password VARCHAR(255) NOT NULL,
	active BOOLEAN NOT NULL,
	access_token VARCHAR(255) NOT NULL,
	PRIMARY KEY(vw_id)
);

CREATE TABLE authentication.user_audit (
	id BIGSERIAL,
	vw_id VARCHAR(20) NOT NULL,
	active BOOLEAN NOT NULL,
	date TIMESTAMP NOT NULL,
	success BOOLEAN NOT NULL,
	PRIMARY KEY(id)
);

CREATE TABLE authentication.resource_audit (
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
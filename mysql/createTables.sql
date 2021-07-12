CREATE DATABASE IF NOT EXISTS dbforexperience;
USE dbforexperience;

CREATE TABLE dbforexperience.githubusers (
	LOGIN VARCHAR(40) NULL UNIQUE,
	REQUEST_COUNT INT
)
ENGINE=InnoDB
COMMENT='Users login and request for them from https://api.github.com/users/';

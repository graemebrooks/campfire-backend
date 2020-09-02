CREATE TABLE user(
    email varchar(50) not null,
    password varchar(50) not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    enabled TINYINT NOT NULL DEFAULT 1,
    PRIMARY KEY (email)

);

CREATE TABLE authorities (
  email VARCHAR(50) NOT NULL,
  authority VARCHAR(50) NOT NULL,
  FOREIGN KEY (email) REFERENCES user(email)
);

CREATE UNIQUE INDEX ix_auth_email on authorities (email,authority);

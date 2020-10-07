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

CREATE TABLE usermovie(
    id varchar(10) not null,
    title varchar(50) not null,
    year integer not null,
    director varchar(50),
    posterPath varchar(100),
    userId varchar(50) not null,
    hasWatched boolean not null,
    watchListed boolean not null,
    review text,
    rating integer,
    PRIMARY KEY (userId, id)
);
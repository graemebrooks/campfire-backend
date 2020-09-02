INSERT INTO user (email, password, firstName, lastName, enabled) VALUES ('user@gmail.com', 'pass',
'bob', 'smith', 1);

INSERT INTO authorities (email, authority)
  values ('user@gmail.com', 'ROLE_USER');
INSERT INTO USUARIOS(username, password, enabled, name, surname, email) VALUES ('vortice', '$2a$10$9k757yHVdFDpzNgaeEnZTetwIo4OLwfd9k.7t/oOoLIWOla0ybKi6', true, 'Victor', 'Bedmar', 'v.y.bedmar@gmail.com');
INSERT INTO USUARIOS(username, password, enabled, name, surname, email) VALUES ('jules', '$2a$10$BIioe18A5jLJ5WaWyBKZaOFn/4V2lETfBTH2Kc7INph/TiKJADRkC', true, 'Julio', 'Zapata', 'j.zapata@gmail.com');

INSERT INTO ROLES(name) VALUES('ROLE_USER');
INSERT INTO ROLES(name) VALUES('ROLE_ADMIN');

INSERT INTO USERS_TO_ROLES(user_id, role_id) VALUES(1,1);
INSERT INTO USERS_TO_ROLES(user_id, role_id) VALUES(2,1);
INSERT INTO USERS_TO_ROLES(user_id,  role_id) VALUES(2,2);
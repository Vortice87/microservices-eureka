INSERT INTO USUARIOS(username, password, enabled, name, surname, email) VALUES ('vortice', 'admin', true, 'Victor', 'Bedmar', 'v.y.bedmar@gmail.com');
INSERT INTO USUARIOS(username, password, enabled, name, surname, email) VALUES ('jules', 'abc', true, 'Julio', 'Zapata', 'j.zapata@gmail.com');

INSERT INTO ROLES(name) VALUES('ROLE_USER');
INSERT INTO ROLES(name) VALUES('ROLE_ADMIN');

INSERT INTO USERS_TO_ROLES(user_id, role_id) VALUES(1,1);
INSERT INTO USERS_TO_ROLES(user_id, role_id) VALUES(2,1);
INSERT INTO USERS_TO_ROLES(user_id,  role_id) VALUES(2,2);
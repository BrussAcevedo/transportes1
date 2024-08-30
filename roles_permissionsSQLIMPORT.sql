
--Inser de tabla permissions

INSERT INTO permissions (permission_name)
VALUES('READ'),
	('CREATE'),
	('DELETE'),
	('UPDATE'),
	('PROGRAM'),
	('MODERATE_COMMENTS'),
	('READ_COMMENTS'),
	('WRITE_COMMENTS');
SELECT * FROM permissions;


--Insert de tabla Roles
INSERT INTO roles (role_name)
VALUES ('ADMIN'),
	('USER'),
	('MODERATOR'),
	('DEVELOPER');
SELECT * FROM roles;


-- Insert de relacion role -> permisions
INSERT INTO role_permissions
VALUES (1, 1),(2, 1),(3, 1),(4, 1),(5, 1),(6, 1), (7, 1),
		(1, 2),(8, 2),
		(1, 3),(6, 3),
	(1, 4),(2, 4),(3, 4),(4, 4),(5, 4),(6, 4), (7, 4),(8, 4);

SELECT* FROM role_permissions;

-- Insert usuarios test
INSERT INTO users (user_last_name, user_mail, user_name, user_password, user_rut)
VALUES('admin', 'admin@admin.com', 'admin', '$2a$10$osMA.SAY4ACNB.2tH4YAp.ItDTmkGqPQ6YGvhWX7VNkpcCOlUQZr6', '00000000-0'),
	('dev', 'dev@dev.com', 'dev', '$2a$10$ExNyMR3cy4glU468OqbQseqUqleRKEyvIJyN7JDWsSCSNXG9juyfe', '00000000-0'),
	('userTst', 'userTst@userTst.com', 'userTst', '$2a$10$/qJftI.x7ZC.6o1NnymKCOn52HUmXXD2Tqo.Ju472CL1sxTQcd9ZO', '00000000-0'),
	('moderatorTst', 'moderatorTst@moderatorTst.com', 'moderatorTst', '$2a$10$Ve6Czaj1jlqNIuV.dY3S9ORgo2PXwTylJa3g6OLUZKzg/jJKlBCXm', '00000000-0');
SELECT*FROM users;

-- Insert de relacion user -> roles
INSERT INTO user_roles
VALUES(1,1), (4,2), (2,3), (3,4);
SELECT * FROM user_roles;


-- Todos los SELECT
SELECT * FROM permissions;

SELECT * FROM roles;

SELECT* FROM role_permissions;

SELECT*FROM users;

SELECT * FROM user_roles;



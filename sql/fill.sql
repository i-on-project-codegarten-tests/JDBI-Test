INSERT INTO USERS(name, gh_id, gh_token) VALUES('Ricardo', '1', 'token1'), 
											   ('Diogo', '2', 'token2'), 
											   ('João', '3', 'token3'),
											   ('Tiago', '4', 'token4'),
											   ('Pedro', '5', 'token5');
											   
INSERT INTO CLASSROOM(name, description) VALUES('i-on Core', 'Classroom for i-on Core'),
											   ('i-on Codegarten', 'Classroom for i-on Codegarten'),
											   ('i-on Integration', 'Classroom for i-on Integration');
											   
INSERT INTO USER_CLASSROOM(type, uid, cid) VALUES('teacher', 5, 1),
												 ('teacher', 5, 2),
												 ('teacher', 5, 3),
												 ('student', 1, 1),
												 ('student', 2, 2),
												 ('student', 3, 2),
												 ('student', 4, 3);

INSERT INTO tuser (login, password, name, surname, email, role)
VALUES ('admin','21232f297a57a5a743894a0e4a801fc3','Tomek','Wodz','twodzinski@op.pl', 'ADMIN');

INSERT INTO tuser (login, password, name, surname, email, role)
VALUES ('tomwodz','21232f297a57a5a743894a0e4a801fc3','Tomek','Wodz','twodzinski@op.pl', 'USER');


INSERT INTO ttopic (author_id, title)
VALUES (1, 'Ignacy');

INSERT INTO ttopic (author_id, title)
VALUES (1, 'Loreen');

INSERT INTO ttopic (author_id, title)
VALUES (1, 'sanah');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Krakowie');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Warszawie');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Łodzi');

INSERT INTO tpost(thread_id, user_id, content)
VALUES (1,1,'Super!');

INSERT INTO tpost(thread_id, user_id, content)
VALUES (1,1,'Mega!');

INSERT INTO tpost(thread_id, user_id, content)
VALUES (1,1,'Świetnie!');
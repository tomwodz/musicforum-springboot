INSERT INTO tuser (login, password, name, surname, email, role)
VALUES ('admin','21232f297a57a5a743894a0e4a801fc3','Tomek','Wodz','twodzinski@op.pl', 'ADMIN');

INSERT INTO tuser (login, password, name, surname, email, role)
VALUES ('tomwodz','6e43a6632d8f44360736762f86f66d1d','Tomek','Wodz','twodzinski@op.pl', 'ADMIN');

INSERT INTO tuser (login, password, name, surname, email, role)
VALUES ('user','6e43a6632d8f44360736762f86f66d1d','Tomek','Wodz','twodzinski@op.pl', 'USER');


INSERT INTO ttopic (author_id, title)
VALUES (1, 'Ignacy');

INSERT INTO ttopic (author_id, title)
VALUES (1, 'sanah');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Krakowie');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Warszawie');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 1, 'Koncert w Łodzi');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (2, 2, 'Sylwester');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (1, 2, 'Koncert na gali');

INSERT INTO tthread (author_id, topic_id, title)
VALUES (2, 2, 'Koncert próbny');

INSERT INTO tpost(thread_id, user_id, content, date_created, date_updated)
VALUES (1,1,'Super!','2023-08-18 23:07:02.391858','2023-08-18 23:07:02.391858');

INSERT INTO tpost(thread_id, user_id, content, date_created, date_updated)
VALUES (1,1,'Extra','2023-08-19 23:07:02.391858','2023-08-19 23:07:02.391858');

INSERT INTO tpost(thread_id, user_id, content, date_created, date_updated)
VALUES (1,1,'Mega!','2023-08-22 23:07:02.391858','2023-08-22 23:07:02.391858');

INSERT INTO tpost(thread_id, user_id, content, date_created, date_updated)
VALUES (1,1,'Super koncert!','2023-08-23 23:07:02.391858','2023-08-30 23:07:02.391858');

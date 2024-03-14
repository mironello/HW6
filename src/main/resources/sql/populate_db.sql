/** add workers*/
INSERT INTO worker (name, birthday, level, salary) values
                                                       ('John Doe', '1990-05-15', 'Trainee', 800),
                                                       ('Alice Smith', '1985-09-20', 'Junior', 1200),
                                                       ('Bob Johnson', '1980-03-10', 'Middle', 3000),
                                                       ('Emily Brown', '1975-11-25', 'Senior', 6000),
                                                       ('Michael Williams', '1995-02-03', 'Trainee', 900),
                                                       ('Emma Jones', '1992-07-08', 'Junior', 1500),
                                                       ('William Davis', '1987-04-12', 'Middle', 3500),
                                                       ('Olivia Miller', '1983-10-17', 'Senior', 7000),
                                                       ('James Wilson', '1998-08-22', 'Trainee', 850),
                                                       ('Sophia Taylor', '1991-01-30', 'Junior', 1300);

/** add clients*/
insert into client (name) values
                              ('Sony corporation'),
                              ('Big Boss Systems'),
                              ('Dragons97'),
                              ('NBA'),
                              ('Umbrella green world');


/** add projects*/
insert into project (client_id, start_date, finish_date)values
                                                            (1, '2023-01-01', '2023-12-31'),
                                                            (2, '2022-05-01', '2022-07-31'),
                                                            (3, '2022-10-15', '2023-02-28'),
                                                            (4, '2023-03-01', '2023-05-31'),
                                                            (5, '2022-12-01', '2023-03-31'),
                                                            (1, '2023-04-01', '2023-07-31'),
                                                            (2, '2022-08-01', '2022-12-31'),
                                                            (3, '2022-11-01', '2023-05-31'),
                                                            (4, '2022-09-01', '2023-04-30'),
                                                            (5, '2022-06-01', '2023-01-31');

/** appointment of workers*/
insert into project_worker (project_id, worker_id) values
                                                       (1, 1), (1, 2), (1, 3),
                                                       (2, 4), (2, 5),
                                                       (3, 6), (3, 7),
                                                       (4, 8), (4, 9), (4, 10),
                                                       (5, 1), (5, 6),
                                                       (6, 2), (6, 7), (6, 10),
                                                       (7, 3), (7, 5), (7, 8),
                                                       (8, 4), (8, 9),
                                                       (9, 1), (9, 6), (9, 10),
                                                       (10, 2), (10, 5), (10, 8), (10, 9);
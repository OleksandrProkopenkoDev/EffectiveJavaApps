-- Insert test data into the student table
INSERT INTO student (name)
VALUES ('Student 1'),
       ('Student 2'),
       ('Student 3'),
       ('Student 4'),
       ('Student 5'),
       ('Student 6'),
       ('Student 7'),
       ('Student 8'),
       ('Student 9'),
       ('Student 10');

-- Insert test data into the teacher table
INSERT INTO teacher (name)
VALUES ('Teacher 1'),
       ('Teacher 2'),
       ('Teacher 3'),
       ('Teacher 4'),
       ('Teacher 5'),
       ('Teacher 6'),
       ('Teacher 7'),
       ('Teacher 8'),
       ('Teacher 9'),
       ('Teacher 10');

-- Insert test data into the subject table
INSERT INTO subject (name, teacher_id)
VALUES ('Subject 1', 1),
       ('Subject 2', 2),
       ('Subject 3', 3),
       ('Subject 4', 4),
       ('Subject 5', 5),
       ('Subject 6', 6),
       ('Subject 7', 7),
       ('Subject 8', 8),
       ('Subject 9', 9),
       ('Subject 10', 10);

-- Insert test data into the student_enrolled table
-- Assuming each student is enrolled in one or more subjects
INSERT INTO student_enrolled (subject_id, student_id)
VALUES (1, 1),
       (1, 2),
       (2, 3),
       (2, 4),
       (3, 5),
       (3, 6),
       (4, 7),
       (4, 8),
       (5, 9),
       (5, 10),
       (6, 1),
       (6, 3),
       (7, 2),
       (7, 4),
       (8, 5),
       (8, 7),
       (9, 6),
       (9, 8),
       (10, 9),
       (10, 10);

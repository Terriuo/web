INSERT INTO users (id, username, password, fullname, email, phonenumber, role) VALUES
                                                                                   ('550e8400-e29b-41d4-a716-446655440000', 'admin', '{noop}admin123', 'Admin User', 'admin@example.com', '1234567890', 'ROLE_ADMIN'),
                                                                                   ('550e8400-e29b-41d4-a716-446655440001', 'student1', '{noop}pass123', 'Student One', 'student1@example.com', '0987654321', 'ROLE_USER');


INSERT INTO guestbook (id, name, message, date) VALUES
    (1, 'Guest', 'Welcome to the course!', '2025-04-15 10:00:00');


INSERT INTO lecture (id, title, lecture_notes_url) VALUES
                                                       (1, 'Introduction to Java', '/files/java-intro.pdf'),
                                                       (2, 'Spring Boot Basics', '/files/spring-boot.pdf');


INSERT INTO poll (id, question) VALUES
    (1, 'Which topic do you prefer?');

INSERT INTO poll_option (id, option_text, vote_count, poll_id) VALUES
                                                                   (1, 'Java', 0, 1),
                                                                   (2, 'Spring', 0, 1);

INSERT INTO comment (id, content, lecture_id, poll_id, user_id) VALUES
                                                                    (1, 'Great lecture!', 1, NULL, '550e8400-e29b-41d4-a716-446655440001'),
                                                                    (2, 'Interesting poll!', NULL, 1, '550e8400-e29b-41d4-a716-446655440001');

INSERT INTO vote_records (id, user_id, poll_option_id) VALUES
    (1, '550e8400-e29b-41d4-a716-446655440001', 1);

INSERT INTO lecture_files (lecture_id, file_url) VALUES
                                                     (1, '/uploads/sample1.pdf'),
                                                     (1, '/uploads/sample2.pdf');--sa

CREATE TABLE vote_records (
                              id BIGINT AUTO_INCREMENT PRIMARY KEY,
                              user_id UUID NOT NULL,
                              poll_option_id BIGINT NOT NULL,
                              FOREIGN KEY (user_id) REFERENCES users(id),
                              FOREIGN KEY (poll_option_id) REFERENCES poll_option(id)
);
ALTER TABLE comment ADD COLUMN user_id UUID;
ALTER TABLE comment ADD COLUMN poll_id BIGINT;
ALTER TABLE comment ADD FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE comment ADD FOREIGN KEY (poll_id) REFERENCES poll(id);
CREATE TABLE lecture_files (
                               lecture_id BIGINT NOT NULL,
                               file_url VARCHAR(255),
                               FOREIGN KEY (lecture_id) REFERENCES lecture(id)
);

CREATE TABLE users (
                       id SERIAL PRIMARY KEY,
                       username VARCHAR(50) NOT NULL,
                       role VARCHAR(20) NOT NULL -- 'teacher' or 'student'
);

CREATE TABLE polls (
                       id SERIAL PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       description TEXT,
                       created_by INTEGER REFERENCES users(id),
                       created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE votes (
                       id SERIAL PRIMARY KEY,
                       user_id INTEGER REFERENCES users(id),
                       poll_id INTEGER REFERENCES polls(id),
                       choice VARCHAR(100) NOT NULL,
                       voted_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_votes_user_id ON votes(user_id);
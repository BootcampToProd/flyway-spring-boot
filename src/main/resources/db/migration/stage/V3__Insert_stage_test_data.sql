-- Insert staging test data
INSERT INTO users (name, email) VALUES
    ('Stage Test User 1', 'testuser1@staging.com'),
    ('Stage Test User 2', 'testuser2@staging.com'),
    ('Stage QA User', 'qa@staging.com');

-- Insert stage admin
INSERT INTO users (name, email) VALUES
    ('Stage Admin', 'admin@staging.com');
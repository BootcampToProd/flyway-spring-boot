-- Insert prod test data
INSERT INTO users (name, email) VALUES
    ('Prod Test User 1', 'testuser1@prod.com'),
    ('Prod Test User 2', 'testuser2@prod.com'),
    ('Prod QA User', 'qa@prod.com');

-- Insert prod admin
INSERT INTO users (name, email) VALUES
    ('Prod Admin', 'admin@prod.com');
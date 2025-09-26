-- Insert development test data
INSERT INTO users (name, email) VALUES
    ('John Doe Dev', 'john.doe@dev.local'),
    ('Jane Smith Dev', 'jane.smith@dev.local'),
    ('Bob Johnson Dev', 'bob.johnson@dev.local'),
    ('Alice Brown Dev', 'alice.brown@dev.local'),
    ('Charlie Wilson Dev', 'charlie.wilson@dev.local');

-- Insert admin user for development
INSERT INTO users (name, email) VALUES
    ('Dev Admin', 'admin@dev.local');

-- Add email column with unique constraint
ALTER TABLE users ADD COLUMN email VARCHAR(255);

-- Add unique constraint
ALTER TABLE users ADD CONSTRAINT users_email_unique UNIQUE (email);